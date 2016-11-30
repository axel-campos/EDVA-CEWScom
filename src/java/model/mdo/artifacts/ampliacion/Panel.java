package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class Panel implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String tematica;
    private String numeroDeIntegrantes;
    private String tiempoDeExposicion;
    private String recurso;

    public Panel setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Panel setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Panel setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Panel setNumeroDeIntegrantes(String numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
        return this;
    }

    public Panel setTiempoDeExposicion(String tiempoDeExposicion) {
        this.tiempoDeExposicion = tiempoDeExposicion;
        return this;
    }

    public Panel setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"ampliacion3_%s\">\n"
            + "                                    <span class=\"section\">Panel: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Número de Integrantes</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Tiempo de Exposición</h2>\n"
            + "                                    <p>%s</p>\n"
            + htmlResource
            + "                                </div>", paso, titulo, descripcion, tematica, numeroDeIntegrantes, tiempoDeExposicion);
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
