package Actions;

import com.opensymphony.xwork2.ActionSupport;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;
import modelo.pojo.Usuario;
import modelo.pojo.TipoUsuario;
import modelo.dao.UsuarioDAO;
import java.sql.Date;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import org.apache.struts2.ServletActionContext;

public class RegistrarAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private String correo;
    private String nombre;
    private String paterno;
    private String materno;
    private String cedula;
    private String fechaN;
    private String password;
    private String pwd;
    private final int LOG_ROUNDS = 13;
    
    //Avatar image properties
    private String avatarImageDataURL;
    private final String destPath = ServletActionContext.getServletContext().getRealPath("/") + "images\\";

    @Override
    public void validate() {
        setCorreo(correo.toLowerCase());
        if (correo == null || correo.trim().isEmpty() || !correo.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$")) {
            addActionError("El formato del correo es incorrecto.");
        } else if (correo.length() > 30) {
            addActionError("El correo no puede tener más de 30 caracteres");
        } else if (nombre == null || nombre.trim().isEmpty()) {
            addActionError("El campo Nombre(s) es requerido.");
        } else if (nombre.length() > 20) {
            addActionError("El nombre no puede tener más de 20 caracteres");
        } else if (paterno == null || paterno.trim().isEmpty()) {
            addActionError("El campo Apellido Paterno es requerido.");
        } else if (paterno.length() > 20) {
            addActionError("El Apellido Paterno no puede tener más de 20 caracteres");
        } else if (materno.length() > 20) {
            addActionError("El Apellido Materno no puede tener más de 20 caracteres");
        } else if (fechaN == null || fechaN.trim().isEmpty()) {
            addActionError("El campo Fecha de Nacimiento es requerido.");
        } else if (password == null || password.trim().isEmpty()) {
            addActionError("El campo Contraseña es requerido.");
        } else if (password.length() > 60) {
            addActionError("El campo Contraseña no puede tener más de 60 caracteres");
        } else if (pwd == null || pwd.trim().isEmpty()) {
            addActionError("El campo Repita su contraseña es requerido.");
        } else if (!pwd.equals(password)) {
            addActionError("Las contraseñas no coinciden.");
        }
    }

    @Override
    public String execute() throws Exception {
        if (cedula == null || cedula.trim().isEmpty()) {
            setCedula(null);
        }
        UsuarioDAO usuariodao = new UsuarioDAO();
        try {
            usuariodao.conectar();
            
            if (usuariodao.buscar(new Usuario().setCorreo(correo)) != null) {
                usuariodao.desconectar();
                addActionError("Ya existe un usuario con ese correo. Por favor, elija otro.");
                return INPUT;
            }

            if(!avatarImageDataURL.equals("")){
                byte[] imagedata = DatatypeConverter.parseBase64Binary(avatarImageDataURL.substring(avatarImageDataURL.indexOf(",") + 1));
                BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
                ImageIO.write(bufferedImage, "png", new File(destPath + correo + ".png"));
            }

            Usuario usuario = new Usuario()
                                .setCorreo(correo)
                                .setNombre(nombre)
                                .setAPaterno(paterno)
                                .setAMaterno(materno)
                                .setCedula(cedula)
                                .setFechaNacimiento(Date.valueOf(fechaN))
                                .setTipo(TipoUsuario.PROFESOR)
                                .setPassword(BCrypt.hashpw(password, BCrypt.gensalt(LOG_ROUNDS)));
            usuariodao.registrar(usuario);
            usuariodao.desconectar();
            session.put("usuario", usuario);
            return SUCCESS;
        } catch (IllegalArgumentException e) {
            usuariodao.desconectar();
            addActionError("El formato de la fecha de nacimiento es incorrecto.");
            return INPUT;
        } catch (RuntimeException e) {
            if (((SQLException) e.getCause()).getErrorCode() == 1062) {
                addActionError("El usuario no pudo ser registrado debido a que ya existe una cuenta en CWEScom con los datos ingresados.");
                return ERROR;
            }
            usuariodao.desconectar();
            addActionError("Ocurrió un error al registrar al nuevo usuario.");
            return ERROR;
        } 
    }

    @Override
    public void setSession(Map<String, Object> session) {
            this.session = session;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwd() {
            return pwd;
    }

    public void setPwd(String pwd) {
            this.pwd = pwd;
    }
    
    public String getAvatarImageDataURL() {
        return avatarImageDataURL;
    }

    public void setAvatarImageDataURL(String avatarImageDataURL) {
        this.avatarImageDataURL = avatarImageDataURL;
    }
    

}
