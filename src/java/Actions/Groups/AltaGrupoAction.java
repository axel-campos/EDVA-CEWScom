package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.dao.GrupoDAO;
import modelo.pojo.Grupo;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.TipoUsuarioGrupo;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;

public class AltaGrupoAction extends ActionSupport implements interceptor.AuthenticatedUser {
    
    private String nombre;
    private String descripcion;
    private Usuario usuario;
    private String submit;
    private String token2;

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
    }
    
	@Override
    public String execute() throws Exception {
        String token = "";
        String [] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K", "L", "M","N","O","P","Q","R","S","T","U","V","W", "X","Y","Z" };
               
        if(submit.equals("Crear")){
            DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
            Date date = new Date();
            token += nombre.charAt(0) + "" + nombre.charAt(nombre.length()-1);
            token += dateFormat.format(date);

            for(int x = 0; x < 3; x++){
                token +=  abecedario[(int) Math.round(Math.random() * 25 )];
            }
        }else{
            token = token2;
        }
        
        GrupoDAO grupoDAO = new GrupoDAO();
        try{
            grupoDAO.conectar();
            if(submit.equals("Crear")){
                List<Grupo> totalGrupos = grupoDAO.buscarTodos();
                token += totalGrupos.size();
            }
            Grupo grupo = new Grupo()
                    .setToken(token)
                    .setNombre(nombre)
                    .setDescripcion(descripcion)
                    .setTotalProfesores(1);
            
            if(submit.equals("Crear")){
                grupoDAO.registrar(grupo);
                addActionMessage("<b>¡Éxito!</b> El grupo " + grupo.getNombre() + " ha sido registrado.");
            }else{
                Grupo viejo = new Grupo().setToken(token);
                grupoDAO.modificar(viejo, grupo);
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
                return SUCCESS;
            }
            return "modificar";
        }catch(RuntimeException e) {
            grupoDAO.desconectar();
            addActionError("Ocurrió un error al registrar al nuevo grupo.");
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
    
}
