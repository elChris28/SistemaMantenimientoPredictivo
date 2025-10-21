package Controladores;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.validar(correo, password);
        
        String context = request.getContextPath();

        if (user != null) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", user);

            String rolNombre = user.getRol().getNombreRol();
            
            sesion.setAttribute("rol", rolNombre.toLowerCase());           

            // Redirección según rol
            if ("Administrador".equalsIgnoreCase(rolNombre)) {
                response.sendRedirect(context + "/vistasAdmin/inicio.jsp");
            } else if ("Conductor".equalsIgnoreCase(rolNombre)) {
                response.sendRedirect(context + "/vistasEmpleado/empleadoMaquinas.jsp");
            } else {
                response.sendRedirect("login.jsp?error=rol");
            }
        } else {
            response.sendRedirect("login.jsp?error=credenciales");
        }
    }
}
