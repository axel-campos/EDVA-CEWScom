package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Demostracion implements MDOArtifact {

	private String titulo;
	private String objetivo;
	private String materialNecesario;
    private String procedimiento;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getMaterialNecesario() {
        return materialNecesario;
    }

    public void setMaterialNecesario(String materialNecesario) {
        this.materialNecesario = materialNecesario;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }
	
    
    
	@Override
	public String toHtml() {
		return String.format("<div id=\"$step_number\">\n" +
"                          <span class=\"section\">Demostración: <small>$s</small></span> \n" +
"							<h2 class=\"StepTitle\">Descripcion</h2>\n" +
"							<p>$s</p>\n" +
"							<h2 class=\"StepTitle\">Objetivo</h2>\n" +
"							<p>$s</p>\n" +
"							<h2 class=\"StepTitle\">Procedimiento</h2>\n" +
"							<p>$s</p>\n" +
"                      </div>", titulo,objetivo,materialNecesario,procedimiento);
	}
}