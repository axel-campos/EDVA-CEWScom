package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.vivencias.*;
import model.mdo.artifacts.MDOArtifact;

public class GrupoEstudio implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String integrantesPorGrupo;
    private String entregables;

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

    public String getIntegrantesPorGrupo() {
        return integrantesPorGrupo;
    }

    public void setIntegrantesPorGrupo(String integrantesPorGrupo) {
        this.integrantesPorGrupo = integrantesPorGrupo;
    }

    public String getEntregables() {
        return entregables;
    }

    public void setEntregables(String entregables) {
        this.entregables = entregables;
    }
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}