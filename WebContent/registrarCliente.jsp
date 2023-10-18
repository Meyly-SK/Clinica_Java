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
	                </nav>
	            </div>
	            <main class="main col">
	                <div class="row justify-content-center align-content-center text-center">
	                    <div class="columna col-lg-6">
	                        REGISTRO
	                        <div>
			<form action="ServletCliente?tipo=registrar" id=frmagregar method="post">
				<label>Cliente</label> 
				<br>
				<label>Nombre</label> 
				<input type="text" name="txt_nom" class="required">
				<br>
				<label>Apellido</label>
				<input type="text" name="txt_ape" class="required">
				<br>
				<label>Numero</label>
				<input type="number" name="txt_num" class="required">
				<br>
				<label>Email</label>
				<input type="text" name="txt_email" class="required">
				<br>
				<label>Contraseña</label>
				<br>
				<input type="password" name="txt_pass" class="required">
				<br>
					<input type=submit value="registrar">
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