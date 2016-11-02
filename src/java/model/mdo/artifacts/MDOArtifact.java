package model.mdo.artifacts;

/**
 * Interfaz que representa a todos los artefactos MDO.
 * Contiene un solo método, el cual convierte los atributos
 * de algún artefacto en código HTML que pueda ser insertado
 * en una página Web.
 */
public interface MDOArtifact {
	
	/**
	 * Convierte los atributos del artefacto MDO
	 * en código HTML, que puede incrustarse dentro
	 * de una página Web.
	 * 
	 * @return Cadena HTML con los atributos del artefacto.
	 */
	String toHtml();
    
    /**
	 * Establece el paso en el codigo HTML
     * en el cual va a ser estructurado en la etapa.
	 * 
	 * @param paso Paso al que pertenece el MDO Artifact.
     * @return La referencia a MDOArtifact.
	 */
    MDOArtifact setPaso(int paso);
}