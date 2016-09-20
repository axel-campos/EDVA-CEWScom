package model.mdo.template;

import java.util.List;

/**
 * Contiene un método para generar un archivo completo HTML,
 * incrustando además el código de los artefactos MDO. Cada
 * etapa de MDO debe implementar esta interfaz.
 */
public interface MDOTemplate {
	
	/**
	 * Genera un archivo HTML completo con los artefactos MDO
	 * ya incrustados en su interior.
	 * 
	 * @param html Lista de códigos HTML generados por los artefactos MDO.
	 * @return Un archivo HTML en forma de cadena.
	 */
	String generarPlantilla(List<String> html);
}