package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class Ejercicios implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String tematica;
    private String ejercicios;
    private String entregables;
    private String recurso;

    public Ejercicios setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Ejercicios setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Ejercicios setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Ejercicios setEjercicios(String ejercicios) {
        this.ejercicios = ejercicios;
        return this;
    }

    public Ejercicios setEntregables(String entregables) {
        this.entregables = entregables;
        return this;
    }

    public Ejercicios setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"aplicacion2_%s\">\n"
            + "                                    <span class=\"section\">Ejercicios: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Ejercicios</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Entregables</h2>\n"
            + "                                    <p>%s</p>\n"
            + htmlResource
            + "                                </div>", paso, titulo, descripcion, tematica, ejercicios, entregables);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }

    @Override
    public String getResource() {
        return this.recurso;
    }
}
