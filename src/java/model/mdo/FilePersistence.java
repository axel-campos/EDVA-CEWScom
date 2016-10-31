package model.mdo;

import java.util.Map;
import java.util.List;

/**
 * Contiene métodos para guardar y descargar los
 * contenidos didácticos con ayuda de algún sistema
 * de archivos.
 */
public interface FilePersistence {
    
    /**
	 * Guarda el HTML del la versión preliminar de cierta versión de una etapa.
	 * jerárquica: [Grupo] -> [Contenido] -> [Etapa].
	 * 
     * @param detallesContenido Contiene la etapa, el nombre del contenido y el nombre del grupo que lo editó.
	 * @param artefactosJSON Una lista de los artefactos de la etapa a convertir en JSON.
	 * @throws RuntimeException Si ocurre algún error al momento de almacenar el contenido.
	 */
	void guardarHTMLpreliminar(Map<String, Object> detallesContenido, String artefactosJSON);
	
	/**
	 * Crea un archivo JSON vacío dentro de la carpeta del contenido didáctico.
	 * La ruta del contenido debe tener la siguiente estructura jerárquica:
	 * [Grupo] -> [Contenido] -> [Etapa] -> [Versión].
	 * 
	 * @param ruta La ruta del contenido didáctico. Debe tener la estructura mostrada anteriormente.
	 * @throws RuntimeException Si ocurre algún error al momento de almacenar el archivo JSON.
	 */
	void crearJsonVacio(String ruta);
	
	/**
	 * Sube el archivo JSON a la carpeta del contenido didáctico. El JSON debe estar compuesto
	 * de dos elementos: la ruta del contenido y un arreglo con los artefactos a subir. La ruta
	 * del contenido debe tener la siguiente estructura jerárquica:
	 * [Grupo] -> [Contenido] -> [Etapa] -> [Versión].
	 * 
	 * @param json El JSON formado y recibido desde el cliente. Debe contener la ruta del
	 * contenido didáctico y el arreglo con los artefactos a guardar.
	 * @throws RuntimeException Si ocurre algún error al momento de almacenar el archivo JSON.
	 */
	void guardarJson(String json);
	
	/**
	 * Descarga el archivo JSON con los artefactos dentro de la carpeta del contenido didáctico.
	 * La ruta del contenido debe tener la siguiente estructura jerárquica:
	 * [Grupo] -> [Contenido] -> [Etapa] -> [Versión].
	 * 
	 * @param ruta La ruta del archivo JSON. Debe tener la estructura mostrada anteriormente.
	 * @return Una cadena con el archivo JSON.
	 * @throws RuntimeException Si ocurre un error al momento de descargar el archivo JSON.
	 */
	String descargarJson(String ruta);
	
	/**
	 * Crea una nueva carpeta.
	 * 
	 * @param ruta La ruta de la carpeta a ser creada.
	 * @throws RuntimeException Si ocurre un error al momento de crear la carpeta.
	 */
	void crearCarpeta(String ruta);
	
	/**
	 * Regresa una serie de objetos necesarios para descargar el contenido didáctico.
	 * El mapa que regresa contiene un FileInputStream ("inputStream"), dos String ("fileName" y "contentType")
	 * y un valor Long ("contentLength").
	 * 
	 * @param detallesContenido Contiene la etapa, el nombre del contenido y el nombre del grupo que lo editó.
	 * @return Un arreglo asociativo con los objetos necesarios para descargar el archivo.
	 * @throws RuntimeException Si ocurre algún error al momento de descargar el contenido.
	 */
	Map<String, Object> descargar(Map<String, Object> detallesContenido);
    
    /**
     * Borra una carpeta
     * 
     * @param ruta La ruta de la carpeta a ser borrada.
     * @throws RuntimeException Si ocurre un error al momento de borrar la carpeta
     */
    void borrarCarpeta(String ruta);
}
