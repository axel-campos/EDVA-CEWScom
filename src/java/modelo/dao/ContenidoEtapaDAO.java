package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.pojo.ContenidoEtapa;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 * ContenidoEtapa, por medio del POJO ContenidoEtapa.
 * 
 * @author kikemon
 */
public class ContenidoEtapaDAO extends ConexionDAO<ContenidoEtapa> {

	@Override
	public void registrar(ContenidoEtapa registro) {
		String sql = "INSERT INTO contenidoetapa () VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdContenido());
			stmt.setInt(2, registro.getVersion());
			stmt.setShort(3, registro.getIdEtapa());
			stmt.setTimestamp(4, new Timestamp(registro.getTiempoModificacion().getTime()));
			stmt.setString(5, registro.getRutaRecursos());
			stmt.setBoolean(6, registro.getLiberado());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(ContenidoEtapa viejo, ContenidoEtapa nuevo) {
		String sql = "UPDATE contenidoetapa SET idContenido = ?, version = ?, idEtapa = ?, "
			+ "tiempoModificacion = ?, rutaRecursos = ?, liberado = ? "
			+ "WHERE idContenido = ? AND version = ? AND idEtapa = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdContenido());
			stmt.setInt(2, nuevo.getVersion());
			stmt.setShort(3, nuevo.getIdEtapa());
			stmt.setTimestamp(4, new Timestamp(nuevo.getTiempoModificacion().getTime()));
			stmt.setString(5, nuevo.getRutaRecursos());
			stmt.setBoolean(6, nuevo.getLiberado());
			stmt.setInt(7, viejo.getIdContenido());
			stmt.setInt(8, viejo.getVersion());
			stmt.setShort(9, viejo.getIdEtapa());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(ContenidoEtapa registro) {
		String sql = "DELETE FROM contenidoetapa WHERE idContenido = ? AND version = ? AND idEtapa = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdContenido());
			stmt.setInt(2, registro.getVersion());
			stmt.setShort(3, registro.getIdEtapa());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ContenidoEtapa buscar(ContenidoEtapa registro) {
		String sql = "SELECT * FROM contenidoetapa WHERE idContenido = ? AND version = ? AND idEtapa = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdContenido());
			stmt.setInt(2, registro.getVersion());
			stmt.setShort(3, registro.getIdEtapa());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new ContenidoEtapa()
						.setIdContenido(rs.getInt("idContenido"))
						.setVersion(rs.getInt("version"))
						.setIdEtapa(rs.getShort("idEtapa"))
						.setTiempoModificacion(rs.getTimestamp("tiempoModificacion"))
						.setRutaRecursos(rs.getString("rutaRecursos"))
						.setLiberado(rs.getBoolean("liberado"));
				} else
					return null;
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ContenidoEtapa> buscarTodos() {
		String sql = "SELECT * FROM contenidoetapa";
		List<ContenidoEtapa> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new ContenidoEtapa()
					.setIdContenido(rs.getInt("idContenido"))
					.setVersion(rs.getInt("version"))
					.setIdEtapa(rs.getShort("idEtapa"))
					.setTiempoModificacion(rs.getTimestamp("tiempoModificacion"))
					.setRutaRecursos(rs.getString("rutaRecursos"))
					.setLiberado(rs.getBoolean("liberado")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
    
    @Override
    public List<Map<String, Object>> consultaGenerica(String sql) {
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			List<Map<String, Object>> tabla = new ArrayList<>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			
			while (rs.next()) {
				Map<String, Object> columna = new HashMap<>();
				
				for (int i = 1; i <= numberOfColumns; i++)
					columna.put(rsmd.getColumnLabel(i), rs.getObject(i));
				
				tabla.add(columna);
			}
			
			return tabla;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}