/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

/**
 *
 * @author kristhor
 */
import Modelo.*;
import java.sql.*;

public class UsuarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public Usuario validar(String correo, String password) {
        Usuario usuario = null;
        String sql = "SELECT u.*, r.nombreRol FROM usuarios u INNER JOIN roles r ON u.idRol = r.idRol WHERE u.correo=? AND u.password=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            System.out.println("🔍 Buscando usuario con correo: " + correo + " y password: " + password);


            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPassword(rs.getString("password"));
                usuario.setIdRol(rs.getInt("idRol"));
                usuario.setFechaRegistro(rs.getString("fechaRegistro"));

                Roles rol = new Roles(); // 👈 usamos tu clase
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombreRol(rs.getString("nombreRol"));
                usuario.setRol(rol);
                
                System.out.println("✅ Usuario encontrado: " + rs.getString("nombre") + " - Rol: " + rs.getString("nombreRol"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
