package modelo.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.pojo.Reporte;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la relación
 * Reporte, por medio del POJO Reporte.
 * 
 * @author kikemon
 */
public class ReporteDAO extends ConexionDAO<Reporte> {

	@Override
	public void registrar(Reporte registro) {
		String sql = "INSERT INTO Reporte VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdReporte());
			stmt.setString(2, registro.getCausa());
            if(registro.getIdContenido() == 0){
                stmt.setObject(3, null);
            }else{
                stmt.setInt(3, registro.getIdContenido());
            }
            stmt.setString(4, registro.getCorreo());
            stmt.setString(5, registro.getToken());
            stmt.setInt(6, registro.getAtendido());
            stmt.setInt(7, registro.getAceptado());
            stmt.setTimestamp(8, new Timestamp(registro.getFechaReporte().getTime()));
            stmt.setString(9, registro.getCorreoReportando());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void modificar(Reporte viejo, Reporte nuevo) {
		String sql = "UPDATE Reporte SET idReporte = ?, causa = ?, idContenido = ?, correo = ?, token = ?, "
                + "atendido = ?, aceptado = ?, fechaReporte = ?, correoReportando = ? WHERE idReporte = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevo.getIdReporte());
			stmt.setString(2, nuevo.getCausa());
			stmt.setInt(3, nuevo.getIdContenido());
            stmt.setString(4, nuevo.getCorreo());
            stmt.setString(5, nuevo.getToken());
            stmt.setInt(6, nuevo.getAtendido());
            stmt.setInt(7, nuevo.getAceptado());
            stmt.setTimestamp(8, new Timestamp(nuevo.getFechaReporte().getTime()));
            stmt.setString(9, nuevo.getCorreoReportando());
			stmt.setInt(10, viejo.getIdReporte());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
            System.out.println(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(Reporte registro) {
		String sql = "DELETE FROM Reporte WHERE idReporte = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdReporte());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Reporte buscar(Reporte registro) {
		String sql = "SELECT * FROM Reporte WHERE idReporte = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, registro.getIdReporte());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Reporte()
						.setIdReporte(rs.getInt("idReporte"))
						.setCausa(rs.getString("causa"))
						.setIdContenido(rs.getInt("idContenido"))
                        .setCorreo(rs.getString("correo"))
                        .setToken(rs.getString("token"))
                        .setAtendido(rs.getInt("atendido"))
                        .setAceptado(rs.getInt("aceptado"))
                        .setFechaReporte(rs.getTimestamp("fechaReporte"))
                        .setCorreoReportando(rs.getString("correoReportando"));
				} else
					return null;
			}
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Reporte> buscarTodos() {
		String sql = "SELECT * FROM Reporte";
		List<Reporte> lista = new ArrayList<>();
		
		try (
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				lista.add(new Reporte()
					.setIdReporte(rs.getInt("idReporte"))
					.setCausa(rs.getString("causa"))
					.setIdContenido(rs.getInt("idContenido"))
                    .setCorreo(rs.getString("correo"))
                    .setToken(rs.getString("token"))
                    .setAtendido(rs.getInt("atendido"))
                    .setAceptado(rs.getInt("aceptado"))
                    .setFechaReporte(rs.getTimestamp("fechaReporte"))
                    .setCorreoReportando(rs.getString("correoReportando")));
			}
			
			return lista;
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void responderSolicitud(Reporte nuevoReporte) {
		String sql = "UPDATE reporte SET atendido = ?, aceptado = ? WHERE idReporte = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, nuevoReporte.getAtendido());
			stmt.setInt(2, nuevoReporte.getAceptado());
			stmt.setInt(3, nuevoReporte.getIdReporte());
			stmt.executeUpdate();
		} catch (SQLException | NullPointerException e) {
            System.out.println(e);
			throw new RuntimeException(e);
		}
	}
}