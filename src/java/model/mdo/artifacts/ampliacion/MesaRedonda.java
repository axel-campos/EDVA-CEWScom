package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class MesaRedonda implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String tematica;
    private String numeroDeIntegrantes;
    private String tiempoDeExposicion;

    public MesaRedonda setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public MesaRedonda setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;

    }

    public MesaRedonda setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public MesaRedonda setNumeroDeIntegrantes(String numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
        return this;
    }

    public MesaRedonda setTiempoDeExposicion(String tiempoDeExposicion) {
        this.tiempoDeExposicion = tiempoDeExposicion;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"ampliacion2_%s\">\n"
            + "                                    <span class=\"section\">Mesa Redonda: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Numero de Integrantes</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Tiempo De Exposición</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>",paso,titulo,descripcion,tematica,numeroDeIntegrantes,tiempoDeExposicion);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
