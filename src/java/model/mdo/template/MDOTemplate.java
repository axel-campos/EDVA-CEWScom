package model.mdo.template;

import java.util.List;
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
	 * @param paso Paso del MDOArtifact.
     * @param artifact Artefacto de la etapa correspondiente (para poner el nombre se utiliza este artefacto).
	 * @return Una cadena con el codigo HTML de los steps para el artefacto.
	 */
    String generarStepHTML(int paso, MDOArtifact artifact);
    
    /**
	 * Genera un archivo HTML completo con los artefactos MDO
	 * ya incrustados en su interior.
	 * 
	 * @param bodyHTML Una lista de cadenas las cuales se ocuparan para substituir el body (Primer el orden de los pasos y despues su definicion).
	 * @return Un archivo HTML en forma de cadena.
	 */
	String generarPlantilla(List<String> bodyHTML);
}