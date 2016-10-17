package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import model.mdo.DropboxPersistence;
import model.mdo.FilePersistence;
import modelo.dao.GrupoDAO;
import modelo.dao.UsuarioDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Grupo;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;

public class BajaGrupo extends ActionSupport implements interceptor.AuthenticatedUser{
    
    private Usuario usuario;
    private String token;
    
    public BajaGrupo() {
    }
    @Override
    public String execute() throws Exception{
        
        GrupoDAO grupoDAO = new GrupoDAO();
        String nombreGrupo = "";
        try{
            grupoDAO.conectar();
            Grupo grupo = grupoDAO.buscar(new Grupo().setToken(token));
            nombreGrupo = grupo.getNombre();
            grupoDAO.eliminar(grupo);
            grupoDAO.desconectar();
            //Eliminamos la carpeta en Dropi
            FilePersistence persistence = new DropboxPersistence();
            persistence.borrarCarpeta("/" + grupo.getToken());
        }catch(RuntimeException e){
            addActionError("El grupo " + nombreGrupo + " no se pudo eliminar.");
            return ERROR;
        }
        addActionMessage("El grupo " + nombreGrupo + " se eliminó con éxito.");
        return SUCCESS;
    }

    public String baja() throws Exception{
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO();
        GrupoDAO grupoDAO = new GrupoDAO();
        String nombreGrupo = "";
        try{
            usuarioGrupoDAO.conectar();
            usuarioGrupoDAO.eliminar(new UsuarioGrupo().setCorreo(usuario.getCorreo()).setToken(token));
            usuarioGrupoDAO.desconectar();
            
            grupoDAO.conectar();
            Grupo grupo = grupoDAO.buscar(new Grupo().setToken(token));
            nombreGrupo = grupo.getNombre();
            grupoDAO.modificar(grupo, new Grupo().setToken(token)
                                                 .setNombre(grupo.getNombre())
                                                 .setDescripcion(grupo.getDescripcion())
                                                 .setTotalProfesores(grupo.getTotalProfesores() - 1));
            grupoDAO.desconectar();
        }catch(RuntimeException e){
            addActionError("Usted no ha podido salir del grupo " + nombreGrupo);
            return ERROR;
        }
        addActionMessage("Usted ha salido de manera exitosa del grupo " + nombreGrupo);
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
