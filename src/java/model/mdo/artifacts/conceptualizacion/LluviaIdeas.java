package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.MDOArtifact;

public class LluviaIdeas implements MDOArtifact {

    private int paso;
	private String titulo;
	private String descripcion;
	private String tematica;
    private String problematica;
    private String preguntasClave;

    public LluviaIdeas setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LluviaIdeas setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public LluviaIdeas setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public LluviaIdeas setProblematica(String problematica) {
        this.problematica = problematica;
        return this;
    }

    public LluviaIdeas setPreguntasClave(String preguntasClave) {
        this.preguntasClave = preguntasClave;
        return this;
    }
	
	@Override
	public String toHtml() {
		return String.format("");
	}
    
    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}