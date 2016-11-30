package model.mdo.parsers;

import java.util.Map;
import model.mdo.artifacts.MDOArtifact;
import model.mdo.artifacts.ampliacion.*;

/**
 * Clase que se encarga de convertir arreglos asociativos en objetos
 * MDOArtifact de la etapa de Ampliación.
 */
public class AmpliacionParser implements MDOParser {

    private MDOArtifact getConferencia(Map<String, Object> artefacto) {
        return new Conferencia()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setObjetivos((String) artefacto.get("objetivos"))
            .setTematica((String) artefacto.get("tematica"))
            .setRecurso((String) artefacto.get("recurso"));
    }
    
    private MDOArtifact getMesaRedonda(Map<String, Object> artefacto) {
        return new MesaRedonda()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setTematica((String) artefacto.get("tematica"))
            .setNumeroDeIntegrantes((String) artefacto.get("numeroIntegrantes"))
            .setTiempoDeExposicion((String) artefacto.get("tiempoExposicion"))
            .setRecurso((String) artefacto.get("recurso"));
    }
    
    private MDOArtifact getPanel(Map<String, Object> artefacto) {
        return new Panel()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setTematica((String) artefacto.get("tematica"))
            .setNumeroDeIntegrantes((String) artefacto.get("numeroIntegrantes"))
            .setTiempoDeExposicion((String) artefacto.get("tiempoExposicion"))
            .setRecurso((String) artefacto.get("recurso"));
    }
    
    private MDOArtifact getSimposio(Map<String, Object> artefacto) {
        return new Simposio()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setTematica((String) artefacto.get("tematica"))
            .setNumeroDeIntegrantes((String) artefacto.get("numeroIntegrantes"))
            .setTiempoDeExposicion((String) artefacto.get("tiempoExposicionPorIntegrante"))
            .setRecurso((String) artefacto.get("recurso"));
    }
    
	@Override
	public MDOArtifact parse(Map<String, Object> artefacto) {
        String nombre = (String) artefacto.get("artefacto");

        if (nombre.contains("conferencia")) {
            return getConferencia(artefacto);
        } else if (nombre.contains("mesaredonda")) {
            return getMesaRedonda(artefacto);
        } else if (nombre.contains("ampliacion-panel")) {
            return getPanel(artefacto);
        } else {
            return getSimposio(artefacto);
        }
    }
}