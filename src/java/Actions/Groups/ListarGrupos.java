package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelo.dao.GrupoDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Grupo;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;

public class ListarGrupos extends ActionSupport implements interceptor.AuthenticatedUser {
    
    private Usuario usuario;
    private List<UsuarioGrupo> grupos;
    private List<List<String>> resultados;
    private String exito = "";
    
	@Override
    public String execute() throws Exception {
        resultados = new ArrayList();
        String tipoUsuario[] = {"","Coordinador", "Administrador", "Colaborador"};
        
        //Vamos a obtener solo los grupos del usuario que tiene activa la sesión
        UsuarioGrupoDAO usuarioGrupoDAO = new UsuarioGrupoDAO(); 
        usuarioGrupoDAO.conectar();
        
        grupos = usuarioGrupoDAO.buscarTodos().stream().filter(
        p -> p.getCorreo().equals(usuario.getCorreo())).collect(Collectors.toList());
        
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
        
        if(!exito.isEmpty() && exito.equals("1")){
            addActionMessage("El grupo se ha registrado");
        }else if(!exito.isEmpty() && exito.equals("2")){
            addActionMessage("El grupo se ha modificado");
        }else if(!exito.isEmpty() && exito.equals("3")){
            addActionMessage("El grupo se ha eliminado");
        }else if(!exito.isEmpty() && exito.equals("4")){
            addActionError("Ha ocurrido un error al eliminar el grupo");
        }else if(!exito.isEmpty() && exito.equals("5")){
            addActionMessage("Se ha dado de baja exitosamente del grupo");
        }else if(!exito.isEmpty() && exito.equals("6")){
            addActionError("Ha ocurrido un error al tratar de darse de baja del grupo");
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
}