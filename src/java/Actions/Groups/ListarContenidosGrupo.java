package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author DanHv
 */
public class ListarContenidosGrupo extends ActionSupport implements interceptor.AuthenticatedUser, SessionAware{
    private Usuario usuario;
    private Map<String, Object> userSession;
    private boolean esCoordinador = false;
    private boolean esAdministrador = false;
    private String token;
    
    
    @Override
    public String execute() throws Exception {
        if(userSession.get("token") != null){
            token = userSession.get("token").toString();
        }
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO();
        usuarioGrupoDAO.conectar();
        UsuarioGrupo usuariogrupo = usuarioGrupoDAO.buscar(new UsuarioGrupo().setCorreo(usuario.getCorreo()).setToken(token));
        if(usuariogrupo != null){
            switch(usuariogrupo.getIdTipoUsuarioGrupo()){
                case 1://coordinador)
                    esCoordinador = true;
                    esAdministrador = true;
                    break;
                case 2://administrador
                    esAdministrador = true;
                    break;
            }
        }
        usuarioGrupoDAO.desconectar();
        return SUCCESS;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isEsCoordinador() {
        return esCoordinador;
    }

    public void setEsCoordinador(boolean esCoordinador) {
        this.esCoordinador = esCoordinador;
    }

    public boolean isEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
    
    
}
