package model.mdo.parsers;

import java.util.Map;
import model.mdo.artifacts.MDOArtifact;

/**
 * Establece un método para convertir un arreglo asociativo
 * en un objeto específico que implemente la interfaz MDOArtifact.
 */
public interface MDOParser {
	
	/**
	 * Convierte un arreglo asociativo en un objeto MDOArtifact.
	 * 
	 * @param artefacto El arreglo asociativo a convertir.
	 * @return Un objeto MDOArtifact.
	 */
	MDOArtifact parse(Map<String, Object> artefacto);
}