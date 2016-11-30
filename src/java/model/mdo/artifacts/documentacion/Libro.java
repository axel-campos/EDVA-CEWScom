package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Libro implements MDOArtifact {

    private int paso;
    private String autor;
    private String titulo;
    private String anyo;
    private String ciudad;
    private String editorial;
    private String volumen;
    private String descripcion;
    private String recurso;

    public Libro setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public Libro setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Libro setAnyo(String anyo) {
        this.anyo = anyo;
        return this;
    }

    public Libro setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public Libro setEditorial(String editorial) {
        this.editorial = editorial;
        return this;
    }

    public Libro setVolumen(String volumen) {
        this.volumen = volumen;
        return this;
    }
    
    public Libro setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
    
    public Libro setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"documentacion3_%s\">\n"
            + "                                    <span class=\"section\">Libro: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Autor</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Año</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Ciudad</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Editorial</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Volumen</h2>\n"
            + "                                    <p>%s</p>\n"
                + htmlResource
            + "                                </div>", paso, titulo, autor, anyo, ciudad, editorial, volumen);
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
