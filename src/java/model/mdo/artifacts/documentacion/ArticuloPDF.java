package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class ArticuloPDF implements MDOArtifact {

    private int paso;
    private String nombre;
    private String descripcion;
    private String url;
    private String recurso;

    public ArticuloPDF setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ArticuloPDF setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ArticuloPDF setUrl(String url) {
        this.url = url;
        return this;
    }

    public ArticuloPDF setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"documentacion1_%s\">\n"
            + "                                    <span class=\"section\">Artículo PDF: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">URL</h2>\n"
            + "                                    <a href='%s'>%s</a>\n"
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
