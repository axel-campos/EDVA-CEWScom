/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Submenu;
/**
 *
 * @author DanHv
 */
public class SubmenuDAO extends ConexionDAO<Submenu>{

    @Override
    public void registrar(Submenu registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Submenu viejo, Submenu nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Submenu registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Submenu buscar(Submenu registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Submenu> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Submenu> buscarSubMenu(int menu){
        String sql = "SELECT * FROM submenu WHERE idmenu = " + menu;
        List<Submenu> lista = new ArrayList<>();
        try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Submenu()
                    .setIdSubmenu(rs.getShort("idsubmenu"))
                    .setNombre(rs.getString("nombre"))
                    .setAction(rs.getString("action"))
                    .setTarget(rs.getString("target")));
                
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		} 
    }
    
}
