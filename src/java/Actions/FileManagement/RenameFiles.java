package Actions.FileManagement;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;

/**
 *
 * @author Axel
 */
public class RenameFiles extends ActionSupport {

    private String fileToRename;
    private String newName;
    private String message;
    private boolean status;

    private final String path = "C:\\Users\\Axel\\Dropbox\\ArchivosPrueba";

    @Override
    public String execute() throws Exception {
        try {
            System.out.println("Renaming file " + fileToRename + " to " + newName);
            File f = new File(path, fileToRename);
            if (f.exists() && !f.isDirectory()) {
                if (f.renameTo(new File(path, newName))) {
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

    public boolean isStatus() {
        return status;
    }

}
