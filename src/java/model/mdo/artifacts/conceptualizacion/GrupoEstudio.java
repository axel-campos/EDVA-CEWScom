package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.MDOArtifact;

public class GrupoEstudio implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String tematica;
    private String integrantesPorGrupo;
    private String entregables;
    private String recurso;

    public GrupoEstudio setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public GrupoEstudio setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public GrupoEstudio setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public GrupoEstudio setIntegrantesPorGrupo(String integrantesPorGrupo) {
        this.integrantesPorGrupo = integrantesPorGrupo;
        return this;
    }

    public GrupoEstudio setEntregables(String entregables) {
        this.entregables = entregables;
        return this;
    }

    public GrupoEstudio setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"conceptualizacion1_%s\">\n"
            + "                                    <span class=\"section\">Grupo de Estudio: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Integrantes Por Grupo</h2>\n"
            + "                                    <p>%s</p>\n"
            + "									<h2 class=\"StepTitle\">Entregables</h2>\n"
            + "                                    <p>%s</p>\n"
            + htmlResource
            + "                                </div>", paso, titulo, descripcion, tematica, integrantesPorGrupo, entregables);
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
