package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelo.dao.UsuarioDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;


public class ListarRolesGrupo extends ActionSupport implements interceptor.AuthenticatedUser {
    
    private String token;
    private Usuario usuario;
    private List<UsuarioGrupo> usuariosGrupo;
    private List<List<String>> results;
    
    public ListarRolesGrupo() {
    }
    
    public String execute() throws Exception {
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO();
        usuarioGrupoDAO.conectar();
        results = new ArrayList();
        usuariosGrupo = usuarioGrupoDAO.buscarTodos().stream().filter(
                p -> p.getToken().equals(token)).filter(p -> p.getAceptado()).filter(p -> p.getIdTipoUsuarioGrupo() != 1).collect(Collectors.toList());
        for(UsuarioGrupo usergroup : usuariosGrupo){
            List<String> info = new ArrayList<>();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.conectar();
            Usuario user = new Usuario();
            user = usuarioDAO.buscar(new Usuario().setCorreo(usergroup.getCorreo()));
            info.add(user.getNombre() + " " + user.getAPaterno() + " " + user.getAMaterno());
            info.add(user.getCorreo());
            info.add(""); info.add("");
            info.set(usergroup.getIdTipoUsuarioGrupo(), "checked");
            usuarioDAO.desconectar();
            results.add(info);
        }        
        usuarioGrupoDAO.desconectar();
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
    
    
    
}
