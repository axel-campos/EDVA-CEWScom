package model.mdo.template;

/**
 * Clase auxiliar para la creación de las plantillas MDO.
 */
public final class MDOTemplateUtil {
	private MDOTemplateUtil() {}
	
	/**
	 * Regresa el generador de plantillas indicado.
	 * 
	 * @param etapa El nombre de la etapa MDO.
	 * @param path La ruta hacia la plantilla que será cargada.
	 * @return La implementación MDOTemplate para la etapa.
	 */
	public static MDOTemplate getTemplate(String etapa, String path, String titulo, String version) {
		if (etapa.contains("vivencia"))
			return new VivenciaTemplate(path,titulo,version);
		else if (etapa.contains("conceptualizacion"))
			return new ConceptualizacionTemplate();
		else if (etapa.contains("documentacion"))
			return new DocumentacionTemplate("/documentacion_template.html");
		else if (etapa.contains("Aplicacion"))
			return new AplicacionTemplate();
		else
			return new AmpliacionTemplate();
	}
}