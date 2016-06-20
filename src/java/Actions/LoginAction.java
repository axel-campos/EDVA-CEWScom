package Actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;
import modelo.pojo.Usuario;
import modelo.dao.UsuarioDAO;

public class LoginAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	private String correo;
	private String password;
	
	@Override
	public String execute() throws Exception {
        setCorreo(correo.toLowerCase());
		if (correo == null || correo.trim().isEmpty() || !correo.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$")) {
			addActionMessage("Por favor, ingrese un correo con formato válido.");
			return INPUT;
		}
		
		if (password == null || password.trim().isEmpty()) {
			addActionMessage("Por favor, ingrese su contraseña.");
			return INPUT;
		}
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		try{	
			usuariodao.conectar();
			Usuario usuario = usuariodao.buscar(new Usuario().setCorreo(correo));
			if(usuario != null){
				if(BCrypt.checkpw(password, usuario.getPassword())){
					usuariodao.desconectar();
					session.put("usuario", usuario);
                    addActionMessage("Usuario Registrado. Por favor, inicie sesión para iniciar a ocupar la aplicación.");
					return SUCCESS;
				}		
            }
			
			usuariodao.desconectar();
			addActionError("El correo o la contraseña son incorrectas.");
			return INPUT;
        }catch(RuntimeException e){
			usuariodao.desconectar();
            e.printStackTrace();
			addActionError("Ocurrió un error al buscar al usuario.");
            return ERROR;
        }
	}
	
	public String logout() throws Exception {
		((SessionMap)session).invalidate();
		return SUCCESS;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}