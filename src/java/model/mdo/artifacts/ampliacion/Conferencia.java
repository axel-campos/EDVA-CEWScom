package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class Conferencia implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String objetivos;
    private String tematica;

    public Conferencia setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Conferencia setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Conferencia setObjetivos(String objetivos) {
        this.objetivos = objetivos;
        return this;
    }

    public Conferencia setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"ampliacion1_%s\">\n"
            + "                                    <span class=\"section\">Conferencia: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Objetivos</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, descripcion, objetivos, tematica);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
