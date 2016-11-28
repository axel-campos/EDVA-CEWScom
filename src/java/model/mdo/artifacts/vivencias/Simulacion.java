package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Simulacion implements MDOArtifact {

    private int paso;
    private String titulo;
    private String tematica;
    private String descripcion;
    private String roles;
    private String materialNecesario;
    private String procedimiento;

    public Simulacion setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Simulacion setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Simulacion setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Simulacion setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public Simulacion setMaterialNecesario(String materialNecesario) {
        this.materialNecesario = materialNecesario;
        return this;
    }

    public Simulacion setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"vivencias4_%s\">\n"
            + "                                    <span class=\"section\">Simulación: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Temática</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Roles</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Material Necesario</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Procedimiento</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, tematica, descripcion, roles, materialNecesario, procedimiento);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }

}
