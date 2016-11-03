package Actions.JSON;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import model.mdo.DropboxPersistence;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Víctor
 */
public class DescargarHTML extends ActionSupport {
    
    private String token;
    private String idContenido;
    private String idEtapa;
    private String version;
    
    public DescargarHTML() {
    }
    
    public String execute() throws Exception {
        
        HttpServletResponse response = ServletActionContext.getResponse();
        try{
            String ruta = String.format("/%s/%s/%s/%s", token, idContenido, idEtapa, version);
            File f = new DropboxPersistence().descargarArchivoHTML(ruta,"preview.html");
            try(PrintWriter out = response.getWriter()) {
                out.println(ruta.substring(1) + "/preview.html");
            }
        }catch(Exception e){
            e.printStackTrace();
            try(PrintWriter out = response.getWriter()) {
                out.println("Error: Hubo un problema al descargar el HTML");
            }
        }
        return SUCCESS;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(String idContenido) {
        this.idContenido = idContenido;
    }

    public String getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(String idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
}
