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
	 * Guarda el contenido didáctico de manera encapsulada; es decir, con la siguiente estructura de carpeta
	 * jerárquica: [Grupo] -> [Contenido] -> [Etapa].
	 * 
	 * @param detallesContenido Contiene la etapa, el nombre del contenido y el nombre del grupo que lo editó.
	 * @param html Contiene el código HTML de los artefactos a guardar.
	 * @throws RuntimeException Si ocurre algún error al momento de almacenar el contenido.
	 */
	void guardar(Map<String, Object> detallesContenido, List<String> html);
	
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