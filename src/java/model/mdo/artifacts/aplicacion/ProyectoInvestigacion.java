package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class ProyectoInvestigacion implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String objetivos;
    private String marcoTeorico;
    private String hipotesis;
    private String entregables;

    public ProyectoInvestigacion setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ProyectoInvestigacion setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProyectoInvestigacion setObjetivos(String objetivos) {
        this.objetivos = objetivos;
        return this;
    }

    public ProyectoInvestigacion setMarcoTeorico(String marcoTeorico) {
        this.marcoTeorico = marcoTeorico;
        return this;
    }

    public ProyectoInvestigacion setHipotesis(String hipotesis) {
        this.hipotesis = hipotesis;
        return this;
    }

    public ProyectoInvestigacion setEntregables(String entregables) {
        this.entregables = entregables;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"aplicacion6_%s\">\n"
            + "                                    <span class=\"section\">Proyecto de Investigación: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Objetivos</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Marco Teórico</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Hipótesis</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Entregables</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, descripcion, objetivos, marcoTeorico, hipotesis,entregables);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
