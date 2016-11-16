package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class ArticuloWeb implements MDOArtifact {

    private int paso;
    private String autor;
    private String titulo;
    private String descripcion;
    private String nombre;
    private String anyo;
    private String mes;
    private String dia;
    private String url;

    public ArticuloWeb setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public ArticuloWeb setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ArticuloWeb setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ArticuloWeb setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ArticuloWeb setAnyo(String anyo) {
        this.anyo = anyo;
        return this;
    }

    public ArticuloWeb setMes(String mes) {
        this.mes = mes;
        return this;
    }

    public ArticuloWeb setDia(String dia) {
        this.dia = dia;
        return this;
    }

    public ArticuloWeb setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"documentacion2_%s\">\n"
            + "                                    <span class=\"section\">Artículo Web: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Autor</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Nombre</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Año</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Mes</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Día</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">URL</h2>\n"
            + "                                    <a href='%s'>%s</a>\n"
            + "                                </div>",paso, titulo, autor, descripcion, nombre, anyo, mes, dia, url, url);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
