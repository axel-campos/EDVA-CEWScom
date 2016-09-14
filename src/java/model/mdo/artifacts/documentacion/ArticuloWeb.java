package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class ArticuloWeb implements MDOArtifact {

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
			"<div class=\"container\">\n" +
	"			<div class=\"panel panel-info\">\n" +
	"				<div class=\"panel-heading\">\n" +
	"					<strong>Artículo Web</strong>\n" +
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
	"							<strong>Descripción:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Nombre del sitio Web:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Año en que se realizó la consulta:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Mes en el que se realizó la consulta:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Día en que se realizó la consulta:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>URL:</strong> <a href='%s' target='_blank'>%s</a>" +
	"						</div>\n" +
	"					</div>\n" +
	"				</div>\n" +
	"			</div>\n" +
	"		</div>", autor, titulo, descripcion, nombre, anyo, mes, dia, url, nombre);
	}
}