package Actions.JSON;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ReporteDAO;
import modelo.pojo.Reporte;
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
                        query = "DELETE FROM usuario WHERE correo = " + reporte.getCorreo();
                        out.println("El usuario ha sido eliminado debido al reporte");
                    }else if(reporte.getToken() != null && !reporte.getToken().equals("")){
                        query = "DELETE FROM grupo WHERE token = " + reporte.getToken();
                        out.println("El grupo ha sido eliminado debido al reporte");
                    }else{
                        query = "DELETE FROM contenido WHERE idContenido = " + reporte.getIdContenido();
                        out.println("El contenido ha sido eliminado debido al reporte");
                    }
                    reporteDAO.consultaGenerica(query);
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
