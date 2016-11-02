package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Demostracion implements MDOArtifact {

    private int paso;
	private String titulo;
	private String objetivo;
	private String materialNecesario;
    private String procedimiento;
    

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
    
	@Override
	public String toHtml() {
		return String.format("<div id=\"%s\">\n" +
"                          <span class=\"section\">Demostración: <small>%s</small></span> \n" +
"							<h2 class=\"StepTitle\">Descripcion</h2>\n" +
"							<p>%s</p>\n" +
"							<h2 class=\"StepTitle\">Objetivo</h2>\n" +
"							<p>%s</p>\n" +
"							<h2 class=\"StepTitle\">Procedimiento</h2>\n" +
"							<p>%s</p>\n" +
"                      </div>",paso, titulo,objetivo,materialNecesario,procedimiento);
	}
    
    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
    
}