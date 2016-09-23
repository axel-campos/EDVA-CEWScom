package Actions.Reportes;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import modelo.dao.ReporteDAO;
import modelo.pojo.Reporte;
import modelo.pojo.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Víctor
 */
public class AltaReporte extends ActionSupport implements SessionAware{
    
    private String causa;
    private int tipoReporte;
    private String valor;
    private String extra;
    private Map<String, Object> userSession;
    
    public AltaReporte() {
    }
    
    @Override
    public void validate() {
        if(tipoReporte == 0){
            addActionError("El campo tipo reporte es requerido");
        }
        if(causa == null || causa.trim().isEmpty()){
            addActionError("El campo causa es requerido");
        }else if(causa.length() > 200){
            addActionError("El número máximo de caracteres en el campo causa es de 200");
        }
        if(valor == null || valor.trim().isEmpty()){
            addActionError("El campo valor es requerido");
        }
    }
    
    public String execute() throws Exception {
        String ret = "";
        ReporteDAO reporteDAO = new ReporteDAO();
        reporteDAO.conectar();
        Reporte reporte = new Reporte();
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        
        reporte.setAceptado(0);
        reporte.setAtendido(0);
        reporte.setCausa(causa);
        reporte.setFechaReporte(now);
        if(tipoReporte == 1){   //Reporte de contenido
            reporte.setIdContenido(Integer.parseInt(valor));
            ret = "contenido";
        }else if(tipoReporte == 2){ //Reporte de grupo
            reporte.setToken(valor);
            userSession.put("token", valor);
            userSession.put("nombre", "");
            ret = "grupo";
        }else{  //Reporte de profesor
            reporte.setCorreo(valor);
            addActionMessage("El reporte del usuario se ha creado correctamente");
            userSession.put("token", extra);
            ret = "profesor";
        }
        
        Usuario usuario = (Usuario)userSession.get("usuario");
        reporte.setCorreoReportando(usuario.getCorreo());
        reporteDAO.registrar(reporte);
        return ret;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public int getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(int tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }   
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.userSession = session;
    }
    
}
