package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class ArbolProblemas implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String problematicaPrincipal;
    private String causas;
    private String problemasSecundarios;
    private String efectos;

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
    
	@Override
	public String toHtml() {
		return String.format("");
	}
}