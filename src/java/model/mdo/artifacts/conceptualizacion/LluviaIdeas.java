package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.MDOArtifact;

public class LluviaIdeas implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String tematica;
    private String problematica;
    private String preguntasClave;

    public LluviaIdeas setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LluviaIdeas setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public LluviaIdeas setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public LluviaIdeas setProblematica(String problematica) {
        this.problematica = problematica;
        return this;
    }

    public LluviaIdeas setPreguntasClave(String preguntasClave) {
        this.preguntasClave = preguntasClave;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"conceptualizacion2_%s\">\n"
            + "                                    <span class=\"section\">Lluvia de Ideas: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Problematica</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Preguntas Clave</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, descripcion, tematica, problematica, preguntasClave);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
