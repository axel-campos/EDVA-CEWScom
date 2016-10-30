package Actions.mdocontenido;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import model.mdo.MDOUtil;
import model.mdo.DropboxPersistence;

/**
 * Guarda el progreso que lleven los profesores en su propia carpeta.
 * Esta clase recibe un JSON desde el cliente con los artefactos creados
 * hasta el momento y los sube a su carpeta específica (grupo - contenido didáctico - etapa).
 */
public class GuardarProgreso extends ActionSupport {
	
	/**
	 * Mensaje de respuesta y tipo al cliente.
	 */
	private String message;
	private boolean estatus;
	
	/**
	 * Contiene las variables que se envían desde el
	 * servidor por AJAX.
	 */
	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		try {
			request = ServletActionContext.getRequest();
			guardar();
			message = "Su progreso ha sido guardado con éxito.";
			estatus = true;
		} catch (Exception e) {
			message = "Ocurrió un error al guardar su contenido: " + e.getMessage();
			estatus = false;
		}
		
		return SUCCESS;
	}
	
	/**
	 * Guarda el progreso que lleven los profesores en su propia carpeta.
	 * Cada grupo de trabajo tiene su carpeta individual, y dentro de ésta
	 * se tienen carpetas individuales para cada contenido didáctico.
	 */
	private void guardar() throws Exception {
		String json = request.getParameter("artefactos");
		new DropboxPersistence().guardarJson(json);
        
        Map<String, Object> detalles_contenido = new HashMap<String, Object>();
        detalles_contenido.put("titulo", request.getParameter("titulo"));
        detalles_contenido.put("version", request.getParameter("version")); 
        
        new DropboxPersistence().guardarHTMLpreliminar(detalles_contenido,json);
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean getEstatus() {
		return estatus;
	}
}