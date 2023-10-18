package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.InformeDTO;
import service.InformeService;

/**
 * Servlet implementation class ServletInforme
 */
@WebServlet("/ServletInforme")
public class ServletInforme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InformeService serviInforme = new InformeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInforme() {
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
        
        else if (tipo.equals("listarInforme"))

            listarCliente(request, response);

        else if (tipo.equals("buscar"))

           buscar(request, response);
        
        else if (tipo.equals("buscarInforme"))

            buscarInforme(request, response);

        else if (tipo.equals("actualizar"))

           actualizar(request, response);

        else if (tipo.equals("eliminar"))

           eliminar(request, response); 
        
        else if (tipo.equals("listarDash"))

            eliminar(request, response); 

     }
    
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("data", serviInforme.listaInforme());
        request.getRequestDispatcher("InformeLista.jsp").forward(request, response);
     }
    
    private void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
        request.setAttribute("data", serviInforme.listaInformexCliente(cod));
        request.getRequestDispatcher("ListaInforme.jsp").forward(request, response);
     }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	int cod = Integer.parseInt(request.getParameter("cod"));
    	serviInforme.eliminarInforme(cod);
    	listar(request,response);

     }



     private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String causa,sintoma,fecSintoma,Diag,fecDiag,obsInfo;
    	 int cli,espe,cod;
    	 
    	 causa = request.getParameter("txt_causa");
    	 sintoma = request.getParameter("txt_sintoma");
    	 fecSintoma = request.getParameter("txt_fecSin");
    	 Diag = request.getParameter("txt_diag");
    	 fecDiag = request.getParameter("txt_fecDiag");
    	 obsInfo = request.getParameter("txt_obs");
    	 
    	 cod= Integer.parseInt(request.getParameter("txt_cod"));
   	  	 cli = Integer.parseInt(request.getParameter("cbo_cli"));
   	     espe = Integer.parseInt(request.getParameter("txt_espe"));
   	  
   	  InformeDTO obj = new InformeDTO();
   	  obj.setId_info(cod);
   	  obj.setCausa_info(causa);
   	  obj.setSintoma_info(sintoma);
   	  obj.setFec_sintoma(fecSintoma);
   	  obj.setDiag_info(Diag);
   	  obj.setFec_diag(fecDiag);
   	  obj.setObs_informe(obsInfo);
   	  obj.setId_cliente(cli);
   	  obj.setId_espe(espe);
   	  
   	  serviInforme.actualizarInforme(obj);
   	  listar(request,response);
        
     }



     private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int cod = Integer.parseInt(request.getParameter("cod"));
    	 request.setAttribute("Informe", serviInforme.buscarInforme(cod));
    	 request.getRequestDispatcher("actualizarInforme.jsp").forward(request, response); 

     }

  private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  String causa,sintoma,fecSintoma,Diag,fecDiag,obsInfo;
 	 int cli,cod;
 	 
 	 causa = request.getParameter("txt_causa");
 	 sintoma = request.getParameter("txt_sintoma");
 	 fecSintoma = request.getParameter("txt_fecSin");
 	 Diag = request.getParameter("txt_diag");
 	 fecDiag = request.getParameter("txt_fecDiag");
 	 obsInfo = request.getParameter("txt_obs");
 	 
	  	 cli = Integer.parseInt(request.getParameter("cbo_cli"));
	     int espe = Integer.parseInt(request.getParameter("txt_espe"));
	  
	     InformeDTO obj = new InformeDTO();
	   	  obj.setCausa_info(causa);
	   	  obj.setSintoma_info(sintoma);
	   	  obj.setFec_sintoma(fecSintoma);
	   	  obj.setDiag_info(Diag);
	   	  obj.setFec_diag(fecDiag);
	   	  obj.setObs_informe(obsInfo);
	   	  obj.setId_cliente(cli);
	   	  obj.setId_espe(espe);
	  
	  serviInforme.registrarInforme(obj);
	  listar(request,response);
	  
	  
  }
  private void buscarInforme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	 int cod = Integer.parseInt(request.getParameter("cod"));
	   	 request.setAttribute("Informe", serviInforme.buscarInforme(cod));
	   	 request.getRequestDispatcher("VerInforme.jsp").forward(request, response); 

	    }


}
