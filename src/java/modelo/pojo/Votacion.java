package modelo.pojo;

/**
 * Clase que sirve para mapear la relación Votacion de la base de datos EDVADB.
 * Su llave primaria es el campo 'idVotacion: int'.
 * 
 * @author kikemon
 */
public class Votacion implements EDVADB {
	
	private int idVotacion;
	private int votosAFavor;
	private int votosEnContra;
	private int abstencion;
	private int votosNulos;
	private String resultado;
	private int idContenido;
	private short idEtapa;
	private int version;
	
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
	 * Regresa el número de votos a favor de esta votación.
	 * 
	 * @return El número de votos a favor de la votación.
	 */
	public int getVotosAFavor() {
		return votosAFavor;
	}
	
	/**
	 * Asigna el número de votos a favor de esta votación.
	 * 
	 * @param votosAFavor El número de votos a favor.
	 * @return La referencia a esta votación.
	 */
	public Votacion setVotosAFavor(int votosAFavor) {
		this.votosAFavor = votosAFavor;
		return this;
	}
	
	/**
	 * Regresa el número de votos en contra de esta votación.
	 * 
	 * @return El número de votos en contra de la votación.
	 */
	public int getVotosEnContra() {
		return votosEnContra;
	}
	
	/**
	 * Asigna el número de votos en contra de esta votación.
	 * 
	 * @param votosEnContra EL número de votos en contra,
	 * @return La referencia a esta votación.
	 */
	public Votacion setVotosEnContra(int votosEnContra) {
		this.votosEnContra = votosEnContra;
		return this;
	}
	
	/**
	 * Regresa el número de abstenciones en esta votación.
	 * 
	 * @return El número de abstenciones de la votación.
	 */
	public int getAbstencion() {
		return abstencion;
	}
	
	/**
	 * Asigna el número de abstenciones a esta votación.
	 * 
	 * @param abstencion El número de abstenciones.
	 * @return La referencia a esta votación.
	 */
	public Votacion setAbstencion(int abstencion) {
		this.abstencion = abstencion;
		return this;
	}
	
	/**
	 * Regresa el número de votos nulos de esta votación.
	 * 
	 * @return El número de votos nulos de la votación.
	 */
	public int getVotosNulos() {
		return votosNulos;
	}
	
	/**
	 * Asigna el número de votos nulos de esta votación.
	 * 
	 * @param votosNulos El número de votos nulos.
	 * @return La referencia a esta votación.
	 */
	public Votacion setVotosNulos(int votosNulos) {
		this.votosNulos = votosNulos;
		return this;
	}
	
	/**
	 * Regresa el resultado de esta votación.
	 * 
	 * @return El resultado de la votación.
	 */
	public String getResultado() {
		return resultado;
	}
	
	/**
	 * Asigna el resultado de esta votación.
	 * 
	 * @param resultado El resultado de la votación.
	 * @return La referencia a esta votación.
	 */
	public Votacion setResultado(String resultado) {
		this.resultado = resultado;
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
	
	/**
	 * Regresa el número de versión del contenido al cual pertenece esta votación.
	 * 
	 * @return El número de versión del contenido.
	 */
	public int getVersion() {
		return version;
	}
	
	/**
	 * Asigna un nuevo número de versión de contenido a esta votación.
	 * 
	 * @param version El nuevo número de versión.
	 * @return La referencia a esta votación.
	 */
	public Votacion setVersion(int version) {
		this.version = version;
		return this;
	}
}