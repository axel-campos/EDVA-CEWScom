package Actions.JSON;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDAO;
import modelo.pojo.Usuario;
import org.apache.struts2.ServletActionContext;

public class VerificarUsuarioFacebookAction extends ActionSupport {
    private String nombre;
    private String apellido;
    private String correo;
    private String fecha;
    private String imagen;
    
    public VerificarUsuarioFacebookAction() {
    }
    
    public String execute() throws Exception {
        //Primero vamos a ver sí el correo del usuario existe en la BD, sí no existe hay que registrarlo.
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        try{
            usuarioDAO.conectar();
            usuario = usuarioDAO.buscar(new Usuario().setCorreo(correo));

            if(usuario == null){
                //Sí el resultado es nulo, vamos a registrar al usuario en la base de datos.
                Date initDate = new SimpleDateFormat("MM/dd/yyyy").parse(fecha);
                String formatter = new SimpleDateFormat("yyyy-MM-dd").format(initDate);
                Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(formatter);
                
                usuarioDAO.registrar(new Usuario()
                        .setCorreo(correo)
                        .setNombre(nombre)
                        .setAPaterno(apellido)
                        .setFechaNacimiento(new java.sql.Date(fechaNacimiento.getTime()))
                        .setTipo(2)
                        .setFacebook(1)
                        .setAvatar(imagen)
                        .setPassword("asdasdasd"));
            }

            //Vamos a obtener al usuario para darlo de alta en la sesión, lo buscamos de nuevo en caso de que haya sido null la primera vez
            usuario = usuarioDAO.buscar(new Usuario().setCorreo(correo));
            usuario.setAvatar(imagen);
            usuarioDAO.modificar(usuario, usuario);
            usuarioDAO.desconectar();
            
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("usuario", usuario);

            HttpServletResponse response = ServletActionContext.getResponse();
            //Se pone el try para que el PrintWriter se cierre solito.
            try(PrintWriter out = response.getWriter()) {
                out.println("Listo");
                out.flush();
            }
        }catch(RuntimeException e){
            e.printStackTrace();
			usuarioDAO.desconectar();
            HttpServletResponse response = ServletActionContext.getResponse();
            //Se pone el try para que el PrintWriter se cierre solito.
            try(PrintWriter out = response.getWriter()) {
                out.println("Error: Hubo un error al procesar la solicitud");
                out.flush();
            }
            return ERROR;
        }
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}

