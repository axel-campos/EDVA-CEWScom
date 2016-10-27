package model.mdo.artifacts.ampliacion;

import model.mdo.artifacts.MDOArtifact;

public class MesaRedonda implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String numeroDeIntegrantes;
    private String posibleResultado;

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

    public String getNumeroDeIntegrantes() {
        return numeroDeIntegrantes;
    }

    public void setNumeroDeIntegrantes(String numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
    }

    public String getPosibleResultado() {
        return posibleResultado;
    }

    public void setPosibleResultado(String posibleResultado) {
        this.posibleResultado = posibleResultado;
    }
    
    
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}