package Actions.FileManagement;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.List;
import model.mdo.DropboxPersistence;
import org.apache.struts2.ServletActionContext;

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
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        File localResourceDir = new File(appRoot + File.separator + path + File.separator + "Recursos");
        try {
            System.out.println(listFilesToDelete);
            for (String fileToDelete : listFilesToDelete) {
                System.out.println("Archivo a borrar: " + path + "/" + fileToDelete);
                DP.eliminarArchivoDropbox(path, fileToDelete);

                File f = new File(localResourceDir, fileToDelete);
                if (f.exists() && !f.isDirectory()) {
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
            message = "Ocurrio un error: " + e;
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
