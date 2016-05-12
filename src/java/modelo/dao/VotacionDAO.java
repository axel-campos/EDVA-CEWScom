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
		String sql = "INSERT INTO Votacion VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			stmt.setInt(2, registro.getVotosAFavor());
			stmt.setInt(3, registro.getVotosEnContra());
			stmt.setInt(4, registro.getAbstencion());
			stmt.setInt(5, registro.getVotosNulos());
			stmt.setString(6, registro.getResultado());
			stmt.setInt(7, registro.getIdContenido());
			stmt.setInt(8, registro.getVersion());
			stmt.setShort(9, registro.getIdEtapa());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(Votacion viejo, Votacion nuevo) {
		String sql = "UPDATE Votacion SET idVotacion = ?, votosAFavor = ?, votosEnContra = ?, "
			+ "abstencion = ?, votosNulos = ?, resultado = ?, idContenido = ?, version = ?, "
			+ "idEtapa = ? WHERE idVotacion = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdVotacion());
			stmt.setInt(2, nuevo.getVotosAFavor());
			stmt.setInt(3, nuevo.getVotosEnContra());
			stmt.setInt(4, nuevo.getAbstencion());
			stmt.setInt(5, nuevo.getVotosNulos());
			stmt.setString(6, nuevo.getResultado());
			stmt.setInt(7, nuevo.getIdContenido());
			stmt.setInt(8, nuevo.getVersion());
			stmt.setShort(9, nuevo.getIdEtapa());
			stmt.setInt(10, viejo.getIdVotacion());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(Votacion registro) {
		String sql = "DELETE FROM Votacion WHERE idVotacion = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Votacion buscar(Votacion registro) {
		String sql = "SELECT * FROM Votacion WHERE idVotacion = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdVotacion());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Votacion()
						.setIdVotacion(rs.getInt("idVotacion"))
						.setVotosAFavor(rs.getInt("votosAFavor"))
						.setVotosEnContra(rs.getInt("votosEnContra"))
						.setAbstencion(rs.getInt("abstencion"))
						.setVotosNulos(rs.getInt("votosNulos"))
						.setResultado(rs.getString("resultado"))
						.setIdContenido(rs.getInt("idContenido"))
						.setVersion(rs.getInt("version"))
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
		String sql = "SELECT * FROM Votacion";
		List<Votacion> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Votacion()
					.setIdVotacion(rs.getInt("idVotacion"))
					.setVotosAFavor(rs.getInt("votosAFavor"))
					.setVotosEnContra(rs.getInt("votosEnContra"))
					.setAbstencion(rs.getInt("abstencion"))
					.setVotosNulos(rs.getInt("votosNulos"))
					.setResultado(rs.getString("resultado"))
					.setIdContenido(rs.getInt("idContenido"))
					.setVersion(rs.getInt("version"))
					.setIdEtapa(rs.getShort("idEtapa")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
}