package model.mdo;

import org.apache.struts2.ServletActionContext;
import org.apache.commons.io.FileUtils;
import com.dropbox.core.*;
import com.dropbox.core.v2.*;
import com.dropbox.core.v2.files.WriteMode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
            client.files().uploadBuilder(ruta + "/" + etapa + ".html").uploadAndFinish(fis);
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
        if(!temp.exists())
        {
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

            subirArchivoTexto((String) map.get("ruta"), "preview.html", template.setDetalles(detalles_contenido).generarPlantilla(generarHTMLString(artefactosMap, parser, template)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Regresa un mapa con el contenido del JSON dado.
     *
     * @param token Token del del grupo al cual pertence el contenido
     * @param idContenido Contenido didactico de que se va a guardar
     * @param versiones_escogidas Una lista con las 5 versiones que se escogieron para cada etapa.
     */
    public void guardarHTMLContenidoDidacticoLiberado(String token, String idContenido, List<String> versiones_escogidas) {
        try {
            Grupo grupo = new GrupoDAO().buscar(new Grupo().setToken(token));
            Contenido contenido = new ContenidoDAO().buscarContenidoConToken(new Contenido().setToken(token).setIdContenido(Integer.parseInt(idContenido)));
            List<String> HTMLbodies = new ArrayList<>();
            Map<String, Object> detalles_contenido = new HashMap<>();
            detalles_contenido.put("titulo", contenido.getTitulo());
            detalles_contenido.put("grupo_nombre", grupo.getNombre());
            detalles_contenido.put("tema", contenido.getTema());
            detalles_contenido.put("descripcion", contenido.getDescripcion());

            for (int i = 0; i < 5; i++) {
                String ruta = token + "/" + idContenido + "/" + (i+1) + "/" + versiones_escogidas.get(i);
                String artefactosJSON = descargarArchivoTexto(ruta, "artefactos.json");
                MDOTemplate template = MDOTemplateUtil.getTemplate(artefactosJSON);
                Map<String, Object> map = obtenerMapaDeJson(artefactosJSON);
                MDOParser parser = MDOUtil.getParser(artefactosJSON);
                List<Map<String, Object>> artefactosMap = (List<Map<String, Object>>) map.get("lista");

                HTMLbodies.addAll(generarHTMLString(artefactosMap, parser, template));
            }
            
            subirArchivoTexto(token + "/" + idContenido, "contenido_didactico_liberado.html", new ContenidoDidacticoTemplate().setDetalles(detalles_contenido).generarPlantilla(HTMLbodies));
        } catch (Exception e) {
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
}
