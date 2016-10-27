package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Observacion implements MDOArtifact {

	private String titulo;
	private String pregunta;
	private String fenomenoAObservar;
    private String posibleExplicacion;
    private String posibleResultado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getFenomenoAObservar() {
        return fenomenoAObservar;
    }

    public void setFenomenoAObservar(String fenomenoAObservar) {
        this.fenomenoAObservar = fenomenoAObservar;
    }

    public String getPosibleExplicacion() {
        return posibleExplicacion;
    }

    public void setPosibleExplicacion(String posibleExplicacion) {
        this.posibleExplicacion = posibleExplicacion;
    }

    public String getPosibleResultado() {
        return posibleResultado;
    }

    public void setPosibleResultado(String posibleResultado) {
        this.posibleResultado = posibleResultado;
    }
	
	@Override
	public String toHtml() {
		return String.format("");
	}
}