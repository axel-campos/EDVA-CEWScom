package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Ensayo implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String requisitos;
    private String tiempoDeRealizacion;

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

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getTiempoDeRealizacion() {
        return tiempoDeRealizacion;
    }

    public void setTiempoDeRealizacion(String tiempoDeRealizacion) {
        this.tiempoDeRealizacion = tiempoDeRealizacion;
    }
    
	@Override
	public String toHtml() {
		return String.format("");
	}
}