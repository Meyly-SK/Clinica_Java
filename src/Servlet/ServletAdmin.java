package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ClienteDTO;
import beans.AdministradorDTO;
import modelo.ModelAdministrador;

/**
 * Servlet implementation class ServletAdmin
 */
@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModelAdministrador m = new ModelAdministrador();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tipo = request.getParameter("tipo");
        
       if(tipo.equals("sesion"))
        	
        	iniciarSesion(request, response);
        

     }
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		HttpSession sesion;
		ClienteDTO cli;
		
		HttpSession miSesion = request.getSession();
		
		String login, clave,nombre;
		login = request.getParameter("txtLogin");
		clave = request.getParameter("txtPass");
		AdministradorDTO e = m.iniciarSesionAdmin(login, clave);
		if (e == null) {
			request.setAttribute("msj", "Error usuario y/o clave");
			request.getRequestDispatcher("LoginAdmin.jsp").forward(request, response);
		} else {
			System.out.println("ID : " + e.getId_admin());
			System.out.println("Login: " + e.getEmail());
			System.out.println("Clave: " + e.getContra());
			request.setAttribute("datos",e );
			request.getSession().setAttribute("dato", e);
			response.sendRedirect("AdminDashboard.jsp");
		}
	}

}
