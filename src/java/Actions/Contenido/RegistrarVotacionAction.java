package Actions.Contenido;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import modelo.dao.UsuarioVotacionDAO;
import modelo.dao.VotacionDAO;
import modelo.pojo.Usuario;
import modelo.pojo.Votacion;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Víctor
 */
public class RegistrarVotacionAction extends ActionSupport implements SessionAware{
    
    private String etapa1;
    private String etapa2;
    private String etapa3;
    private String etapa4;
    private String etapa5;
    private String idContenido;
    private Usuario usuario;
    
    public RegistrarVotacionAction() {
    }
    
    @Override
    public void validate(){
        if(etapa1 == null || etapa1.trim().isEmpty()){
            addActionError("No se seleccionó ninguna versión de la etapa 1.");
        }
        if(etapa2 == null || etapa2.trim().isEmpty()){
            addActionError("No se seleccionó ninguna versión de la etapa 2.");
        }
        if(etapa3 == null || etapa3.trim().isEmpty()){
            addActionError("No se seleccionó ninguna versión de la etapa 3.");
        }
        if(etapa4 == null || etapa4.trim().isEmpty()){
            addActionError("No se seleccionó ninguna versión de la etapa 4.");
        }
        if(etapa5 == null || etapa5.trim().isEmpty()){
            addActionError("No se seleccionó ninguna versión de la etapa 5.");
        }
        if(idContenido == null || idContenido.trim().isEmpty()){
            addActionError("No ha recibido el parámetro del contenido.");
        }
    }
    
    public String execute() throws Exception {
        VotacionDAO votacionDAO = new VotacionDAO();
        UsuarioVotacionDAO usuarioVotacionDAO = new UsuarioVotacionDAO();
        try{
            votacionDAO.conectar();
            usuarioVotacionDAO.conectar();
            String buscarVotacionSQL = "SELECT * FROM votacion WHERE idContenido = " + idContenido;
            List<Map<String,Object>> buscarVotacion = votacionDAO.consultaGenerica(buscarVotacionSQL);
            if(buscarVotacion == null || buscarVotacion.isEmpty()){
                for(int i = 1; i < 6; i++){
                    Votacion votacion = new Votacion().setIdContenido(Integer.parseInt(idContenido))
                                                       .setIdEtapa(Short.parseShort(i + ""));
                    votacionDAO.registrar(votacion);
                } 
            }
            
        }catch(Exception e){
            addActionError("Hubo un error al procesar la solicitud, inténtelo de nuevo");
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        usuario = (Usuario)map.get("usuario");
    }
    
}
