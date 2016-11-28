package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Pelicula implements MDOArtifact {

    private int paso;
    private String titulo;
    private String descripcion;
    private String director;
    private String productora;
    private String pais;
    private String anyo;

    public Pelicula setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Pelicula setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Pelicula setDirector(String director) {
        this.director = director;
        return this;
    }

    public Pelicula setProductora(String productora) {
        this.productora = productora;
        return this;
    }

    public Pelicula setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public Pelicula setAnyo(String anyo) {
        this.anyo = anyo;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"documentacion4_%s\">\n"
            + "                                    <span class=\"section\">Película: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Director</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Productor</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">País</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Año</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, descripcion, director, productora, pais, anyo);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
