package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.UsuarioVotacion;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 UsuarioVotacion, por medio del POJO UsuarioVotacion.
 * 
 * @author kikemon
 */
public class UsuarioVotacionDAO extends ConexionDAO<UsuarioVotacion> {

	@Override
	public void registrar(UsuarioVotacion registro) {
		String sql = "INSERT INTO UsuarioVotacion VALUES (?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			stmt.setString(2, registro.getCorreo());
			stmt.setInt(3, registro.getVersion());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(UsuarioVotacion viejo, UsuarioVotacion nuevo) {
		String sql = "UPDATE UsuarioVotacion SET idVotacion = ?, correo = ?, version = ? "
			+ "WHERE idVotacion = ? AND correo = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdVotacion());
			stmt.setString(2, nuevo.getCorreo());
			stmt.setInt(3, nuevo.getVersion());
			stmt.setInt(4, viejo.getIdVotacion());
			stmt.setString(5, viejo.getCorreo());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(UsuarioVotacion registro) {
		String sql = "DELETE FROM UsuarioVotacion WHERE idVotacion = ? AND correo = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			stmt.setString(2, registro.getCorreo());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public UsuarioVotacion buscar(UsuarioVotacion registro) {
		String sql = "SELECT * FROM UsuarioVotacion WHERE idVotacion = ? AND correo = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			stmt.setString(2, registro.getCorreo());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new UsuarioVotacion()
						.setIdVotacion(rs.getInt("idVotacion"))
						.setCorreo(rs.getString("correo"))
						.setVersion(rs.getInt("version"));
				} else
					return null;
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<UsuarioVotacion> buscarTodos() {
		String sql = "SELECT * FROM UsuarioVotacion";
		List<UsuarioVotacion> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new UsuarioVotacion()
					.setIdVotacion(rs.getInt("idVotacion"))
					.setCorreo(rs.getString("correo"))
					.setVersion(rs.getInt("version")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
}