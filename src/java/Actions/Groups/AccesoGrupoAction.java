/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions.Groups;

/**
 *
 * @author Christian Campos
 */

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelo.dao.GrupoDAO;
import modelo.dao.UsuarioGrupoDAO;
import modelo.pojo.Grupo;
import modelo.pojo.Usuario;
import modelo.pojo.UsuarioGrupo;

public class AccesoGrupoAction extends ActionSupport implements interceptor.AuthenticatedUser{
    private Usuario usuario;
    private String token;
    private List<Grupo> grupos;  
    
    
    public AccesoGrupoAction() {
        
        GrupoDAO grupoDAO = new GrupoDAO(); 
        grupoDAO.conectar();
        
        Grupo grupo_token = new Grupo().setToken(token);
        grupos = grupoDAO.buscarTodos().stream().filter(
        p -> p.getToken().equals(token)).collect(Collectors.toList());
        grupoDAO.buscar(grupo_token);
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
