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
     * @param detalles_template Detalles para el template para hacerlo mas
     * personalizado.
     */
    public static MDOTemplate getTemplate(String etapa, Map<String, Object> detalles_template) {
        if (etapa.contains("vivencia")) {
            return new VivenciaTemplate(detalles_template);
        } else if (etapa.contains("conceptualizacion")) {
            return new ConceptualizacionTemplate(detalles_template);
        } else if (etapa.contains("documentacion")) {
            return new DocumentacionTemplate(detalles_template);
        } else if (etapa.contains("aplicacion")) {
            return new AplicacionTemplate(detalles_template);
        } else {
            return new AmpliacionTemplate(detalles_template);
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
        String artifactString = "";
        if (template instanceof VivenciaTemplate) {
            if (artifact instanceof Demostracion) {
                artifactString = "Demostración";
            } else if (artifact instanceof Ensayo) {
                artifactString = "Ensayo";
            } else if (artifact instanceof Observacion) {
                artifactString = "Observación";
            } else if (artifact instanceof Simulacion) {
                artifactString = "Simulación";
            } else if (artifact instanceof Visita) {
                artifactString = "Visita";
            }
        } else if (template instanceof ConceptualizacionTemplate) {
            if (artifact instanceof GrupoEstudio) {
                artifactString = "Grupo de Estudio";
            } else if (artifact instanceof LluviaIdeas) {
                artifactString = "Lluvia de ideas";
            } else if (artifact instanceof Preguntas) {
                artifactString = "Preguntas";
            } else if (artifact instanceof Tutoria) {
                artifactString = "Tutoría";
            }
        } else if (template instanceof DocumentacionTemplate) {
            if (artifact instanceof ArticuloPDF) {
                artifactString = "Articulo PDF";
            } else if (artifact instanceof ArticuloWeb) {
                artifactString = "Aplicación";
            } else if (artifact instanceof Libro) {
                artifactString = "Libro";
            } else if (artifact instanceof Pelicula) {
                artifactString = "Película";
            } else if (artifact instanceof Revista) {
                artifactString = "Revista";
            } else if (artifact instanceof Video) {
                artifactString = "Video";
            }
        } else if (template instanceof AmpliacionTemplate) {
            if (artifact instanceof Conferencia) {
                artifactString = "Conferencia";
            } else if (artifact instanceof MesaRedonda) {
                artifactString = "Mesa Redonda";
            } else if (artifact instanceof Panel) {
                artifactString = "Panel";
            } else if (artifact instanceof Simposio) {
                artifactString = "Simposio";
            }
        } else if (template instanceof AplicacionTemplate) {
            if (artifact instanceof ArbolProblemas) {
                artifactString = "Arbol de Problemas";
            } else if (artifact instanceof Ejercicios) {
                artifactString = "Ejercicios";
            } else if (artifact instanceof EstudioCaso) {
                artifactString = "Estudio de Caso";
            } else if (artifact instanceof MapaConceptual) {
                artifactString = "Mapa Conceptual";
            } else if (artifact instanceof MarcoLogico) {
                artifactString = "Marco Lógico";
            } else if (artifact instanceof ProyectoInvestigacion) {
                artifactString = "Proyecto de Investigación";
            }
        }

        return String.format("<li>\n"
            + "                          <a href=\"#%s\">\n"
            + "                            <span class=\"step_no\">%s</span>\n"
            + "                          </a>\n"
            + "                        </li>", paso, artifactString);
    }
}

