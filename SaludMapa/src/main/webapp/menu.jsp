<jsp:include page="validar.jsp" />
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Administrador</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
</head>
<body>
<%
	HttpSession sesion = request.getSession(true); 
%>
<div class="w3-container w3-teal">
  <h3>HEALTH MAP</h3>
  <h4>Bienvenido: <%=sesion.getAttribute("usuarioAcceso") %></h4>
</div>
<div class="w3-bar w3-black">
  <a href="http://localhost:8089/SaludMapa/menu.jsp" class="w3-bar-item w3-button">Inicio</a>
  <a href="http://localhost:8089/SaludMapa/country.jsp" class="w3-bar-item w3-button">Country</a>
  <a href="http://localhost:8089/SaludMapa/CRUDIndicador.jsp" class="w3-bar-item w3-button">Indicador Salud</a>
  <a href="http://localhost:8089/SaludMapa/CRUDData.jsp" class="w3-bar-item w3-button">Data</a>
   <a href="http://localhost:8089/SaludMapa/index.jsp?estado=2" class="w3-bar-item w3-button">Salir</a>
</div>
<hr>
  
</body>
</html>