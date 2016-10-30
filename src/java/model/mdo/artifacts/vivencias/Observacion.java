package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Observacion implements MDOArtifact {

    private int paso;
    private String titulo;
    private String pregunta;
    private String fenomenoAObservar;
    private String posibleExplicacion;
    private String posibleResultado;

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

    @Override
    public String toHtml() {
        return String.format("<div id=\"$s\">\n"
            + "                          <span class=\"section\">Observación: <small>$s</small></span> \n"
            + "							<h2 class=\"StepTitle\">Pregunta</h2>\n"
            + "							<p>$s</p>\n"
            + "							<h2 class=\"StepTitle\">Fenomeno a Observar</h2>\n"
            + "							<p>$s</p>\n"
            + "							<h2 class=\"StepTitle\">Posible Explicacion</h2>\n"
            + "							<p>$s</p>\n"
            + "							<h2 class=\"StepTitle\">Posible Resultado</h2>\n"
            + "							<p>$s</p>\n"
            + "                      </div>", paso, titulo, pregunta, fenomenoAObservar, posibleExplicacion, posibleResultado);
    }

    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}
