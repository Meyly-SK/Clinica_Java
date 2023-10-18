<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.PruebaR"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ArrayList<PruebaR> datos = new ArrayList<PruebaR>();
	Class.forName("com.mysql.jdbc.Driver");
	try{
		Connection miCX = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_newest","root","mysql");
		Statement miStatement = miCX.createStatement();
		String comandoSQL = "select id_prueba p, cau_prueba p,fec_prueba p ,obs_prueba p, nom_cliente c,  nom_espe e, nom_esp s from prueba p " + 
				" join cliente c on c.id_cliente = p.id_cliente " +
				" join especialista e on e.id_espe = p.id_espe " + 
				" inner join especialidad s on s.id_esp = p.id_esp " +
				";";
		ResultSet rs = miStatement.executeQuery(comandoSQL);
		while (rs.next()){
			datos.add(new PruebaR(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7)
					));
		}
		rs.close();
		miCX.close();
	}
	catch (Exception e){
		out.println("Ocurrio un error!!!!!");
	}
	pageContext.setAttribute("lasPruebas", datos);

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
<td>Causa</td>
<td>Fecha de Prueba</td>
<td>Observacion</td>
<td>Cliente</td>
<td>Especialista</td>
<td>Especialidad</td>
</tr>
<c:forEach var="PruebaTemporal" items="${lasPruebas}">
<tr>
<td>${PruebaTemporal.id_prueba}</td> 
<td>${PruebaTemporal.cau_prueba}</td> 
<td>${PruebaTemporal.fec_prueba}</td> 
<td>${PruebaTemporal.obs_prueba}</td> 
<td>${PruebaTemporal.nom_cliente}</td> 
<td>${PruebaTemporal.nom_espe}</td> 
<td>${PruebaTemporal.nom_esp}</td> 
</tr>
</c:forEach>

</table>
</div>

</body>
</html>