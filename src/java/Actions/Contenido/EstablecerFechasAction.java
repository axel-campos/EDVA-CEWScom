package Actions.Contenido;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import model.mdo.DropboxPersistence;
import model.mdo.FilePersistence;
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
    //Para saber si pueden crear o sólo editar.
    private String etapaActiva;
    //Para mostrar el resultado
    private String message;
    private String type;
    
    
    @Override
    public String execute() throws Exception {
        ContenidoEtapaDAO contEtapaDAO = new ContenidoEtapaDAO();        
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            contEtapaDAO.conectar();
            //DateFormat df = DateFormat.getDateInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d HH:mm");
            Date limite = formatter.parse(fecha);
            List<ContenidoEtapa> versiones = contEtapaDAO.buscarTodos().stream()
                    .filter(p -> p.getIdContenido() == Integer.parseInt(idContenido)).filter(p -> p.getTiempoModificacion().after(limite)).collect(Collectors.toList());
            
            
            //Si hay versiones después de la fecha límite, quiere decir que no podemos guardar dicha versión
            if(versiones.isEmpty()){//Vacía, entonces si podemos guardar
                String ruta = this.getRutaRecursos(contEtapaDAO);
                contEtapaDAO.registrar(new ContenidoEtapa()
					.setIdContenido(Integer.parseInt(idContenido))
					.setIdEtapa(Short.parseShort(etapa))
					.setLiberado(false)
					.setRutaRecursos(ruta)
					.setVersion(Integer.parseInt(version))
					.setTiempoModificacion(limite));
                out.print("Exito");
                contEtapaDAO.desconectar();
				
                FilePersistence persistence = new DropboxPersistence();
				persistence.crearCarpeta(ruta);
				persistence.crearJsonVacio(ruta);
            } else {
                out.print("Fecha");
                contEtapaDAO.desconectar();
            }
            
            
        }catch(RuntimeException e){
            contEtapaDAO.desconectar();
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    public String cargaEtapas() throws Exception{
        /*if(version.isEmpty()){
            version = "";
        }*/
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
            /*String txt = "<thead> <tr> <th style=\"width: 30%; text-align: center\">Versión</th><th style=\"width: 70%; text-align: center\">Tiempo Límite Creación</th>" +
            "</tr></thead><tbody>";*/
            String txt = "";
            Locale espanol = new Locale("es","ES");
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM yyyy, HH:mm:ss", espanol);
            for(ContenidoEtapa version1 : versiones){
                txt += "<div class='form-group version'><label class='col-md-4 control-label'><p align='center'>" + version1.getVersion() + "</p></label>"
                    + "<div class='col-md-8'><p align='center'>" + dateFormat.format(version1.getTiempoModificacion()) + "</p></div></div>";
            }
			
            /*txt += "</tbody>";*/
            out.println(txt);
        }catch(RuntimeException e){
            contEtapaDAO.desconectar();
        }        
        return SUCCESS;
    }
    
    public String cargaVersionParaEditar() throws Exception{
        ContenidoEtapaDAO contEtapaDAO = new ContenidoEtapaDAO();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            contEtapaDAO.conectar();
            List<ContenidoEtapa> versiones = contEtapaDAO.buscarTodos().stream()
                    .filter(p -> p.getIdContenido() == Integer.parseInt(idContenido)).filter(p -> p.getIdEtapa() == Integer.parseInt(etapa))
                    .filter(p -> p.getVersion() == Integer.parseInt(version)).collect(Collectors.toList());
            contEtapaDAO.desconectar();
            /*String txt = "<thead> <tr> <th style=\"width: 30%; text-align: center\">Versión</th><th style=\"width: 70%; text-align: center\">Tiempo Límite Creación</th>" +
            "</tr></thead><tbody>";*/
            String txt = "";
            Locale espanol = new Locale("es","ES");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            for(ContenidoEtapa version1 : versiones){
                String fechaEstablecida = dateFormat.format(version1.getTiempoModificacion());
                txt += "<div class='form-group version'><label class='col-md-4 control-label'><p align='center'>" + version1.getVersion() + "</p>"
                    + "<input type='hidden' value='" + version1.getVersion() + "' id='version' name='version'></label>"
                    + "<div class='col-md-2'></div><div class='col-md-4'><input type='text' id='fecha' name='fecha' class='form-control'/></div></div>";
                /*txt += "<tr>"
                + "<td style='text-align: center'>" + version1.getVersion() + "<input type='hidden' value='" + version1.getVersion() + "' id='version' name='version'></td>"
                + "<td style='padding-left: 26%'><div class='form-group row-fluid'><input type='text' placeholder='Ingresa fecha' id='fecha' name='fecha' class='form-control' "
                + "style='width: 60%' value='" + fechaEstablecida + "'></div></td>"
                + "</tr>";*/
            }
            out.println(txt);
        }catch(RuntimeException e){
            contEtapaDAO.desconectar();
        }        
        return SUCCESS;
    }
    
    public String editaVersion() throws Exception{
        //Consultamos la fecha anterior
        ContenidoEtapaDAO contenidoetapaDAO = new ContenidoEtapaDAO();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try(PrintWriter out = response.getWriter()){
            contenidoetapaDAO.conectar();
            ContenidoEtapa viejo = contenidoetapaDAO.buscar(new ContenidoEtapa().setIdContenido(Integer.parseInt(idContenido))
                    .setIdEtapa(Short.parseShort(etapa)).setVersion(Integer.parseInt(version)));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d HH:mm");
            Date limite = formatter.parse(fecha);
            if(viejo.getTiempoModificacion().before(limite)){//Sólo si la nueva fecha es mayor a la anterior
                //Entonces ya modificamos
                contenidoetapaDAO.modificar(viejo, new ContenidoEtapa().setIdContenido(Integer.parseInt(idContenido)).setIdEtapa(Short.parseShort(etapa))
                .setLiberado(viejo.getLiberado()).setRutaRecursos(viejo.getRutaRecursos()).setTiempoModificacion(limite).setVersion(viejo.getVersion()));
                out.print("Exito");
            }else{
                out.print("Fecha");
                contenidoetapaDAO.desconectar();
            }
        }catch(RuntimeException e){
            contenidoetapaDAO.desconectar();
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    public String terminarVersion() throws Exception{
        ContenidoEtapaDAO contenidoetapaDAO = new ContenidoEtapaDAO();
        try{
            contenidoetapaDAO.conectar();
            //Buscamos para editar
            ContenidoEtapa viejo = contenidoetapaDAO.buscar(new ContenidoEtapa().setIdContenido(Integer.parseInt(idContenido))
                    .setIdEtapa(Short.parseShort(etapa)).setVersion(Integer.parseInt(version)));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d HH:mm");
            Date hoy = new Date();
            //Date acaba = formatter.parse(hoy.toString());
            viejo.setTiempoModificacion(hoy);
            contenidoetapaDAO.modificar(viejo, viejo);
        }catch(RuntimeException e){
            contenidoetapaDAO.desconectar();
            return ERROR;
        }
        return SUCCESS;
    }
    
    private String getRutaRecursos(ContenidoEtapaDAO contEtapaDAO){
        String sql = "SELECT token FROM contenido WHERE idContenido = " + idContenido;
        String ruta = "/";
        try{
            List<Map<String, Object>> resultado = contEtapaDAO.consultaGenerica(sql);
            for(Map<String, Object>respuesta : resultado){
                //numeroEtapa = Integer.parseInt(respuesta.get("etapa").toString());
                ruta += respuesta.get("token").toString() + "/" + idContenido + "/"
                        + etapa + "/" + version;
            }
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        return ruta;
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

    public String getEtapaActiva() {
        return etapaActiva;
    }

    public void setEtapaActiva(String etapaActiva) {
        this.etapaActiva = etapaActiva;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
