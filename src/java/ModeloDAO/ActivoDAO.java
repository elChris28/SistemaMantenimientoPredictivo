/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Modelo.Activos;
import java.sql.*;
import java.util.*;
import Modelo.Conexion;

public class ActivoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    // ✅ Listar todos los activos
    public List<Activo> listar() {
        List<Activo> lista = new ArrayList<>();
        String sql = "SELECT * FROM activos ORDER BY idActivo DESC";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Activo a = new Activo();
                a.setIdActivo(rs.getInt("idActivo"));
                a.setPlaca(rs.getString("placa"));
                a.setCodigoInterno(rs.getString("codigoInterno"));
                a.setNombre(rs.getString("nombre"));
                a.setIdTipoActivo(rs.getInt("idTipoActivo"));
                a.setMarca(rs.getString("marca"));
                a.setModelo(rs.getString("modelo"));
                a.setAnio(rs.getInt("anio"));
                a.setCapacidadPasajeros(rs.getInt("capacidadPasajeros"));
                a.setKilometrajeActual(rs.getDouble("kilometrajeActual"));
                a.setEstado(rs.getString("estado"));
                a.setFechaRegistro(rs.getTimestamp("fechaRegistro"));
                lista.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // ✅ Insertar nuevo activo
    public boolean agregar(Activo a) {
        String sql = "INSERT INTO activos (placa, codigoInterno, nombre, idTipoActivo, marca, modelo, anio, capacidadPasajeros, kilometrajeActual, estado, fechaRegistro) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getPlaca());
            ps.setString(2, a.getCodigoInterno());
            ps.setString(3, a.getNombre());
            ps.setInt(4, a.getIdTipoActivo());
            ps.setString(5, a.getMarca());
            ps.setString(6, a.getModelo());
            ps.setInt(7, a.getAnio());
            ps.setInt(8, a.getCapacidadPasajeros());
            ps.setDouble(9, a.getKilometrajeActual());
            ps.setString(10, a.getEstado());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
