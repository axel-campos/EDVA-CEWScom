package actions.mdocontenido;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.HashMap;

public class DescargarContenido extends ActionSupport {

	private Map<String, String> stateMap = new HashMap<>();
	
	@Override
	public String execute() throws Exception {
		stateMap.put("message", "La llamada AJAX se realizó correctamente.");
		return SUCCESS;
	}

	public Map<String, String> getStateMap() {
		return stateMap;
	}

	public void setStateMap(Map<String, String> stateMap) {
		this.stateMap = stateMap;
	}
}