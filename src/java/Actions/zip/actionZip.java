/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions.zip;

import Actions.FileManagement.DropboxFile;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
public class actionZip extends ActionSupport implements ParameterAware {

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
        File tempDir = new File(appRoot + File.separator + path);
        OutputZipFileName = path.split("/")[1] + "_" + path.split("/")[2];
        System.out.println("Writing on temp directory: " + tempDir.getPath());

        System.out.println("Is directory?: " + tempDir.isDirectory());
        System.out.println("Can write?: " + tempDir.canWrite());
        System.out.println("Can read?: " + tempDir.canRead());
        System.out.println("Writing on temp directory: " + tempDir.getPath());
        try {
            if (tempDir.mkdirs()) {
                files = DP.listarArchivosDropbox(path);

                for (DropboxFile droppyFile : files) {
                    DP.descargarArchivoGenerico(path, droppyFile.getName());
                }
                
                message = "Listo, cara de pene.";
                status = true;
                FileZipper.zip(tempDir + File.separator, appRoot + File.separator + OutputZipFileName + ".zip");
                zipInputStream = new FileInputStream(appRoot + File.separator + OutputZipFileName + ".zip");
                
            } else {
                message = "No se pudo descagar el archivo";
                status = false;
            }
        } catch (Exception e) {
            message = "Ocurrio un error: " + e.getMessage();
            e.printStackTrace();
            status = false;
        }
        FileUtils.deleteDirectory(new File(appRoot + File.separator + path.split("/")[1]));
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
