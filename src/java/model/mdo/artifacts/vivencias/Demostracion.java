package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Demostracion implements MDOArtifact {

    private int paso;
    private String titulo;
    private String objetivo;
    private String materialNecesario;
    private String procedimiento;
    private String descripcion;
    private String recurso;

    public Demostracion setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Demostracion setObjetivo(String objetivo) {
        this.objetivo = objetivo;
        return this;
    }

    public Demostracion setMaterialNecesario(String materialNecesario) {
        this.materialNecesario = materialNecesario;
        return this;
    }

    public Demostracion setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
        return this;
    }

    public Demostracion setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Demostracion setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"vivencias1_%s\">\n"
            + "                                    <span class=\"section\">Demostración: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Objetivo</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Material Necesario</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Procedimiento</h2>\n"
            + "                                    <p>%s</p>\n"
            + htmlResource
            + "                                </div>", paso, titulo, descripcion, objetivo, materialNecesario, procedimiento);
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
