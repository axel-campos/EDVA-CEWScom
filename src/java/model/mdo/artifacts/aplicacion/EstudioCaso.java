package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class EstudioCaso implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String objetivos;
    private String problematica;
    private String metodosDeInvestigacion;
    private String entregables;

    public EstudioCaso setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public EstudioCaso setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public EstudioCaso setObjetivos(String objetivos) {
        this.objetivos = objetivos;
        return this;
    }

    public EstudioCaso setProblematica(String problematica) {
        this.problematica = problematica;
        return this;
    }

    public EstudioCaso setMetodosDeInvestigacion(String metodosDeInvestigacion) {
        this.metodosDeInvestigacion = metodosDeInvestigacion;
        return this;
    }

    public EstudioCaso setEntregables(String entregables) {
        this.entregables = entregables;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"aplicacion3_%s\">\n"
            + "                                    <span class=\"section\">Estudio de Caso: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Objetivos</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Problemática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Métodos de Investigación</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Entregables</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, descripcion, objetivos, problematica, metodosDeInvestigacion, entregables);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
