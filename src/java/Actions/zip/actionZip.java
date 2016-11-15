/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions.zip;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import zip.file.*;

/**
 *
 * @author Christian Campos
 */
public class actionZip extends ActionSupport {

    private String message;
    private boolean estatus;
    private InputStream zipInputStream;
    private String fileName;

    @Override
    public String execute() throws Exception {
        try {
            FileZipper.zip("C:\\Users\\Christian Campos\\Downloads\\Reporte1.docx", "C:\\Users\\Christian Campos\\Downloads\\Jamon.zip");
            message = "Listo, cara de pene.";
            estatus = true;
        } catch (Exception e) {
            message = "Ocurrió un error al guardar su contenido: " + e.getMessage();
            estatus = false;
        }
        zipInputStream = new FileInputStream(new File("C:\\Users\\Christian Campos\\Downloads\\Jamon.zip"));
        fileName = "Recursos_chingones";
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public InputStream getZipInputStream() {
        return zipInputStream;
    }

    public String getFileName() {
        return fileName;
    }
}
