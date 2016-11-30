package Actions.FileManagement;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import model.mdo.DropboxPersistence;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Axel
 */
public class DeleteFiles extends ActionSupport {

    private final String nombreArchivoRecursos = "resources.edva";
    private final DropboxPersistence DP = new DropboxPersistence();
    private List<String> listFilesToDelete;
    private List<Integer> types;
    private String message;
    private boolean status;

    private String path;

    @Override
    public String execute() throws Exception {
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        File localResourceDir = new File(appRoot + File.separator + path + File.separator + "Recursos");
        try {
            System.out.println(listFilesToDelete);
            int i = 0;
            for (String fileToDelete : listFilesToDelete) {
                if (types.get(i) == 1) {
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
                } else {
                    System.out.println("Recurso a borrar: " + path + "/" + fileToDelete);
                    File resourceFile = new File(localResourceDir, nombreArchivoRecursos);
                    List<String> resourceList = Files.readAllLines(resourceFile.toPath());
                    resourceList.remove(fileToDelete);
                    Files.write(resourceFile.toPath(), resourceList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "Ocurrio un error: " + e;
            status = false;
        }
        message = "Los recursos han sido eliminados.";
        status = true;
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

    public void setTypes(List<Integer> types) {
        this.types = types;
    }

    public void setListFilesToDelete(List<String> listFilesToDelete) {
        this.listFilesToDelete = listFilesToDelete;
    }
}
