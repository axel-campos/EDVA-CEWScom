/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Axel
 */
public class ContenidoDidacticoTemplate implements MDOTemplate {

    private String titulo = "Sin título";
    private String tema = "Sin tema";
    private String descripcion = "Sin descripción";
    private String grupo_nombre = "Grupo anónimo";

    @Override
    public String generarPlantilla(List<String> html) {
        EtapaDAO dao = new EtapaDAO();
        try {
            String ruta_template = ServletActionContext.getRequest().getServletContext().getRealPath("/") + "/templates/contenido_didactico_template.html";
            File htmlTemplateFile = new File(ruta_template);

            String template_string = FileUtils.readFileToString(htmlTemplateFile).replace("$ruta", "http://" + ServletActionContext.getRequest().getServerName() + ":" + ServletActionContext.getRequest().getServerPort() + ServletActionContext.getRequest().getServletContext().getContextPath());
            dao.conectar();
            Etapa etapa_1 = dao.buscar(new Etapa().setIdEtapa((short) 1));
            Etapa etapa_2 = dao.buscar(new Etapa().setIdEtapa((short) 2));
            Etapa etapa_3 = dao.buscar(new Etapa().setIdEtapa((short) 3));
            Etapa etapa_4 = dao.buscar(new Etapa().setIdEtapa((short) 4));
            Etapa etapa_5 = dao.buscar(new Etapa().setIdEtapa((short) 5));
            dao.desconectar();

            return String.format(template_string, titulo, titulo, tema, descripcion,
                    etapa_1.getNombre(), etapa_1.getDescripcion(), html.get(0), html.get(1),
                    etapa_2.getNombre(), etapa_2.getDescripcion(), html.get(2), html.get(3),
                    etapa_3.getNombre(), etapa_3.getDescripcion(), html.get(4), html.get(5),
                    etapa_4.getNombre(), etapa_4.getDescripcion(), html.get(6), html.get(7),
                    etapa_5.getNombre(), etapa_5.getDescripcion(), html.get(8), html.get(9),
                    grupo_nombre);
            
        } catch (IOException ex) {
            Logger.getLogger(VivenciaTemplate.class.getName()).log(Level.SEVERE, null, ex);
            dao.desconectar();
            return String.format("Error creating template.");
        }
    }

    @Override
    public MDOTemplate setDetalles(Map<String, Object> detalles_plantilla) {
        this.titulo = detalles_plantilla.get("titulo").toString();
        this.tema = detalles_plantilla.get("tema").toString();
        this.descripcion = detalles_plantilla.get("descripcion").toString();
        this.grupo_nombre = detalles_plantilla.get("grupo_nombre").toString();
        return this;
    }

}
