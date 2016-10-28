package model.mdo.parsers;

import java.util.Map;
import model.mdo.artifacts.MDOArtifact;
import model.mdo.artifacts.vivencias.*;

/**
 * Clase que se encarga de convertir arreglos asociativos en objetos MDOArtifact
 * de la etapa de Vivencia.
 */
public class VivenciaParser implements MDOParser {

    private MDOArtifact getObservacion(Map<String, Object> artefacto) {
        return new Observacion()
            .setTitulo((String) artefacto.get("titulo"))
            .setPregunta((String) artefacto.get("pregunta"))
            .setFenomenoAObservar((String) artefacto.get("fenomenoAObservar"))
            .setPosibleExplicacion((String) artefacto.get("posibleExplicacion"))
            .setPosibleResultado((String) artefacto.get("posibleResultado"));
    }

    private MDOArtifact getDemostracion(Map<String, Object> artefacto) {
        return new Demostracion()
            .setTitulo((String) artefacto.get("titulo"))
            .setObjetivo((String) artefacto.get("objetivo"))
            .setMaterialNecesario((String) artefacto.get("materialNecesario"))
            .setProcedimiento((String) artefacto.get("procedimiento"));
    }
    
    private MDOArtifact getSimulacion(Map<String, Object> artefacto) {
        return new Simulacion()
            .setTitulo((String) artefacto.get("titulo"))
            .setTematica((String) artefacto.get("tematica"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setRoles((String) artefacto.get("roles"))
            .setMaterialNecesario((String) artefacto.get("materialNecesario"))
            .setProcedimiento((String) artefacto.get("procedimiento"));
    }
    
    private MDOArtifact getVisita(Map<String, Object> artefacto) {
        return new Visita()
            .setTitulo((String) artefacto.get("titulo"))
            .setLugarAVisitar((String) artefacto.get("lugarAVisitar"))
            .setTematicaDelLugar((String) artefacto.get("tematica"))
            .setProposito((String) artefacto.get("proposito"))
            .setObjetivos((String) artefacto.get("objetivos"))
            .setEntregables((String) artefacto.get("entregables"));
    }
    
    private MDOArtifact getEnsayo(Map<String, Object> artefacto) {
        return new Ensayo()
            .setTitulo((String) artefacto.get("titulo"))
            .setDescripcion((String) artefacto.get("descripcion"))
            .setTematica((String) artefacto.get("tematica"))
            .setRequisitos((String) artefacto.get("requisitos"))
            .setTiempoDeRealizacion((String) artefacto.get("tiempoRealizacion"));
    }

    @Override
    public MDOArtifact parse(Map<String, Object> artefacto) {
        String nombre = (String) artefacto.get("artefacto");

        if (nombre.contains("observacion")) {
            return getObservacion(artefacto);
        } else if (nombre.contains("visita")) {
            return getVisita(artefacto);
        } else if (nombre.contains("demostracion")) {
            return getDemostracion(artefacto);
        } else if (nombre.contains("ensayo")) {
            return getEnsayo(artefacto);
        } else {
            return getSimulacion(artefacto);
        }
    }
}
