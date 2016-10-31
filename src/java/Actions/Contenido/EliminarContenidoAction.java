package Actions.Contenido;

import static com.opensymphony.xwork2.Action.*;
import com.opensymphony.xwork2.ActionSupport;
import model.mdo.DropboxPersistence;
import model.mdo.FilePersistence;
import modelo.dao.ContenidoDAO;
import modelo.pojo.Contenido;

/**
 *
 * @author DanHv
 */
public class EliminarContenidoAction extends ActionSupport{
    private String id;
    private String message;
    private String type;
    
    
    public String execute() throws Exception {
        ContenidoDAO  contenidoDAO = new ContenidoDAO();
        String nombre = "";
        try{
            contenidoDAO.conectar();
            Contenido contenido = contenidoDAO.buscar(new Contenido().setIdContenido(Integer.parseInt(id)));
            if(contenido != null){
                nombre = contenido.getTitulo();
                contenidoDAO.eliminar(contenido);
                contenidoDAO.desconectar();
                //Eliminamos la carpeta de Dropbox
                FilePersistence persistence = new DropboxPersistence();	
                persistence.borrarCarpeta("/" + contenido.getToken() + "/" + contenido.getIdContenido());
                //Regresamos                
                type = "success";
                message = "El contenido didáctico <b>" + nombre + "</b> se eliminó con éxito.";
                return SUCCESS;
            }else{
                contenidoDAO.desconectar();
                type = "info";
                message = "El contenido didáctico que se quería eliminar no se encontró.";
                return INPUT;
            }
            
        }catch(RuntimeException e){
            e.printStackTrace();
            contenidoDAO.desconectar();
            type = "danger";
            message = "El contenido didáctico <b>" + nombre + "</b>no se pudo eliminar.";
            return ERROR;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
   
    
}
