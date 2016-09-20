package model.mdo;

import org.apache.commons.io.FileUtils;
import com.dropbox.core.*;
import com.dropbox.core.v2.*;
import com.dropbox.core.v2.files.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import model.mdo.template.MDOTemplateUtil;
import org.apache.struts2.ServletActionContext;

/**
 * Permite almacenar y descargar archivos desde Dropbox
 * por medio de su API 2.1.1.
 */
public final class DropboxPersistence implements FilePersistence {

	private final String ACCESS_TOKEN = "_vjkq--5dsAAAAAAAAAAI1AIN17ztTSAF_7kZ_IAeOO11tmOe-L5YJMEWpXp_h7M";
	private final DbxRequestConfig config;
	private final DbxClientV2 client;
	private final String realPath;
	
	/**
	 * 
	 * @param realPath La ruta hacia la carpeta de plantillas MDO.
	 */
	public DropboxPersistence(String realPath) {
		this.realPath = realPath;
		config = new DbxRequestConfig("edva/cwescom");
		client = new DbxClientV2(config, ACCESS_TOKEN);
	}
	
	@Override
	public void guardar(Map<String, Object> detallesContenido, List<String> html) {
		try {
			String ruta = String.format("/%s/%s/%s",
				detallesContenido.get("token"), detallesContenido.get("contenido"), detallesContenido.get("etapa"));
			String pagina = MDOTemplateUtil
				.getTemplate((String)detallesContenido.get("etapa"), realPath)
				.generarPlantilla(html);
			subir(ruta, pagina,
				(String)detallesContenido.get("token"), (String)detallesContenido.get("contenido"), (String)detallesContenido.get("etapa"));
		} catch (IOException | DbxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Map<String, Object> descargar(Map<String, Object> detallesContenido) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	/**
	 * Sube la página del contenido creado a su carpeta específica en Dropbox.
	 * 
	 * @param ruta La ruta de la carpeta donde se guardará la página.
	 * @param pagina Cadena con todo el HTML que se guardará.
	 * @param token El token del grupo.
	 * @param contenido El nombre del contenido didáctico.
	 * @param etapa El nombre de la etapa MDO a guardar.
	 * @throws IOException Si ocurre un error al leer la página HTML.
	 * @throws DbxException Si ocurre un error al subir el archivo a Dropbox.
	 */
	private void subir(String ruta, String pagina, String token, String contenido, String etapa) throws IOException, DbxException {
		String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
		String tempFile = String.format("%s%s/%s/%s.html", appRoot, token, contenido, etapa);
		File temp = new File(tempFile);
		
		FileUtils.writeStringToFile(temp, pagina, "UTF-8");
		FileInputStream fis = new FileInputStream(temp);
		client.files().uploadBuilder(ruta + "/" + etapa + ".html").uploadAndFinish(fis);
		
		fis.close();
		FileUtils.deleteDirectory(new File(appRoot + token));
	}
}