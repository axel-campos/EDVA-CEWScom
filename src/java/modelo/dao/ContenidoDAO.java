package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.Contenido;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la
 * relación Contenido, por medio del POJO Contenido.
 *
 * @author kikemon
 */
public class ContenidoDAO extends ConexionDAO<Contenido> {

	@Override
	public void registrar(Contenido registro) {
		String sql = "INSERT INTO Contenido VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdContenido());
			stmt.setString(2, registro.getToken());
			stmt.setString(3, registro.getTitulo());
			stmt.setString(4, registro.getTema());
			stmt.setString(5, registro.getDescripcion());
            stmt.setString(6, registro.getCompetencia());
			stmt.setBoolean(7, registro.getFinalizado());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(Contenido viejo, Contenido nuevo) {
		String sql = "UPDATE Contenido SET idContenido = ?, token = ?, titulo = ?, tema = ?, "
			+ "descripcion = ?, competencia = ?, finalizado = ? WHERE idContenido = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdContenido());
			stmt.setString(2, nuevo.getToken());
			stmt.setString(3, nuevo.getTitulo());
			stmt.setString(4, nuevo.getTema());
			stmt.setString(5, nuevo.getDescripcion());
            stmt.setString(6, nuevo.getCompetencia());
			stmt.setBoolean(7, nuevo.getFinalizado());
			stmt.setInt(8, viejo.getIdContenido());
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
						.setFinalizado(rs.getBoolean("finalizado"))
                        .setCompetencia(rs.getString("competencia"));
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
					.setFinalizado(rs.getBoolean("finalizado"))
                    .setCompetencia(rs.getString("competencia")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void buscarContenidoxTitulo(Contenido registro){
        String sql = "SELECT * FROM Contenido WHERE titulo = ? AND token = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, registro.getIdContenido());
            stmt.setString(2, registro.getToken());
            stmt.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Regresa un Contenido a partir de su ID y su token.
     *
     * @param registro Registro Contenido con el token y el idContenido dentro
     * del éste.
     * @return Contenido con los datos completos de acuerdo a su al IdContenido
     * y al token proporcionado.
     */
    public Contenido buscarContenidoConToken(Contenido registro) {
        String sql = "SELECT * FROM Contenido WHERE idContenido = ? and token = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, registro.getIdContenido());
            stmt.setString(2, registro.getToken());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Contenido()
                        .setIdContenido(rs.getInt("idContenido"))
                        .setToken(rs.getString("token"))
                        .setTitulo(rs.getString("titulo"))
                        .setTema(rs.getString("tema"))
                        .setDescripcion(rs.getString("descripcion"))
                        .setFinalizado(rs.getBoolean("finalizado"));
                } else {
                    return null;
                }
            }
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
