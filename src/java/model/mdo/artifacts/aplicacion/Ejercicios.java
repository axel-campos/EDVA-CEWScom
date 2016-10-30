package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class Ejercicios implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String ejercicios;
    private String entregables;

    public Ejercicios setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Ejercicios setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Ejercicios setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Ejercicios setEjercicios(String ejercicios) {
        this.ejercicios = ejercicios;
        return this;
    }

    public Ejercicios setEntregables(String entregables) {
        this.entregables = entregables;
        return this;
    }

    
    
	@Override
	public String toHtml() {
		return String.format("");
	}
}