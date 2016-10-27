package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class EstudioCaso implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String objetivos;
    private String problematica;
    private String metodosDeInvestigacion;
    private String entregables;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getProblematica() {
        return problematica;
    }

    public void setProblematica(String problematica) {
        this.problematica = problematica;
    }

    public String getMetodosDeInvestigacion() {
        return metodosDeInvestigacion;
    }

    public void setMetodosDeInvestigacion(String metodosDeInvestigacion) {
        this.metodosDeInvestigacion = metodosDeInvestigacion;
    }

    public String getEntregables() {
        return entregables;
    }

    public void setEntregables(String entregables) {
        this.entregables = entregables;
    }
    
	@Override
	public String toHtml() {
		return String.format("");
	}
}