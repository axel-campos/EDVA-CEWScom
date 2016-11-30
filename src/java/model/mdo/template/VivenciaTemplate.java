package model.mdo.template;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.mdo.artifacts.MDOArtifact;
import model.mdo.artifacts.vivencias.*;
import modelo.dao.EtapaDAO;
import modelo.pojo.Etapa;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * Generador de plantillas HTML para la etapa de Vivencia.
 */
public class VivenciaTemplate implements MDOTemplate {

    private String titulo;
    private String version;

    @Override
    public String generarPlantilla(List<String> html, String resourceReference) {
        EtapaDAO conexionDAO = new EtapaDAO();
        try {
            String ruta_template = ServletActionContext.getRequest().getServletContext().getRealPath("/") + "/templates/preview_template.html";
            File htmlTemplateFile = new File(ruta_template);

            String template_string = FileUtils.readFileToString(htmlTemplateFile)
                .replace("$ruta", resourceReference);

            conexionDAO.conectar();
            Etapa etapa = conexionDAO.buscar(new Etapa().setIdEtapa((short) 1));
            conexionDAO.desconectar();
            return String.format(template_string, titulo, titulo, version, etapa.getNombre(), etapa.getDescripcion(), html.get(0), html.get(1));

        } catch (IOException ex) {
            conexionDAO.desconectar();
            Logger.getLogger(VivenciaTemplate.class.getName()).log(Level.SEVERE, null, ex);
            return String.format("Error creating template.");
        }

    }

    @Override
    public MDOTemplate setDetalles(Map<String, Object> detalles_plantilla) {
        this.titulo = detalles_plantilla.get("titulo").toString();
        this.version = detalles_plantilla.get("version").toString();
        return this;
    }
}
