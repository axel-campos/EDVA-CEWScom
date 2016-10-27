package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class Conferencia implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String objetivos;
    private String tematica;

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

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}