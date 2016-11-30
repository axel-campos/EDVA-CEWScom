package model.mdo.parsers;

import java.util.Map;
import model.mdo.artifacts.MDOArtifact;
import model.mdo.artifacts.conceptualizacion.*;

/**
 * Clase que se encarga de convertir arreglos asociativos en objetos
 * MDOArtifact de la etapa de Conceptualización.
 */
public class ConceptualizacionParser implements MDOParser {
    
    private MDOArtifact getGrupoEstudio(Map<String, Object> artefacto) {
        return new GrupoEstudio()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setTematica((String) artefacto.get("tematica"))
            .setIntegrantesPorGrupo((String) artefacto.get("integrantes"))
            .setEntregables((String) artefacto.get("entregables"))
            .setRecurso((String) artefacto.get("recurso"));
    }
    
    private MDOArtifact getLluviaIdeas(Map<String, Object> artefacto) {
        return new LluviaIdeas()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setTematica((String) artefacto.get("tematica"))
            .setProblematica((String) artefacto.get("problematica"))
            .setPreguntasClave((String) artefacto.get("preguntasClave"))
            .setRecurso((String) artefacto.get("recurso"));
    }
    
    private MDOArtifact getPreguntas(Map<String, Object> artefacto) {
        return new Preguntas()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setTematica((String) artefacto.get("tematica"))
            .setPreguntasARealizar((String) artefacto.get("preguntas"))
            .setRecurso((String) artefacto.get("recurso"));
    }
    
    private MDOArtifact getTutoria(Map<String, Object> artefacto) {
        return new Tutoria()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("pregunta"))
            .setObjetivos((String) artefacto.get("objetivos"))
            .setTemasATratar((String) artefacto.get("temas"))
            .setMaterialDeApoyo((String) artefacto.get("materialApoyo"))
            .setRecurso((String) artefacto.get("recurso"));
    }

	@Override
	public MDOArtifact parse(Map<String, Object> artefacto) {
		String nombre = (String) artefacto.get("artefacto");

        if (nombre.contains("tutoria")) {
            return getTutoria(artefacto);
        } else if (nombre.contains("lluviaideas")) {
            return getLluviaIdeas(artefacto);
        } else if (nombre.contains("preguntas")) {
            return getPreguntas(artefacto);
        } else {
            return getGrupoEstudio(artefacto);
        }
	}
}