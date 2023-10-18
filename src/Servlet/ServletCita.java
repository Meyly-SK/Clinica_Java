package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CitaDTO;
import service.CitaService;

/**
 * Servlet implementation class ServletCita
 */
@WebServlet("/ServletCita")
public class ServletCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CitaService serviCita = new CitaService();

    public ServletCita() {
        super();

    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if (tipo.equals("listar"))

           listar(request, response);
        
        if (tipo.equals("listarCliente"))

            listarCliente(request, response);

        else if (tipo.equals("registrar"))

           registrar(request, response);
        
        else if (tipo.equals("registrarxCliente"))

            registrarxCliente(request, response);

        else if (tipo.equals("buscar"))

           buscar(request, response);
        
        else if (tipo.equals("buscarxCliente"))

            buscarxCliente(request, response);

        else if (tipo.equals("actualizar"))

           actualizar(request, response);
        
        else if (tipo.equals("actualizarxCliente"))

            actualizarxCliente(request, response);

        else if (tipo.equals("eliminar"))

           eliminar(request, response); 
        
        else if (tipo.equals("eliminarxCliente"))

            eliminarxCliente(request, response); 
        
        else if (tipo.equals("listarDash"))

            eliminar(request, response); 

     }
    
    private void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("data", serviCita.listaCita());
        request.getRequestDispatcher("ListaCita.jsp").forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("data", serviCita.listaCita());
        request.getRequestDispatcher("PagLista.jsp").forward(request, response);
     }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	int cod = Integer.parseInt(request.getParameter("cod"));
    	serviCita.eliminarCita(cod);
    	listar(request,response);

     }
    private void eliminarxCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	int cod = Integer.parseInt(request.getParameter("cod"));
    	serviCita.eliminarCita(cod);
    	listarCliente(request,response);

     }



     private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int cli,esp,cod;
    	 cod= Integer.parseInt(request.getParameter("txt_cod"));
   	  	 cli = Integer.parseInt(request.getParameter("cbo_cli"));
   	     esp = Integer.parseInt(request.getParameter("cbo_esp"));
   	     String fec = request.getParameter("txt_fec");
   	  
   	  CitaDTO obj = new CitaDTO();
   	  obj.setId_cita(cod);
   	  obj.setId_cli(cli);
   	  obj.setId_esp(esp);
   	  obj.setFec_cita(fec);
   	  
   	  serviCita.actualizarCita(obj);
   	  listar(request,response);
        
     }
     private void actualizarxCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int cli,esp,cod;
    	 cod= Integer.parseInt(request.getParameter("txt_cod"));
   	  	 cli = Integer.parseInt(request.getParameter("cbo_cli"));
   	     esp = Integer.parseInt(request.getParameter("cbo_esp"));
   	     String fec = request.getParameter("txt_fec");
   	  
   	  CitaDTO obj = new CitaDTO();
   	  obj.setId_cli(cli);
   	  obj.setId_esp(esp);
   	  obj.setFec_cita(fec);
   	  obj.setId_cita(cod);
   	  
   	  serviCita.actualizarCita(obj);
   	  listarCliente(request,response);
        
     }



     private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int cod = Integer.parseInt(request.getParameter("cod"));
    	 request.setAttribute("Cita", serviCita.buscarCita(cod));
    	 request.getRequestDispatcher("actualizarCita.jsp").forward(request, response); 

     }
     private void buscarxCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int cod = Integer.parseInt(request.getParameter("cod"));
    	 request.setAttribute("Cita", serviCita.buscarCita(cod));
    	 request.getRequestDispatcher("actualizarCitaCliente.jsp").forward(request, response); 

     }

  private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  int cli,esp;
	  cli = Integer.parseInt(request.getParameter("cbo_cli"));
	  esp = Integer.parseInt(request.getParameter("cbo_esp"));
	  String fec = request.getParameter("txt_fec");
	  
	  CitaDTO obj = new CitaDTO();
	  obj.setId_cli(cli);
	  obj.setId_esp(esp);
	  obj.setFec_cita(fec);
	  
	  serviCita.registrarCita(obj);
	  listar(request,response);
	  
	  
  }
  private void registrarxCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  int cli,esp;
	  cli = Integer.parseInt(request.getParameter("cbo_cli"));
	  esp = Integer.parseInt(request.getParameter("cbo_esp"));
	  String fec = request.getParameter("txt_fec");
	  
	  CitaDTO obj = new CitaDTO();
	  obj.setId_cli(cli);
	  obj.setId_esp(esp);
	  obj.setFec_cita(fec);
	  
	  serviCita.registrarCita(obj);
	  listarCliente(request,response);
	  
	  
  }



}
