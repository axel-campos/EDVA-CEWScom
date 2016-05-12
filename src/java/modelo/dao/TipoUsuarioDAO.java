package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.TipoUsuario;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 * TipoUsuario, por medio del POJO TipoUsuario.
 * 
 * @author kikemon
 */
public class TipoUsuarioDAO extends ConexionDAO<TipoUsuario> {

	@Override
	public void registrar(TipoUsuario registro) {
		String sql = "INSERT INTO tipoUsuario VALUES (?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdTipoUsuario());
			stmt.setString(2, registro.getNombre());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(TipoUsuario viejo, TipoUsuario nuevo) {
		String sql = "UPDATE tipoUsuario SET idtipoUsuario = ?, nombre = ? WHERE idtipoUsuario = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdTipoUsuario());
			stmt.setString(2, nuevo.getNombre());
			stmt.setInt(3, viejo.getIdTipoUsuario());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(TipoUsuario registro) {
		String sql = "DELETE FROM tipoUsuario WHERE idtipoUsuario = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdTipoUsuario());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public TipoUsuario buscar(TipoUsuario registro) {
		String sql = "SELECT * FROM tipoUsuario WHERE idtipoUsuario = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdTipoUsuario());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new TipoUsuario()
						.setIdTipoUsuario(rs.getInt("idtipoUsuario"))
						.setNombre(rs.getString("nombre"));
				} else
					return null;
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<TipoUsuario> buscarTodos() {
		String sql = "SELECT * FROM tipoUsuario";
		List<TipoUsuario> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new TipoUsuario()
					.setIdTipoUsuario(rs.getInt("idtipoUsuario"))
					.setNombre(rs.getString("nombre")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
}