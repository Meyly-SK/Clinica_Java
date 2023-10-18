<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.InformeR"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ArrayList<InformeR> datos = new ArrayList<InformeR>();
	Class.forName("com.mysql.jdbc.Driver");
	try{
		Connection miCX = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_newest","root","mysql");
		Statement miStatement = miCX.createStatement();
		String comandoSQL = "SELECT id_informe i, causa_informe i, sintoma_informe i, fec_sintoma i, diag_informe i, fec_diag i,obser_informe i, nom_cliente c, nom_espe e from Informe i " + 
				" JOIN cliente c on c.id_cliente = i.id_cliente " + 
				" JOIN especialista e on e.id_espe = i.id_especialista;";
		ResultSet rs = miStatement.executeQuery(comandoSQL);
		while (rs.next()){
			datos.add(new InformeR(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getString(8),
					rs.getString(9)
					));
		}
		rs.close();
		miCX.close();
	}
	catch (Exception e){
		out.println("Ocurrio un error!!!!!");
	}
	pageContext.setAttribute("losInformes", datos);

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
<td>Sintoma</td>
<td>Fecha de Sintomas</td>
<td>Diagnostico</td>
<td>Fecha de Diagnostico</td>
<td>Observacion</td>
<td>Cliente</td>
<td>Especialista</td>
</tr>
<c:forEach var="InformeTemporal" items="${losInformes}">
<tr>
<td>${InformeTemporal.id_info}</td> 
<td>${InformeTemporal.causa_info}</td> 
<td>${InformeTemporal.sintoma_info}</td> 
<td>${InformeTemporal.fec_sintoma}</td> 
<td>${InformeTemporal.diag_info}</td> 
<td>${InformeTemporal.fec_diag}</td> 
<td>${InformeTemporal.obs_informe}</td> 
<td>${InformeTemporal.nom_cliente}</td> 
<td>${InformeTemporal.nom_espe}</td> 

</tr>
</c:forEach>

</table>
</div>

</body>
</html>