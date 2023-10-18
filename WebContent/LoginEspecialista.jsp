<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"  content="text/html";  charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/estilo_login.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lexend&display=swap" rel="stylesheet">
<title>Login</title>
</head>
<body class="body">
<%
   String x = (String) request.getAttribute("msj");
   String a = "";
   if(x != null)
	   a = x;
%>
    <div class="login-principal">
        <h2>ESPECIALISTA</h2>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing 
                elit.
            </p>
            <form class="frm-box" action="ServletEspecialista?tipo=login" name="frmsesion" method="post"> 
                <label id="nom"for="nombre"> <strong>Email</strong></label>
                <br>
                <input id="nombre" type="text" name="txtLogin" placeholder="ingrese su Email"> 
                <br>
                <label id="pas"for="pass"> <strong>Contraseña</strong></label>
                <br>
                <input id="pass" type="password" name="txtPass" placeholder="ingrese contraseña" >
                <br>
                <button id="btn-login">Login</button>
                <h5 align="center"><%=a%></h5>
            </form>
    </div>
    <button id="btnIntranet" onclick="location.href='LoginAdmin.jsp'">ADMINISTRADOR</button>  
</body>
</html>