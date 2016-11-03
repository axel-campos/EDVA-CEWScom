package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class MapaConceptual implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String tematica;
    private String entregables;

    public MapaConceptual setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public MapaConceptual setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public MapaConceptual setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public MapaConceptual setEntregables(String entregables) {
        this.entregables = entregables;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"aplicacion4_%s\">\n"
            + "                                    <span class=\"section\">Mapa Conceptual: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Entregables</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, descripcion, tematica, entregables);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
