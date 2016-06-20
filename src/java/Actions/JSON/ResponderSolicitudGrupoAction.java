package Actions.JSON;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.ServletActionContext;

public class ResponderSolicitudGrupoAction extends ActionSupport {
    
    private String token;
    private String correo;
    private int tipo;
    
    public ResponderSolicitudGrupoAction() {
    }
    
    public String execute() throws Exception {
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO();
        UsuarioGrupo usuarioGrupo;
        usuarioGrupo = usuarioGrupoDAO.buscar(new UsuarioGrupo()
                                                .setCorreo(correo)
                                                .setToken(token));
        
        HttpServletResponse response = ServletActionContext.getResponse();
        try(PrintWriter out = response.getWriter()) {
            try{    
                usuarioGrupoDAO.conectar();
                if(tipo == 1){
                    usuarioGrupoDAO.modificar(usuarioGrupo, new UsuarioGrupo().setCorreo(correo)
                                                                              .setToken(token)
                                                                              .setAceptado(true)
                                                                              .setIdTipoUsuarioGrupo(usuarioGrupo.getIdTipoUsuarioGrupo()));
                    out.println("Se ha aceptado al usuario en el grupo");
                }else{
                    usuarioGrupoDAO.eliminar(usuarioGrupo);     //Se elimina la solicitud del usuario si se rechaza
                    out.println("Se ha eliminado la solicitud del usuario");
                }
                usuarioGrupoDAO.desconectar();
                out.flush();
            }catch(RuntimeException e){
                out.println("Error: Hubo un error al procesar la solicitud");
                out.flush();
                usuarioGrupoDAO.desconectar();
                return ERROR;
            }
        }
        return SUCCESS;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}
