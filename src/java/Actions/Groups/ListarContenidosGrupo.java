package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;

/**
 *
 * @author DanHv
 */
public class ListarContenidosGrupo extends ActionSupport implements interceptor.AuthenticatedUser{
    private Usuario usuario;
    
    private boolean esCoordinador = false;
    private boolean esAdministrador = false;
    private String token;
    
    
    @Override
    public String execute() throws Exception {
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
    
    
}
