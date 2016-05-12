package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Menu;
/**
 * Clase para listar los menus y submenus de la aplicación.
 * 
 * @author DanHv
 */
public class MenuDAO extends ConexionDAO<Menu> {
    @Override
    public void registrar(Menu registro){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Menu viejo, Menu nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Menu registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Menu buscar(Menu registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Menu> buscarTodos() {
        String sql = "SELECT * FROM menu";
		List<Menu> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Menu()
                    .setIdMenu(rs.getShort("idMenu"))
                    .setNombre(rs.getString("nombre"))
                    .setAction(rs.getString("action")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
    }
    
    public List<Menu> buscarTodos(int perfil){
        String sql = "SELECT m.idmenu AS idmenu, m.nombre AS menu,m.action AS menuAction, m.target AS target FROM permisomenu pm INNER JOIN menu m ON pm.idmenu = m.idmenu WHERE pm.idperfil = " + 
                    perfil + " ORDER BY m.idmenu";
        List<Menu> lista = new ArrayList<>();
        try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Menu()
                    .setIdMenu(rs.getShort("idmenu"))
                    .setNombre(rs.getString("menu"))
                    .setAction(rs.getString("menuAction"))
                    .setTarget(rs.getString("target")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}        
    }
}
