package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.vivencias.*;
import model.mdo.artifacts.MDOArtifact;

public class Simposio implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String numeroDeIntegrantes;
    private String tiempoDeExposicion;

    public Simposio setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Simposio setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Simposio setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Simposio setNumeroDeIntegrantes(String numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
        return this;
    }

    public Simposio setTiempoDeExposicion(String tiempoDeExposicion) {
        this.tiempoDeExposicion = tiempoDeExposicion;
        return this;
    }
    
	@Override
	public String toHtml() {
		return String.format("");
	}
}