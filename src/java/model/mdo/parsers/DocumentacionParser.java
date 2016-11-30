package model.mdo.parsers;

import java.util.Map;
import model.mdo.artifacts.MDOArtifact;
import model.mdo.artifacts.documentacion.*;

/**
 * Clase que se encarga de convertir arreglos asociativos en objetos
 * MDOArtifact de la etapa de Documentación.
 */
public final class DocumentacionParser implements MDOParser {

	private MDOArtifact getPelicula(Map<String, Object> artefacto) {
		return new Pelicula()
			.setTitulo((String)artefacto.get("titulo"))
			.setDescripcion((String)artefacto.get("descripcion"))
			.setDirector((String)artefacto.get("director"))
			.setProductora((String)artefacto.get("productora"))
			.setPais((String)artefacto.get("pais"))
			.setAnyo((String)artefacto.get("anyo"))
            .setRecurso((String) artefacto.get("recurso"));
	}
	
	private MDOArtifact getVideo(Map<String, Object> artefacto) {
		return new Video()
			.setNombre((String)artefacto.get("nombre"))
			.setDescripcion((String)artefacto.get("descripcion"))
			.setUrl((String)artefacto.get("url"))
            .setRecurso((String) artefacto.get("recurso"));
	}
	
	private MDOArtifact getLibro(Map<String, Object> artefacto) {
		return new Libro()
			.setAutor((String)artefacto.get("autor"))
			.setTitulo((String)artefacto.get("titulo"))
			.setAnyo((String)artefacto.get("anyo"))
			.setCiudad((String)artefacto.get("ciudad"))
			.setEditorial((String)artefacto.get("editorial"))
			.setVolumen((String)artefacto.get("volumen"))
            .setDescripcion((String)artefacto.get("descripcion"))
            .setRecurso((String) artefacto.get("recurso"));
	}
	
	private MDOArtifact getArticuloWeb(Map<String, Object> artefacto) {
		return new ArticuloWeb()
			.setAutor((String)artefacto.get("autor"))
			.setTitulo((String)artefacto.get("titulo"))
			.setDescripcion((String)artefacto.get("descripcion"))
			.setNombre((String)artefacto.get("nombre"))
			.setAnyo((String)artefacto.get("anyo"))
			.setMes((String)artefacto.get("mes"))
			.setDia((String)artefacto.get("dia"))
			.setUrl((String)artefacto.get("url"))
            .setRecurso((String) artefacto.get("recurso"));
	}
	
	private MDOArtifact getArticuloPDF(Map<String, Object> artefacto) {
		return new ArticuloPDF()
			.setNombre((String)artefacto.get("nombre"))
			.setDescripcion((String)artefacto.get("descripcion"))
			.setUrl((String)artefacto.get("url"))
            .setRecurso((String) artefacto.get("recurso"));
	}
	
	private MDOArtifact getRevista(Map<String, Object> artefacto) {
		return new Revista()
			.setAutor((String)artefacto.get("autor"))
			.setTitulo((String)artefacto.get("titulo"))
			.setDescripcion((String)artefacto.get("descripcion"))
			.setNombre((String)artefacto.get("nombre"))
			.setAnyo((String)artefacto.get("anyo"))
			.setPaginas((String)artefacto.get("paginas"))
			.setVolumen((String)artefacto.get("volumen"))
			.setNumero((String)artefacto.get("numero"))
            .setRecurso((String) artefacto.get("recurso"));
	}
	
	@Override
	public MDOArtifact parse(Map<String, Object> artefacto) {
		String nombre = (String)artefacto.get("artefacto");
		
		if (nombre.contains("pelicula"))
			return getPelicula(artefacto);
		else if (nombre.contains("video"))
			return getVideo(artefacto);
		else if (nombre.contains("libro"))
			return getLibro(artefacto);
		else if (nombre.contains("articuloweb"))
			return getArticuloWeb(artefacto);
		else if (nombre.contains("articulopdf"))
			return getArticuloPDF(artefacto);
		else
			return getRevista(artefacto);
	}
}