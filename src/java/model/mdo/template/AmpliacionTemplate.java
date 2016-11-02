package model.mdo.template;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.EtapaDAO;
import modelo.pojo.Etapa;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * Generador de plantillas HTML para la etapa de Ampliación.
 */
public class AmpliacionTemplate implements MDOTemplate {

    private final String titulo;
    private final String version;

    public AmpliacionTemplate(String titulo, String version) {
        this.titulo = titulo;
        this.version = version;
    }
    
    public AmpliacionTemplate(Map<String,Object> detalles_contenido) {
        this.titulo = detalles_contenido.get("titulo").toString();
        this.version = detalles_contenido.get("version").toString();
    }
    
    @Override
    public String generarPlantilla(List<String> html) {
        try {
            String ruta_template = ServletActionContext.getRequest().getServletContext().getRealPath("/") + "/templates/preview_template.html";
            File htmlTemplateFile = new File(ruta_template);
            
            String template_string = FileUtils.readFileToString(htmlTemplateFile).replace("$ruta","http://" + ServletActionContext.getRequest().getServerName() + ":" + ServletActionContext.getRequest().getServerPort() + ServletActionContext.getRequest().getServletContext().getContextPath());
            
            Etapa etapa = new EtapaDAO().buscar(new Etapa().setIdEtapa((short) 4));
            return String.format(template_string,titulo, titulo, version,etapa.getNombre(),etapa.getDescripcion(), html.get(0),html.get(1));
        } catch (IOException ex) {
            Logger.getLogger(VivenciaTemplate.class.getName()).log(Level.SEVERE, null, ex);
            return String.format("Error creating template.");
        }

    }

    
}