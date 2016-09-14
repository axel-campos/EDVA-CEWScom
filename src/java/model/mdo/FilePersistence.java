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
	 * Regresa una serie de objetos necesarios para descargar el contenido didáctico.
	 * El mapa que regresa contiene un FileInputStream ("inputStream"), dos String ("fileName" y "contentType")
	 * y un valor Long ("contentLength").
	 * 
	 * @param detallesContenido Contiene la etapa, el nombre del contenido y el nombre del grupo que lo editó.
	 * @return Un arreglo asociativo con los objetos necesarios para descargar el archivo.
	 * @throws RuntimeException Si ocurre algún error al momento de descargar el contenido.
	 */
	Map<String, Object> descargar(Map<String, Object> detallesContenido);
}