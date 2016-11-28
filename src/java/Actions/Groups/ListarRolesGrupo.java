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


public class ListarRolesGrupo extends ActionSupport implements interceptor.AuthenticatedUser, SessionAware {
    
    private String token;
    private Usuario usuario;
    private List<UsuarioGrupo> usuariosGrupo;
    private List<List<String>> results;
    private Map<String, Object> userSession;
    private String mensaje = "";
    
    @Override    
    public String execute() throws Exception {
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO();
        usuarioGrupoDAO.conectar();
        results = new ArrayList();
        if(token == null){
            token = userSession.get("token").toString();
            userSession.remove("token");
        }
        usuariosGrupo = usuarioGrupoDAO.buscarTodos().stream().filter(
                p -> p.getToken().equals(token)).filter(p -> p.getAceptado()).filter(p -> p.getIdTipoUsuarioGrupo() != 1).collect(Collectors.toList());
        for(UsuarioGrupo usergroup : usuariosGrupo){
            List<String> info = new ArrayList<>();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.conectar();
            Usuario user = new Usuario();
            user = usuarioDAO.buscar(new Usuario().setCorreo(usergroup.getCorreo()));
            String nombre = user.getNombre() + " " + user.getAPaterno();
            if(user.getAMaterno() != null){
                nombre += " " + user.getAMaterno();
            }
            info.add(nombre);
            info.add(user.getCorreo());
            info.add(""); info.add("");
            info.set(usergroup.getIdTipoUsuarioGrupo(), "checked");
            usuarioDAO.desconectar();
            results.add(info);
        }        
        usuarioGrupoDAO.desconectar();
        if(!mensaje.isEmpty()){
            switch(mensaje){
                case "1":
                    addActionMessage("Los roles del grupo han sido cambiados exitosamente.");
                    break;
                case "2":
                    addActionError("Los roles del grupo no se han podido cambiar.");
                    break;
                case "3":
                    addActionMessage("Profesor eliminado con éxito.");
                    break;
                case "4":
                    addActionError("El profesor no pudo ser eliminado con éxito.");
                    break;    
            }
        }
        return SUCCESS;
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

    public List<UsuarioGrupo> getUsuariosGrupo() {
        return usuariosGrupo;
    }

    public void setUsuariosGrupo(List<UsuarioGrupo> usuariosGrupo) {
        this.usuariosGrupo = usuariosGrupo;
    }

    public List<List<String>> getResults() {
        return results;
    }

    public void setResults(List<List<String>> results) {
        this.results = results;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    } 

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
    
}
