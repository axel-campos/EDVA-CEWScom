/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions.FileManagement;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Axel
 */
public class ListFiles extends ActionSupport {

    private boolean status;
    private final List<FileDropbox> filesJson = new ArrayList<>();
    private final String path = "C:\\Users\\Axel\\Dropbox\\ArchivosPrueba";
    //private final String path = "C:\\Users\\Christian Campos\\Dropbox\\ArchivosPrueba";
    
    @Override
    public String execute() {
        try {
            System.out.println("------ Lista de archivos en directorio: " + path + " -----");
            for (File file : new File(path).listFiles()) {
                if (file.isFile()) {
                    filesJson.add(new FileDropbox(
                        FilenameUtils.getBaseName(file.getName()),
                        readableFileSize(file.length()),
                        Files.probeContentType(file.toPath()) + " (." + FilenameUtils.getExtension(file.getName()) + ")")
                    );
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
            status = true;
            System.out.println("------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e);
            e.printStackTrace();
            status = false;
        }
        return SUCCESS;
    }

    public boolean isStatus() {
        return status;
    }

    public List<FileDropbox> getFilesJson() {
        return filesJson;
    }

    private String getFileTypeString(File file) throws IOException {
        String MIMEType = Files.probeContentType(file.toPath());
        return "QuienSabe";
    }

    private static String readableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

}
