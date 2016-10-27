package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.vivencias.*;
import model.mdo.artifacts.MDOArtifact;

public class Tutoria implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String objetivos;
    private String temasATratar;
    private String materialDeApoyo;

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

    public String getTemasATratar() {
        return temasATratar;
    }

    public void setTemasATratar(String temasATratar) {
        this.temasATratar = temasATratar;
    }

    public String getMaterialDeApoyo() {
        return materialDeApoyo;
    }

    public void setMaterialDeApoyo(String materialDeApoyo) {
        this.materialDeApoyo = materialDeApoyo;
    }

    
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}