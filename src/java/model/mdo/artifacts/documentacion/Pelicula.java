package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Pelicula implements MDOArtifact {

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
			"<div class=\"container\">\n" +
	"			<div class=\"panel panel-info\">\n" +
	"				<div class=\"panel-heading\">\n" +
	"					<strong>Película</strong>\n" +
	"				</div>\n" +
	"				<div class=\"panel-body\">\n" +
	"					<div class=\"col-md-12\">\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Título:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Descripción:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Director:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Productora:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>País:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Año:</strong> %s" +
	"						</div>\n" +
	"					</div>\n" +
	"				</div>\n" +
	"			</div>\n" +
	"		</div>", titulo, descripcion, director, productora, pais, anyo);
	}	
}