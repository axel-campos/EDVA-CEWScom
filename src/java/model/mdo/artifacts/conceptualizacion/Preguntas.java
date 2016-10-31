package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.MDOArtifact;

public class Preguntas implements MDOArtifact {

    private int paso;
	private String titulo;
	private String descripcion;
	private String tematica;
    private String preguntasARealizar;

    public Preguntas setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Preguntas setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Preguntas setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Preguntas setPreguntasARealizar(String preguntasARealizar) {
        this.preguntasARealizar = preguntasARealizar;
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