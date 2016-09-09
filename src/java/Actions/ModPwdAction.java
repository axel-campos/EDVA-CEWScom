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

    private String old_pwd;
    private String new_pwd;
    private String new_pwd_rpt;

    private final int LOG_ROUNDS = 13;

    public ModPwdAction() {
    }

    @Override
    public String execute() throws Exception {
        UsuarioDAO usuariodao = new UsuarioDAO();

        try {
            usuariodao.conectar();
            if (BCrypt.checkpw(old_pwd, usuario.getPassword())) {
                if (new_pwd.equals(new_pwd_rpt)) {

                    String pwd = BCrypt.hashpw(new_pwd, BCrypt.gensalt(LOG_ROUNDS));
                    usuario.setPassword(pwd);
                    userSession.put("usuario", usuario);
                    usuariodao.modificar(usuario, usuario);
                    usuariodao.desconectar();
                    addActionMessage("Contraseña modificada con éxito.");

                    return SUCCESS;
                } else {
                    addActionError("La contraseñas nuevas no coinciden");
                    System.out.println("Contraseñas nuevas no coinciden");
                    usuariodao.desconectar();
                    return ERROR;
                }

            } else {
                addActionError("Contraseña actual errónea");
                System.out.println("Contraseñas actual erronea");
                usuariodao.desconectar();
                return ERROR;
            }

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

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public String getOld_pwd() {
        return old_pwd;
    }

    public void setOld_pwd(String old_pwd) {
        this.old_pwd = old_pwd;
    }

    public String getNew_pwd_rpt() {
        return new_pwd_rpt;
    }

    public void setNew_pwd_rpt(String new_pwd_rpt) {
        this.new_pwd_rpt = new_pwd_rpt;
    }

    public String getNew_pwd() {
        return new_pwd;
    }

    public void setNew_pwd(String new_pwd) {
        this.new_pwd = new_pwd;
    }

}
