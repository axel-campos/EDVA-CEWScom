/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mdo.template;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.EtapaDAO;
import modelo.pojo.Etapa;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Axel
 */
public class ContenidoDidacticoTemplate implements MDOTemplate{
    
    private final String descripcion;

    public ContenidoDidacticoTemplate(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String generarPlantilla(List<String> html) {
        try {
            String ruta_template = ServletActionContext.getRequest().getServletContext().getRealPath("/") + "/templates/preview_template.html";
            File htmlTemplateFile = new File(ruta_template);
            
            String template_string = FileUtils.readFileToString(htmlTemplateFile).replace("$ruta","http://" + ServletActionContext.getRequest().getServerName() + ":" + ServletActionContext.getRequest().getServerPort() + ServletActionContext.getRequest().getServletContext().getContextPath());
            
            EtapaDAO dao = new EtapaDAO();
            
            Etapa etapa_1 = dao.buscar(new Etapa().setIdEtapa((short) 1));
            Etapa etapa_2 = dao.buscar(new Etapa().setIdEtapa((short) 2));
            Etapa etapa_3 = dao.buscar(new Etapa().setIdEtapa((short) 3));
            Etapa etapa_4 = dao.buscar(new Etapa().setIdEtapa((short) 4));
            Etapa etapa_5 = dao.buscar(new Etapa().setIdEtapa((short) 5));
            
            return String.format(template_string,etapa_1.getNombre(),etapa_1.getDescripcion(), html.get(0),html.get(1));
        } catch (IOException ex) {
            Logger.getLogger(VivenciaTemplate.class.getName()).log(Level.SEVERE, null, ex);
            return String.format("Error creating template.");
        }
    }
    
}
