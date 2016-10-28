package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class Panel implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String numeroDeIntegrantes;
    private String tiempoDeExposicion;

    public Panel setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Panel setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Panel setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Panel setNumeroDeIntegrantes(String numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
        return this;
    }

    public Panel setTiempoDeExposicion(String tiempoDeExposicion) {
        this.tiempoDeExposicion = tiempoDeExposicion;
        return this;
    }
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}