package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Observacion implements MDOArtifact {

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
		return String.format("");
	}
}