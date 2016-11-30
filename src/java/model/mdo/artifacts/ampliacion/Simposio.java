package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class Simposio implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String tematica;
    private String numeroDeIntegrantes;
    private String tiempoDeExposicion;
    private String recurso;

    public Simposio setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Simposio setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Simposio setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Simposio setNumeroDeIntegrantes(String numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
        return this;
    }

    public Simposio setTiempoDeExposicion(String tiempoDeExposicion) {
        this.tiempoDeExposicion = tiempoDeExposicion;
        return this;
    }

    public Simposio setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"ampliacion4_%s\">\n"
            + "                                    <span class=\"section\">Simposio: <small>%s</small></span> \n"
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
