package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.vivencias.*;
import model.mdo.artifacts.MDOArtifact;

public class ProyectoInvestigacion implements MDOArtifact {

	private String titulo;
	private String descripcion;
	private String objetivos;
    private String marcoTeorico;
    private String hipotesis;
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

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getMarcoTeorico() {
        return marcoTeorico;
    }

    public void setMarcoTeorico(String marcoTeorico) {
        this.marcoTeorico = marcoTeorico;
    }

    public String getHipotesis() {
        return hipotesis;
    }

    public void setHipotesis(String hipotesis) {
        this.hipotesis = hipotesis;
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