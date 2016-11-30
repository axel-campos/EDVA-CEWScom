package Actions.FileManagement;

import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import model.mdo.DropboxPersistence;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Axel
 */
public class UploadResources extends ActionSupport {

    private final String nombreArchivoRecursos = "resources.edva";
    private final DropboxPersistence DP = new DropboxPersistence();
    private String resourceToUpload;
    private String message;
    private boolean status;

    private String path;

    @Override
    public String execute() {
        try {
            if (!resourceToUpload.isEmpty()) {
                System.out.print("\n\nReferencia a subir:" + resourceToUpload + " \n");
                int i = 0;
                String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
                File localResourceDir = new File(appRoot + File.separator + path + File.separator + "Recursos");

                if (!localResourceDir.exists()) {
                    System.out.println("Creating initial resource directory: " + localResourceDir.getPath());
                    localResourceDir.mkdirs();
                }

                File resourceFile = new File(localResourceDir, nombreArchivoRecursos);
                if (!resourceFile.exists()) {
                    resourceFile.createNewFile();
                }
                if (!Files.readAllLines(resourceFile.toPath()).contains(resourceToUpload)) {
                    try (BufferedWriter output = new BufferedWriter(new FileWriter(resourceFile, true))) {
                        output.append(resourceToUpload.trim());
                        output.newLine();
                    }
                    message = "Referencia a recurso subida correctamente.";
                    status = true;
                }
                else
                {
                    message = "El recurso ya se encuentra referenciado.";
                    status = false;
                }
            } else {
                message = "Ingrese un link, porfavor.";
                status = false;
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e);
            e.printStackTrace();
            message = "Ocurrió un error: " + e;
            status = false;
        }
        return SUCCESS;
    }

    public String getResourceToUpload() {
        return resourceToUpload;
    }

    public void setResourceToUpload(String resourceToUpload) {
        this.resourceToUpload = resourceToUpload;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

}
