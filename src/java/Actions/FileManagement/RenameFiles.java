package Actions.FileManagement;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import model.mdo.DropboxPersistence;

/**
 *
 * @author Axel
 */
public class RenameFiles extends ActionSupport {

    private final DropboxPersistence DP = new DropboxPersistence();
    private String fileToRename;
    private String newName;
    private String message;
    private boolean status;

    private String path;

    @Override
    public String execute() throws Exception {
        try {
            System.out.println("Renaming file " + fileToRename + " to " + newName);
            DP.editarNombreArchivoDropbox(fileToRename, newName, path);
            message = "El archivo <strong>" + fileToRename + "</strong> ha sido renombrado a <strong>" + newName + "</strong>.";
            status = true;
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

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isStatus() {
        return status;
    }

}
