package model.mdo;

import org.apache.struts2.ServletActionContext;
import org.apache.commons.io.FileUtils;
import com.dropbox.core.*;
import com.dropbox.core.v2.*;
import com.dropbox.core.v2.files.WriteMode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import model.mdo.template.MDOTemplateUtil;

/**
 * Permite almacenar y descargar archivos desde Dropbox
 * por medio de su API 2.1.1.
 */
public final class DropboxPersistence implements FilePersistence {

	//private final String ACCESS_TOKEN = "_vjkq--5dsAAAAAAAAAAI1AIN17ztTSAF_7kZ_IAeOO11tmOe-L5YJMEWpXp_h7M";
    private final String ACCESS_TOKEN = "_vjkq--5dsAAAAAAAAAANaKwM5NYC9M2wAjk0cFSzKVhGI_Jxi7KNvQucdAvHvQU";  
	private final DbxRequestConfig config;
	private final DbxClientV2 client;
	private final Gson gson = new Gson();
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

    public DropboxPersistence() {        
        realPath = "";
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
	
	@Override
    public void crearCarpeta(String nombre) {
        try {
			client.files().createFolder(nombre);
		} catch (DbxException e) {
			throw new RuntimeException(e);
		}
    }
	
	@Override
	public void crearJsonVacio(String ruta) {
		try {
			String json = "{\"artefactos\":[]}";
			subirArchivoTexto(ruta, "artefactos.json", json);
		} catch (IOException | DbxException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Override
	public void guardarJson(String json) {
		try {
			Map<String, Object> map = obtenerMapaDeJson(json);
			String ruta = (String)map.get("ruta");
			List<Map<String, Object>> artefactos = (List<Map<String, Object>>)map.get("lista");
			String nuevoJson = String.format("{\"artefactos\":%s}", gson.toJson(artefactos));
			subirArchivoTexto(ruta, "artefactos.json", nuevoJson);
		} catch (DbxException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String descargarJson(String ruta) {
		try {
			String json = descargarArchivoTexto(ruta, "artefactos.json");
			return json;
		} catch (IOException | DbxException e) {
			throw new RuntimeException(e);
		}
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
		try(FileInputStream fis = new FileInputStream(temp)) {
			client.files().uploadBuilder(ruta + "/" + etapa + ".html").uploadAndFinish(fis);
		}
		FileUtils.deleteDirectory(new File(appRoot + token));
	}
	
	/**
	 * Sube el archivo de texto indicado a la carpeta de Dropbox indicada.
	 * 
	 * @param ruta La ruta a la cual se subirá el archivo.
	 * @param nombre El nombre del archivo con su extensión.
	 * @param contenido El contenido del archivo.
	 * @throws IOException Si ocurre un error al leer el archivo de texto.
	 * @throws DbxException Si ocurre un error al subir el archivo a Dropbox.
	 */
	private void subirArchivoTexto(String ruta, String nombre, String contenido) throws IOException, DbxException {
		String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
		String token = ruta.split("/")[1];
		String tempFile = appRoot + ruta + "/" + nombre;
		File temp = new File(tempFile);
		FileUtils.writeStringToFile(temp, contenido);
		try (FileInputStream fis = new FileInputStream(temp)) {
			client
				.files()
				.uploadBuilder(ruta + "/" + nombre)
				.withMode(WriteMode.OVERWRITE)
				.uploadAndFinish(fis);
		}
		FileUtils.deleteDirectory(new File(appRoot + token));
	}
	
	private String descargarArchivoTexto(String ruta, String nombre) throws IOException, DbxException {
		String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
		String token = ruta.split("/")[1];
		String tempFile = appRoot + ruta + "/" + nombre;
		File temp = new File(tempFile);
		FileUtils.writeStringToFile(temp, "");
		
		try (FileOutputStream fos = new FileOutputStream(temp)) {
			client.files().download(ruta + "/" + nombre).download(fos);
		}
		
		String file = FileUtils.readFileToString(temp);
		FileUtils.deleteDirectory(new File(appRoot + token));
		return file;
	}
	
	/**
	 * Regresa un mapa con el contenido del JSON dado.
	 * 
	 * @param json Cadena de texto con los artefactos obtenidos desde el cliente.
	 * @return Un mapa con los artefactos del JSON.
	 */
	private Map<String, Object> obtenerMapaDeJson(String json) {
		return (
			(Map<String, Map<String, Object>>)gson
				.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType())
		).get("artefactos");
	}
	
	
}