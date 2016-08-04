package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import modelo.dao.GrupoDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Grupo;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class CambiaRolesAction extends ActionSupport implements interceptor.AuthenticatedUser, SessionAware {
    private int numMiembros;
    private String token;
    private Usuario usuario;
    private Map<String, Object> userSession;
    private String correo;
    
    @Override    
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UsuarioGrupoDAO usuariogrupoDAO = new UsuarioGrupoDAO();
        try{
            usuariogrupoDAO.conectar();
            for(int i = 0; i < numMiembros; i++){
                correo = request.getParameter("txt_correo_" + i);
                int tipo = Integer.parseInt(request.getParameter("txt_result_" + i));
                UsuarioGrupo UGold = usuariogrupoDAO.buscar(new UsuarioGrupo().setCorreo(correo).setToken(token));
                UsuarioGrupo UGnew = new UsuarioGrupo().setCorreo(correo)
                        .setToken(token).setAceptado(true).setIdTipoUsuarioGrupo(tipo);
                usuariogrupoDAO.modificar(UGold, UGnew);
            }
            usuariogrupoDAO.desconectar();
        }catch(RuntimeException e){
            usuariogrupoDAO.desconectar();
            return ERROR;
        }
        userSession.put("token", token);
        return SUCCESS;
    }
    
    public String establecerNuevoCoordinador(){
        HttpServletRequest request = ServletActionContext.getRequest();
        UsuarioGrupoDAO usuariogrupoDAO = new UsuarioGrupoDAO();
        String nombreGrupo = "";
        try{
            //Obtenemos el nombre del grupo.
            GrupoDAO grupoDAO = new GrupoDAO();
            grupoDAO.conectar();
            Grupo group = grupoDAO.buscar(new Grupo().setToken(token));
            nombreGrupo = group.getNombre();
            grupoDAO.desconectar();
            //iniciamos este mame
            usuariogrupoDAO.conectar();
            //Quitar el rol de coordinador al viejo.
            List<UsuarioGrupo> coordinadores = usuariogrupoDAO.buscarTodos().stream().filter(p -> p.getIdTipoUsuarioGrupo() == 1)
                    .filter(p -> p.getToken().equals(token)).collect(Collectors.toList());
            for(int i = 0; i < numMiembros; i++){
                String tipo = request.getParameter("txt_result_" + i);
                if(tipo != null){
                    correo = request.getParameter("txt_correo_" + i);
                    UsuarioGrupo UGold = usuariogrupoDAO.buscar(new UsuarioGrupo().setCorreo(correo).setToken(token));
                    UsuarioGrupo UGnew = new UsuarioGrupo().setCorreo(correo).setToken(token).setAceptado(true).setIdTipoUsuarioGrupo(Integer.parseInt(tipo));
                    usuariogrupoDAO.modificar(UGold, UGnew);
                    for(UsuarioGrupo coordinador : coordinadores){
                        UsuarioGrupo coordinadorNew = usuariogrupoDAO.buscar(coordinador);
                        coordinadorNew.setIdTipoUsuarioGrupo(2);
                        if(!coordinador.getCorreo().equals(correo)){
                            usuariogrupoDAO.modificar(coordinador, coordinadorNew);
                        }
                    }
                    break;
                }
            }
            
            
            //Nos desconectamos
            usuariogrupoDAO.desconectar();
        }catch(RuntimeException e){
            usuariogrupoDAO.desconectar();
            addActionError("El cambio de coordinador en el grupo " + nombreGrupo + " no se ha podido efectuar. Usted sigue siendo el coordinador");
            return ERROR;
        }
        addActionMessage("Cambio de coordinador exitoso en el grupo " + nombreGrupo + ". Su rol en este grupo ahora es de administrador.");
        return SUCCESS;
    }
    
    public String eliminaMiembro(){
        UsuarioGrupoDAO usuariogrupoDAO = new UsuarioGrupoDAO();
        try{
            usuariogrupoDAO.conectar();
            //Quitar el rol de coordinador al viejo.
            usuariogrupoDAO.eliminar(new UsuarioGrupo().setCorreo(correo).setToken(token));
            //Nos desconectamos
            usuariogrupoDAO.desconectar();
            //Ahora disminuimos el número de miembros
            GrupoDAO grupoDAO = new GrupoDAO();
            grupoDAO.conectar();
            Grupo grupo = grupoDAO.buscar(new Grupo().setToken(token));
            grupoDAO.modificar(grupo, new Grupo().setDescripcion(grupo.getDescripcion())
            .setNombre(grupo.getNombre()).setToken(grupo.getToken()).setTotalProfesores(grupo.getTotalProfesores() - 1));
            grupoDAO.desconectar();
        }catch(RuntimeException e){
            usuariogrupoDAO.desconectar();
            return ERROR;
        }
        userSession.put("token", token);
        return SUCCESS;
    }

    public int getNumMiembros() {
        return numMiembros;
    }

    public void setNumMiembros(int numMiembros) {
        this.numMiembros = numMiembros;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public Map<String, Object> getUserSession() {
        return userSession;
    }

    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
