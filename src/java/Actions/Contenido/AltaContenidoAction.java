package Actions.Contenido;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.ContenidoDAO;
import modelo.pojo.Contenido;


public class AltaContenidoAction extends ActionSupport {
    
    private String titulo;
    private String tema;
    private String descripcion;
    private String token;
    private String tipo;
    private String id;
    
    @Override
    public void validate(){
        if(titulo == null || titulo.trim().isEmpty()){
            addActionError("El campo título es requerido.");
        }else if(titulo.length() > 20){
            addActionError("El campo título no debe contener más de 20 letras.");
        }
        if(tema.length() > 20){
            addActionError("El campo tema no debe contener más de 20 letras.");
        }
        if(descripcion.length() > 100){
            addActionError("El campo descripción no debe contener más de 100 letras.");
        }
    }
    
    @Override
    public String execute() throws Exception {
        ContenidoDAO contenidoDAO = new ContenidoDAO();
        String accion = "";
        Contenido contenido = new Contenido();
        Contenido viejo = new Contenido();
        contenido.setToken(token).setTitulo(titulo).setTema(tema).setFinalizado(false).setDescripcion(descripcion);
        if(tipo.equals("Guardar")){//Registrar            
            accion = "guardó";
        }else{//Modificar
            viejo.setIdContenido(Integer.parseInt(id));
            accion = "modificó";
        }
        try{
            contenidoDAO.conectar();        
            if(tipo.equals("Guardar")){//Registrar
                if(contenidoDAO.buscarContenidoxTitulo(contenido)){//existe, entonces no podemos guardar
                    addActionError("El contenido " + titulo + " no se guardó debido a que este grupo ya creo un contenido con el mismo título.");
                    contenidoDAO.desconectar();
                    return INPUT;
                }
                contenidoDAO.registrar(contenido);                
            }else{//Modificar
                contenidoDAO.modificar(viejo, contenido);
            }
            addActionMessage("El contenido didáctico " + titulo + " se " + accion + ".");
            contenidoDAO.desconectar();
            return SUCCESS;
        }catch(RuntimeException e){
            addActionError("El contenido didáctico " + titulo + " no se " + accion + ".");
            contenidoDAO.desconectar();
            return ERROR;
        }
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
