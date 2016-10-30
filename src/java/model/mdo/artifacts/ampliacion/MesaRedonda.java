package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class MesaRedonda implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String numeroDeIntegrantes;
    private String tiempoDeExposicion;

    public MesaRedonda setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public MesaRedonda setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
        
    }

    public MesaRedonda setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public MesaRedonda setNumeroDeIntegrantes(String numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
        return this;
    }

    public MesaRedonda setTiempoDeExposicion(String tiempoDeExposicion) {
        this.tiempoDeExposicion = tiempoDeExposicion;
        return this;
    }
    
	@Override
	public String toHtml() {
		return String.format("");
	}
}