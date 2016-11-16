package Actions.FileManagement;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import model.mdo.DropboxPersistence;

/**
 *
 * @author Axel
 */
public class DeleteFiles extends ActionSupport {

    private final DropboxPersistence DP = new DropboxPersistence();
    private List<String> listFilesToDelete;
    private String message;
    private boolean status;

    private String path;

    @Override
    public String execute() throws Exception {
        try {
            System.out.println(listFilesToDelete);
            for (String fileToDelete : listFilesToDelete) {
                System.out.println("Archivo a borrar: " + path + "/" + fileToDelete);
                DP.eliminarArchivoDropbox(path, fileToDelete);
                message = "Los archivos han sido eliminados.";
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "Ocurrió un error: " + e;
            status = false;
        }
        return SUCCESS;
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

    public void setListFilesToDelete(List<String> listFilesToDelete) {
        this.listFilesToDelete = listFilesToDelete;
    }
}
