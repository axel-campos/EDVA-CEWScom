package Actions.Groups;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.GrupoDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Grupo;
import modelo.pojo.UsuarioGrupo;
import org.apache.struts2.ServletActionContext;



public class verificaTokenAccesoAction extends ActionSupport  {
    
    private String token;
    
    public verificaTokenAccesoAction() {
    }
    @Override
    public String execute() throws Exception {
        GrupoDAO grupoDAO = new GrupoDAO();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            grupoDAO.conectar();
            Grupo grupo = grupoDAO.buscar(new Grupo().setToken(token));
            grupoDAO.desconectar();
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
                        + "</tr>"
                        + "<tr>"
                        + "<td style='text-align: center' colspan='2'><input type='button' class='btn btn-success' onclick='mandarSolicitud(\""+ grupo.getToken()+"\")' value='Envíar solicitud'></td>"
                        + "</tr>";
                out.println(texto);
            }else{//No los hubo
                out.println("Error:");
            }
            
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
