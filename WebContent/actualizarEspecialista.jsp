<%@page import="beans.EspecialistaDTO"%>

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
                        MODIFICAR ESPECIALISTA
                        <%
		EspecialistaDTO obj = (EspecialistaDTO) request.getAttribute("Especialista");
	%>
	<form action="ServletEspecialista?tipo=actualizar" id="frmactualizar" 
		method="post">
		
		<label>ID</label>
		<input  name="txt_cod"
			value="${requestScope.Especialista.id_espe}">
			<br>
				
				<label>Nombre</label>
			   <input type="text" name="txt_nom" value="${requestScope.Especialista.nom_espe}">
				<br>
				<label>Apellido</label>
				<input type="text" name="txt_ape" value="${requestScope.Especialista.ape_espe}">
				<br>
				<label>Numero</label>
				<input type="number" name="txt_tel" value="${requestScope.Especialista.tel_espe}">
				<br>
				 
				<label>DNI</label>
				<input type="number" name="txt_dni" value="${requestScope.Especialista.dni_espe}">
				<br>
				<label>Email</label>
				<input type="text" name="txt_email" value="${requestScope.Especialista.email_espe}">
				<br>
				<label>Contraseña</label>
				<input type="password" name="txt_contra" value="${requestScope.Especialista.contra_espe}">
				<br>
				<label>Especialidad</label>
				<select name="cbo_esp">
						<%
							 String marca[] = { "", "Cardiologia", "Cirujia", "Dermatologia","Ginecologia","General" };
						String estado = "";
						for (int i = 1; i < marca.length; i++) {
							System.out.println("Objeto:" + obj.getNom_esp());
							System.out.println("Arreglo:" + marca[i]);
							if (Integer.parseInt(obj.getNom_esp()) == i) {
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
				</select>
				<br>
				<label>Fecha de Nacimiento</label>
				<br>
				<input type="date" name="txt_naci" value="${requestSocpe.Especialista.fec_na}" class="required">
				<br>
				<label>Fecha de Inicio</label>
				<br>
				<input type="date" name="txt_ini" value="${requestSocpe.Especialista.fec_ini}" class="required">
				<br>
				<label>Fecha Final</label>
				<br>
				<input type="date" name="txt_fin" value="${requestSocpe.Especialista.fec_fin}" class="required">
				<br>
				<label>Sexo</label>
				<select name="cbo_sexo">
						<%
							String marca1[] = { "","Masculino","Femenino" };
						String estado1 = "";
						for (int i = 1; i < marca1.length; i++) {
							System.out.println("Objeto:" + obj.getNom_sexo());
							System.out.println("Arreglo:" + marca1[i]);
							if (Integer.parseInt(obj.getNom_sexo()) == i) {
								System.out.println("En selección");
								estado1 = "selected";
							} else {
								estado1 = "";
							}
						%>
						<option value="<%=i%>" <%=estado1%>>
							<%=marca1[i]%></option>
						<%
	}
%>
				</select>
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