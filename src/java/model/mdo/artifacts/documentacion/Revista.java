package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Revista implements MDOArtifact {

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
			"<div class=\"container\">\n" +
	"			<div class=\"panel panel-info\">\n" +
	"				<div class=\"panel-heading\">\n" +
	"					<strong>Revista</strong>\n" +
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
	"							<strong>Nombre de la revista:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Año:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Páginas:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Volumen:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Número:</strong> %s" +
	"						</div>\n" +
	"					</div>\n" +
	"				</div>\n" +
	"			</div>\n" +
	"		</div>", autor, titulo, descripcion, nombre, anyo, paginas, volumen, numero);
	}
}