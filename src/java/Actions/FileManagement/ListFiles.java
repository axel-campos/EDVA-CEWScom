package Actions.FileManagement;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.mdo.DropboxPersistence;
import org.apache.struts2.interceptor.ParameterAware;

/**
 *
 * @author Axel
 */
public class ListFiles extends ActionSupport implements ParameterAware {

    private final DropboxPersistence DP = new DropboxPersistence();
    private List<FileDropbox> filesJson = new ArrayList<>();
    private String path;

    @Override
    public String execute() {
        try {
            System.out.println("------ Lista de archivos en directorio: " + path + " -----");
            filesJson = DP.listarArchivosDropbox(path);
            System.out.println("------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e);
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public List<FileDropbox> getFilesJson() {
        return filesJson;
    }

    private String getFileTypeString(File file) throws IOException {
        String MIMEType = Files.probeContentType(file.toPath());
        return "QuienSabe";
    }
    
    @Override
    public void setParameters(Map<String, String[]> maps) {
        this.path = maps.get("path")[0];
    }
}
