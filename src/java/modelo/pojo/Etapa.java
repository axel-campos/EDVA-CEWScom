package modelo.pojo;

/**
 * Clase que sirve para mapear la relación Etapa de la base de datos EDVADB.
 * Su llave primaria es el campo 'idEtapa: short'.
 * 
 * @author kikemon
 */
public class Etapa implements EDVADB {
	
	private short idEtapa;
	private String nombre;
	private String descripcion;
	
	public static final short VIVENCIAS = 1;
	public static final short CONCEPTUALIZACION = 2;
	public static final short DOCUMENTACION = 3;
	public static final short AMPLIACION = 4;
	public static final short APLICACION = 5;
	
	/**
	 * Regresa el ID de esta etapa.
	 * 
	 * @return El ID de la etapa.
	 */
	public short getIdEtapa() {
		return idEtapa;
	}
	
	/**
	 * Asigna un nuevo ID a esta etapa.
	 * 
	 * @param idEtapa El nuevo ID.
	 * @return La referencia a esta etapa.
	 */
	public Etapa setIdEtapa(short idEtapa) {
		this.idEtapa = idEtapa;
		return this;
	}
	
	/**
	 * Regresa el nombre de esta etapa.
	 * 
	 * @return El nombre de la etapa.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Asigna un nuevo nombre a esta etapa.
	 * 
	 * @param nombre El nuevo nombre.
	 * @return La referencia a esta etapa.
	 */
	public Etapa setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	/**
	 * Regresa la descripción de esta etapa.
	 * 
	 * @return La descripción de la etapa.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Asigna una nueva descripción a esta etapa.
	 * 
	 * @param descripcion La nueva descripción.
	 * @return La referencia a esta etapa.
	 */
	public Etapa setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
}