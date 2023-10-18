package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModelCliente;
import service.ClienteService;
import beans.CitaDTO;
import beans.ClienteDTO;
/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	ModelCliente m = new ModelCliente();
	ClienteService serviCliente = new ClienteService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
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

        if (tipo.equals("listar"))

           listar(request, response);

        else if (tipo.equals("registrar"))

           registrar(request, response);

        else if (tipo.equals("buscar"))

           buscar(request, response);
        
        else if (tipo.equals("perfil"))

            perfil(request, response);
        
        else if (tipo.equals("prueba"))

            prueba(request, response);
       
        else if (tipo.equals("actualizar"))

           actualizar(request, response);

        else if (tipo.equals("eliminar"))

           eliminar(request, response); 
        
        else if(tipo.equals("sesion"))
        	
        	iniciarSesion(request, response);
        
        else if(tipo.equals("cerrarSesion"))
        	
        	cerrarSesion(request,response);

     }
	
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		HttpSession sesion;
		ClienteDTO cli;
		
		HttpSession miSesion = request.getSession();
		
		String login, clave,nombre;
		login = request.getParameter("txtLogin");
		clave = request.getParameter("txtPass");
		ClienteDTO e = m.iniciarSesion(login, clave);
		if (e == null) {
			request.setAttribute("msj", "Error usuario y/o clave");
			request.getRequestDispatcher("LoginCliente.jsp").forward(request, response);
		} else {
			System.out.println("ID : " + e.getId_cliente());
			System.out.println("Login: " + e.getEmail_cliente());
			System.out.println("Clave: " + e.getContra_cliente());
			System.out.println("Nombre: " + e.getNom_cliente());
			System.out.println("Apellifos: " + e.getApe_cliente());
			request.setAttribute("datos",e );
			request.getSession().setAttribute("dato", e);
			response.sendRedirect("ClienteDashboard.jsp");
		}
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		
		request.setAttribute("msg", "Iniciar sesion!!!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviCliente.listaCliente());
        request.getRequestDispatcher("ClienteLista.jsp").forward(request, response);
     }

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom, ape,email,pass,num;
		nom = request.getParameter("txt_nom");
		ape = request.getParameter("txt_ape");
		email = request.getParameter("txt_email");
		pass = request.getParameter("txt_pass");
		num = request.getParameter("txt_num");
		
		ClienteDTO obj = new ClienteDTO();
		obj.setEmail_cliente(email);
		obj.setContra_cliente(pass);
		obj.setNom_cliente(nom);
		obj.setApe_cliente(ape);
		obj.setTel_cliente(num);

		serviCliente.registrarCliente(obj);
		iniciarSesion(request,response);
		
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 int cod = Integer.parseInt(request.getParameter("cod"));
   	 request.setAttribute("Cliente", serviCliente.buscarCliente(cod));
   	 request.getRequestDispatcher("actualizarCliente.jsp").forward(request, response); 
	}
	private void perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	 int cod = Integer.parseInt(request.getParameter("cod"));
	   	 request.setAttribute("Cliente", serviCliente.buscarCliente(cod));
	   	 request.getRequestDispatcher("PerfilCliente.jsp").forward(request, response); 
	}
	private void prueba(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	 int cod = Integer.parseInt(request.getParameter("cod"));
	   	 request.setAttribute("Cliente", serviCliente.buscarCliente(cod));
	   	 request.getRequestDispatcher("PruebaCliente.jsp").forward(request, response); 
		}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod, email, contra,nom, ape, tel;
		cod = request.getParameter("txt_cod");
		email = request.getParameter("txt_email");
		contra = request.getParameter("txt_contra");
		nom = request.getParameter("txt_nom");
		ape = request.getParameter("txt_ape");
		tel = request.getParameter("txt_tel");
		ClienteDTO obj = new ClienteDTO();
		obj.setId_cliente(Integer.parseInt(cod));
		obj.setEmail_cliente(email);
		obj.setContra_cliente(contra);
		obj.setNom_cliente(nom);
		obj.setApe_cliente(ape);
		obj.setTel_cliente(tel);

		serviCliente.actualizarCliente(obj);
		listar(request,response);
    }
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
    	serviCliente.eliminarCliente(cod);
    	listar(request,response);
	}
	
	

}
