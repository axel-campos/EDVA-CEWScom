package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.vivencias.*;
import model.mdo.artifacts.MDOArtifact;

public class Preguntas implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String preguntasARealizar;

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

    public String getPreguntasARealizar() {
        return preguntasARealizar;
    }

    public void setPreguntasARealizar(String preguntasARealizar) {
        this.preguntasARealizar = preguntasARealizar;
    }
    
    
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}