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
        return String.format(
            "                                <div id=\"conceptualizacion4_%s\">\n"
            + "                                    <span class=\"section\">Tutoría <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Objetivos</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Temas a Tratar</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Maerial de Apoyo</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, descripcion, objetivos, temasATratar, materialDeApoyo);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
