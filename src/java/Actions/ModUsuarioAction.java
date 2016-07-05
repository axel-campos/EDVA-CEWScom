/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;
import modelo.pojo.Usuario;
import interceptor.AuthenticatedUser;
import java.sql.Date;
import java.util.Map;
import modelo.dao.UsuarioDAO;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author axelcampos
 */
public class ModUsuarioAction extends ActionSupport implements AuthenticatedUser, SessionAware {
    private Map<String, Object> userSession;
    private Usuario usuario;
    
    private String correo;
    private String nombre;
    private String paterno;
    private String materno;
    private String cedula;
    private String fechaN;
    
    public ModUsuarioAction() {
    }
    
    @Override
    public void validate() {
        if (correo == null || correo.trim().isEmpty() || !correo.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$")) {
            addActionError("El formato del correo es incorrecto.");
        } else if (nombre == null || nombre.trim().isEmpty()) {
            addActionError("El campo Nombre(s) es requerido.");
        } else if (paterno == null || paterno.trim().isEmpty()) {
            addActionError("El campo Apellido Paterno es requerido.");
        } else if (fechaN == null || fechaN.trim().isEmpty()) {
            addActionError("El campo Fecha de Nacimiento es requerido.");
        }
    }
    
    @Override
    public String execute() throws Exception {
        UsuarioDAO usuariodao = new UsuarioDAO();
        try {
            usuariodao.conectar();

            Usuario usuario_modificado = new Usuario()
                    .setFechaNacimiento(Date.valueOf(fechaN))
                    .setCorreo(correo)
                    .setNombre(nombre)
                    .setAPaterno(paterno)
                    .setAMaterno(materno)
                    .setCedula(cedula)
                    .setTipo(usuario.getTipo())
                    .setPassword(usuario.getPassword());

            userSession.put("usuario", usuario_modificado);

            usuariodao.modificar(usuario, usuario_modificado);
            usuariodao.desconectar();
            return SUCCESS;

        } catch (IllegalArgumentException e) {
            usuariodao.desconectar();
            addActionError("El formato de la fecha de nacimiento es incorrecto.");
            e.printStackTrace();
            return INPUT;
        } catch (RuntimeException e) {
            usuariodao.desconectar();
            addActionError("Ocurrió un error al modificar al nuevo usuario.");
            e.printStackTrace();
            return ERROR;
        }

    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession ;
    }

    
    
    
}
