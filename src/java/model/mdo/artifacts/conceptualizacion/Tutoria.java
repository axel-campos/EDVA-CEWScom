package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.MDOArtifact;

public class Tutoria implements MDOArtifact {

    private int paso;
	private String titulo;
	private String descripcion;
	private String objetivos;
    private String temasATratar;
    private String materialDeApoyo;

    public Tutoria setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Tutoria setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Tutoria setObjetivos(String objetivos) {
        this.objetivos = objetivos;
        return this;
    }

    public Tutoria setTemasATratar(String temasATratar) {
        this.temasATratar = temasATratar;
        return this;
    }

    public Tutoria setMaterialDeApoyo(String materialDeApoyo) {
        this.materialDeApoyo = materialDeApoyo;
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