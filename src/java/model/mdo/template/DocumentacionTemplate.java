package model.mdo.template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.mdo.artifacts.MDOArtifact;
import org.apache.commons.io.IOUtils;

/**
 * Generador de plantillas HTML para la etapa de Documentación.
 */
public class DocumentacionTemplate implements MDOTemplate {

    private final String realPath;

    public DocumentacionTemplate(String realPath) {
        this.realPath = realPath;
    }

    @Override
    public String generarStepHTML(int paso, MDOArtifact artifact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generarPlantilla(List<String> html) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
