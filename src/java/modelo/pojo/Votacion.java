package modelo.pojo;

/**
 * Clase que sirve para mapear la relación Votacion de la base de datos EDVADB.
 * Su llave primaria es el campo 'idVotacion: int'.
 * 
 * @author kikemon
 */
public class Votacion implements EDVADB {
	
	private int idVotacion;
	private int idContenido;
	private short idEtapa;
	
	/**
	 * Regresa el ID de esta votación.
	 * 
	 * @return El ID de la votación.
	 */
	public int getIdVotacion() {
		return idVotacion;
	}
	
	/**
	 * Asigna un nuevo ID a esta votación.
	 * 
	 * @param idVotacion El nuevo ID.
	 * @return La referencia a esta votación.
	 */
	public Votacion setIdVotacion(int idVotacion) {
		this.idVotacion = idVotacion;
		return this;
	}
	
	/**
	 * Regresa el ID del contenido al cual pertenece esta votación.
	 * 
	 * @return El ID del contenido.
	 */
	public int getIdContenido() {
		return idContenido;
	}
	
	/**
	 * Asigna un nuevo ID de contenido a esta votación.
	 * 
	 * @param idContenido El nuevo ID.
	 * @return La referencia a esta votación.
	 */
	public Votacion setIdContenido(int idContenido) {
		this.idContenido = idContenido;
		return this;
	}
	
	/**
	 * Regresa el ID de la etapa a la cual pertenece esta votación.
	 * 
	 * @return El ID de la etapa.
	 */
	public short getIdEtapa() {
		return idEtapa;
	}
	
	/**
	 * Asigna un nuevo ID de etapa a esta votación.
	 * 
	 * @param idEtapa El nuevo ID.
	 * @return La referencia a esta votación.
	 */
	public Votacion setIdEtapa(short idEtapa) {
		this.idEtapa = idEtapa;
		return this;
	}
}