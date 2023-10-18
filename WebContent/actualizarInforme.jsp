<%@page import="beans.InformeDTO"%>
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
                        MODIFICAR INFORME
                        <%
		InformeDTO obj = (InformeDTO) request.getAttribute("Informe");
	%>
	<form action="ServletInforme?tipo=actualizar" id="frmactualizar"
		method="post">
		
		<label>ID</label>
		<br>
		<input name="txt_cod" readonly
			value="${requestScope.Informe.id_info}">
			<br>
     	<label>Cliente</label>
				<select name="cbo_cli">
						<%
							String marca[] = { "", "Andy", "Jeffer", "Andrea" };
						String estado = "";
						for (int i = 1; i < marca.length; i++) {
							System.out.println("Objeto:" + obj.getNom_cliente());
							System.out.println("Arreglo:" + marca[i]);
							if (Integer.parseInt(obj.getNom_cliente()) == i) {
								System.out.println("En selección");
								estado = "selected";
							} else {
								estado = "";
							}
						%>
						<option value="<%=i%>" <%=estado%>>
							<%=marca[i]%></option>
						<%
	}
%>
				</select>>
				<br>
				<label>Especialista</label>
				<input type="text" value="${Especialista.nom_espe}" readonly>
				<br>
				<br>
				<label>ID Especialista</label>
				<input type="text" name="txt_espe" value="${Especialista.id_espe}" readonly>
				<br>
				<label>Causa</label>
				<input type="text" name="txt_causa" value="${requestScope.Informe.causa_info}" >
				<br>
				<label>Sintoma</label>
				<input type="text" name="txt_sintoma" value="${requestScope.Informe.sintoma_info}" >
				<br>
				<label>Fecha Sintoma</label>
				<input type="date" name="txt_fecSin" value="${requestScope.Informe.fec_sintoma}" >
				<br>
				<label>Diagnostico</label>
				<input type="text" name="txt_diag" value="${requestScope.Informe.diag_info}" >
				<br>
				<label>Fecha Diagnostico</label>
				<input type="date" name="txt_fecDiag" value="${requestScope.Informe.fec_diag}" >
				<br>
				<label>Observacion</label>
				<textarea name="txt_obs" ></textarea>
				<br>

				<input type="submit" value="Actualizar">
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