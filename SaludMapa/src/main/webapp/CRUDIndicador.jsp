<jsp:include page="validar.jsp" />
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.lang.String, unedMasterJavaModelo.*, java.util.List, java.util.Iterator, java.util.ArrayList" %>
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CRUD Indicador</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
</head>
<body>

<%
	HttpSession sesion = request.getSession(true); 
%>
<div class="w3-container w3-teal">
  <h3>HEALTH MAP</h3>
  <h4>Health Indicadores</h4>
</div>
<div class="w3-bar w3-black">
  <a href="http://localhost:8089/SaludMapa/menu.jsp" class="w3-bar-item w3-button">Inicio</a>
  <a href="http://localhost:8089/SaludMapa/country.jsp" class="w3-bar-item w3-button">Country</a>
  <a href="http://localhost:8089/SaludMapa/CRUDIndicador.jsp" class="w3-bar-item w3-button">Indicador Salud</a>
  <a href="http://localhost:8089/SaludMapa/CRUDData.jsp" class="w3-bar-item w3-button">Data</a>
   <a href="http://localhost:8089/SaludMapa/index.jsp?estado=2" class="w3-bar-item w3-button">Salir</a>
</div>
<hr></hr>
<div class="w3-row">
  <div class="w3-col m5 l3">
  <div class="w3-container w3-blue w3-border">
  <h4>Ingresar Nuevo Indicador</h4>
</div>
<form class="w3-container" action="./HealthIndicadores" method="get">
  <p>
  <label>Codigo Indicador</label>
  <input class="w3-input w3-border" type="text" name="indicadorcode"/></p>
  <p>
  <label>Nombre Indicador</label>
  <input class="w3-input w3-border" type="text" name="indicadorname"/></p>
  <p>
  <label>Source Nota</label>
  <input class="w3-input w3-border" type="text" name="indicadorsourcenota"/></p>
   <p>
  <label>Source Organization</label>
  <input class="w3-input w3-border" type="text" name="indicadorsourceorganization"/></p>
  <p>
   <input type="submit" class="w3-button w3-black" name="Agregar_Indicador" value="Agregar"/></p>
</form>  
</div>   
  <div class="w3-col m2 l9">
    
  </div>
   <div class="w3-col m5 l9">
    <div class="w3-container w3-blue w3-border">
  <h4>Actualizar Indicador</h4>
</div>
<form class="w3-container" id="edit"  name="editindicator"  action="./HealthIndicadores" method="get">
  <p>
  <label>Codigo Indicador</label>
  <input class="w3-input w3-border" type="text" name="actualizarindicadorcode"/></p>
  <p>
  <label>Nombre Indicador</label>
  <input class="w3-input w3-border" type="text" name="actualizarindicadorname"/></p>
  <p>
  <label>Source Nota</label>
  <input class="w3-input w3-border" type="text" name="actualizarindicadorsourcenota"/></p>
   <p>
  <label>Source Organization</label>
  <input class="w3-input w3-border" type="text" name="actualizarindicadorsourceorganization"/></p>
  <p>
   <input type="submit" class="w3-button w3-black" name="Actualizar_Indicador" value="Actualizar"/></p>
</form>  
  </div>
</div>
<hr></hr>
<table class="w3-table">
  <tr>
     <th>INDICADOR_CODE</th>
     <th>INDICADOR_NAME</th>
     <th>SOURCE_NOTE</th>
     <th>SOURCE_ORGANIZATION</th>
     <th>Eliminar</th>
  </tr>
  <tr>
</tr>
<c:forEach items="${listadoIndicadores1}" var="indicadores">
<tr>
<td><c:out value="${indicadores.indicadores_code}" /></td>
<td><c:out value="${indicadores.indicadores_name}" /></td>
<td><c:out value="${indicadores.source_note}" /></td>
<td><c:out value="${indicadores.source_organization}" /></td>
<td>
 <form action="./HealthIndicadores"method="get">
        <input type="submit"  name="Eliminar_indicador" value="Eliminar" />
         <input type="hidden" name="eliminar"  value="${indicadores.indicadores_code}" />
        </form>
</td>
</tr>
</c:forEach>
</table>
<hr></hr>

<c:if test="${currentpageno>1}">  
       <a href="pag?currentpageno=1" class="w3-button"> 1 </a>  
       <a href="pag?currentpageno=${currentpageno-1}" class="w3-button"> < </a>
       <a href="pag?currentpageno=${currentpageno+1}" class="w3-button"> > </a>
       <a href="pag?currentpageno=${totalPage}" class="w3-button"> >> </a>
</c:if>
<c:if test="${currentpageno==totalPage}">
	 <a href="pag?currentpageno=1" class="w3-button"> 1 </a>  
	 <a href="pag?currentpageno=${currentpageno-1}" class="w3-button"> < </a>
</c:if>
<c:if test="${currentpageno==1}">  
       <a href="pag?currentpageno=${currentpageno+1}" class="w3-button"> > </a>  
       <a href="pag?currentpageno=${totalPage}" class="w3-button"> >> </a>  
</c:if>
 
 
 



</body>
</html>