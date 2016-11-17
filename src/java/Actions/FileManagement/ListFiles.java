package Actions.FileManagement;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.FileMetadata;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.mdo.DropboxPersistence;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.interceptor.ParameterAware;

/**
 *
 * @author Axel
 */
public class ListFiles extends ActionSupport implements ParameterAware {

    private final DropboxPersistence DP = new DropboxPersistence();
    private final List<FileListTable> filesJSONforTable = new ArrayList<>();
    private String path;

    @Override
    public String execute() {
        try {
            System.out.println("------ Lista de archivos en directorio: " + path + " -----");
            List<DropboxFile> ListDF = DP.listarArchivosDropbox(path);
            for (DropboxFile file : ListDF) {
                filesJSONforTable.add(file.toFileListTable());
            }
            System.out.println("------------------------------------------------------------");
        } catch (DbxException | IOException | NumberFormatException e) {
            System.out.println("Ocurrió un error: " + e);
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public List<FileListTable> getFilesJSONforTable() {
        return filesJSONforTable;
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
