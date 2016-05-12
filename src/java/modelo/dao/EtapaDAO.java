package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.Etapa;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 * Etapa, por medio del POJO Etapa.
 * 
 * @author kikemon
 */
public class EtapaDAO extends ConexionDAO<Etapa> {

	@Override
	public void registrar(Etapa registro) {
		String sql = "INSERT INTO Etapa VALUES (?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setShort(1, registro.getIdEtapa());
			stmt.setString(2, registro.getNombre());
			stmt.setString(3, registro.getDescripcion());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(Etapa viejo, Etapa nuevo) {
		String sql = "UPDATE Etapa SET idEtapa = ?, nombre = ?, descripcion = ? "
			+ "WHERE idEtapa = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setShort(1, nuevo.getIdEtapa());
			stmt.setString(2, nuevo.getNombre());
			stmt.setString(3, nuevo.getDescripcion());
			stmt.setShort(4, viejo.getIdEtapa());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(Etapa registro) {
		String sql = "DELETE FROM Etapa WHERE idEtapa = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setShort(1, registro.getIdEtapa());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Etapa buscar(Etapa registro) {
		String sql = "SELECT * FROM Etapa WHERE idEtapa = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setShort(1, registro.getIdEtapa());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Etapa()
						.setIdEtapa(rs.getShort("idEtapa"))
						.setNombre(rs.getString("nombre"))
						.setDescripcion(rs.getString("descripcion"));
				} else
					return null;
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Etapa> buscarTodos() {
		String sql = "SELECT * FROM Etapa";
		List<Etapa> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Etapa()
					.setIdEtapa(rs.getShort("idEtapa"))
					.setNombre(rs.getString("nombre"))
					.setDescripcion(rs.getString("descripcion")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
}