package Actions.FileManagement;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Axel
 */
public class UploadFiles extends ActionSupport {

    private List<File> files;
    private List<String> filesContentType;
    private List<String> filesFileName;
    private String message;
    private boolean status;
    //private final String path = "C:\\Users\\Axel\\Dropbox\\ArchivosPrueba";
    private final String path = "C:\\Users\\Christian Campos\\Dropbox\\ArchivosPrueba";

    @Override
    public String execute(){
        try {
            System.out.print("\n\n--------Archivos a subir---------------\n");
            int i = 0;
            System.out.print("Archivos subidos " + files.size());
            for (File file : files) {
                System.out.print("\nFile [" + i + "] ");
                System.out.print("; name:" + filesFileName.get(i));
                System.out.print("; contentType: " + filesContentType.get(i));
                System.out.print("; length: " + file.length());

                File destFile = new File(path, filesFileName.get(i));
                FileUtils.copyFile(files.get(i), destFile);
                i++;
            }
            System.out.println("\n---------------------------------------\n");
            message = "Se subio el archivo correctamente";
            status = true;

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e);
            e.printStackTrace();
            message = "Ocurrió un error: " + e;
            status = false;
        }
        return SUCCESS;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<String> getFilesContentType() {
        return filesContentType;
    }

    public void setFilesContentType(List<String> filesContentType) {
        this.filesContentType = filesContentType;
    }

    public List<String> getFilesFileName() {
        return filesFileName;
    }

    public void setFilesFileName(List<String> filesFileName) {
        this.filesFileName = filesFileName;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

}
