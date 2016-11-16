package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Video implements MDOArtifact {

    private int paso;
    private String nombre;
    private String descripcion;
    private String url;

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

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"documentacion6_%s\">\n"
            + "                                    <span class=\"section\">Video: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">URL</h2>\n"
            + "                                    <a href=\"%s\">%s</a>\n"
            + "                                </div>",paso, nombre, descripcion, url, url);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
