package Actions.Profesor;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.UsuarioDAO;
import modelo.pojo.Usuario;

/**
 *
 * @author Víctor
 */
public class BajaProfesor extends ActionSupport {
    
    private String correo;
    
    public BajaProfesor() {
    }
    
    public String execute() throws Exception {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        try{
            usuarioDAO.conectar();
            Usuario usuario = new Usuario().setCorreo(correo);
            usuarioDAO.eliminar(usuario);
            usuarioDAO.desconectar();
        }catch(RuntimeException e){
            addActionError("El usuario " + correo + " no se pudo eliminar.");
            return ERROR;
        }
        addActionMessage("El usuario " + correo + " se eliminó con éxito.");
        
        return SUCCESS;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
