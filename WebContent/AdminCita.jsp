<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.CitaR"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ArrayList<CitaR> datos = new ArrayList<CitaR>();
	Class.forName("com.mysql.jdbc.Driver");
	try{
		Connection miCX = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_newest","root","mysql");
		Statement miStatement = miCX.createStatement();
		String comandoSQL = "select id_cita c, nom_cliente e, nom_esp s, fec_cita from cita c \r\n" + 
         		"join cliente e on e.id_cliente = c.id_cliente\r\n" + 
         		"join especialidad s on s.id_esp = c.id_esp;\r\n" + 
         		"";
		ResultSet rs = miStatement.executeQuery(comandoSQL);
		while (rs.next()){
			datos.add(new CitaR(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)
					));
		}
		rs.close();
		miCX.close();
	}
	catch (Exception e){
		out.println("Ocurrio un error!!!!!");
	}
	pageContext.setAttribute("lasCitas", datos);

%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/pagRep.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lexend&display=swap" rel="stylesheet">
<style>
.cabecera{
	font-weight : bold;
}
</style>
</head>
<body>
<div class="tabla">

<table class="tabla1"  align="center" width="85%">
<tr  class="fila">
<td>Codigo</td>
<td>Cliente</td>
<td>Especialidad</td>
<td>Fecha</td>
</tr>
<c:forEach var="CitaTemporal" items="${lasCitas}">
<tr>
<td>${CitaTemporal.id_cita}</td> 
<td>${CitaTemporal.nom_cita}</td> 
<td>${CitaTemporal.esp_cita}</td> 
<td>${CitaTemporal.fec_cita}</td>
</tr>
</c:forEach>

</table>
</div>

</body>
</html>