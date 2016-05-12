package modelo.pojo;

/**
 * Clase que sirve para mapear la relación Grupo de la base de datos EDVADB.
 * Su llave primaria es el campo 'token: String'.
 * 
 * @author kikemon
 */
public class Grupo implements EDVADB {
	
	private String token;
	private String nombre;
	private String descripcion;
	private int totalProfesores;
	
	/**
	 * Regresa el token de este grupo.
	 * 
	 * @return El token del grupo.
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Asigna un nuevo token a este grupo.
	 * 
	 * @param token EL nuevo token.
	 * @return La referencia a este grupo.
	 */
	public Grupo setToken(String token) {
		this.token = token;
		return this;
	}
	
	/**
	 * Regresa el nombre de este grupo.
	 * 
	 * @return El nombre del grupo.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Asigna un nuevo nombre a este grupo.
	 * 
	 * @param nombre El nuevo nombre.
	 * @return La referencia a este grupo.
	 */
	public Grupo setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	/**
	 * Regresa la descripción de este grupo.
	 * 
	 * @return La descripción del grupo.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Asigna una nueva descripción a este grupo.
	 * 
	 * @param descripcion La nueva descripción.
	 * @return La referencia a este grupo.
	 */
	public Grupo setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	/**
	 * Regresa el total de profesores de este grupo.
	 * 
	 * @return El total de profesores del grupo.
	 */
	public int getTotalProfesores() {
		return totalProfesores;
	}
	
	/**
	 * Asigna un nuevo total de profesores a este grupo.
	 * 
	 * @param totalProfesores El nuevo total de profesores.
	 * @return La referencia a este grupo.
	 */
	public Grupo setTotalProfesores(int totalProfesores) {
		this.totalProfesores = totalProfesores;
		return this;
	}
}