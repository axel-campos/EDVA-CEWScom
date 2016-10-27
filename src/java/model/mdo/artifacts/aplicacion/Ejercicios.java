package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class Ejercicios implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String ejercicios;
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

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(String ejercicios) {
        this.ejercicios = ejercicios;
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