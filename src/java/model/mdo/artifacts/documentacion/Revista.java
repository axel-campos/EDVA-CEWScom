package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Revista implements MDOArtifact {

    private int paso;
    private String autor;
    private String titulo;
    private String descripcion;
    private String nombre;
    private String anyo;
    private String paginas;
    private String volumen;
    private String numero;

    public Revista setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public Revista setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Revista setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Revista setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Revista setAnyo(String anyo) {
        this.anyo = anyo;
        return this;
    }

    public Revista setPaginas(String paginas) {
        this.paginas = paginas;
        return this;
    }

    public Revista setVolumen(String volumen) {
        this.volumen = volumen;
        return this;
    }

    public Revista setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format(
            "                                <div id=\"documentacion5_%s\">\n"
            + "                                    <span class=\"section\">Revista: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Autor</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Nombre</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Año</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Páginas</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Volumen</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Número</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                </div>", paso, titulo, autor, descripcion, nombre, anyo, paginas, volumen, numero);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
