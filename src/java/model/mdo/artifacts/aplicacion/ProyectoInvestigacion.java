package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class ProyectoInvestigacion implements MDOArtifact {

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
		return String.format("");
	}
}