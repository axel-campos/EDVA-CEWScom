package model.mdo.template;

import java.util.List;
import java.util.Map;
import model.mdo.artifacts.MDOArtifact;

/**
 * Contiene un método para generar un archivo completo HTML,
 * incrustando además el código de los artefactos MDO. Cada
 * etapa de MDO debe implementar esta interfaz.
 */
public interface MDOTemplate {
    
    /**
	 * Genera un archivo HTML completo con los artefactos MDO
	 * ya incrustados en su interior.
	 * 
	 * @param detalles_plantilla Un mapa definiendo los detalles de la plantilla como titulo, version, grupo, descripcion, etc.
	 * @return La referencia al mismo template.
	 */
    MDOTemplate setDetalles(Map<String,Object> detalles_plantilla);
    
    /**
	 * Genera un archivo HTML completo con los artefactos MDO
	 * ya incrustados en su interior.
	 * 
	 * @param html Una lista de cadenas las cuales se ocuparan para substituir el body.
     * @param resourceReference Una cadena indicando de donde se leeran los css's y js's del template.
	 * @return Un archivo HTML en forma de cadena.
	 */
	String generarPlantilla(List<String> html, String resourceReference);
}