package model.mdo.artifacts.documentacion;

import model.mdo.artifacts.MDOArtifact;

public class ArticuloPDF implements MDOArtifact {

    private int paso;
	private String nombre;
	private String descripcion;
	private String url;
	
	public ArticuloPDF setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public ArticuloPDF setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	public ArticuloPDF setUrl(String url) {
		this.url = url;
		return this;
	}
	
	@Override
	public String toHtml() {
		return String.format(
			"<div class=\"container\">\n" +
	"			<div class=\"panel panel-info\">\n" +
	"				<div class=\"panel-heading\">\n" +
	"					<strong>Artículo PDF</strong>\n" +
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
	"							<object data='%s' type='application/pdf' width='700' height='480'></object>\n" +
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