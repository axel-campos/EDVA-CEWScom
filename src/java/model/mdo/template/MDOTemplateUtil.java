package model.mdo.template;

import java.util.Map;
import model.mdo.artifacts.MDOArtifact;
import model.mdo.artifacts.ampliacion.*;
import model.mdo.artifacts.conceptualizacion.*;
import model.mdo.artifacts.aplicacion.*;
import model.mdo.artifacts.documentacion.*;
import model.mdo.artifacts.vivencias.*;

/**
 * Clase auxiliar para la creación de las plantillas MDO.
 */
public final class MDOTemplateUtil {

    private MDOTemplateUtil() {
    }

    /**
     * Regresa el generador de plantillas indicado.
     *
     * @param etapa El nombre de la etapa MDO.
     */
    public static MDOTemplate getTemplate(String etapa) {
        if (etapa.contains("vivencia")) {
            return new VivenciaTemplate();
        } else if (etapa.contains("conceptualizacion")) {
            return new ConceptualizacionTemplate();
        } else if (etapa.contains("documentacion")) {
            return new DocumentacionTemplate();
        } else if (etapa.contains("aplicacion")) {
            return new AplicacionTemplate();
        } else {
            return new AmpliacionTemplate();
        }
    }

    /**
     * Genera un archivo HTML completo con los artefactos MDO ya incrustados en
     * su interior.
     *
     * @param paso Paso del MDOArtifact.
     * @param artifact Artefacto de la etapa correspondiente (para poner el
     * nombre se utiliza este artefacto).
     * @param template Template de la etapa correspondiente (para no buscar
     * entre todos los artefactos).
     * @return Una cadena con el codigo HTML de los steps para el artefacto.
     */
    public static String generarStepHTML(int paso, MDOTemplate template, MDOArtifact artifact) {
        String artifactName = "", artifactString = "", artifactID = "";
        if (template instanceof VivenciaTemplate) {
            artifactString = "vivencias";
            if (artifact instanceof Demostracion) {
                artifactName = "Demostración";
                artifactID = "1";
            } else if (artifact instanceof Ensayo) {
                artifactName = "Ensayo";
                artifactID = "2";
            } else if (artifact instanceof Observacion) {
                artifactName = "Observación";
                artifactID = "3";
            } else if (artifact instanceof Simulacion) {
                artifactName = "Simulación";
                artifactID = "4";
            } else if (artifact instanceof Visita) {
                artifactName = "Visita";
                artifactID = "5";
            }
        } else if (template instanceof ConceptualizacionTemplate) {
            artifactString = "conceptualizacion";
            if (artifact instanceof GrupoEstudio) {
                artifactName = "Grupo de Estudio";
                artifactID = "1";
            } else if (artifact instanceof LluviaIdeas) {
                artifactName = "Lluvia de ideas";
                artifactID = "2";
            } else if (artifact instanceof Preguntas) {
                artifactName = "Preguntas";
                artifactID = "3";
            } else if (artifact instanceof Tutoria) {
                artifactName = "Tutoría";
                artifactID = "4";
            }
        } else if (template instanceof DocumentacionTemplate) {
            artifactString = "documentacion";
            if (artifact instanceof ArticuloPDF) {
                artifactName = "Articulo PDF";
                artifactID = "1";
            } else if (artifact instanceof ArticuloWeb) {
                artifactName = "Aplicación";
                artifactID = "2";
            } else if (artifact instanceof Libro) {
                artifactName = "Libro";
                artifactID = "3";
            } else if (artifact instanceof Pelicula) {
                artifactName = "Película";
                artifactID = "4";
            } else if (artifact instanceof Revista) {
                artifactName = "Revista";
                artifactID = "5";
            } else if (artifact instanceof Video) {
                artifactName = "Video";
                artifactID = "6";
            }
        } else if (template instanceof AplicacionTemplate) {
            artifactString = "aplicacion";
            if (artifact instanceof ArbolProblemas) {
                artifactName = "Arbol de Problemas";
                artifactID = "1";
            } else if (artifact instanceof Ejercicios) {
                artifactName = "Ejercicios";
                artifactID = "2";
            } else if (artifact instanceof EstudioCaso) {
                artifactName = "Estudio de Caso";
                artifactID = "3";
            } else if (artifact instanceof MapaConceptual) {
                artifactName = "Mapa Conceptual";
                artifactID = "4";
            } else if (artifact instanceof MarcoLogico) {
                artifactName = "Marco Lógico";
                artifactID = "5";
            } else if (artifact instanceof ProyectoInvestigacion) {
                artifactName = "Proyecto de Investigación";
                artifactID = "6";
            }
        } else if (template instanceof AmpliacionTemplate) {
            artifactString = "ampliacion";
            if (artifact instanceof Conferencia) {
                artifactName = "Conferencia";
                artifactID = "1";
            } else if (artifact instanceof MesaRedonda) {
                artifactName = "Mesa Redonda";
                artifactID = "2";
            } else if (artifact instanceof Panel) {
                artifactName = "Panel";
                artifactID = "3";
            } else if (artifact instanceof Simposio) {
                artifactName = "Simposio";
                artifactID = "4";
            }
        }

        return String.format("                                    <li>\n"
            + "                                        <a href=\"#%s%s_%s\">\n"
            + "                                            <span class=\"step_no\">%s</span>\n"
            + "                                        </a>\n"
            + "                                    </li>", artifactString, artifactID, paso, artifactName);
    }
}
