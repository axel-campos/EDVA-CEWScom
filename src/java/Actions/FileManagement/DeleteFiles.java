package Actions.FileManagement;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.List;

/**
 *
 * @author Axel
 */
public class DeleteFiles extends ActionSupport {

    private List<String> listFilesToDelete;
    private String message;
    private boolean status;
    private final String path = "C:\\Users\\Axel\\Dropbox\\ArchivosPrueba";

    @Override
    public String execute() throws Exception {
        try {
            System.out.println(listFilesToDelete);
            for (String fileToDelete : listFilesToDelete) {
                File f = new File(path, fileToDelete);
                System.out.println("Archivo a borrar: " + f.getPath());
                if (f.exists() && !f.isDirectory()) {
                    //Borrar archivo en dropbox
                    //client.files().delete(filePath);
                    if (f.delete()) {
                        message = "Los archivos han sido eliminados.";
                        status = true;
                    } else {
                        message = "El archivo no pudo ser borrado.";
                        status = true;
                    }
                } else {
                    message = "El archivo " + fileToDelete + " no existe. Por favor, recarge la lista.";
                    status = false;
                }
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

    public boolean isStatus() {
        return status;
    }

    public void setListFilesToDelete(List<String> listFilesToDelete) {
        this.listFilesToDelete = listFilesToDelete;
    }
}
