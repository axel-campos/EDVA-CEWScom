package model.mdo.artifacts.aplicacion;

import model.mdo.artifacts.MDOArtifact;

public class MarcoLogico implements MDOArtifact {

    private int paso;
    private String titulo;
    private String objetivoGeneral;
    private String objetivosEspecificos;
    private String resultadosEsperados;
    private String actividadesARealizar;
    private String indicadores;
    private String fuentesDeVerificacion;
    private String supuestos;
    private String descripcion;
    private String recurso;

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

    public MarcoLogico setActividadesARealizar(String actividadesARealizar) {
        this.actividadesARealizar = actividadesARealizar;
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

    public MarcoLogico setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public MarcoLogico setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"aplicacion5_%s\">\n"
            + "                                    <span class=\"section\">Marco Lógico: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripcion</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Objetivo General</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Objetivos Específicos</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Resultados Esperados</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Actividades A Realizar</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Indicadores</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Fuentes de Verificación</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Supuestos</h2>\n"
            + "                                    <p>%s</p>\n"
            + htmlResource
            + "                                </div>", paso, titulo, descripcion, objetivoGeneral, objetivosEspecificos, resultadosEsperados, actividadesARealizar, indicadores, fuentesDeVerificacion, supuestos);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }

    @Override
    public String getResource() {
        return this.recurso;
    }
}
