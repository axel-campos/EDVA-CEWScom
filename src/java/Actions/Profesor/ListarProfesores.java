package Actions.Profesor;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.dao.UsuarioDAO;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.interceptor.SessionAware;

public class ListarProfesores extends ActionSupport implements SessionAware{
    
    private Usuario usuario;
    private List<List<String>> resultados;
    private Map<String, Object> userSession;
    private String exito = "";
    private String nombre;
    private String correo;
    private String cedula;
    
    public ListarProfesores() {
    }
    
    public String execute() throws Exception {
        resultados = new ArrayList();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.conectar();
        List<Map<String, Object>> usuarios;
        String where = "WHERE tipoUsuario = 2 ";
        
        if(nombre != null && !nombre.isEmpty()){
            where = "AND CONCAT_WS(' ',u.nombre,u.aPaterno,u.aMaterno) LIKE '%" + nombre + "%'";
            userSession.put("nombre", nombre);
        }
        if(correo != null && !correo.isEmpty()){
            where = "AND u.correo = '" + correo + "'";
            userSession.put("correo", correo);
        }
        if(cedula != null && !cedula.isEmpty()){
            where = "AND u.cedula = '" + cedula + "'";
            userSession.put("cedula", cedula);
        }
        
        String sql = "SELECT * FROM usuario u " + where;
        usuarios = usuarioDAO.consultaGenerica(sql);
        for(Map<String, Object> u : usuarios){
            List<String> aux = new ArrayList<>();
            aux.add(u.get("correo").toString());
            aux.add(u.get("nombre").toString());
            if(u.get("cedula") != null){
                aux.add(u.get("cedula").toString());
            }else{
                aux.add("");
            }
            resultados.add(aux);
        }
        
        userSession.put("busco", true);
        usuarioDAO.desconectar();
        return SUCCESS;
    }

    public List<List<String>> getResultados() {
        return resultados;
    }

    public void setResultados(List<List<String>> resultados) {
        this.resultados = resultados;
    }

    public String getExito() {
        return exito;
    }

    public void setExito(String exito) {
        this.exito = exito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
        usuario = (Usuario)userSession.get("usuario");
    }
    
    
}
