package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.Votacion;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 * Votacion, por medio del POJO Votacion.
 * 
 * @author kikemon
 */
public class VotacionDAO extends ConexionDAO<Votacion> {

	@Override
	public void registrar(Votacion registro) {
		String sql = "INSERT INTO votacion VALUES (?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			stmt.setInt(2, registro.getIdContenido());
			stmt.setShort(3, registro.getIdEtapa());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(Votacion viejo, Votacion nuevo) {
		String sql = "UPDATE votacion SET idVotacion = ?, idContenido = ?, idEtapa = ? WHERE idVotacion = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdVotacion());
			stmt.setInt(2, nuevo.getIdContenido());
			stmt.setShort(3, nuevo.getIdEtapa());
			stmt.setInt(4, viejo.getIdVotacion());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(Votacion registro) {
		String sql = "DELETE FROM votacion WHERE idVotacion = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Votacion buscar(Votacion registro) {
		String sql = "SELECT * FROM votacion WHERE idVotacion = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Votacion()
						.setIdVotacion(rs.getInt("idVotacion"))
						.setIdContenido(rs.getInt("idContenido"))
						.setIdEtapa(rs.getShort("idEtapa"));
				} else
					return null;
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Votacion> buscarTodos() {
		String sql = "SELECT * FROM votacion";
		List<Votacion> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Votacion()
					.setIdVotacion(rs.getInt("idVotacion"))
					.setIdContenido(rs.getInt("idContenido"))
					.setIdEtapa(rs.getShort("idEtapa")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
}