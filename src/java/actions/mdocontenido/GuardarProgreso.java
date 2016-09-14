package actions.mdocontenido;

import com.opensymphony.xwork2.ActionSupport;
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
	 * Recibe los artefactos del cliente en JSON. El
	 * primer objeto (artefactos[0]) siempre contiene la etapa,
	 * el nombre del contenido didactico y el token del grupo
	 * que está editándolo.
	 */
	private List<Map<String, Object>> artefactos;
	
	/**
	 * Mensaje de respuesta y tipo al cliente.
	 */
	private String message;
	private boolean estatus;
	
	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		guardar();
		message = "Su progreso ha sido guardado.";
		estatus = true;
		return SUCCESS;
	}
	
	/**
	 * Guarda el progreso que lleven los profesores en su propia carpeta.
	 * Cada grupo de trabajo tiene su carpeta individual, y dentro de ésta
	 * se tienen carpetas individuales para cada contenido didáctico.
	 */
	private void guardar() throws Exception {
		Map<String, Object> detallesContenido = artefactos.get(0);
		List<String> html =
			MDOUtil.parseMDOArtifacts(MDOUtil.parseJsonArtifacts(artefactos.subList(1, artefactos.size())));
		new DropboxPersistence(request.getServletContext().getRealPath("/plantillas")).guardar(detallesContenido, html);
	}
	
	public void setArtefactos(List<Map<String, Object>> artefactos) {
		this.artefactos = artefactos;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean getEstatus() {
		return estatus;
	}
}