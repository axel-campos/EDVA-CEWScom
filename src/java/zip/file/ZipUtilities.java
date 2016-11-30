/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zip.file;

import Actions.FileManagement.DropboxFile;
import java.io.File;
import java.util.List;
import model.mdo.DropboxPersistence;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Christian Campos
 */
public class ZipUtilities {

    public static void generarZipContenidoDidactico(String contenidoDidacticoString, String path, String nombreZip) throws Exception {

        String nombreArchivoRecursos = "resources.edva";
        System.out.println("Content to zip: " + nombreArchivoRecursos);
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");

        File contenidoDir = new File(appRoot + File.separator + path);
        File ZipDir = new File(contenidoDir, nombreZip);
        ZipDir.mkdirs();

        System.out.println("Directory of final Contenido Didactico: " + ZipDir.getPath());

        try {
            File ResourcesDir = new File(ZipDir, "Recursos");
            ResourcesDir.mkdirs();

            //Crear archivos del contenido
            DropboxPersistence DP = new DropboxPersistence();
            List<DropboxFile> files = DP.listarOnlyFilesDropbox(path);
            for (DropboxFile droppyFile : files) {
                if (!droppyFile.getName().equals("contenido_didactico_liberado.html")) {
                    DP.descargarArchivoGenerico(path, ResourcesDir, droppyFile.getName());
                }
            }

            //Escribimos el archivo HTML
            File contenidoDidacticoFile = new File(ZipDir, "contenido_didactico_liberado.html");
            FileUtils.writeStringToFile(contenidoDidacticoFile, contenidoDidacticoString, "UTF-8");

            //Referencias de CSS  
            /*<link rel="shortcut icon" href="$ruta/images/principal/CWEScom.ico">*/
            try {
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "images" + File.separator + "principal" + File.separator + "CWEScom.ico"),
                    new File(ResourcesDir, File.separator + "images" + File.separator + "principal"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*<link href="$ruta/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
            <link href="$ruta/css/font-awesome/font-awesome.min.css" rel="stylesheet" type="text/css"/>
            <link href="$ruta/css/gentella/custom_gentellela.css" rel="stylesheet" type="text/css"/>*/
            try {
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "css" + File.separator + "bootstrap.min.css"),
                    new File(ResourcesDir, File.separator + "css"));
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "css" + File.separator + "font-awesome" + File.separator + "font-awesome.min.css"),
                    new File(ResourcesDir, File.separator + "css" + File.separator + "font-awesome"));
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "css" + File.separator + "gentella" + File.separator + "custom_gentellela.css"),
                    new File(ResourcesDir, File.separator + "css" + File.separator + "gentella"));

                //Copy Font
                FileUtils.copyDirectoryToDirectory(
                    new File(appRoot, File.separator + "css"),
                    new File(ResourcesDir, File.separator + "css"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Referencias de JS
            /*<!-- jQuery -->
            <script src="$ruta/js/jquery/jquery-2.2.4.min.js" type="text/javascript"></script>
            <script src="$ruta/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
            <script src="$ruta/js/plantillas/fastclick.js" type="text/javascript"></script>
            <script src="$ruta/js/plantillas/jquery.smartWizard.js" type="text/javascript"></script>
            <script src="$ruta/js/collaboration/custom_gentellela.js" type="text/javascript"></script>*/
            try {
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "js" + File.separator + "jquery" + File.separator + "jquery-2.2.4.min.js"),
                    new File(ResourcesDir, File.separator + "js" + File.separator + "jquery"));
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "js" + File.separator + "bootstrap" + File.separator + "bootstrap.min.js"),
                    new File(ResourcesDir, File.separator + "js" + File.separator + "bootstrap"));
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "js" + File.separator + "plantillas" + File.separator + "fastclick.js"),
                    new File(ResourcesDir, File.separator + "js" + File.separator + "plantillas"));
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "js" + File.separator + "plantillas" + File.separator + "jquery.smartWizard.js"),
                    new File(ResourcesDir, File.separator + "js" + File.separator + "plantillas"));
                FileUtils.copyFileToDirectory(
                    new File(appRoot, File.separator + "js" + File.separator + "collaboration" + File.separator + "custom_gentellela.js"),
                    new File(ResourcesDir, File.separator + "js" + File.separator + "collaboration"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Creación del ZIP
            FileZipper.zip(ZipDir + File.separator, contenidoDir.getAbsolutePath() + File.separator + nombreZip + ".zip");
        } catch (Exception e) {
            e.printStackTrace();
        }

        FileUtils.deleteDirectory(ZipDir);
    }

}
