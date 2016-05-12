/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;
import modelo.pojo.Usuario;
import interceptor.AuthenticatedUser;
import java.util.Map;
import modelo.dao.UsuarioDAO;
import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author axelcampos
 */
public class ModPwdAction extends ActionSupport implements AuthenticatedUser, SessionAware {
    private Map<String, Object> userSession;
    private Usuario usuario;
    
    private String old_password;
    private String new_password;
    private String new_pwd;
       
	private final int LOG_ROUNDS = 13;
    
    public ModPwdAction() {
    }
    
    @Override
    public String execute() throws Exception {
        UsuarioDAO usuariodao = new UsuarioDAO();
        try{
            usuariodao.conectar();
            if(BCrypt.checkpw(old_password, usuario.getPassword())){ 
                String pwd = BCrypt.hashpw(new_password, BCrypt.gensalt(LOG_ROUNDS));                
                usuario.setPassword(pwd);
                userSession.put("usuario", usuario);
                usuariodao.modificar(usuario, usuario);  
                usuariodao.desconectar();            
                
                return SUCCESS;
            }
            else
            {
                addActionError("Contraseña actual errónea");
                return ERROR; 
            }
                        
		} catch(RuntimeException e) {
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

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getNew_pwd() {
        return new_pwd;
    }

    public void setNew_pwd(String new_pwd) {
        this.new_pwd = new_pwd;
    }
    
}
