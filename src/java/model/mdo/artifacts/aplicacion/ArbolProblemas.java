package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class ArbolProblemas implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String problematicaPrincipal;
    private String causas;
    private String problemasSecundarios;
    private String efectos;

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

    public String getProblematicaPrincipal() {
        return problematicaPrincipal;
    }

    public void setProblematicaPrincipal(String problematicaPrincipal) {
        this.problematicaPrincipal = problematicaPrincipal;
    }

    public String getCausas() {
        return causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

    public String getProblemasSecundarios() {
        return problemasSecundarios;
    }

    public void setProblemasSecundarios(String problemasSecundarios) {
        this.problemasSecundarios = problemasSecundarios;
    }

    public String getEfectos() {
        return efectos;
    }

    public void setEfectos(String efectos) {
        this.efectos = efectos;
    }

    
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}