<%@page import="beans.PruebaDTO"%>
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
                    <a href="#"><i class="fas fa-home"></i><span>Inicio</span></a>
                    <a href="PagLista.jsp"><i class="fas fa-home"></i><span>Gestionar Cita</a></span></a>
                    <a href="#"><i class="fas fa-home"></i><span>Pruebas Diagnosticas</span></a>
                    <a href="#"><i class="fas fa-home"></i><span>Informes</span></a>
                    <a href="ClienteLista.jsp"><i class="fas fa-home"></i><span>Clientes</span></a>
                    <a href="#"><i class="fas fa-home"></i><span>specialista</span></a>
                    <a href="#"><i class="fas fa-home"></i><span>Vision General</span></a>
                </nav>
            </div>
            <main class="main col">
                <div class="row justify-content-center align-content-center text-center">
                    <div class="columna col-lg-6">
                        PRUEBA 
                        <%
		PruebaDTO obj = (PruebaDTO) request.getAttribute("Prueba");
	%>
	<form action="ServletPrueba?tipo=actualizar" id="frmactualizar"
		method="post">
		
		<label>ID</label>
		<input name="txt_cod" readonly
			value="${requestScope.Prueba.id_prueba}">
			<br>
     	<label>Cliente</label>
				<input type=text value="${Prueba.nom_cliente}" readonly>
				<br>
				<label>Causa</label>
				<input type="text" value="${Prueba.cau_prueba}"name="txt_causa" readonly>
				<br>
				<label>Fecha</label>
				<input type="date" value="${Prueba.fec_prueba}"name="txt_fec" readonly>
				<br>
				<label>Observacion</label>
				<input type="text" value="${Prueba.obs_prueba}"name="txt_obs" readonly>
				<br>		
				<label>ID Especialidad</label>
				<input type="text" name="txt_esp" value="${Prueba.nom_esp}" readonly>
				<br>
				<label>ID Especialista</label>
				<input type="text" name="txt_espe" value="${Prueba.nom_espe}" readonly>
				<br>
	</form>

	</div>
	<script src="https://momentjs.com/downloads/moment.js"></script>
	<script type="text/javascript" src="script/codigo.js"></script>
                        
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