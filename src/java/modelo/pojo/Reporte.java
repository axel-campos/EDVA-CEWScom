package modelo.pojo;

import java.util.Date;

/**
 * Esta clase sirve para mapear la relación Reporte de la base de datos EDVADB.
 * Su llave primaria es el campo 'idReporte: int'.
 * 
 * @author kikemon
 */
public class Reporte implements EDVADB {
	
	private int idReporte;
	private int idContenido;
	private String causa;
	private String correo;
    private String token;
    private int atendido;
    private int aceptado;
    private Date fechaReporte;
    private String correoReportando;
    
	/**
	 * Regresa el ID de este reporte.
	 * 
	 * @return El ID del reporte.
	 */
	public int getIdReporte() {
		return idReporte;
	}
	
	/**
	 * Asigna un nuevo ID a este reporte.
	 * 
	 * @param idReporte EL nuevo ID.
	 * @return La referencia a este reporte.
	 */
	public Reporte setIdReporte(int idReporte) {
		this.idReporte = idReporte;
		return this;
	}
	
	/**
	 * Regresa el ID del contenido al cual pertenece este reporte.
	 * 
	 * @return El ID de contenido del reporte.
	 */
	public int getIdContenido() {
		return idContenido;
	}
	
	/**
	 * Asigna un nuevo ID de contenido a este reporte.
	 * 
	 * @param idContenido El nuevo ID de contenido.
	 * @return La referencia a este reporte.
	 */
	public Reporte setIdContenido(int idContenido) {
		this.idContenido = idContenido;
		return this;
	}
	
	/**
	 * Regresa la causa de este reporte.
	 * 
	 * @return La causa del reporte.
	 */
	public String getCausa() {
		return causa;
	}
	
	/**
	 * Asigna una nueva causa a este reporte.
	 * 
	 * @param causa La nueva causa.
	 * @return La referencia a este reporte.
	 */
	public Reporte setCausa(String causa) {
		this.causa = causa;
		return this;
	}
    
    /**
	 * Regresa el correo reportado en el reporte.
	 * 
	 * @return El correo reportado en el reporte.
	 */
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Asigna un nuevo correo a este reporte.
	 * 
	 * @param correo El nuevo correo.
	 * @return La referencia a este reporte.
	 */
	public Reporte setCorreo(String correo) {
		this.correo = correo;
		return this;
	}
    
    /**
	 * Regresa el token reportado en el reporte.
	 * 
	 * @return El token reportado en el reporte.
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Asigna un nuevo token a este reporte.
	 * 
	 * @param token El nuevo token.
	 * @return La referencia a este reporte.
	 */
	public Reporte setToken(String token) {
		this.token = token;
		return this;
	} 
    
    /**
	 * Regresa si el reporte está atendido o no.
	 * 
	 * @return Sí el reporte está atendido o no.
	 */
	public int getAtendido() {
		return atendido;
	}
	
	/**
	 * Asigna si el reporte está atendido o no.
	 * 
	 * @param atendido EL nuevo estado de atendido.
	 * @return La referencia a este reporte.
	 */
	public Reporte setAtendido(int atendido) {
		this.atendido = atendido;
		return this;
	}
    
    /**
	 * Regresa si el reporte está en aceptado o no
	 * 
	 * @return Sí el reporte está en aceptado o no.
	 */
	public int getAceptado() {
		return aceptado;
	}
	
	/**
	 * Asigna si el reporte está aceptado o no.
	 * 
	 * @param aceptado EL nuevo estado de aceptado.
	 * @return La referencia a este reporte.
	 */
	public Reporte setAceptado(int aceptado) {
		this.aceptado = aceptado;
		return this;
	}
    
    /**
	 * Regresa la fecha en que se generó el reporte
	 * 
	 * @return La fecha del reporte
	 */
	public Date getFechaReporte() {
		return new Date(fechaReporte.getTime());
	}
	
	/**
	 * Asigna la fecha en la que se genera el reporte
	 * 
	 * @param fechaReporte La fecha en la que se está generando el reporte
	 * @return La referencia a este reporte.
	 */
	public Reporte setFechaReporte(Date fechaReporte) {
		this.fechaReporte = new Date(fechaReporte.getTime());;
		return this;
	}
    
    /**
	 * Regresa el correo que creo el reporte.
	 * 
	 * @return El correo que creo el reporte.
	 */
	public String getCorreoReportando() {
		return correoReportando;
	}
	
	/**
	 * Asigna el correo que genera el reporte.
	 * 
	 * @param correo El correo que genera el reporte.
	 * @return La referencia a este reporte.
	 */
	public Reporte setCorreoReportando(String correoReportando) {
		this.correoReportando = correoReportando;
		return this;
	}
}