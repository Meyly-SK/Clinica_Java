package Servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AdministradorDTO;
import beans.ClienteDTO;
import modelo.ModelAdministrador;
import modelo.ModelCliente;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet implements Servlet {
	ModelCliente m = new ModelCliente();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmpleado() {

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login, clave;
		login = request.getParameter("txtLogin");
		clave = request.getParameter("txtPass");
		ClienteDTO e = m.iniciarSesion(login, clave);
		if (e == null) {
			request.setAttribute("msj", "Error usuario y/o clave");
			request.getRequestDispatcher("LoginCliente.jsp").forward(request, response);
		} else {
			response.sendRedirect("Dashboard.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		 
	}
      */ 
}  
