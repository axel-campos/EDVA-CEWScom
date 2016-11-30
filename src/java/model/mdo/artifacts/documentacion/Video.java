package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Video implements MDOArtifact {

    private int paso;
    private String nombre;
    private String descripcion;
    private String url;
    private String recurso;

    public Video setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Video setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Video setUrl(String url) {
        this.url = url;
        return this;
    }

    public Video setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    public String getRecurso() {
        return recurso;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"documentacion6_%s\">\n"
            + "                                    <span class=\"section\">Video: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">URL</h2>\n"
            + "                                    <a href=\"%s\">%s</a>\n"
            + htmlResource
            + "                                </div>", paso, nombre, descripcion, url, url);
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
