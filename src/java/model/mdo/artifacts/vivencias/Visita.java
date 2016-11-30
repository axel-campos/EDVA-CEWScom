package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Visita implements MDOArtifact {

    private int paso;
    private String titulo;
    private String lugarAVisitar;
    private String tematicaDelLugar;
    private String proposito;
    private String objetivos;
    private String entregables;
    private String descripcion;
    private String recurso;

    public Visita setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Visita setLugarAVisitar(String lugarAVisitar) {
        this.lugarAVisitar = lugarAVisitar;
        return this;
    }

    public Visita setTematicaDelLugar(String tematicaDelLugar) {
        this.tematicaDelLugar = tematicaDelLugar;
        return this;
    }

    public Visita setProposito(String proposito) {
        this.proposito = proposito;
        return this;
    }

    public Visita setObjetivos(String objetivos) {
        this.objetivos = objetivos;
        return this;
    }

    public Visita setEntregables(String entregables) {
        this.entregables = entregables;
        return this;
    }

    public Visita setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Visita setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"vivencias5_%s\">\n"
            + "                                    <span class=\"section\">Visita: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Lugar a Visitar</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática Del Lugar</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Propósito</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Objetivos</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Entregables</h2>\n"
            + "                                    <p>%s</p>\n"
            + htmlResource
            + "                                </div>", paso, titulo, descripcion, lugarAVisitar, tematicaDelLugar, proposito, objetivos, entregables);
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
