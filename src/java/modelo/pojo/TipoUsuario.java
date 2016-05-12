package modelo.pojo;

/**
 * Clase que sirve para mapear la relación TipoUsuario de la base de datos EDVADB.
 * Su llave primaria es el campo 'idTipoUsuario: int'.
 * 
 * @author kikemon
 */
public class TipoUsuario implements EDVADB {
	
	private int idTipoUsuario;
	private String nombre;
	
	public static final int ADMINISTRADOR = 1;
	public static final int PROFESOR = 2;
	
	/**
	 * Regresa el ID de este tipo de usuario.
	 * 
	 * @return El ID del tipo de usuario.
	 */
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	
	/**
	 * Asigna un nuevo ID a este tipo de usuario.
	 * 
	 * @param idTipoUsuario EL nuevo ID.
	 * @return La referencia a este tipo de usuario.
	 */
	public TipoUsuario setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
		return this;
	}
	
	/**
	 * Regresa el nombre de este tipo de usuario.
	 * 
	 * @return El nombre del tipo de usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Asigna un nuevo nombre a este tipo de usuario.
	 * 
	 * @param nombre EL nuevo nombre.
	 * @return La referencia a este tipo de usuario.
	 */
	public TipoUsuario setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
}