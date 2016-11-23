package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.TipoUsuarioGrupo;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 * TipoUsuarioGrupo, por medio del POJO TipoUsuarioGrupo.
 * 
 * @author kikemon
 */
public class TipoUsuarioGrupoDAO extends ConexionDAO<TipoUsuarioGrupo> {

	@Override
	public void registrar(TipoUsuarioGrupo registro) {
		String sql = "INSERT INTO tipousuariogrupo VALUES (?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdTipoUsuarioGrupo());
			stmt.setString(2, registro.getNombre());
			stmt.setString(3, registro.getDescripcion());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(TipoUsuarioGrupo viejo, TipoUsuarioGrupo nuevo) {
		String sql = "UPDATE tipousuariogrupo SET idtipoUsuarioGrupo = ?, nombre = ?, "
			+ "descripcion = ? WHERE idtipoUsuarioGrupo = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdTipoUsuarioGrupo());
			stmt.setString(2, nuevo.getNombre());
			stmt.setString(3, nuevo.getDescripcion());
			stmt.setInt(4, viejo.getIdTipoUsuarioGrupo());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(TipoUsuarioGrupo registro) {
		String sql = "DELETE FROM tipousuariogrupo WHERE idtipoUsuarioGrupo = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdTipoUsuarioGrupo());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public TipoUsuarioGrupo buscar(TipoUsuarioGrupo registro) {
		String sql = "SELECT * FROM tipousuariogrupo WHERE idtipoUsuarioGrupo = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdTipoUsuarioGrupo());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new TipoUsuarioGrupo()
						.setIdTipoUsuarioGrupo(rs.getInt("idtipoUsuarioGrupo"))
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
	public List<TipoUsuarioGrupo> buscarTodos() {
		String sql = "SELECT * FROM tipousuariogrupo";
		List<TipoUsuarioGrupo> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new TipoUsuarioGrupo()
					.setIdTipoUsuarioGrupo(rs.getInt("idtipoUsuarioGrupo"))
					.setNombre(rs.getString("nombre"))
					.setDescripcion(rs.getString("descripcion")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
}