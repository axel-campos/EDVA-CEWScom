package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.GrupoDAO;
import modelo.pojo.Grupo;
import org.apache.struts2.ServletActionContext;



public class verificaTokenAccesoAction extends ActionSupport {
    
    private String token;
    
    public verificaTokenAccesoAction() {
    }
    
    public String execute() throws Exception {
        GrupoDAO grupoDAO = new GrupoDAO();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            grupoDAO.conectar();
            Grupo grupo = grupoDAO.buscar(new Grupo().setToken(token));
            if(grupo != null){//Hubo datos
                String texto = "<tr>"
                        + "<td style='width:40%'><b>Token:</b></td>"
                        + "<td style='width:60%'>" + grupo.getToken() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style='width:40%'><b>Nombre:</b></td>"
                        + "<td style='width:60%'>" + grupo.getNombre() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style='width:40%'><b>Descripción:</b></td>"
                        + "<td style='width:60%'>" + grupo.getDescripcion() + "</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td style='width:40%'><b>Total Profesores:</b></td>"
                        + "<td style='width:60%'>" + grupo.getTotalProfesores() + "</td>"
                        + "</tr>";
                out.println(texto);
            }else{//No los hubo
                out.println("Error:");
            }
            grupoDAO.desconectar();
        }catch(RuntimeException e){
            grupoDAO.desconectar();
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
