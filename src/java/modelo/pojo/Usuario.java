package modelo.pojo;

import java.sql.Date;

/**
 * Clase que sirve para mapear la relación Usuario de la base de datos EDVADB.
 * Su llave primaria es el campo 'correo: String'.
 * 
 * @author kikemon
 */
public class Usuario implements EDVADB {
	
	private String correo;
	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private String cedula;
	private int tipo;
	private Date fechaNacimiento;
	private String password;
    private Date ultimaConexion;
	
	/**
	 * Regresa el correo de este usuario.
	 * 
	 * @return El correo del usuario.
	 */
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Asigna un nuevo correo a este usuario.
	 * 
	 * @param correo El nuevo correo.
	 * @return La referencia a este usuario.
	 */
	public Usuario setCorreo(String correo) {
		this.correo = correo;
		return this;
	}
	
	/**
	 * Regresa el nombre de este usuario.
	 * 
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Asigna un nuevo nombre a este usuario.
	 * 
	 * @param nombre El nuevo nombre.
	 * @return La referencia a este usuario.
	 */
	public Usuario setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	/**
	 * Regresa el apellido paterno de este usuario.
	 * 
	 * @return El apellido paterno del usuario.
	 */
	public String getAPaterno() {
		return aPaterno;
	}
	
	/**
	 * Asigna un nuevo apellido paterno a este usuario.
	 * 
	 * @param aPaterno El nuevo apellido paterno.
	 * @return La referencia a este usuario.
	 */
	public Usuario setAPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
		return this;
	}
	
	/**
	 * Regresa el apellido materno de este usuario.
	 * 
	 * @return El apellido materno del usuario.
	 */
	public String getAMaterno() {
		return aMaterno;
	}
	
	/**
	 * Asigna un nuevo apellido materno a este usuario.
	 * 
	 * @param aMaterno El nuevo apellido materno.
	 * @return La referencia a este usuario.
	 */
	public Usuario setAMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
		return this;
	}
	
	/**
	 * Regresa la cédula de este usuario.
	 * 
	 * @return La cédula del usuario.
	 */
	public String getCedula() {
		return cedula;
	}
	
	/**
	 * Asigna una nueva cédula a este usuario.
	 * 
	 * @param cedula La nueva cédula.
	 * @return La referencia a este usuario.
	 */
	public Usuario setCedula(String cedula) {
		this.cedula = cedula;
		return this;
	}
	
	/**
	 * Regresa el tipo de este usuario.
	 * 
	 * @return El tipo de usuario.
	 */
	public int getTipo() {
		return tipo;
	}
	
	/**
	 * Asigna un nuevo tipo de usuario a éste.
	 * 
	 * @param tipo EL nuevo tipo.
	 * @return La referencia a este usuario.
	 */
	public Usuario setTipo(int tipo) {
		this.tipo = tipo;
		return this;
	}
	
	/**
	 * Regresa la fecha de nacimiento de este usuario.
	 * 
	 * @return La fecha de nacimiento.
	 */
	public Date getFechaNacimiento() {
		return new Date(fechaNacimiento.getTime());
	}
	
	/**
	 * Asigna una nueva fecha de nacimiento a este usuario.
	 * 
	 * @param fechaNacimiento La nueva fecha de nacimiento.
	 * @return La referencia a este objeto.
	 */
	public Usuario setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = new Date(fechaNacimiento.getTime());
		return this;
	}
	
	/**
	 * Regresa la contraseña de este usuario.
	 * 
	 * @return La contraseña del usuario.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Asigna una nueva contraseña a este usuario.
	 * 
	 * @param password La nueva contraseña.
	 * @return La referencia a este objeto.
	 */
	public Usuario setPassword(String password) {
		this.password = password;
		return this;
	}
    /**
	 * Regresa la contraseña de este usuario.
	 * 
	 * @return La contraseña del usuario.
	 */
	public Date getUltimaConexion() {
		return ultimaConexion;
	}
	
	/**
	 * Asigna una nueva contraseña a este usuario.
	 * 
	 * @param password La nueva contraseña.
	 * @return La referencia a este objeto.
	 */
	public Usuario setUltimaConexion(Date ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
		return this;
	}
}