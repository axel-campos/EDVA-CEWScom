package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.pojo.Grupo;
import modelo.pojo.Usuario;

public class AccesoGrupoAction extends ActionSupport implements interceptor.AuthenticatedUser{
    private Usuario usuario;
    private String token;
    private List<Grupo> grupos; 
    
    
    public AccesoGrupoAction() {        
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
   
    
    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
