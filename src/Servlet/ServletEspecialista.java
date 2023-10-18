package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EspecialistaDTO;
import modelo.ModelEspecialista;
import service.EspecialistaService;

/**
 * Servlet implementation class ServletEspecialista
 */
@WebServlet("/ServletEspecialista")
public class ServletEspecialista extends HttpServlet {
	ModelEspecialista m = new ModelEspecialista();
	EspecialistaService serviEspecialista = new EspecialistaService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEspecialista() {
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
        
        else if (tipo.equals("actualizar"))

           actualizar(request, response);

        else if (tipo.equals("eliminar"))

           eliminar(request, response); 
        
         if(tipo.equals("login"))
        	
        	iniciarSesion(request, response);
        
        else if(tipo.equals("cerrarSesion"))
        	
        	cerrarSesion(request,response);

     }
	
	 /* private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviEspecialista.listaEspecialista());
        request.getRequestDispatcher("ClienteLista.jsp").forward(request, response);
     } */
	
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		
		
		String login, pas;
		login = request.getParameter("txtLogin");
		System.out.print("Opcion Login:" + login);
		pas = request.getParameter("txtPass");
		System.out.print("Opcion Pass" + pas);
		
		EspecialistaDTO e = m.iniciarSesion(login, pas);
		if (e == null) {
			request.setAttribute("msj", "Error usuario y/o clave");
			request.getRequestDispatcher("LoginEspecialista.jsp").forward(request, response);
		} else {
			System.out.println("Login: " + e.getEmail_espe());
			System.out.println("Contra: " + e.getContra_espe());
			System.out.println("ID Espe: " + e.getId_espe());
			System.out.println("Nombre: " + e.getNom_espe());
			System.out.println("ESP: " + e.getId_esp());
			request.setAttribute("Espe",e );
			request.getSession().setAttribute("Especialista", e);
			response.sendRedirect("EspeDashboard.jsp");
		}
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		
		request.setAttribute("msg", "Iniciar sesion!!!");
		request.getRequestDispatcher("Inicio.jsp").forward(request, response);
		
		
	}
	
	private void perfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	 int cod = Integer.parseInt(request.getParameter("cod"));
	   	 request.setAttribute("Cliente", serviEspecialista.buscarEspecialista(cod));
	   	 request.getRequestDispatcher("PerfilEspe.jsp").forward(request, response); 
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviEspecialista.listaEspecialista());
        request.getRequestDispatcher("EspecialistaLista.jsp").forward(request, response);
     } 
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	 int cod = Integer.parseInt(request.getParameter("cod"));
	   	 request.setAttribute("Especialista", serviEspecialista.buscarEspecialista(cod));
	   	 request.getRequestDispatcher("actualizarEspecialista.jsp").forward(request, response); 
		}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom, ape,email,pass,num,naci,ini,fin,dni;
        int espe, sexo;
		nom = request.getParameter("txt_nom");
		ape = request.getParameter("txt_ape");
		email = request.getParameter("txt_email");
		pass = request.getParameter("txt_pass");
		num = request.getParameter("txt_num");
		naci = request.getParameter("txt_naci");
		ini = request.getParameter("txt_ini");
		fin = request.getParameter("txt_fin");
		dni = request.getParameter("txt_dni");
		
		espe = Integer.parseInt(request.getParameter("cbo_esp"));
		sexo = Integer.parseInt(request.getParameter("cbo_sexo"));
		
		EspecialistaDTO obj = new EspecialistaDTO();
		obj.setEmail_espe(email);
		obj.setContra_espe(pass);
		obj.setNom_espe(nom);
		obj.setApe_espe(ape);
		obj.setTel_espe(num);
		obj.setId_esp(espe);
		obj.setFec_na(naci);
		obj.setFec_ini(ini);
		obj.setFec_fin(fin);
		obj.setDni_espe(dni);
		obj.setSexo_espe(sexo);

		serviEspecialista.registrarEspecialista(obj);
		listar(request,response);
		
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pass,num,naci,ini,fin,dni;
        int espe, sexo;
		String cod, email, contra,nom, ape, tel;
		cod = request.getParameter("txt_cod");
		nom = request.getParameter("txt_nom");
		ape = request.getParameter("txt_ape");
		email = request.getParameter("txt_email");
		pass = request.getParameter("txt_pass");
		num = request.getParameter("txt_num");
		naci = request.getParameter("txt_naci");
		ini = request.getParameter("txt_ini");
		fin = request.getParameter("txt_fin");
		dni = request.getParameter("txt_dni");
		
		espe = Integer.parseInt(request.getParameter("cbo_esp"));
		sexo = Integer.parseInt(request.getParameter("cbo_sexo"));
		
		EspecialistaDTO obj = new EspecialistaDTO();
		obj.setId_espe(Integer.parseInt(cod));
		obj.setEmail_espe(email);
		obj.setContra_espe(pass);
		obj.setNom_espe(nom);
		obj.setApe_espe(ape);
		obj.setTel_espe(num);
		obj.setId_esp(espe);
		obj.setFec_na(naci);
		obj.setFec_ini(ini);
		obj.setFec_fin(fin);
		obj.setDni_espe(dni);
		obj.setSexo_espe(sexo); 

		serviEspecialista.actualizarEspecialista(obj);
		listar(request,response);
    }
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
    	serviEspecialista.eliminarEspecialista(cod);
    	listar(request,response);
	}

}
