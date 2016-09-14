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
	public static MDOTemplate getTemplate(String etapa, String path) {
		if (etapa.equalsIgnoreCase("Vivencia"))
			return new VivenciaTemplate();
		else if (etapa.equalsIgnoreCase("Conceptualizacion"))
			return new ConceptualizacionTemplate();
		else if (etapa.equalsIgnoreCase("Documentacion"))
			return new DocumentacionTemplate(path + "/documentacion.html");
		else if (etapa.equalsIgnoreCase("Aplicacion"))
			return new AplicacionTemplate();
		else
			return new AmpliacionTemplate();
	}
}