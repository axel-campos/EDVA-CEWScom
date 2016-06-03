package modelo.pojo;
import java.util.Date;
/**
 * Clase que sirve para mapear la relación UsuarioGrupo_log de la base de datos EDVADB.
 * Sus llaves primarias son los campos 'correo: String' y 'token: String'.
 * 
 * @author Víctor
 */
public class UsuarioGrupoLog {
    
    private String correo;
	private String token;
	private int idTipoUsuarioGrupo_anterior;
    private int idTipoUsuarioGrupo_nuevo;
	private boolean aceptado_anterior;
    private boolean aceptado_nuevo;
    private Date fechaCambio;
    
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
	public UsuarioGrupoLog setCorreo(String correo) {
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
	public UsuarioGrupoLog setToken(String token) {
		this.token = token;
		return this;
	}
	
	/**
	 * Regresa el ID del tipo de usuario anterior de este usuario-grupo.
	 * 
	 * @return El ID del tipo de usuario anterior del usuario-grupo.
	 */
    
    public int getIdTipoUsuarioGrupoAnterior() {
		return idTipoUsuarioGrupo_anterior;
	}
	
	/**
	 * Asigna un nuevo ID de tipo de usuario anterior a este usuario-grupo.
	 * 
	 * @param idTipoUsuarioGrupo El nuevo ID anterior.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupoLog setIdTipoUsuarioGrupoAnterior(int idTipoUsuarioGrupoAnterior) {
		this.idTipoUsuarioGrupo_anterior = idTipoUsuarioGrupoAnterior;
		return this;
	}
	
	/**
	 * Regresa el estado de aceptado anterior de este usuario-grupo.
	 * 
	 * @return El estado de aceptado anterior del usuario-grupo.
	 */
	public boolean getAceptadoAnterior() {
		return aceptado_anterior;
	}
	
	/**
	 * Asigna un nuevo estado de aceptado anterior a este usuario-grupo.
	 * 
	 * @param aceptado El nuevo estado anterior.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupoLog setAceptadoAnterior(boolean aceptadoAnterior) {
		this.aceptado_anterior = aceptadoAnterior;
		return this;
	}
    
    /**
	 * Regresa el ID del tipo de usuario nuevo de este usuario-grupo.
	 * 
	 * @return El ID del tipo de usuario nuevo del usuario-grupo.
	 */
    
    public int getIdTipoUsuarioGrupoNuevo() {
		return idTipoUsuarioGrupo_nuevo;
	}
	
	/**
	 * Asigna un nuevo ID de tipo de usuario nuevo a este usuario-grupo.
	 * 
	 * @param idTipoUsuarioGrupo El nuevo ID nuevo.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupoLog setIdTipoUsuarioGrupoNuevo(int idTipoUsuarioGrupoNuevo) {
		this.idTipoUsuarioGrupo_nuevo = idTipoUsuarioGrupoNuevo;
		return this;
	}
	
	/**
	 * Regresa el estado de aceptado nuevo de este usuario-grupo.
	 * 
	 * @return El estado de aceptado nuevo del usuario-grupo.
	 */
	public boolean getAceptadoNuevo() {
		return aceptado_nuevo;
	}
	
	/**
	 * Asigna un nuevo estado de aceptado nuevo a este usuario-grupo.
	 * 
	 * @param aceptado El nuevo estado nuevo.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupoLog setAceptadoNuevo(boolean aceptadoNuevo) {
		this.aceptado_nuevo = aceptadoNuevo;
		return this;
	}
    
    /**
	 * Regresa la fecha cambio de este usuario-grupo.
	 * 
	 * @return La fecha cambio del usuario-grupo.
	 */
	public Date getFechaCambio() {
		return fechaCambio;
	}
	
	/**
	 * Asigna una nueva fecah de cambio a este usuario-grupo.
	 * 
	 * @param aceptado la nueva fecha de cambio.
	 * @return La referencia a este usuario-grupo.
	 */
	public UsuarioGrupoLog setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
		return this;
	}
}
