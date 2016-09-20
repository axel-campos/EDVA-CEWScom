package model.mdo;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import model.mdo.artifacts.MDOArtifact;
import model.mdo.parsers.*;

/**
 * Contiene métodos de utilidad para manejar las
 * clases de este paquete.
 */
public final class MDOUtil {
	
	private MDOUtil() {}
	
	/**
	 * Convierte una lista de artefactos MDO (lista de mapas obtenida a partir de un JSON)
	 * en una lista de objetos MDOArtifact.
	 * 
	 * @param list Lista obtenida a partir de un JSON.
	 * @return Una lista de objetos MDOArtifact.
	 */
	public static List<MDOArtifact> parseJsonArtifacts(List<Map<String, Object>> list) {
		return list
			.stream()
			.map(e -> getParser((String)e.get("artefacto")).parse(e))
			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	/**
	 * Convierte una lista de objetos MDOArtifact en una lista de cadenas con
	 * código HTML.
	 * 
	 * @param list Lista de objetos MDOArtifact.
	 * @return Lista de cadenas, cada una con el HTML correspondiente de los
	 * artefactos.
	 */
	public static List<String> parseMDOArtifacts(List<MDOArtifact> list) {
		return list
			.stream()
			.map(e -> e.toHtml())
			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	/**
	 * Regresa un parse específico de acuerdo al nombre del artefacto.
	 * 
	 * @param artefacto El nombre del artefacto.
	 * @return Un objeto MDOParser que pueda convertir dicho artefacto
	 * en un objeto MDOArtifact.
	 */
	private static MDOParser getParser(String artefacto) {
		if (artefacto.contains("vivencia"))
			return new VivenciaParser();
		else if (artefacto.contains("conceptualizacion"))
			return new ConceptualizacionParser();
		else if (artefacto.contains("documentacion"))
			return new DocumentacionParser();
		else if (artefacto.contains("aplicacion"))
			return new AplicacionParser();
		else
			return new AmpliacionParser();
	}
}