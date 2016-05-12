package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;
import modelo.pojo.Usuario;

public class AuthInterceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		Usuario usuario = (Usuario)session.get("usuario");
		
		if (usuario == null) {
			return Action.LOGIN;
		} else {
			Action action = (Action)actionInvocation.getAction();
			if (action instanceof AuthenticatedUser)
				((AuthenticatedUser)action).setUsuario(usuario);
			return actionInvocation.invoke();
		}
	}
}