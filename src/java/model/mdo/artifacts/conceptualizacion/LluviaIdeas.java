package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.vivencias.*;
import model.mdo.artifacts.MDOArtifact;

public class LluviaIdeas implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String problematica;
    private String preguntasClave;

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

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getProblematica() {
        return problematica;
    }

    public void setProblematica(String problematica) {
        this.problematica = problematica;
    }

    public String getPreguntasClave() {
        return preguntasClave;
    }

    public void setPreguntasClave(String preguntasClave) {
        this.preguntasClave = preguntasClave;
    }
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}