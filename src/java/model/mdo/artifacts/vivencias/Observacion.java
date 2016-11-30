package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Observacion implements MDOArtifact {

    private int paso;
    private String titulo;
    private String pregunta;
    private String fenomenoAObservar;
    private String posibleExplicacion;
    private String posibleResultado;
    private String descripcion;
    private String recurso;

    public Observacion setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Observacion setPregunta(String pregunta) {
        this.pregunta = pregunta;
        return this;
    }

    public Observacion setFenomenoAObservar(String fenomenoAObservar) {
        this.fenomenoAObservar = fenomenoAObservar;
        return this;
    }

    public Observacion setPosibleExplicacion(String posibleExplicacion) {
        this.posibleExplicacion = posibleExplicacion;
        return this;
    }

    public Observacion setPosibleResultado(String posibleResultado) {
        this.posibleResultado = posibleResultado;
        return this;
    }

    public Observacion setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Observacion setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public String toHtml(String htmlResource) {
        return String.format(
            "                                <div id=\"vivencias3_%s\">\n"
            + "                                    <span class=\"section\">Observación: <small>%s</small></span> \n"
            + "                                    <h2 class=\"StepTitle\">Descripción</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Pregunta</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Fenómeno a Observar</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Posible Explicación</h2>\n"
            + "                                    <p>%s</p>\n"
            + "                                    <h2 class=\"StepTitle\">Posible Resultado</h2>\n"
            + "                                    <p>%s</p>\n"
            + htmlResource
            + "                                </div>", paso, titulo, descripcion, pregunta, fenomenoAObservar, posibleExplicacion, posibleResultado);
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
