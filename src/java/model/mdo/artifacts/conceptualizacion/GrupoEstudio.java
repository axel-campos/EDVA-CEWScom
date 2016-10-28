package model.mdo.artifacts.conceptualizacion;

import model.mdo.artifacts.MDOArtifact;

public class GrupoEstudio implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String tematica;
    private String integrantesPorGrupo;
    private String entregables;

    public GrupoEstudio setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public GrupoEstudio setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public GrupoEstudio setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public GrupoEstudio setIntegrantesPorGrupo(String integrantesPorGrupo) {
        this.integrantesPorGrupo = integrantesPorGrupo;
        return this;
    }

    public GrupoEstudio setEntregables(String entregables) {
        this.entregables = entregables;
        return this;
    }
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}