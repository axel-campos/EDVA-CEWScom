package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.Grupo;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 * Grupo, por medio del POJO Grupo.
 * 
 * @author kikemon
 */
public class GrupoDAO extends ConexionDAO<Grupo> {

	@Override
	public void registrar(Grupo registro) {
		String sql = "INSERT INTO Grupo VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, registro.getToken());
			stmt.setString(2, registro.getNombre());
			stmt.setString(3, registro.getDescripcion());
			stmt.setInt(4, registro.getTotalProfesores());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(Grupo viejo, Grupo nuevo) {
		String sql = "UPDATE Grupo SET token = ?, nombre = ?, "
			+ "descripcion = ?, totalProfesores = ? WHERE token = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nuevo.getToken());
			stmt.setString(2, nuevo.getNombre());
			stmt.setString(3, nuevo.getDescripcion());
			stmt.setInt(4, nuevo.getTotalProfesores());
			stmt.setString(5, viejo.getToken());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(Grupo registro) {
		String sql = "DELETE FROM Grupo WHERE token = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, registro.getToken());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
            e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Grupo buscar(Grupo registro) {
		String sql = "SELECT * FROM Grupo WHERE token = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, registro.getToken());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Grupo()
						.setToken(rs.getString("token"))
						.setNombre(rs.getString("nombre"))
						.setDescripcion(rs.getString("descripcion"))
						.setTotalProfesores(rs.getInt("totalProfesores"));
				} else
					return null;
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Grupo> buscarTodos() {
		String sql = "SELECT * FROM Grupo";
		List<Grupo> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Grupo()
					.setToken(rs.getString("token"))
					.setNombre(rs.getString("nombre"))
					.setDescripcion(rs.getString("descripcion"))
					.setTotalProfesores(rs.getInt("totalProfesores")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
    
    public List<Grupo> buscarTodosLimite() {
		String sql = "SELECT * FROM Grupo LIMIT 100";
		List<Grupo> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Grupo()
					.setToken(rs.getString("token"))
					.setNombre(rs.getString("nombre"))
					.setDescripcion(rs.getString("descripcion"))
					.setTotalProfesores(rs.getInt("totalProfesores")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
}