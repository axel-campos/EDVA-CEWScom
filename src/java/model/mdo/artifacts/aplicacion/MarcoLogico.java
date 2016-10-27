package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class MarcoLogico implements MDOArtifact {

	private String titulo;
	private String objetivoGeneral;
	private String objetivosEspecificos;
    private String resultadosEsperados;
    private String actividadesArealizar;
    private String indicadores;
    private String fuentesDeVerificacion;
    private String supuestos;
    
    public String getResultadosEsperados() {
        return resultadosEsperados;
    }

    public void setResultadosEsperados(String resultadosEsperados) {
        this.resultadosEsperados = resultadosEsperados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public void setObjetivosEspecificos(String objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public String getActividadesArealizar() {
        return actividadesArealizar;
    }

    public void setActividadesArealizar(String actividadesArealizar) {
        this.actividadesArealizar = actividadesArealizar;
    }

    public String getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(String indicadores) {
        this.indicadores = indicadores;
    }

    public String getFuentesDeVerificacion() {
        return fuentesDeVerificacion;
    }

    public void setFuentesDeVerificacion(String fuentesDeVerificacion) {
        this.fuentesDeVerificacion = fuentesDeVerificacion;
    }

    public String getSupuestos() {
        return supuestos;
    }

    public void setSupuestos(String supuestos) {
        this.supuestos = supuestos;
    }
    
    
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}