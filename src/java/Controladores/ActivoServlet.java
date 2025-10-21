/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;
import Modelo.Activo;
import ModeloDAO.ActivoDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author kristhor
 */
@WebServlet("/ActivoServlet")
public class ActivoServlet extends HttpServlet {

    ActivoDAO dao = new ActivoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Activo> lista = dao.listar();
        request.setAttribute("activos", lista);
        request.getRequestDispatcher("/vistasAdmin/maquinas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("agregar".equals(accion)) {
            Activo a = new Activo();
            a.setPlaca(request.getParameter("placa"));
            a.setCodigoInterno(request.getParameter("codigoInterno"));
            a.setNombre(request.getParameter("nombre"));
            a.setIdTipoActivo(Integer.parseInt(request.getParameter("idTipoActivo")));
            a.setMarca(request.getParameter("marca"));
            a.setModelo(request.getParameter("modelo"));
            a.setAnio(Integer.parseInt(request.getParameter("anio")));
            a.setCapacidadPasajeros(Integer.parseInt(request.getParameter("capacidadPasajeros")));
            a.setKilometrajeActual(Double.parseDouble(request.getParameter("kilometrajeActual")));
            a.setEstado(request.getParameter("estado"));

            dao.agregar(a);
            response.sendRedirect(request.getContextPath() + "/ActivoServlet");
        }
    }
}
