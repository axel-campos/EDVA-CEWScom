package Actions.Contenido;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.mdo.DropboxPersistence;
import modelo.dao.ContenidoDAO;
import modelo.dao.ContenidoEtapaDAO;
import modelo.pojo.Contenido;
import modelo.pojo.ContenidoEtapa;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Víctor
 */
public class LiberarContenido extends ActionSupport {
    
    private String token;
    private String idContenido;
    private String etapa1;
    private String etapa2;
    private String etapa3;
    private String etapa4;
    private String etapa5;
    
    public LiberarContenido() {
    }
    
    public String execute() throws Exception {
        if(token == null || token.isEmpty()){
            addActionError("No se ha recibido el parámetro del token");
            return INPUT;
        }
        if(idContenido == null || idContenido.isEmpty()){
            addActionError("No se ha recibido el parámetro del contenido");
            return INPUT;
        }
        if(etapa1 == null || etapa1.isEmpty()){
            addActionError("No se ha recibido el parámetro de la version de la etapa 1");
            return INPUT;
        }
        if(etapa2 == null || etapa2.isEmpty()){
            addActionError("No se ha recibido el parámetro de la version de la etapa 2");
            return INPUT;
        }
        if(etapa3 == null || etapa3.isEmpty()){
            addActionError("No se ha recibido el parámetro de la version de la etapa 3");
            return INPUT;
        }
        if(etapa4 == null || etapa4.isEmpty()){
            addActionError("No se ha recibido el parámetro de la version de la etapa 4");
            return INPUT;
        }
        if(etapa5 == null || etapa5.isEmpty()){
            addActionError("No se ha recibido el parámetro de la version de la etapa 5");
            return INPUT;
        }
        List<String> versiones = new ArrayList<>();
        versiones.add(etapa1);
        versiones.add(etapa2);
        versiones.add(etapa3);
        versiones.add(etapa4);
        versiones.add(etapa5);
        int numIdContenido = Integer.parseInt(idContenido);
        
        ContenidoEtapaDAO contenidoEtapaDAO = new ContenidoEtapaDAO();
        ContenidoDAO contenidoDAO = new ContenidoDAO();
        try{
            contenidoEtapaDAO.conectar();
            short etapa = 1;
            for(String version: versiones){
                ContenidoEtapa contenidoEtapa = contenidoEtapaDAO.buscar(new ContenidoEtapa()
                                                                        .setIdContenido(numIdContenido)
                                                                        .setIdEtapa(etapa)
                                                                        .setVersion(Integer.parseInt(version)));
                contenidoEtapa.setLiberado(true);
                contenidoEtapaDAO.modificar(contenidoEtapa, contenidoEtapa);
                etapa++;
            }
            contenidoEtapaDAO.desconectar();
            new DropboxPersistence().guardarHTMLContenidoDidacticoLiberado(token, idContenido, versiones);
            
//            String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
//            FileUtils.deleteDirectory(new File(appRoot + token));
            
            contenidoDAO.conectar();
            Contenido contenido = contenidoDAO.buscar(new Contenido().setIdContenido(numIdContenido));
            contenido.setFinalizado(true);
            contenidoDAO.modificar(contenido, contenido);
            contenidoDAO.desconectar();
        }catch(Exception e){
            e.printStackTrace();
            contenidoEtapaDAO.desconectar();
            return ERROR;
        }
        return SUCCESS;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(String idContenido) {
        this.idContenido = idContenido;
    }

    public String getEtapa1() {
        return etapa1;
    }

    public void setEtapa1(String etapa1) {
        this.etapa1 = etapa1;
    }

    public String getEtapa2() {
        return etapa2;
    }

    public void setEtapa2(String etapa2) {
        this.etapa2 = etapa2;
    }

    public String getEtapa3() {
        return etapa3;
    }

    public void setEtapa3(String etapa3) {
        this.etapa3 = etapa3;
    }

    public String getEtapa4() {
        return etapa4;
    }

    public void setEtapa4(String etapa4) {
        this.etapa4 = etapa4;
    }

    public String getEtapa5() {
        return etapa5;
    }

    public void setEtapa5(String etapa5) {
        this.etapa5 = etapa5;
    }
 
}
