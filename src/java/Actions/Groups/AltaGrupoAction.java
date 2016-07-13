package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import modelo.dao.GrupoDAO;
import modelo.pojo.Grupo;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.TipoUsuarioGrupo;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.interceptor.SessionAware;

public class AltaGrupoAction extends ActionSupport implements interceptor.AuthenticatedUser, SessionAware {
    
    private String nombre;
    private String descripcion;
    private Usuario usuario;
    private String submit;
    private String token2;
    private Map<String, Object> userSession;

	public AltaGrupoAction() {
    }
	
    @Override
    public void validate() {
        if(nombre == null || nombre.trim().isEmpty()){
            addActionError("El campo nombre es requerido");
        }else if(nombre.length() > 40){
            addActionError("El número máximo de caracteres en el campo nombre es de 20");
        }
        if(descripcion.length() > 100){
            addActionError("El número máximo de caracteres en el campo descripción es de 100");
        }
        int valueLength = nombre.length();
        String letras = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "1234567890";
        String nombreAux = nombre.toLowerCase();
        char letraInicial = nombreAux.charAt(0);
        char letraFinal = nombreAux.charAt(valueLength - 1);
        if(!((letras.indexOf(letraInicial) != -1 || numeros.indexOf(letraInicial) != -1) && (letras.indexOf(letraFinal) != -1 || numeros.indexOf(letraFinal) != -1))){
            addActionError("El nombre del grupo debe iniciar y terminar con una letra o un número");
        }
    }
    
	@Override
    public String execute() throws Exception {
        
        //Validamos que el token no contenga caracteres especiales para la creación del token
        String token = ""; 
        String [] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z" };
               
        if(submit.equals("Crear")){
            DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
            Date date = new Date();
            token +=  abecedario[(int) Math.round(Math.random() * 25 )];
            token += nombre.charAt(0) + "" + nombre.charAt(nombre.length()-1);
            token += dateFormat.format(date);

            for(int x = 0; x < 2; x++){
                token +=  abecedario[(int) Math.round(Math.random() * 25 )];
            }
        }else{
            token = token2;
        }
        
        GrupoDAO grupoDAO = new GrupoDAO();
        String accion = "crear", nombreGrupo = "";
        if(submit.equals("Crear")){
            accion = "modificar";
        }
        try{
            grupoDAO.conectar();
            if(submit.equals("Crear")){
                List<Grupo> totalGrupos = grupoDAO.buscarTodos();
                token += totalGrupos.size();
            }
            Grupo grupo = new Grupo()
                    .setToken(token)
                    .setNombre(nombre)
                    .setDescripcion(descripcion);
            nombreGrupo = grupo.getNombre();
            if(submit.equals("Crear")){
                grupo.setTotalProfesores(1);//Solo el creador es registrado
                grupoDAO.registrar(grupo);
                addActionMessage("El grupo " + grupo.getNombre() + " ha sido registrado con éxito.");
            }else{
                Grupo viejo = grupoDAO.buscar(new Grupo().setToken(token));
                grupo.setTotalProfesores(viejo.getTotalProfesores());//Se busca el numero de profesores que tenía antes de modificar
                grupoDAO.modificar(viejo, grupo);
                addActionMessage("El grupo " + grupo.getNombre() + " ha sido modificado con éxito");
            }
            grupoDAO.desconectar();
            /*Esto es para agregar al usuario como profesor coordinador.*/
            if(submit.equals("Crear")){
                UsuarioGrupoDAO grupoUsuarioDAO = new UsuarioGrupoDAO();
                grupoUsuarioDAO.conectar();

                grupoUsuarioDAO.registrar(new UsuarioGrupo()
                                            .setCorreo(usuario.getCorreo())
                                            .setAceptado(true)
                                            .setIdTipoUsuarioGrupo(TipoUsuarioGrupo.COORDINADOR)
                                            .setToken(token));

                grupoUsuarioDAO.desconectar();
                userSession.put("token", token);
                userSession.put("nombre", nombre);
                return SUCCESS;
            }
            userSession.put("token", token);
            userSession.put("nombre", nombre);
            return "modificar";
        }catch(RuntimeException e) {
            grupoDAO.desconectar();
            addActionError("Ocurrió un error al " + accion + " el grupo " + nombreGrupo);
            return ERROR;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getToken2() {
        return token2;
    }

    public void setToken2(String token2) {
        this.token2 = token2;
    }

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }
    
}
