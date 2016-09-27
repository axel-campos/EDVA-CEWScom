package Actions.JSON;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ContenidoDAO;
import modelo.dao.GrupoDAO;
import modelo.dao.ReporteDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Contenido;
import modelo.pojo.Grupo;
import modelo.pojo.Reporte;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.ServletActionContext;

public class ResponderReporteAction extends ActionSupport {
    
    private int idReporte;
    private int respuesta;
    
    public ResponderReporteAction() {
    }
    
    public String execute() throws Exception {
        ReporteDAO reporteDAO = new ReporteDAO();
        HttpServletResponse response = ServletActionContext.getResponse();
        try(PrintWriter out = response.getWriter()) {
            try{
                reporteDAO.conectar();
                Reporte reporte = reporteDAO.buscar(new Reporte().setIdReporte(idReporte));
                if(respuesta == 1){ //Fue aceptado el reporte por lo tanto hay que dar cuello
                    reporte.setAceptado(1);
                    reporte.setAtendido(1);
                    String query = "";
                    if(reporte.getCorreo() != null && !reporte.getCorreo().equals("")){
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        usuarioDAO.conectar();
                        String queryGruposProfesor = "SELECT DISTINCT token, idtipoUsuarioGrupo FROM usuariogrupo WHERE correo = '" + reporte.getCorreo() + "';";
                        List<Map<String, Object>> grupos = usuarioDAO.consultaGenerica(queryGruposProfesor);
                        for(Map<String,Object> grupo: grupos){
                            GrupoDAO grupoDAO = new GrupoDAO();
                            grupoDAO.conectar();
                            Grupo aux = grupoDAO.buscar(new Grupo().setToken((String)grupo.get("token")));
                            int idTipoUsuarioGrupo = (int)grupo.get("idtipoUsuarioGrupo");
                            if(idTipoUsuarioGrupo == 1){    //Si es coordinador asignaremos a otro integrante
                                if(aux.getTotalProfesores() == 1){  //Solo él está en el grupo así que eliminamos totalmente el grupo
                                    grupoDAO.eliminar(aux);
                                }else{
                                    String queryCoordinador = "SELECT * FROM usuariogrupo WHERE token = '" + aux.getToken() + "' "
                                            + "AND aceptado = 1 AND correo != '" + reporte.getCorreo() + "' LIMIT 1;";
                                    List<Map<String, Object>> lista = grupoDAO.consultaGenerica(queryCoordinador);
                                    for(Map<String,Object> elemento: lista){
                                        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO();
                                        usuarioGrupoDAO.conectar();
                                        UsuarioGrupo usuarioGrupo = new UsuarioGrupo();
                                        usuarioGrupo.setCorreo((String)elemento.get("correo"));
                                        usuarioGrupo.setToken((String)elemento.get("token"));
                                        usuarioGrupo.setAceptado(true);
                                        usuarioGrupo.setIdTipoUsuarioGrupo(1);
                                        usuarioGrupoDAO.modificar(usuarioGrupo, usuarioGrupo);
                                        usuarioGrupoDAO.desconectar();
                                    }
                                }
                            }
                            aux.setTotalProfesores(aux.getTotalProfesores() - 1);
                            grupoDAO.modificar(aux, aux);
                            grupoDAO.desconectar();
                        }
                        usuarioDAO.eliminar(new Usuario().setCorreo(reporte.getCorreo()));
                        out.println("El usuario ha sido eliminado debido al reporte");
                        usuarioDAO.desconectar();
                    }else if(reporte.getToken() != null && !reporte.getToken().equals("")){
                        GrupoDAO grupoDAO = new GrupoDAO();
                        grupoDAO.conectar();
                        grupoDAO.eliminar(new Grupo().setToken(reporte.getToken()));
                        out.println("El grupo ha sido eliminado debido al reporte");
                        grupoDAO.desconectar();
                    }else{
                        ContenidoDAO contenidoDAO = new ContenidoDAO();
                        contenidoDAO.conectar();
                        contenidoDAO.eliminar(new Contenido().setIdContenido(reporte.getIdContenido()));
                        out.println("El contenido ha sido eliminado debido al reporte");
                        contenidoDAO.desconectar();
                    }
                    out.println("El reporte ha sido atendido exitosamente");
                }else{  //El reporte fue rechazado y no habrá consecuencias
                    reporte.setAtendido(1);
                    reporte.setAceptado(0);
                    out.println("El reporte ha sido atendido exitosamente");
                }
                reporteDAO.responderSolicitud(reporte);
                reporteDAO.desconectar();
            }catch(RuntimeException e){
                reporteDAO.desconectar();
                out.println("Error: Hubo un problema al procesar la solicitud");
            }
            out.flush();
        }
        return SUCCESS;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
}
