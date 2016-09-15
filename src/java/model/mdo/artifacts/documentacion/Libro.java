package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Libro implements MDOArtifact {
	
	private String autor;
	private String titulo;
	private String anyo;
	private String ciudad;
	private String editorial;
	private String volumen;
	
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
	
	@Override
	public String toHtml() {
		return String.format(
			"<div class=\"container\">\n" +
	"			<div class=\"panel panel-info\">\n" +
	"				<div class=\"panel-heading\">\n" +
	"					<strong>Libro</strong>\n" +
	"				</div>\n" +
	"				<div class=\"panel-body\">\n" +
	"					<div class=\"col-md-12\">\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Autor:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Título:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Año:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Ciudad:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Editorial:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Volumen:</strong> %s" +
	"						</div>\n" +
	"					</div>\n" +
	"				</div>\n" +
	"			</div>\n" +
	"		</div>", autor, titulo, anyo, ciudad, editorial, volumen);
	}
}