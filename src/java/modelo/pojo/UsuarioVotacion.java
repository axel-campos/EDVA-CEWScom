package modelo.pojo;

/**
 * Esta clase sirve para mapear la relación UsuarioVotacion de la base de datos EDVADB.
 * Sus llaves primarias son los campos 'idVotacion: int' y 'correo: String'.
 * 
 * @author kikemon
 */
public class UsuarioVotacion implements EDVADB {
	
	private String correo;
	private int idVotacion;
	private int version;;
	
	/**
	 * Regresa el correo de usuario de este usuario-votación.
	 * 
	 * @return El correo de usuario del usuario-votación.
	 */
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Asigna un nuevo correo de usuario a este usuario-votacion.
	 * 
	 * @param correo El nuevo correo de usuario.
	 * @return La referencia a este usuario-votacion.
	 */
	public UsuarioVotacion setCorreo(String correo) {
		this.correo = correo;
		return this;
	}
	
	/**
	 * Regresa el ID de la votación asociada a este usuario-votacion.
	 * 
	 * @return El ID de votación del usuario-votacion.
	 */
	public int getIdVotacion() {
		return idVotacion;
	}
	
	/**
	 * Asigna un nuevo ID de votación a este usuario-votacion.
	 * 
	 * @param idVotacion El nuevo ID de votación.
	 * @return La referencia a este usuario-votacion.
	 */
	public UsuarioVotacion setIdVotacion(int idVotacion) {
		this.idVotacion = idVotacion;
		return this;
	}
	
	/**
	 * Regresa la version por la cual voto el usuario en está etapa
	 * 
	 * @return La versión del voto.
	 */
	public int getVersion() {
		return version;
	}
	
	/**
	 * Asigna la versión por la cuál votó el usuario
	 * 
	 * @param version La version de la etapa por la cuál votó el usuario
	 * @return La referencia a este usuario-votacion.
	 */
	public UsuarioVotacion setVersion(int version) {
		this.version = version;
		return this;
	}
}