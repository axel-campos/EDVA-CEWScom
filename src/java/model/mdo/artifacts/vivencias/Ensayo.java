package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Ensayo implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String requisitos;
    private String tiempoDeRealizacion;

    public Ensayo setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Ensayo setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Ensayo setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Ensayo setRequisitos(String requisitos) {
        this.requisitos = requisitos;
        return this;
    }

    public Ensayo setTiempoDeRealizacion(String tiempoDeRealizacion) {
        this.tiempoDeRealizacion = tiempoDeRealizacion;
        return this;
    }
    
	@Override
	public String toHtml() {
		return String.format("");
	}
}