package Actions.Groups;


import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import modelo.dao.UsuarioDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.interceptor.SessionAware;

public class ListarMiembros extends ActionSupport implements interceptor.AuthenticatedUser, SessionAware {
    Map<String, Object> userSession;
    private String token;
    private List<UsuarioGrupo> usuariosGrupo;
    private List<String> results;
    private Usuario usuario;
    @Override
    public String execute() throws Exception {
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO();
        usuarioGrupoDAO.conectar();
        results = new ArrayList();
        usuariosGrupo = usuarioGrupoDAO.buscarTodos().stream().filter(
                p -> p.getToken().equals(token)).filter(p -> p.getAceptado()).collect(Collectors.toList());
        for(UsuarioGrupo usergroup : usuariosGrupo){            
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.conectar();
            Usuario user = usuarioDAO.buscar(new Usuario().setCorreo(usergroup.getCorreo()));
            String nombre = user.getNombre() + " " + user.getAPaterno();
            if(user.getAMaterno() != null){
                nombre += " " + user.getAMaterno();
            }
            usuarioDAO.desconectar();
            results.add(nombre);
        }
        usuarioGrupoDAO.desconectar();
        userSession.put("token", token);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }   

    public Map<String, Object> getUserSession() {
        return userSession;
    }

    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public List<UsuarioGrupo> getUsuariosGrupo() {
        return usuariosGrupo;
    }

    public void setUsuariosGrupo(List<UsuarioGrupo> usuariosGrupo) {
        this.usuariosGrupo = usuariosGrupo;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    
}
