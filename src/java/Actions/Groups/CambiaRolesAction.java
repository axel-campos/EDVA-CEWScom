package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class CambiaRolesAction extends ActionSupport implements interceptor.AuthenticatedUser, SessionAware {
    private int numMiembros;
    private String token;
    private Usuario usuario;
    private Map<String, Object> userSession;
    
    @Override    
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UsuarioGrupoDAO usuariogrupoDAO = new UsuarioGrupoDAO();
        try{
            usuariogrupoDAO.conectar();
            for(int i = 0; i < numMiembros; i++){
                String correo = request.getParameter("txt_correo_" + i);
                int tipo = Integer.parseInt(request.getParameter("txt_result_" + i));
                UsuarioGrupo UGold = usuariogrupoDAO.buscar(new UsuarioGrupo().setCorreo(correo).setToken(token));
                UsuarioGrupo UGnew = new UsuarioGrupo().setCorreo(correo)
                        .setToken(token).setAceptado(true).setIdTipoUsuarioGrupo(tipo);
                usuariogrupoDAO.modificar(UGold, UGnew);
            }
            usuariogrupoDAO.desconectar();
        }catch(RuntimeException e){
            usuariogrupoDAO.desconectar();
            return ERROR;
        }
        userSession.put("token", token);
        return SUCCESS;
    }
    
    public String establecerNuevoCoordinador(){
        HttpServletRequest request = ServletActionContext.getRequest();
        UsuarioGrupoDAO usuariogrupoDAO = new UsuarioGrupoDAO();
        try{
            usuariogrupoDAO.conectar();
            for(int i = 0; i < numMiembros; i++){
                String correo = request.getParameter("txt_correo_" + i);
                int tipo = Integer.parseInt(request.getParameter("txt_result_" + i));
                UsuarioGrupo UGold = usuariogrupoDAO.buscar(new UsuarioGrupo().setCorreo(correo).setToken(token));
                UsuarioGrupo UGnew = new UsuarioGrupo().setCorreo(correo)
                        .setToken(token).setAceptado(true).setIdTipoUsuarioGrupo(tipo);
                usuariogrupoDAO.modificar(UGold, UGnew);
            }
            usuariogrupoDAO.desconectar();
        }catch(RuntimeException e){
            usuariogrupoDAO.desconectar();
            return ERROR;
        }
        userSession.put("token", token);
        return SUCCESS;
    }

    public int getNumMiembros() {
        return numMiembros;
    }

    public void setNumMiembros(int numMiembros) {
        this.numMiembros = numMiembros;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
    
}
