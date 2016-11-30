/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zip.file;

import Actions.FileManagement.DropboxFile;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.mdo.DropboxPersistence;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import zip.file.*;

/**
 *
 * @author Christian Campos
 */
public class actionZipRecursos extends ActionSupport implements ParameterAware {

    private String message;
    private boolean status;
    private final DropboxPersistence DP = new DropboxPersistence();
    private List<DropboxFile> files = new ArrayList<>();

    private String path;
    private InputStream zipInputStream;
    private String OutputZipFileName;

    @Override
    public String execute() throws Exception {
        System.out.println("Path to download: " + path);
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");

        File appDir = new File(appRoot + File.separator + path);
        File temporaryDir = Files.createTempDirectory(appDir.toPath(), "temp").toFile();

        OutputZipFileName = path.split("/")[1] + "_" + path.split("/")[2];
        System.out.println("Writing on temp directory: " + temporaryDir.getPath());

        try {
            files = DP.listarArchivosDropbox(path);

            for (DropboxFile droppyFile : files) {
                DP.descargarArchivoGenerico(path, temporaryDir, droppyFile.getName());
            }

            File zipFile = File.createTempFile("files", ".zip", appDir);
            FileZipper.zip(temporaryDir + File.separator, zipFile.getAbsolutePath());
            zipInputStream = new FileInputStream(zipFile);

            message = "Listo, mijo.";
            status = true;
            zipFile.deleteOnExit();
        } catch (Exception e) {
            message = "Ocurrio un error: " + e.getMessage();
            e.printStackTrace();
            status = false;
        }
        FileUtils.deleteDirectory(temporaryDir);
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public boolean getEstatus() {
        return status;
    }

    public InputStream getZipInputStream() {
        return zipInputStream;
    }

    public String getOutputZipFileName() {
        return OutputZipFileName;
    }

    @Override
    public void setParameters(Map<String, String[]> maps) {
        this.path = maps.get("path")[0];
    }
}
