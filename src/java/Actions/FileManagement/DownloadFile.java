/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions.FileManagement;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import model.mdo.DropboxPersistence;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Christian Campos
 */
public class DownloadFile extends ActionSupport {

    private final String serverContext = 
        "http://" + ServletActionContext.getRequest().getServerName()
                    + ":" + ServletActionContext.getRequest().getServerPort()
                    + ServletActionContext.getRequest().getServletContext().getContextPath();
    private String message;
    private boolean status;
    private String path;
    private String fileName;
    private String filePreview;
    private final DropboxPersistence DP = new DropboxPersistence();

    @Override
    public String execute() throws Exception {
        System.out.println("File to preview: " + path);
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        File tempDir = new File(appRoot + File.separator + path);
        System.out.println("Creating reference to temp file dir: " + tempDir.getPath());

        try {
            if (tempDir.exists()) {
                File tempFile = DP.descargarArchivoGenericoTemporal(path, fileName);
                filePreview = serverContext + path + File.separator + tempFile.getName();
                tempFile.deleteOnExit();
            } else {
                message = "No se pudo descagar el archivo";
                status = false;
            }
        } catch (Exception e) {
            message = "Ocurrio un error: " + e.getMessage();
            e.printStackTrace();
            status = false;
        }
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public boolean getEstatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

    public String getFilePreview() {
        return filePreview;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
