package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class ArbolProblemas implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String problematicaPrincipal;
    private String causas;
    private String problemasSecundarios;
    private String efectos;
    private String recurso;

    public ArbolProblemas setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ArbolProblemas setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ArbolProblemas setProblematicaPrincipal(String problematicaPrincipal) {
        this.problematicaPrincipal = problematicaPrincipal;
        return this;
    }

    public ArbolProblemas setCausas(String causas) {
        this.causas = causas;
        return this;
    }

    public ArbolProblemas setProblemasSecundarios(String problemasSecundarios) {
        this.problemasSecundarios = problemasSecundarios;
        return this;
    }

    public ArbolProblemas setEfectos(String efectos) {
        this.efectos = efectos;
        return this;
    }

    public ArbolProblemas setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"aplicacion1_%s\">\n"
            + "                                    <span class=\"section\">Árbol de Problemas: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Problemática Principal</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Causas</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Problemas Secundarios</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Efectos</h2>\n"
            + "                                    <p>%s</p>\n"
            + htmlResource
            + "                                </div>", paso, titulo, descripcion, problematicaPrincipal, causas, problemasSecundarios, efectos);
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
