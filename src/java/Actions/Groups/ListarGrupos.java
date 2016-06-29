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
    
	@Override
    public String execute() throws Exception {
        resultados = new ArrayList();
        String tipoUsuario[] = {"","Coordinador", "Administrador", "Colaborador"};
        
        //Vamos a obtener solo los grupos del usuario que tiene activa la sesión
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO(); 
        usuarioGrupoDAO.conectar();
        if(nombre.trim().isEmpty() && rol.equals("0")){//No hubo filtros
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
        }else{//Hubo mínimo un filtro
            String where = "";
            if(!nombre.trim().isEmpty()){ 
                where += "AND g.nombre LIKE '%" + nombre + "%'";
                userSession.put("nombre", nombre);
            }
            if(!rol.equals("0")){
                where += "AND idtipoUsuarioGrupo = " + rol;
                userSession.put("rol", rol);
            }
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
        if(!exito.isEmpty()){
            switch(exito){
                case "1":
                    addActionMessage("El grupo se ha registrado");
                    break;
                case "2":
                    addActionMessage("El grupo se ha modificado");
                    break;
                case "3":
                    addActionMessage("El grupo se ha eliminado");
                    break;
                case "4":
                    addActionError("Ha ocurrido un error al eliminar el grupo");
                    break;
                case "5":
                    addActionMessage("Se ha dado de baja exitosamente del grupo");
                    break;
                case "6":
                    addActionError("Ha ocurrido un error al tratar de darse de baja del grupo");
                    break;
                case "7":
                    addActionMessage("El rol de administrador fue cambiado con éxito.");
                    break;
                case "8":
                    addActionError("No se pudo cambiar de rol de administrador.");
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

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
    
    
}