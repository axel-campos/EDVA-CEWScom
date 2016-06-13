package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Grupo;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;

public class AccesoGrupoAction extends ActionSupport implements interceptor.AuthenticatedUser{
    private Usuario usuario;
    private String token;
    
    
    public AccesoGrupoAction() {        
    }
    @Override
    public String execute() throws Exception {
        //Primero buscamos que no tenga ya una solicitud.
        UsuarioGrupoDAO usuariogrupoDAO = new UsuarioGrupoDAO();
        try{
            usuariogrupoDAO.conectar();
            UsuarioGrupo usuariogrupo = usuariogrupoDAO.buscar(new UsuarioGrupo().setToken(token).setCorreo(usuario.getCorreo()));
            if(usuariogrupo == null){//No se tiene registro de que ya se hizo una solicitud.
                usuariogrupoDAO.registrar(new UsuarioGrupo().setToken(token).setCorreo(usuario.getCorreo()).setAceptado(false).setIdTipoUsuarioGrupo(3));
                addActionMessage("Éxito al enviar la solicitud. Por favor, espere la respuesta a su solicitud.");
                usuariogrupoDAO.desconectar();                
            }else{//Si se tiene registro.
                usuariogrupoDAO.desconectar();
                addActionMessage("Usted ya había envíado una solicitud previa para ingresar a este grupo. Por favor, espere la respuesta de su solicitud.");
                return INPUT;
            }
        }catch(RuntimeException e){
            addActionError("No se pudo enviar solicitud. Intente de nuevo.");
            usuariogrupoDAO.desconectar();
            return ERROR;
        }
        return SUCCESS;
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
