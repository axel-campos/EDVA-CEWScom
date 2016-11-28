package model.mdo;

import Actions.FileManagement.DropboxFile;
import org.apache.struts2.ServletActionContext;
import org.apache.commons.io.FileUtils;
import com.dropbox.core.*;
import com.dropbox.core.v2.*;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.files.WriteMode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.mdo.artifacts.MDOArtifact;
import model.mdo.parsers.MDOParser;
import model.mdo.template.ContenidoDidacticoTemplate;
import model.mdo.template.MDOTemplate;
import model.mdo.template.MDOTemplateUtil;
import modelo.dao.ContenidoDAO;
import modelo.dao.GrupoDAO;
import modelo.pojo.Contenido;
import modelo.pojo.Grupo;
import org.apache.commons.io.FilenameUtils;

/**
 * Permite almacenar y descargar archivos desde Dropbox por medio de su API
 * 2.1.1.
 */
public final class DropboxPersistence implements FilePersistence {

    //private final String ACCESS_TOKEN = "_vjkq--5dsAAAAAAAAAAI1AIN17ztTSAF_7kZ_IAeOO11tmOe-L5YJMEWpXp_h7M";
    private final String ACCESS_TOKEN = "_vjkq--5dsAAAAAAAAAANaKwM5NYC9M2wAjk0cFSzKVhGI_Jxi7KNvQucdAvHvQU";
    private final DbxRequestConfig config;
    private final DbxClientV2 client;
    private final Gson gson = new Gson();
    private final String realPath;

    /**
     *
     * @param realPath La ruta hacia la carpeta de plantillas MDO.
     */
    public DropboxPersistence(String realPath) {
        this.realPath = realPath;
        config = new DbxRequestConfig("edva/cwescom");
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    public DropboxPersistence() {
        realPath = "";
        config = new DbxRequestConfig("edva/cwescom");
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    @Override
    public Map<String, Object> descargar(Map<String, Object> detallesContenido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearCarpeta(String nombre) {
        try {
            client.files().createFolder(nombre);
        } catch (DbxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void crearJsonVacio(String ruta) {
        try {
            String json = "{\"artefactos\":[]}";
            subirArchivoTexto(ruta, "artefactos.json", json);
        } catch (IOException | DbxException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void guardarJson(String json) {
        try {
            Map<String, Object> map = obtenerMapaDeJson(json);
            String ruta = (String) map.get("ruta");
            List<Map<String, Object>> artefactos = (List<Map<String, Object>>) map.get("lista");
            String nuevoJson = String.format("{\"artefactos\":%s}", gson.toJson(artefactos));
            subirArchivoTexto(ruta, "artefactos.json", nuevoJson);
        } catch (DbxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String descargarJson(String ruta) {
        try {
            String json = descargarArchivoTexto(ruta, "artefactos.json");
            return json;
        } catch (IOException | DbxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sube la página del contenido creado a su carpeta específica en Dropbox.
     *
     * @param ruta La ruta de la carpeta donde se guardará la página.
     * @param pagina Cadena con todo el HTML que se guardará.
     * @param token El token del grupo.
     * @param contenido El nombre del contenido didáctico.
     * @param etapa El nombre de la etapa MDO a guardar.
     * @throws IOException Si ocurre un error al leer la página HTML.
     * @throws DbxException Si ocurre un error al subir el archivo a Dropbox.
     */
    private void subir(String ruta, String pagina, String token, String contenido, String etapa) throws IOException, DbxException {
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        String tempFile = String.format("%s%s/%s/%s.html", appRoot, token, contenido, etapa);
        File temp = new File(tempFile);

        FileUtils.writeStringToFile(temp, pagina, "UTF-8");
        try (FileInputStream fis = new FileInputStream(temp)) {
            client
                    .files()
                    .uploadBuilder(ruta + "/" + etapa + ".html")
                    .uploadAndFinish(fis);
        }
        FileUtils.deleteDirectory(new File(appRoot + token));
    }

    /**
     * Sube el archivo de texto indicado a la carpeta de Dropbox indicada.
     *
     * @param ruta La ruta a la cual se subirá el archivo.
     * @param nombre El nombre del archivo con su extensión.
     * @param contenido El contenido del archivo.
     * @throws IOException Si ocurre un error al leer el archivo de texto.
     * @throws DbxException Si ocurre un error al subir el archivo a Dropbox.
     */
    private void subirArchivoTexto(String ruta, String nombre, String contenido) throws IOException, DbxException {
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        String token = ruta.split("/")[1];
        String tempFile = appRoot + ruta + "/" + nombre;
        File temp = new File(tempFile);
        FileUtils.writeStringToFile(temp, contenido);
        try (FileInputStream fis = new FileInputStream(temp)) {
            client
                    .files()
                    .uploadBuilder(ruta + "/" + nombre)
                    .withMode(WriteMode.OVERWRITE)
                    .uploadAndFinish(fis);
        }
        FileUtils.deleteDirectory(new File(appRoot + token));
    }

    private void subirArchivoHTML(String ruta, String nombre, String contenido) throws IOException, DbxException {
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        String token = ruta.split("/")[1];
        String tempFile = appRoot + ruta + "/" + nombre;
        File temp = new File(tempFile);
        FileUtils.writeStringToFile(temp, contenido, "UTF-8");
        try (FileInputStream fis = new FileInputStream(temp)) {
            client
                    .files()
                    .uploadBuilder(ruta + "/" + nombre)
                    .withMode(WriteMode.OVERWRITE)
                    .uploadAndFinish(fis);
        }
        FileUtils.deleteDirectory(new File(appRoot + token));
    }

    private String descargarArchivoTexto(String ruta, String nombre) throws IOException, DbxException {
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        String token = ruta.split("/")[1];
        String tempFile = appRoot + ruta + "/" + nombre;
        File temp = new File(tempFile);
        FileUtils.writeStringToFile(temp, "");

        try (FileOutputStream fos = new FileOutputStream(temp)) {
            client.files().download(ruta + "/" + nombre).download(fos);
        }

        String file = FileUtils.readFileToString(temp);
        FileUtils.deleteDirectory(new File(appRoot + token));
        return file;
    }

    public File descargarArchivoHTML(String ruta, String nombre) throws IOException, DbxException {
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        File temp = new File(appRoot + ruta + "/" + nombre);
        if (!temp.exists()) {
            FileUtils.writeStringToFile(temp, "");
            try (FileOutputStream fos = new FileOutputStream(temp)) {
                client.files().download(ruta + "/" + nombre).download(fos);
            }
        }
        return temp;
    }

    /**
     * Regresa un mapa con el contenido del JSON dado.
     *
     * @param json Cadena de texto con los artefactos obtenidos desde el
     * cliente.
     * @return Un mapa con los artefactos del JSON.
     */
    private Map<String, Object> obtenerMapaDeJson(String json) {
        return ((Map<String, Map<String, Object>>) gson
                .fromJson(json, new TypeToken<Map<String, Object>>() {
                }.getType())).get("artefactos");
    }

    private List<Map<String, Object>> obtenerArtefactosDeJson(String json) {
        return ((Map<String, List<Map<String, Object>>>) gson
                .fromJson(json, new TypeToken<Map<String, Object>>() {
                }.getType())).get("artefactos");
    }

    @Override
    public void borrarCarpeta(String ruta) {
        try {
            client.files().delete(ruta);
        } catch (DbxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardarHTMLpreliminar(Map<String, Object> detalles_contenido, String artefactosJSON) {
        try {
            MDOTemplate template = MDOTemplateUtil.getTemplate(artefactosJSON);
            Map<String, Object> map = obtenerMapaDeJson(artefactosJSON);
            MDOParser parser = MDOUtil.getParser(artefactosJSON);
            List<Map<String, Object>> artefactosMap = (List<Map<String, Object>>) map.get("lista");

            subirArchivoHTML((String) map.get("ruta"), "preview.html", template.setDetalles(detalles_contenido)
                    .generarPlantilla(generarHTMLString(artefactosMap, parser, template)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Regresa un mapa con el contenido del JSON dado.
     *
     * @param token Token del del grupo al cual pertence el contenido
     * @param idContenido Contenido didactico de que se va a guardar
     * @param versiones_escogidas Una lista con las 5 versiones que se
     * escogieron para cada etapa.
     */
    public void guardarHTMLContenidoDidacticoLiberado(String token, String idContenido, List<String> versiones_escogidas) {
        GrupoDAO grupoDAO = new GrupoDAO();
        ContenidoDAO contenidoDAO = new ContenidoDAO();
        try {
            grupoDAO.conectar();
            Grupo grupo = grupoDAO.buscar(new Grupo().setToken(token));
            contenidoDAO.conectar();
            Contenido contenido = contenidoDAO.buscarContenidoConToken(new Contenido().setToken(token).setIdContenido(Integer.parseInt(idContenido)));
            List<String> HTMLbodies = new ArrayList<>();
            Map<String, Object> detalles_contenido = new HashMap<>();
            detalles_contenido.put("titulo", contenido.getTitulo());
            detalles_contenido.put("grupo_nombre", grupo.getNombre());
            detalles_contenido.put("tema", contenido.getTema());
            detalles_contenido.put("descripcion", contenido.getDescripcion());
            detalles_contenido.put("rutaDescarga", "/" + token + "/" + idContenido);

            grupoDAO.desconectar();
            contenidoDAO.desconectar();

            for (int i = 0; i < 5; i++) {
                String ruta = String.format("/%s/%s/%s/%s", token, idContenido, i + 1, versiones_escogidas.get(i));
                String artefactosJSON = descargarArchivoTexto(ruta, "artefactos.json");
                MDOTemplate template = MDOTemplateUtil.getTemplate(artefactosJSON);
                List<Map<String, Object>> artefactosMap = obtenerArtefactosDeJson(artefactosJSON);
                MDOParser parser = MDOUtil.getParser(artefactosJSON);

                HTMLbodies.addAll(generarHTMLString(artefactosMap, parser, template));
            }

            subirArchivoHTML("/" + token + "/" + idContenido, "contenido_didactico_liberado.html",
                    new ContenidoDidacticoTemplate().setDetalles(detalles_contenido).generarPlantilla(HTMLbodies));
        } catch (Exception e) {
            grupoDAO.desconectar();
            contenidoDAO.desconectar();
            throw new RuntimeException(e);
        }
    }

    private List<String> generarHTMLString(List<Map<String, Object>> artefactosMap, MDOParser parser, MDOTemplate template) {
        int num_paso = 1;
        StringBuilder orderHTMLcode = new StringBuilder();
        StringBuilder definitionHTMLcode = new StringBuilder();
        for (Map<String, Object> artefacto : artefactosMap) {
            MDOArtifact artifact = parser.parse(artefacto);
            orderHTMLcode.append(MDOTemplateUtil.generarStepHTML(num_paso, template, artifact));
            definitionHTMLcode.append(artifact.setPaso(num_paso).toHtml());
            num_paso = num_paso + 1;
        }

        return Arrays.<String>asList(orderHTMLcode.toString(), definitionHTMLcode.toString());
    }

    /*File Management Methods*/
    /**
     * Agrega un archivo a dropbox
     *
     * @param localFile Clase File del archivo a subir
     * @param dropboxPath Ruta del drobox donde se quiere guardar
     * @param name
     * @throws java.io.IOException
     * @throws com.dropbox.core.DbxException
     */
    public void subirArchivoDropbox(File localFile, String dropboxPath, String name) throws IOException, DbxException {
        try (FileInputStream fis = new FileInputStream(localFile)) {
            client
                    .files()
                    .uploadBuilder(dropboxPath + "/" + name)
                    .withMode(WriteMode.OVERWRITE)
                    .uploadAndFinish(fis);
        }
    }

    /**
     * Edita el archivo en dropbox
     *
     * @param oldName Nombre del archivo
     * @param newName Nombre nuevo
     * @param path ruta del archivo
     * @throws java.io.IOException
     * @throws com.dropbox.core.DbxException
     */
    public void editarNombreArchivoDropbox(String oldName, String newName, String path) throws IOException, DbxException {
        client.files().move(path + "/" + oldName, path + "/" + newName);
//        try (FileInputStream fis = new FileInputStream(archivoAsubir)) {
//            client
//                .files()
//                .uploadBuilder(path + "/" + archivoAsubir.getName())
//                .withAutorename(Boolean.TRUE)
//                .withMode(WriteMode.OVERWRITE)
//                .uploadAndFinish(fis);
//        }
    }

    /**
     * Elimina un archivo de dropbox
     *
     * @param fileToDelete Nombre del archivo a borrar
     * @param path Ruta del archivo en dropbox
     * @throws java.io.IOException
     * @throws com.dropbox.core.DbxException
     */
    public void eliminarArchivoDropbox(String path, String fileToDelete) throws IOException, DbxException {
        client.files().delete(path + "/" + fileToDelete);
    }

    public List<DropboxFile> listarArchivosDropbox(String path) throws DbxException, IOException {
        List<DropboxFile> files = new ArrayList<>();
        //Agregando los recursos a la lista
        String nombreArchivoRecursos = "resources.edva";
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        File localResourceDir = new File(appRoot + File.separator + path + File.separator + "Recursos");
        File resourceFile = new File(localResourceDir, nombreArchivoRecursos);
        
        List<String> listaRecursos = new ArrayList<>();
        if (resourceFile.exists()) {
            listaRecursos = Files.readAllLines(Paths.get(resourceFile.getParent(), resourceFile.getName()));
            for(String nombreRecurso: listaRecursos)
            {
                System.out.println("Referencia encontrada: " + nombreRecurso);
                files.add(new DropboxFile(nombreRecurso,0,"Referencia", "Referencia"));
            }
        }
        
        System.out.println("Requesting data to dropbox...");
        ListFolderResult result = client.files().listFolderBuilder(path)
                .withIncludeDeleted(false)
                .withRecursive(false)
                .withIncludeMediaInfo(false)
                .start();
        
        for (Metadata metadata : result.getEntries()) {
            if (metadata instanceof FileMetadata) {
                System.out.println(metadata.getPathDisplay());
                File file = new File(metadata.getPathDisplay());
                files.add(new DropboxFile(
                        file.getName(),
                        ((FileMetadata) metadata).getSize(),
                        FilenameUtils.getExtension(file.getName()),
                        Files.probeContentType(file.toPath())
                ));
            }
        }
        return files;
    }

    /**
     * Lista los archivos de los recursos y nombres de el contenido.
     *
     * @param path Ruta del archivo en dropbox
     * @return Lista de cadenas con los nombres de los archivos
     * @throws java.io.IOException
     * @throws com.dropbox.core.DbxException
     */
    public List<String> listarNombresArchivosRecursosDropbox(String path) throws DbxException, IOException {
        //Agregando los recursos a la lista
        String nombreArchivoRecursos = "resources.edva";
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        File localResourceDir = new File(appRoot + File.separator + path + File.separator + "Recursos");
        File resourceFile = new File(localResourceDir, nombreArchivoRecursos);
        List<String> listaRecursosArchivos = new ArrayList<>();
        if (!resourceFile.exists()) {
            listaRecursosArchivos = Files.readAllLines(Paths.get(resourceFile.getParent(), resourceFile.getName()));
        }

        //Agregando nombres de archivos a la lista
        System.out.println("Requesting data to dropbox...");
        ListFolderResult result = client.files().listFolderBuilder(path)
                .withIncludeDeleted(false)
                .withRecursive(false)
                .withIncludeMediaInfo(false)
                .start();
        for (Metadata metadata : result.getEntries()) {
            if (metadata instanceof FileMetadata) {
                System.out.println(metadata.getPathDisplay());
                File file = new File(metadata.getPathDisplay());
                listaRecursosArchivos.add(file.getName());
            }
        }
        return listaRecursosArchivos;
    }

    public File descargarArchivoGenerico(String ruta, File dir, String nombre) throws IOException, DbxException {
        File tempFile = new File(dir, nombre);
        if (!tempFile.exists()) {
            try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(tempFile.toPath(), CREATE))) {
                client.files().download(ruta + "/" + nombre).download(out);
            }
        }
        return tempFile;
    }

    public File descargarArchivoGenericoTemporal(String ruta, String nombre) throws IOException, DbxException {
        String appRoot = ServletActionContext.getRequest().getServletContext().getRealPath("/");
        File tempFile = File.createTempFile("preview", "." + FilenameUtils.getExtension(nombre), new File(appRoot + ruta + File.separator));
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(tempFile.toPath(), CREATE))) {
            client.files().download(ruta + "/" + nombre).download(out);
        }
        return tempFile;
    }

}
