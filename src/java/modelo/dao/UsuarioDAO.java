package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Usuario;

/**
 * Clase que sirve para realizar operaciones entre la base de datos EDVADB y la
 * relación Usuario, por medio del POJO Usuario.
 *
 * @author kikemon
 */
public class UsuarioDAO extends ConexionDAO<Usuario> {

    @Override
    public void registrar(Usuario registro) {
        String sql = "INSERT INTO Usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, registro.getCorreo());
            stmt.setString(2, registro.getNombre());
            stmt.setString(3, registro.getAPaterno());
            stmt.setString(4, registro.getAMaterno());
            stmt.setString(5, registro.getCedula());
            stmt.setInt(6, registro.getTipo());
            stmt.setDate(7, registro.getFechaNacimiento());
            stmt.setString(8, registro.getPassword());
            stmt.setInt(9, registro.getFacebook());
            stmt.setString(10, registro.getAvatar());
            stmt.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modificar(Usuario viejo, Usuario nuevo) {
        String sql = "UPDATE Usuario SET correo = ?, nombre = ?, aPaterno = ?, aMaterno = ?, "
            + "cedula = ?, tipoUsuario = ?, fechaNacimiento = ?, password = ?, facebook = ?, avatar = ? WHERE correo = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevo.getCorreo());
            stmt.setString(2, nuevo.getNombre());
            stmt.setString(3, nuevo.getAPaterno());
            stmt.setString(4, nuevo.getAMaterno());
            stmt.setString(5, nuevo.getCedula());
            stmt.setInt(6, nuevo.getTipo());
            stmt.setDate(7, nuevo.getFechaNacimiento());
            stmt.setString(8, nuevo.getPassword());
            stmt.setInt(9, nuevo.getFacebook());
            stmt.setString(10, nuevo.getAvatar());
            stmt.setString(11, viejo.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Usuario registro) {
        String sql = "DELETE FROM Usuario WHERE correo = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, registro.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario buscar(Usuario registro) {
        String sql = "SELECT * FROM Usuario WHERE correo = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, registro.getCorreo());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario()
                        .setCorreo(rs.getString("correo"))
                        .setNombre(rs.getString("nombre"))
                        .setAPaterno(rs.getString("aPaterno"))
                        .setAMaterno(rs.getString("aMaterno"))
                        .setCedula(rs.getString("cedula"))
                        .setTipo(rs.getInt("tipoUsuario"))
                        .setFechaNacimiento(rs.getDate("fechaNacimiento"))
                        .setPassword(rs.getString("password"))
                        .setFacebook(rs.getInt("facebook"))
                        .setAvatar(rs.getString("avatar"));
                } else {
                    return null;
                }
            }
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        String sql = "SELECT * FROM Usuario";
        List<Usuario> lista = new ArrayList<>();

        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                lista.add(new Usuario()
                    .setCorreo(rs.getString("correo"))
                    .setNombre(rs.getString("nombre"))
                    .setAPaterno(rs.getString("aPaterno"))
                    .setAMaterno(rs.getString("aMaterno"))
                    .setCedula(rs.getString("cedula"))
                    .setTipo(rs.getInt("tipoUsuario"))
                    .setFechaNacimiento(rs.getDate("fechaNacimiento"))
                    .setPassword(rs.getString("password"))
                    .setFacebook(rs.getInt("facebook"))
                    .setAvatar(rs.getString("avatar")));
            }

            return lista;
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> buscarProfesores() {
        String sql = "SELECT * FROM Usuario WHERE tipoUsuario = 2";
        List<Usuario> lista = new ArrayList<>();

        try (
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                lista.add(new Usuario()
                    .setCorreo(rs.getString("correo"))
                    .setNombre(rs.getString("nombre"))
                    .setAPaterno(rs.getString("aPaterno"))
                    .setAMaterno(rs.getString("aMaterno"))
                    .setCedula(rs.getString("cedula"))
                    .setTipo(rs.getInt("tipoUsuario"))
                    .setFechaNacimiento(rs.getDate("fechaNacimiento"))
                    .setPassword(rs.getString("password"))
                    .setFacebook(rs.getInt("facebook"))
                    .setAvatar(rs.getString("avatar")));
            }

            return lista;
        } catch (SQLException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
