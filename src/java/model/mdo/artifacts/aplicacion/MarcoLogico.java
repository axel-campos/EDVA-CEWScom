package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class MarcoLogico implements MDOArtifact {

    private int paso;
	private String titulo;
	private String objetivoGeneral;
	private String objetivosEspecificos;
    private String resultadosEsperados;
    private String actividadesArealizar;
    private String indicadores;
    private String fuentesDeVerificacion;
    private String supuestos;
    
    public MarcoLogico setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public MarcoLogico setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
        return this;
    }

    public MarcoLogico setObjetivosEspecificos(String objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
        return this;
    }
    
    public MarcoLogico setResultadosEsperados(String resultadosEsperados) {
        this.resultadosEsperados = resultadosEsperados;
        return this;
    }

    public MarcoLogico setActividadesArealizar(String actividadesArealizar) {
        this.actividadesArealizar = actividadesArealizar;
        return this;
    }

    public MarcoLogico setIndicadores(String indicadores) {
        this.indicadores = indicadores;
        return this;
    }

    public MarcoLogico setFuentesDeVerificacion(String fuentesDeVerificacion) {
        this.fuentesDeVerificacion = fuentesDeVerificacion;
        return this;
    }

    public MarcoLogico setSupuestos(String supuestos) {
        this.supuestos = supuestos;
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