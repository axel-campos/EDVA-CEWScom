package Actions.FileManagement;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.UploadErrorException;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.util.List;
import model.mdo.DropboxPersistence;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Axel
 */
public class UploadResources extends ActionSupport {
    private final String nombreArchivoRecursos = "resources.edva";
    private final DropboxPersistence DP = new DropboxPersistence();
    private String resourceToUpload;
    private String message;
    private boolean status;

    private String path;

    @Override
    public String execute() {
        try {
            System.out.print("\n\n--------Archivos a subir---------------\n");
            int i = 0;
            String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
            File localResourceDir = new File(appRoot + File.separator + path + File.separator + "Recursos");

            if(!localResourceDir.exists())
            {
                System.out.println("Creating initial resource directory: " + localResourceDir.getPath());
                localResourceDir.mkdirs();
            }
            
            File resourceFile = new File(localResourceDir, nombreArchivoRecursos );
            if (resourceFile.exists())
            {
                
            }

//            System.out.print("Archivos subidos " + files.size());
//            for (File file : files) {
//                System.out.print("\nFile [" + i + "] ");
//                System.out.print("; name:" + filesFileName.get(i));
//                System.out.print("; contentType: " + filesContentType.get(i));
//                System.out.print("; length: " + file.length());
//
//                DP.subirArchivoDropbox(file, path, filesFileName.get(i));
//                File destFile = new File(localResourceDir, filesFileName.get(i));
//                FileUtils.copyFile(files.get(i), destFile);
//                i++;
//            }
//            System.out.println("\n---------------------------------------\n");
//            message = "Se subieron los archivos correctamente";
//            status = true;
//
//        } catch (UploadErrorException ex) {
//            message = "Error uploading to Dropbox" + ex;
//            status = false;
//        } catch (DbxException ex) {
//            message = "Error subiendo al Dropbox: " + ex;
//            status = false;
//        } catch (IOException ex) {
//            message = "Error leyendo el archivo: " + ex;
//            status = false;
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e);
            e.printStackTrace();
            message = "Ocurrió un error: " + e;
            status = false;
        }
        return SUCCESS;
    }


    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

}
