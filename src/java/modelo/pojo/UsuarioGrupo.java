package modelo.pojo;

/**
 * Clase que sirve para mapear la relación UsuarioGrupo de la base de datos EDVADB.
 * Sus llaves primarias son los campos 'correo: String' y 'token: String'.
 * 
 * @author kikemon
 */
public class UsuarioGrupo implements EDVADB {
	
	private String correo;
	private String token;
	private int idTipoUsuarioGrupo;
	private boolean aceptado;
	
	/**
	 * Regresa el correo de este usuario-grupo
	 * 
	 * @return El correo del usuario-grupo.
	 */
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Asigna un nuevo correo a este usuario-grupo.
	 * 
	 * @param correo El nuevo correo.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupo setCorreo(String correo) {
		this.correo = correo;
		return this;
	}
	
	/**
	 * Regresa el token de este usuario-grupo.
	 * 
	 * @return El token del usuario-grupo.
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Asigna un nuevo token a este usuario-grupo.
	 * 
	 * @param token El nuevo token.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupo setToken(String token) {
		this.token = token;
		return this;
	}
	
	/**
	 * Regresa el ID del tipo de usuario de este usuario-grupo.
	 * 
	 * @return El ID del tipo de usuario del usuario-grupo.
	 */
	public int getIdTipoUsuarioGrupo() {
		return idTipoUsuarioGrupo;
	}
	
	/**
	 * Asigna un nuevo ID de tipo de usuario a este usuario-grupo.
	 * 
	 * @param idTipoUsuarioGrupo El nuevo ID.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupo setIdTipoUsuarioGrupo(int idTipoUsuarioGrupo) {
		this.idTipoUsuarioGrupo = idTipoUsuarioGrupo;
		return this;
	}
	
	/**
	 * Regresa el estado de aceptado de este usuario-grupo.
	 * 
	 * @return El estado ed aceptado del usuario-grupo.
	 */
	public boolean getAceptado() {
		return aceptado;
	}
	
	/**
	 * Asigna un nuevo estado de aceptado a este usuario-grupo.
	 * 
	 * @param aceptado El nuevo estado.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupo setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
		return this;
	}
}