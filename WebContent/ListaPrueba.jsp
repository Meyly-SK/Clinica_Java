<%@page import="beans.PruebaDTO"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles/dashboard.css">

</head>

<body>
    <div class="container-fluid">
        <div class="row justify-content-center align-content-center">
            <div class="col-8 barra">
                <h4 class="text-light">NEW WEST</h4>
            </div>
            <div class="col-4 text-right barra">
                <ul class="navbar-nav mr-auto">
                    <li>
                        <a href="#" class="px-3 text-light perfil dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-circle user"></i></a>

                        <div class="dropdown-menu" aria-labelledby="navbar-dropdown">
                            <a class="dropdown-item menuperfil cerrar" href="#"><i class="fas fa-sign-out-alt m-1"></i>Salir
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="barra-lateral col-12 col-sm-auto">
                <nav class="menu d-flex d-sm-block justify-content-center flex-wrap">
                    <a href="ClienteDashboard.jsp"><i class="fas fa-home"></i><span>Inicio</span></a>
                    <a href="ServletCita?tipo=listarCliente"><i class="fas fa-home"></i><span>Gestionar Cita</a></span></a>
                    <a href="ServletPrueba?tipo=listarPrueba&cod=${dato.id_cliente}"><i class="fas fa-home"></i><span>Pruebas Asignadas</span></a>
                    <a href="ServletInforme?tipo=listarInforme&cod=${dato.id_cliente}"><i class="fas fa-home"></i><span>Ver Informes</span></a>
                </nav>
            </div>
            <main class="main col">
                <div class="row justify-content-center align-content-center text-center">
                    <div class="columna col-lg-6">
                        CONTENIDO
                        
<%
  	List<PruebaDTO> da = (List<PruebaDTO>) request.getAttribute("data");
  %>

   <h2 align="center">PRUEBAS</h2>

   <p align="center">

   <table border="2" align="center" width="75%">

      <tr>

         <th>CÓDIGO</th>

         <th>CAUSA</th>
         
         <th>FECHA</th>
                    
         <th colspan="4">ACCIONES</th>

      </tr>

      <%
      	if (da != null) {

                           for (PruebaDTO a : da) {
      %>

      <tr>

         <td><%=a.getId_prueba()%></td>

         <td><%=a.getCau_prueba()%></td>

         <td><%=a.getFec_prueba()%></td>
                 
         <td colspan="2" align="center"><a
				target="_blank" href="ServletPrueba?tipo=buscarPrueba&cod=<%=a.getId_prueba()%>"> <img
					title="Ver" src="img/vista2.png"></a>
		 </td>

    

      </tr>

      <%   }

   }

%>



   </table>
                    </div>

                </div>

            </main>
        </div>
    </div>





    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/646c794df3.js"></script>
</body>

</html>