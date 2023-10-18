<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>
     Primer JSP
      </h1>
     Hola Alumnos!! la fecha del sistema es: <%= new java.util.Date() %>
 <h1>
 Ejemplo de expresiones
 </h1>
 Convirtiendo a mayusculas : <%= new String("juan").toUpperCase() %>
 <br>
 La suma de 5 y 7 es : <%=5 + 7 %>
 <br>
 10 es mayor que 100: <%= 10>100 %>
 <br>
 <h1>Ejemplo 2 Scriplets</h1>
 <%
    for (int i =  0; i<10;i++){
    	out.println(" <br> Este es el mensaje " + i);
    } 
 %>
 <br>
 <h1 style= "text-align:center">Ejemplo 3 Declaraciones</h1>
 <%!
    private int resultado;
 
 	public int metodoSuma(int num1, int num2){
 		resultado = num1 + num2;
 		return resultado;
 	}
 	
 	public int metodoRest(int num1, int num2){
 		resultado = num1 - num2;
 		return resultado;
 	}
 	
 	public int metodoMultiplica(int num1, int num2){
 		resultado = num1 + num2;
 		return resultado;
 	}
 	
 %>
 
 El resultado de la suma es: <%= metodoSuma(7,5) %>
 <br>
 El resultado de la resta es: <%= metodoRest(7,5) %>
 <br>
 El resultado de la multiplicacion es: <%= metodoMultiplica(7,5) %>
 </body>
</html>