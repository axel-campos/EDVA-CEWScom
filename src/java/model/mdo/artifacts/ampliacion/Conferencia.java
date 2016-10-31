package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class Conferencia implements MDOArtifact {
    
    private int paso;
	private String titulo;
	private String descripcion;
	private String objetivos;
    private String tematica;

    public Conferencia setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Conferencia setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Conferencia setObjetivos(String objetivos) {
        this.objetivos = objetivos;
        return this;
    }

    public Conferencia setTematica(String tematica) {
        this.tematica = tematica;
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