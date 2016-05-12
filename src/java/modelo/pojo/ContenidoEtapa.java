package modelo.pojo;

import java.util.Date;

/**
 * Esta clase sirve para mapear la relación ContenidoEtapa de la base de datos EDVADB.
 * Sus llaves primarias son los campos 'idContenido: int', 'idEtapa: short' y 'version: int'.
 * 
 * @author kikemon
 */
public class ContenidoEtapa implements EDVADB {
	
	private int idContenido;
	private short idEtapa;
	private int version;
	private Date tiempoModificacion;
	private Date tiempoVotacion;
	private String rutaRecursos;
	private boolean liberado;
	
	/**
	 * Regresa el ID de contenido de este contenido-etapa.
	 * 
	 * @return El ID de contenido del contenido-etapa.
	 */
	public int getIdContenido() {
		return idContenido;
	}
	
	/**
	 * Asigna un nuevo ID de contenido a este contenido-etapa.
	 * 
	 * @param idContenido El nuevo ID de contenido.
	 * @return La referencia a este contenido-etapa.
	 */
	public ContenidoEtapa setIdContenido(int idContenido) {
		this.idContenido = idContenido;
		return this;
	}
	
	/**
	 * Regresa el ID de etapa de este contenido-etapa.
	 * 
	 * @return El ID de etapa del contenido-etapa.
	 */
	public short getIdEtapa() {
		return idEtapa;
	}
	
	/**
	 * Asigna un nuevo ID de etapa a este contenido-etapa.
	 * 
	 * @param idEtapa El nuevo ID de etapa.
	 * @return La referencia a este contenido-etapa.
	 */
	public ContenidoEtapa setIdEtapa(short idEtapa) {
		this.idEtapa = idEtapa;
		return this;
	}
	
	/**
	 * Regresa el número de versión de este contenido-etapa.
	 * 
	 * @return El número de versión del contenido-etapa.
	 */
	public int getVersion() {
		return version;
	}
	
	/**
	 * Asigna un nuevo número de versión a este contenido-etapa.
	 * 
	 * @param version El nuevo número de versión.
	 * @return La referencia a este contenido-etapa.
	 */
	public ContenidoEtapa setVersion(int version) {
		this.version = version;
		return this;
	}
	
	/**
	 * Regresa la fecha límite de modificación de este contenido-etapa.
	 * 
	 * @return La fecha límite de mofdificación del contenido-etapa.
	 */
	public Date getTiempoModificacion() {
		return new Date(tiempoModificacion.getTime());
	}
	
	/**
	 * Asigna una nueva fecha límite de modificación a este contenido-etapa.
	 * 
	 * @param tiempoModificacion La nueva fecha límite de modificación.
	 * @return La referencia a este contenido-etapa.
	 */
	public ContenidoEtapa setTiempoModificacion(Date tiempoModificacion) {
		this.tiempoModificacion = new Date(tiempoModificacion.getTime());
		return this;
	}
	
	/**
	 * Regresa la fecha límite de votación para este contenido-etapa.
	 * 
	 * @return La fecha límite de votación del contenido-etapa.
	 */
	public Date getTiempoVotacion() {
		return new Date(tiempoVotacion.getTime());
	}
	
	/**
	 * Asigna una nueva fecha límite de votación a este contenido-etapa.
	 * 
	 * @param tiempoVotacion La nueva fecha límite de votación.
	 * @return La referencia a este contenido-etapa.
	 */
	public ContenidoEtapa setTiempoVotacion(Date tiempoVotacion) {
		this.tiempoVotacion = new Date(tiempoVotacion.getTime());
		return this;
	}
	
	/**
	 * Regresa la ruta de los recursos de este contenido-etapa.
	 * 
	 * @return La ruta de recursos del contenido-etapa.
	 */
	public String getRutaRecursos() {
		return rutaRecursos;
	}
	
	/**
	 * Asigna una nueva ruta de recursos a este contenido-etapa.
	 * 
	 * @param rutaRecursos La nueva ruta de recursos.
	 * @return La referencia a este contenido-etapa.
	 */
	public ContenidoEtapa setRutaRecursos(String rutaRecursos) {
		this.rutaRecursos = rutaRecursos;
		return this;
	}
	
	/**
	 * Regresa el estado de liberado de este contenido-etapa.
	 * 
	 * @return El estado de liberado del contenido-etapa.
	 */
	public boolean getLiberado() {
		return liberado;
	}
	
	/**
	 * Asigna un nuevo estado de liberado a este contenido-etapa.
	 * 
	 * @param oficial El nuevo estado.
	 * @return La referencia a este contenido-etapa.
	 */
	public ContenidoEtapa setLiberado(boolean liberado) {
		this.liberado = liberado;
		return this;
	}
}