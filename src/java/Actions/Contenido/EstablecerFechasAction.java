package Actions.Contenido;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ContenidoEtapaDAO;
import modelo.dao.EtapaDAO;
import modelo.pojo.ContenidoEtapa;
import modelo.pojo.Etapa;
import org.apache.struts2.ServletActionContext;

public class EstablecerFechasAction extends ActionSupport  {
    
    private String idContenido;
    private String version;
    private String fecha;
    //Para cargaEtapas
    private List<Etapa> etapas;
    //Para cargaVersiones
    private String etapa;
    
    @Override
    public String execute() throws Exception {
        ContenidoEtapaDAO contEtapaDAO = new ContenidoEtapaDAO();        
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            contEtapaDAO.conectar();
            //DateFormat df = DateFormat.getDateInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            /*List<ContenidoEtapa> versiones = contEtapaDAO.buscarTodos().stream()
                    .filter(p -> p.getIdContenido() == Integer.parseInt(idContenido)).filter(p -> p.getTiempoModificacion() >= Date.valueOf(fecha)).collect(Collectors.toList());*/
            contEtapaDAO.registrar(new ContenidoEtapa().setIdContenido(Integer.parseInt(idContenido))
            .setIdEtapa(Short.parseShort(etapa)).setLiberado(false).setRutaRecursos("").setVersion(Integer.parseInt(version))
            .setTiempoModificacion(formatter.parse(fecha)));
            out.print("Exito");
            contEtapaDAO.desconectar();
        }catch(RuntimeException e){
            contEtapaDAO.desconectar();
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    public String cargaEtapas(){
        ContenidoEtapaDAO contEtapaDAO = new ContenidoEtapaDAO();
        String sql = "SELECT IF(ISNULL(MAX(idEtapa)),1, MAX(idEtapa) + 1) AS etapa FROM contenidoetapa WHERE idContenido = " + idContenido;
        int numeroEtapa = 0;
        try{
            contEtapaDAO.conectar();
            List<Map<String, Object>> resultado = contEtapaDAO.consultaGenerica(sql);
            for(Map<String, Object>respuesta : resultado){
                numeroEtapa = Integer.parseInt(respuesta.get("etapa").toString());
            }
            final int n = numeroEtapa;
            contEtapaDAO.desconectar();
            EtapaDAO etapaDAO = new EtapaDAO();
            etapaDAO.conectar();
            etapas = etapaDAO.buscarTodos().stream().filter(p -> p.getIdEtapa() <= n).collect(Collectors.toList());
            etapaDAO.desconectar();
            return SUCCESS;
        }catch(RuntimeException e){
            contEtapaDAO.desconectar();
            return ERROR;
        }
    }
    
    public String cargaVersiones() throws Exception{
        ContenidoEtapaDAO contEtapaDAO = new ContenidoEtapaDAO();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            contEtapaDAO.conectar();
            List<ContenidoEtapa> versiones = contEtapaDAO.buscarTodos().stream()
                    .filter(p -> p.getIdContenido() == Integer.parseInt(idContenido)).filter(p -> p.getIdEtapa() == Integer.parseInt(etapa)).collect(Collectors.toList());
            contEtapaDAO.desconectar();
            String txt = "<thead> <tr> <th style=\"width: 30%; text-align: center\">Versión</th><th style=\"width: 70%; text-align: center\">Tiempo Límite Creación</th>" +
            "</tr></thead><tbody>";
            Locale espanol = new Locale("es","ES");
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy, HH:mm:ss", espanol);
            for(ContenidoEtapa version : versiones){
                txt += "<tr>"
                        + "<td style='text-align: center;'>" + version.getVersion() + "</td>"
                        + "<td style='text-align: center;'>" + dateFormat.format(version.getTiempoModificacion()) + "</td>"
                        + "</tr>";
            }
            txt += "</tbody>";
            out.println(txt);
        }catch(RuntimeException e){
            contEtapaDAO.desconectar();
        }        
        return SUCCESS;
    }

    public String getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(String idContenido) {
        this.idContenido = idContenido;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
