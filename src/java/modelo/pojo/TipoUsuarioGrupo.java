package modelo.pojo;

/**
 * Clase que sirve para mapear la relación TipoUsuarioGrupo de la base de datos EDVADB.
 * Su llave primaria es el campo 'idTipoUsuarioGrupo: int'.
 * 
 * @author kikemon
 */
public class TipoUsuarioGrupo implements EDVADB {
	
	private int idTipoUsuarioGrupo;
	private String nombre;
	private String descripcion;
	
	public static final int COORDINADOR = 1;
	public static final int ADMINISTRADOR = 2;
	public static final int COLABORADOR = 3;
	
	/**
	 * Regresa el ID de este tipo de usuario de grupo.
	 * 
	 * @return El ID del tipo de usuario de grupo.
	 */
	public int getIdTipoUsuarioGrupo() {
		return idTipoUsuarioGrupo;
	}
	
	/**
	 * Asigna un nuevo ID a este tipo de usuario de grupo.
	 * 
	 * @param idTipoUsuarioGrupo EL nuevo ID.
	 * @return La referencia a este tipo de usuario de grupo.
	 */
	public TipoUsuarioGrupo setIdTipoUsuarioGrupo(int idTipoUsuarioGrupo) {
		this.idTipoUsuarioGrupo = idTipoUsuarioGrupo;
		return this;
	}
	
	/**
	 * Regresa el nombre de este tipo de usuario de grupo.
	 * 
	 * @return EL nombre del tipo de usuario de grupo.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Asigna un nuevo nombre a este tipo de usuario de grupo.
	 * 
	 * @param nombre El nuevo nombre.
	 * @return La referencia a este tipo de usuario de grupo.
	 */
	public TipoUsuarioGrupo setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	/**
	 * Regresa la descripción de este tipo de usuario de grupo.
	 * 
	 * @return La descripción del tipo de usuario de grupo.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Asigna una nueva descripción a este tipo de usuario de grupo.
	 * 
	 * @param descripcion La nueva descripción.
	 * @return La referencia a este tipo de usuario de grupo.
	 */
	public TipoUsuarioGrupo setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
}