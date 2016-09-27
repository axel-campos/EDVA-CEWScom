package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import modelo.dao.GrupoDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Grupo;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.interceptor.SessionAware;

public class ListarGrupos extends ActionSupport implements interceptor.AuthenticatedUser, SessionAware {
    
    private Usuario usuario;
    private List<UsuarioGrupo> grupos;
    private List<List<String>> resultados;
    private List<Map<String, Object>> groups;
    private Map<String, Object> userSession;
    private String exito = "";
    private String nombre;
    private String rol;
    private String token;
    
	@Override
    public String execute() throws Exception {
        resultados = new ArrayList();
        String tipoUsuario[] = {"","Coordinador", "Administrador", "Colaborador"};
        //Vamos a verificar si no hay token en session
        if(userSession.get("token") != null){
            token = userSession.get("token").toString();
            userSession.remove("token");
            rol = "0";
        }if(userSession.get("nombre") != null){
            nombre = userSession.get("nombre").toString();
            userSession.remove("nombre");
        }
        //Vamos a obtener solo los grupos del usuario que tiene activa la sesión
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO(); 
        usuarioGrupoDAO.conectar();
        if(token.trim().isEmpty() && nombre.trim().isEmpty() && rol.equals("0")){//No hubo filtros
            if(usuario.getTipo() == 1){
                GrupoDAO grupoDAO = new GrupoDAO();
                grupoDAO.conectar();
                List<Grupo> grupos = grupoDAO.buscarTodosLimite();
                for(Grupo g : grupos){
                    List<String> aux = new ArrayList<>();
                    aux.add(g.getNombre());
                    aux.add(g.getDescripcion());
                    aux.add(tipoUsuario[1]);
                    aux.add(g.getToken());
                    aux.add(1 + "");
                    resultados.add(aux);
                }
                grupoDAO.desconectar();
            }else{
                grupos = usuarioGrupoDAO.buscarTodos().stream().filter(
                p -> p.getCorreo().equals(usuario.getCorreo())).filter(p -> p.getAceptado()).collect(Collectors.toList());
                for(int i = 0; i < grupos.size(); i++){
                    List<String> aux = new ArrayList<>();
                    GrupoDAO grupoDAO = new GrupoDAO();
                    grupoDAO.conectar();
                    Grupo group = grupoDAO.buscar(new Grupo().setToken(grupos.get(i).getToken()));
                    aux.add(group.getNombre());
                    aux.add(group.getDescripcion());
                    aux.add(tipoUsuario[grupos.get(i).getIdTipoUsuarioGrupo()]);
                    aux.add(group.getToken());
                    aux.add(grupos.get(i).getIdTipoUsuarioGrupo() + "");
                    grupoDAO.desconectar();
                    resultados.add(aux);
                }
            }
        }else{//Hubo mínimo un filtro
            String where = "";
            if(!token.trim().isEmpty()){
                if(usuario.getTipo() == 1){
                    where = "WHERE g.token LIKE '%" + token + "%' ";
                }else{
                    where += "AND g.token LIKE '%" + token + "%' ";
                }
                userSession.put("token", token);
            }if(nombre != null && !nombre.trim().isEmpty()){ 
                if(usuario.getTipo() == 1){
                    if(where.trim().isEmpty()){
                        where = "WHERE g.nombre LIKE '%" + nombre + "%' ";
                    }else{
                        where += "AND g.nombre LIKE '%" + nombre + "%' ";
                    }
                }else{
                    where += "AND g.nombre LIKE '%" + nombre + "%' ";
                }
                userSession.put("nombre", nombre);
            }if(rol != null && !rol.equals("0")){
                if(usuario.getTipo() != 1){
                    where += "AND idtipoUsuarioGrupo = " + rol;
                    userSession.put("rol", rol);
                }
            }
            if(usuario.getTipo() == 1){
                String sql = "SELECT g.nombre, g.descripcion, g.token FROM grupo g " + where;
                groups = usuarioGrupoDAO.consultaGenerica(sql);
                for(Map<String, Object> group : groups){
                    List<String> aux = new ArrayList<>();
                    aux.add(group.get("nombre").toString());
                    aux.add(group.get("descripcion").toString());
                    aux.add(tipoUsuario[1]);
                    aux.add(group.get("token").toString());
                    aux.add(1 + "");
                    resultados.add(aux);
                }
            }else{
                String sql = "SELECT g.nombre, g.descripcion, ug.idtipoUsuarioGrupo AS rol, g.token FROM usuariogrupo ug INNER JOIN grupo g ON g.token = ug.token " +
                        "WHERE ug.aceptado = 1 AND ug.correo = '" + usuario.getCorreo() + "' " + where;
                groups = usuarioGrupoDAO.consultaGenerica(sql);
                for(Map<String, Object> group : groups){
                    List<String> aux = new ArrayList<>();
                    aux.add(group.get("nombre").toString());
                    aux.add(group.get("descripcion").toString());
                    aux.add(tipoUsuario[Integer.parseInt(group.get("rol").toString())]);
                    aux.add(group.get("token").toString());
                    aux.add(group.get("rol").toString());
                    resultados.add(aux);
                }
            }
        }       
        if(!exito.isEmpty()){
            switch(exito){
                case "1"://Exito al crear.
                    addActionMessage("El grupo " + nombre + " ha sido creado con éxito.");
                    break;
                case "2":
                    addActionMessage("El grupo " + nombre + " ha sido modificado con éxito.");
                    break;
                case "3":
                    addActionMessage("El reporte ha sido creado con éxito");
                    break;
                case "4"://Error al crear
                    addActionError("Ocurrió un error con el grupo " + nombre + ". Por favor, inténtelo más tarde.");
                    break;
                case "5":
                    
                    break;
                case "6":
                    
                    break;
                /*case "7":
                    addActionMessage("El rol de administrador fue cambiado con éxito.");
                    break;
                case "8":
                    addActionError("No se pudo cambiar de rol de administrador.");
                    break;*/
            }
        }
        usuarioGrupoDAO.desconectar();
        userSession.put("busco", true);
        return SUCCESS;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<UsuarioGrupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<UsuarioGrupo> grupos) {
        this.grupos = grupos;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
        usuario = (Usuario)userSession.get("usuario");
    }
    
    
}
