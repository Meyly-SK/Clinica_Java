package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CitaDTO;
import beans.ClienteDTO;
import beans.PruebaDTO;
import service.PruebaService;

/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	PruebaService serviPrueba = new PruebaService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrueba() {
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
        
        if (tipo.equals("listarPrueba"))

            listarCliente(request, response); 

        else if (tipo.equals("registrar"))

           registrar(request, response);

        else if (tipo.equals("buscar"))

           buscar(request, response);
        
        else if (tipo.equals("buscarPrueba"))

            buscarPrueba(request, response);
       
        else if (tipo.equals("actualizar"))

           actualizar(request, response);

        else if (tipo.equals("eliminar"))

           eliminar(request, response); 

     }
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("data", serviPrueba.listaPrueba());
        request.getRequestDispatcher("PruebaLista.jsp").forward(request, response);
     }
	private void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("data", serviPrueba.listaPruebaxCliente(cod));
        request.getRequestDispatcher("ListaPrueba.jsp").forward(request, response);
     }
    
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cau, fec,obs;
        int cli,espe,esp;
		cau = request.getParameter("txt_causa");
		fec = request.getParameter("txt_fec");
		obs = request.getParameter("txt_obs");
		
		cli = Integer.parseInt(request.getParameter("cbo_cli"));
		espe = Integer.parseInt(request.getParameter("txt_espe"));
		esp = Integer.parseInt(request.getParameter("txt_esp"));
		
		
		PruebaDTO obj = new PruebaDTO();
		obj.setCau_prueba(cau);
		obj.setFec_prueba(fec);
		obj.setObs_prueba(obs);
		obj.setId_cliente(cli);
		obj.setId_espe(espe);
		obj.setId_esp(esp);
		
		serviPrueba.registrarPrueba(obj);
		listar(request,response);
		
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	int cod = Integer.parseInt(request.getParameter("cod"));
    	serviPrueba.eliminarPrueba(cod);
    	listar(request,response);

     }
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cau, fec, obs;
   	 int cli,espe,esp; 
   	 int cod;
   	 
   	 	cod = Integer.parseInt(request.getParameter("txt_cod"));
   	 
		cau = request.getParameter("txt_causa");
		fec = request.getParameter("txt_fec");
		obs = request.getParameter("txt_obs");
   	 
		cli = Integer.parseInt(request.getParameter("cbo_cli"));
		espe = Integer.parseInt(request.getParameter("txt_espe"));
		esp = Integer.parseInt(request.getParameter("txt_esp"));
  	  
  	  PruebaDTO obj = new PruebaDTO();
  	  obj.setId_prueba(cod);
  	  obj.setCau_prueba(cau);
  	  obj.setFec_prueba(fec);
  	  obj.setObs_prueba(obs);
  	  obj.setId_cliente(cli);
  	  obj.setId_espe(espe);
  	  obj.setId_esp(esp);
  	
  	  System.out.println("Causa :" + obj.getCau_prueba());
  	  serviPrueba.actualizarPrueba(obj);
  	  listar(request,response);
       
    }
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 int cod = Integer.parseInt(request.getParameter("cod"));
   	 request.setAttribute("Prueba", serviPrueba.buscarPrueba(cod));
   	 request.getRequestDispatcher("actualizarPrueba.jsp").forward(request, response); 

    }
	private void buscarPrueba(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	 int cod = Integer.parseInt(request.getParameter("cod"));
	   	 request.setAttribute("Prueba", serviPrueba.buscarPrueba(cod));
	   	 request.getRequestDispatcher("VerPrueba.jsp").forward(request, response); 

	    }

}
