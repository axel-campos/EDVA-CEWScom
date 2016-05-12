package modelo.pojo;

/**
 * Esta clase sirve para mapear la relación Reporte de la base de datos EDVADB.
 * Su llave primaria es el campo 'idReporte: int'.
 * 
 * @author kikemon
 */
public class Reporte implements EDVADB {
	
	private int idReporte;
	private int idContenido;
	private String causa;
	
	/**
	 * Regresa el ID de este reporte.
	 * 
	 * @return El ID del reporte.
	 */
	public int getIdReporte() {
		return idReporte;
	}
	
	/**
	 * Asigna un nuevo ID a este reporte.
	 * 
	 * @param idReporte EL nuevo ID.
	 * @return La referencia a este reporte.
	 */
	public Reporte setIdReporte(int idReporte) {
		this.idReporte = idReporte;
		return this;
	}
	
	/**
	 * Regresa el ID del contenido al cual pertenece este reporte.
	 * 
	 * @return El ID de contenido del reporte.
	 */
	public int getIdContenido() {
		return idContenido;
	}
	
	/**
	 * Asigna un nuevo ID de contenido a este reporte.
	 * 
	 * @param idContenido El nuevo ID de contenido.
	 * @return La referencia a este reporte.
	 */
	public Reporte setIdContenido(int idContenido) {
		this.idContenido = idContenido;
		return this;
	}
	
	/**
	 * Regresa la causa de este reporte.
	 * 
	 * @return La causa del reporte.
	 */
	public String getCausa() {
		return causa;
	}
	
	/**
	 * Asigna una nueva causa a este reporte.
	 * 
	 * @param causa La nueva causa.
	 * @return La referencia a este reporte.
	 */
	public Reporte setCausa(String causa) {
		this.causa = causa;
		return this;
	}
}