package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Visita implements MDOArtifact {

	private String titulo;
	private String lugarAVisitar;
	private String tematicaDelLugar;
    private String proposito;
    private String objetivos;
    private String entregables;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLugarAVisitar() {
        return lugarAVisitar;
    }

    public void setLugarAVisitar(String lugarAVisitar) {
        this.lugarAVisitar = lugarAVisitar;
    }

    public String getTematicaDelLugar() {
        return tematicaDelLugar;
    }

    public void setTematicaDelLugar(String tematicaDelLugar) {
        this.tematicaDelLugar = tematicaDelLugar;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
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