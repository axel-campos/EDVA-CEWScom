package modelo.pojo;

/**
 * Clase que sirve para mapear la relación Contenido de la base de datos EDVADB.
 * Su llave primaria es el campo 'idContenido: int'.
 * 
 * @author kikemon
 */
public class Contenido implements EDVADB {
	
	private int idContenido;
	private String token;
	private String titulo;
	private String tema;
	private String descripcion;
	private boolean finalizado;
	
	/**
	 * Regresa el ID de este contenido.
	 * 
	 * @return El ID del contenido.
	 */
	public int getIdContenido() {
		return idContenido;
	}
	
	/**
	 * Asigna un nuevo ID a este contenido.
	 * 
	 * @param idContenido El nuevo ID.
	 * @return La referencia a este contenido.
	 */
	public Contenido setIdContenido(int idContenido) {
		this.idContenido = idContenido;
		return this;
	}
	
	/**
	 * Regresa el token del grupo al que pertenece este contenido.
	 * 
	 * @return El token del grupo.
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Asigna un nuevo token de grupo a este contenido.
	 * 
	 * @param token El nuevo token.
	 * @return La referencia a este contenido.
	 */
	public Contenido setToken(String token) {
		this.token = token;
		return this;
	}
	
	/**
	 * Regresa el título de este contenido.
	 * 
	 * @return El título del contenido.
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Asigna un nuevo título a este contenido.
	 * 
	 * @param titulo EL nuevo título.
	 * @return La referencia a este contenido.
	 */
	public Contenido setTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	
	/**
	 * Regresa el tema de este contenido.
	 * 
	 * @return El tema del contenido.
	 */
	public String getTema() {
		return tema;
	}
	
	/**
	 * Asigna un nuevo tema a este contenido.
	 * 
	 * @param tema El nuevo tema.
	 * @return La referencia a este contenido.
	 */
	public Contenido setTema(String tema) {
		this.tema = tema;
		return this;
	}
	
	/**
	 * Regresa la descripción de este contenido.
	 * 
	 * @return La descripción del contenido.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Asigna una nueva descripción a este contenido.
	 * 
	 * @param descripcion La nueva descripción.
	 * @return La referencia a este contenido.
	 */
	public Contenido setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	/**
	 * Regresa el estado de finalizado de este contenido.
	 * 
	 * @return El estado de finalizado del contenido.
	 */
	public boolean getFinalizado() {
		return finalizado;
	}
	
	/**
	 * Asigna un nuevo estado de finalizado a este contenido.
	 * 
	 * @param finalizado El nuevo estado.
	 * @return La referencia de este contenido.
	 */
	public Contenido setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
		return this;
	}
}