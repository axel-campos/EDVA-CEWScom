package Actions.JSON;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ContenidoDAO;
import modelo.dao.GrupoDAO;
import modelo.dao.ReporteDAO;
import modelo.dao.UsuarioDAO;
import modelo.pojo.Contenido;
import modelo.pojo.Grupo;
import modelo.pojo.Reporte;
import modelo.pojo.Usuario;
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
