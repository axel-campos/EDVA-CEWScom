package Actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class EstablecerMostrarAction extends ActionSupport implements SessionAware {
    Map<String,Object> userSession;
    private String action;
    private String accion;
    
    @Override    
    public String execute() throws Exception {
        if(accion.equals("1")){//A crear
            userSession.put("action", action);
        }else{//A destruir
            userSession.remove("action");
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
    
}
