package model.mdo.template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Generador de plantillas HTML para la etapa de Documentación.
 */
public class DocumentacionTemplate implements MDOTemplate {

	private final String realPath;
	
	public DocumentacionTemplate(String realPath) {
		this.realPath = realPath;
	}
	
	@Override
	public String generarPlantilla(List<String> html) {
		try {
			List<String> lineas = Files.readAllLines(Paths.get(realPath));
			int bodyIndex = lineas.indexOf("\t</body>");
			lineas.addAll(bodyIndex, html);
			return String.join("", lineas);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}