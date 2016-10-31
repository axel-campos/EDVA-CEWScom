package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class Video implements MDOArtifact {
	
    private int paso;
	private String nombre;
	private String descripcion;
	private String url;
	
	public Video setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public Video setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	public Video setUrl(String url) {
		this.url = url;
		return this;
	}
	
	@Override
	public String toHtml() {
		return String.format(
			"<div class=\"container\">\n" +
	"			<div class=\"panel panel-info\">\n" +
	"				<div class=\"panel-heading\">\n" +
	"					<strong>Video</strong>\n" +
	"				</div>\n" +
	"				<div class=\"panel-body\">\n" +
	"					<div class=\"col-md-12\">\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Nombre:</strong> %s" +
	"						</div>\n" +
	"						<div class=\"well well-sm\">\n" +
	"							<strong>Descripción:</strong> %s" +
	"						</div>\n" +
	"						<div align=\"center\">\n" +
	"							<iframe width=\"700\" height=\"480\" src=\"%s\" frameborder=\"0\" allowfullscreen></iframe>\n" +
	"						</div>\n" +
	"					</div>\n" +
	"				</div>\n" +
	"			</div>\n" +
	"		</div>", nombre, descripcion, url);
	}	
    
    @Override
    public MDOArtifact setPaso(int paso) {
        this.paso = paso;
        return this;
    }
}