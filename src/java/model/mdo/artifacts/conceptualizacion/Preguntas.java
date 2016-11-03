package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.MDOArtifact;

public class Preguntas implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String tematica;
    private String preguntasARealizar;

    public Preguntas setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Preguntas setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Preguntas setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Preguntas setPreguntasARealizar(String preguntasARealizar) {
        this.preguntasARealizar = preguntasARealizar;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"conceptualizacion3_%s\">\n"
            + "                                    <span class=\"section\">Preguntas: <small>%s</small></span>\n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Preguntas A Realizar</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, descripcion, tematica, preguntasARealizar);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
