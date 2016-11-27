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

public class ListarSolicitudesAction extends ActionSupport implements interceptor.AuthenticatedUser, SessionAware {
    private Usuario usuario;
    private Map<String, Object> userSession;
    private String token;
    private List<List<String>> solicitantes;
    
    
    @Override
    public String execute() throws Exception {
        UsuarioGrupoDAO usuariogrupoDAO = new UsuarioGrupoDAO();
        usuariogrupoDAO.conectar();
        List<UsuarioGrupo> lista = usuariogrupoDAO.buscarTodos().stream().filter(p -> p.getToken().equals(token)).filter(p -> !p.getAceptado()).collect(Collectors.toList());
        usuariogrupoDAO.desconectar();
        solicitantes = new ArrayList();
        for(UsuarioGrupo solicitud : lista){
            List<String> datos = new ArrayList<>();
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.conectar();
            Usuario solicitante = usuarioDAO.buscar(new Usuario().setCorreo(solicitud.getCorreo()));
            datos.add(solicitante.getCorreo()); 
            String nombre = solicitante.getNombre() + " " + solicitante.getAPaterno();
            if(solicitante.getAMaterno() != null){
                nombre += " " + solicitante.getAMaterno();
            }
            datos.add(nombre);
            solicitantes.add(datos);
            usuarioDAO.desconectar();
        }
        return SUCCESS;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public List<List<String>> getSolicitantes() {
        return solicitantes;
    }

    public void setSolicitantes(List<List<String>> solicitantes) {
        this.solicitantes = solicitantes;
    }
    
    
    
    
}
