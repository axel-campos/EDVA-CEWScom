package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.Contenido;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 * Contenido, por medio del POJO Contenido.
 * 
 * @author kikemon
 */
public class ContenidoDAO extends ConexionDAO<Contenido> {

	@Override
	public void registrar(Contenido registro) {
		String sql = "INSERT INTO Contenido VALUES (?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdContenido());
			stmt.setString(2, registro.getToken());
			stmt.setString(3, registro.getTitulo());
			stmt.setString(4, registro.getTema());
			stmt.setString(5, registro.getDescripcion());
			stmt.setBoolean(6, registro.getFinalizado());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(Contenido viejo, Contenido nuevo) {
		String sql = "UPDATE Contenido SET idContenido = ?, token = ?, titulo = ?, tema = ?, "
			+ "descripcion = ?, finalizado = ? WHERE idContenido = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdContenido());
			stmt.setString(2, nuevo.getToken());
			stmt.setString(3, nuevo.getTitulo());
			stmt.setString(4, nuevo.getTema());
			stmt.setString(5, nuevo.getDescripcion());
			stmt.setBoolean(6, nuevo.getFinalizado());
			stmt.setInt(7, viejo.getIdContenido());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(Contenido registro) {
		String sql = "DELETE FROM Contenido WHERE idContenido = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdContenido());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Contenido buscar(Contenido registro) {
		String sql = "SELECT * FROM Contenido WHERE idContenido = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdContenido());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Contenido()
						.setIdContenido(rs.getInt("idContenido"))
						.setToken(rs.getString("token"))
						.setTitulo(rs.getString("titulo"))
						.setTema(rs.getString("tema"))
						.setDescripcion(rs.getString("descripcion"))
						.setFinalizado(rs.getBoolean("finalizado"));
				} else
					return null;
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Contenido> buscarTodos() {
		String sql = "SELECT * FROM Contenido";
		List<Contenido> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Contenido()
					.setIdContenido(rs.getInt("idContenido"))
					.setToken(rs.getString("token"))
					.setTitulo(rs.getString("titulo"))
					.setTema(rs.getString("tema"))
					.setDescripcion(rs.getString("descripcion"))
					.setFinalizado(rs.getBoolean("finalizado")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
    
    public boolean buscarContenidoxTitulo(Contenido registro){
        String sql = "SELECT * FROM Contenido WHERE titulo = ? AND token = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, registro.getTitulo());
            stmt.setString(2, registro.getToken());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { 
                    return true;
				} else{
					return false;
                }
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
    }
}