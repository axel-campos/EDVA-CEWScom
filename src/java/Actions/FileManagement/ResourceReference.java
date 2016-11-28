package Actions.FileManagement;

import com.dropbox.core.DbxException;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.mdo.DropboxPersistence;
import org.apache.struts2.interceptor.ParameterAware;

/**
 *
 * @author Axel
 */
public class ResourceReference extends ActionSupport implements ParameterAware {

    private final DropboxPersistence DP = new DropboxPersistence();
    private final List<String> filesJSONforWorkspace = new ArrayList<>();
    private String path;

    @Override
    public String execute() {
        try {
            System.out.println("------ Lista de archivos en directorio: " + path + " -----");
            List<DropboxFile> ListDF = DP.listarArchivosDropbox(path);
            for (DropboxFile file : ListDF) {
                filesJSONforWorkspace.add(file.getName());
            }
            System.out.println("------------------------------------------------------------");
        } catch (DbxException | IOException | NumberFormatException e) {
            System.out.println("Ocurrió un error: " + e);
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public List<String> getFilesJSONforWorkspace() {
        return filesJSONforWorkspace;
    }
    //localhost:8084/EDVA/files/resourceFiles?path=ILs101116FW0/2

    @Override
    public void setParameters(Map<String, String[]> maps) {
        this.path = maps.get("path")[0];
    }
}
