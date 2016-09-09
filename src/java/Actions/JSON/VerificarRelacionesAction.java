package Actions.JSON;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.ContenidoDAO;
import modelo.pojo.Contenido;
import modelo.pojo.Usuario;
import org.apache.struts2.ServletActionContext;

public class VerificarRelacionesAction extends ActionSupport {
    
    private String token;
    List<Contenido> contenidos;
    List<Map<String, Object>> usuarios;
    private int respuesta;
    
    public VerificarRelacionesAction() {
    }
    
    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        
        //Obtenemos todos los contenidos asociados
        ContenidoDAO contenidoDAO = new ContenidoDAO();
        contenidoDAO.conectar();
        
        contenidos = contenidoDAO.buscarTodos().stream().filter(
        p -> p.getToken().equals(token)).collect(Collectors.toList());
        
        //Obtenemos todos los integrantes del grupo
        String sql = "SELECT u.correo, u.nombre, u.APaterno, u.AMaterno FROM usuario u "
                + "LEFT JOIN usuariogrupo AS ug ON ug.correo = u.correo "
                + "WHERE ug.token = '" + token + "' AND u.correo != '" + usuario.getCorreo() + "'";
        usuarios = contenidoDAO.consultaGenerica(sql);
        
        HttpServletResponse response = ServletActionContext.getResponse();
        //Se pone el try para que el PrintWriter se cierre solito.
        try(PrintWriter out = response.getWriter()) {
            if(!contenidos.isEmpty() && !usuarios.isEmpty()){
                respuesta = 1;
                out.println("Si");
            }else{
                respuesta = 0;
                out.println("No");
            }

            out.flush();
        }
        return SUCCESS;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    public List<Map<String, Object>> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Map<String, Object>> usuarios) {
        this.usuarios = usuarios;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
    
}
