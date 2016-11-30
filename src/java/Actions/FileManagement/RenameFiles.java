package Actions.FileManagement;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import java.util.List;
import model.mdo.DropboxPersistence;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Axel
 */
public class RenameFiles extends ActionSupport {

    private final String nombreArchivoRecursos = "resources.edva";
    private final DropboxPersistence DP = new DropboxPersistence();
    private String fileToRename;
    private String newName;
    private String message;
    private boolean status;
    private int type;

    private String path;

    @Override
    public String execute() throws Exception {
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        File localResourceDir = new File(appRoot + File.separator + path + File.separator + "Recursos");
        if (type == 1) {
            try {
                System.out.println("Renaming file " + fileToRename + " to " + newName);
                DP.editarNombreArchivoDropbox(fileToRename, newName, path);
                File f = new File(localResourceDir, fileToRename);
                if (f.exists() && !f.isDirectory()) {
                    if (f.renameTo(new File(localResourceDir, newName))) {
                        message = "El archivo <strong>" + fileToRename + "</strong> ha sido renombrado a <strong>" + newName + "</strong>.";
                        status = true;
                    } else {
                        message = "La edición del archivo ha fallado debido a permisos.";
                        status = false;
                    }
                } else {
                    message = "El archivo " + fileToRename + " no existe. Por favor, recarge la lista.";
                    status = false;
                }

            } catch (Exception e) {
                e.printStackTrace();
                message = "Ocurrió un error: " + e;
                status = false;
            }
        } else {
            File resourceFile = new File(localResourceDir, nombreArchivoRecursos);
            try {
                System.out.println("Renaming resource: " + fileToRename + " to " + newName);
                List<String> resourceList = Files.readAllLines(resourceFile.toPath());
                resourceList.set(resourceList.indexOf(fileToRename.trim()),newName.trim());
                Files.write(resourceFile.toPath(), resourceList);
                message = "La referencia <strong>" + fileToRename + "</strong> ha sido renombrado a <strong>" + newName + "</strong>.";
                status = true;
            } catch (Exception e) {
                e.printStackTrace();
                message = "Ocurrió un error: " + e;
                status = false;
            }

        }
        return SUCCESS;
    }

    public void setFileToRename(String fileToRename) {
        this.fileToRename = fileToRename;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getMessage() {
        return message;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isStatus() {
        return status;
    }

}
