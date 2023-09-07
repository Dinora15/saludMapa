<jsp:include page="validar.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.lang.String, unedMasterJavaModelo.*, unedMasterControlador.*,java.util.List, java.util.Iterator, java.util.ArrayList" %>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Country</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
</head>
<body>
<%
	HttpSession sesion = request.getSession(true); 
%>
<c:choose>
	<c:when test="${!empty param.estadobbdd}">
		<c:choose>
  			<c:when test="${param.estadobbdd == 'addok'}">
    			<c:set var="estadogestion" value="Insert realizado correctamente"/>
  			</c:when>
  			<c:when test="${param.estadobbdd == 'addnook'}">
    			<c:set var="estadogestion" value="Insert no realizado: Formato incorrecto"/>
  			</c:when>
  			<c:when test="${param.estadobbdd == 'addexiste'}">
    			<c:set var="estadogestion" value="Insert no realizado: Pa’s existente"/>
  			</c:when>
  			<c:when test="${param.estadobbdd == 'upok'}">
    			<c:set var="estadogestion" value="Update realizado correctamente"/>
  			</c:when>
  			<c:when test="${param.estadobbdd == 'upnook'}">
    			<c:set var="estadogestion" value="Update no realizado: Formato incorrecto"/>
  			</c:when>
  			<c:when test="${param.estadobbdd == 'upnoexiste'}">
    			<c:set var="estadogestion" value="Update no realizado: Pa’s inexistente"/>
  			</c:when>
  			<c:when test="${param.estadobbdd == 'delok'}">
    			<c:set var="estadogestion" value="Delete realizado correctamente"/>
  			</c:when>
  			<c:when test="${param.estadobbdd == 'delnook'}">
    			<c:set var="estadogestion" value="Delete no realizado: Formato incorrecto"/>
  			</c:when>
  			<c:when test="${param.estadobbdd == 'delnoexiste'}">
    			<c:set var="estadogestion" value="Delete no realizado: Pa’s inexistente"/>
  			</c:when>
  			<c:otherwise>
    			<c:set var="estadogestion" value="Estado gestion erroneo"/>
  			</c:otherwise>
		</c:choose>
	</c:when>
  	<c:otherwise>
    	<c:set var="estadogestion" value="ÀQue gestion de bbdd hacer?"/>
  	</c:otherwise>
</c:choose>
<div class="w3-container w3-teal">
  <h3>HEALTH MAP</h3>
  <h4>Country</h4>
</div>
<div class="w3-bar w3-black">
  <a href="http://localhost:8089/SaludMapa/menu.jsp" class="w3-bar-item w3-button">Inicio</a>
  <a href="http://localhost:8089/SaludMapa/country.jsp" class="w3-bar-item w3-button">Country</a>
  <a href="http://localhost:8089/SaludMapa/CRUDIndicador.jsp" class="w3-bar-item w3-button">Indicador Salud</a>
  <a href="http://localhost:8089/SaludMapa/CRUDData.jsp" class="w3-bar-item w3-button">Data</a>
   <a href="http://localhost:8089/SaludMapa/index.jsp?estado=2" class="w3-bar-item w3-button">Salir</a>
</div>
<hr>
<div class="w3-row">
  <div class="w3-col m5 l3">
  <div class="w3-container w3-blue w3-border">
  <h4>Ingresar Nuevo Pais</h4>
</div>

<form class="w3-container" name="Country-form"  action="./administracion" method="get">
  <p>
  <label>Codigo</label>
  <input class="w3-input w3-border" type="text" name="country_code_agregar"></p>
  <p>
  <label>Nombre</label>
  <input class="w3-input w3-border" type="text" name="country_name_agregar"></p>
  <p>
   <input type="submit" class="w3-button w3-black" name="Agregar_Country" value="Agregar">
</form>    
  </div>
  <div class="w3-col m2 l9">
    
  </div>
   <div class="w3-col m5 l9">
    <div class="w3-container w3-blue w3-border">
  <h4>Actualizar Pais</h4>
</div>

<form class="w3-container" name="Country-form"  action="./administracion" method="get">
  <p>
  <label>Codigo</label>
  <input class="w3-input w3-border" type="text" name="country_code_up"></p>
  <p>
  <label>Nombre</label>
  <input class="w3-input w3-border" type="text" name="country_name_up"></p>
  <p>
   <input type="submit" class="w3-button w3-black" name="Actualizar_Country" value="Actualizar">
</form>    
  </div>
</div>
<hr>

<table class="w3-table">
<tr>
  <th>Codigo Pais</th>
  <th>Nombre Pais</th>  
  <th>Eliminar</th>
</tr>
<c:forEach items="${countryList}" var="paises">
  			<tr>
            	<td> <c:out value="${paises.country_name}" /> </td>
                <td> <c:out value="${paises.country_code}" /> </td>               
                <td>
                 <form action="./administracion"method="get">
        <input type="submit"  name="Eliminar_Country" value="Eliminar" />
         <input type="hidden" name="eliminar"  value="${paises.country_code}" />
               </form> 
                </td>
</tr>
</c:forEach>
</table>
<hr>

<c:if test="${currentpageno>1}">  
       <a href="page?currentpageno=1" class="w3-button"> 1 </a>  
       <a href="page?currentpageno=${currentpageno-1}" class="w3-button"> < </a>
       <a href="page?currentpageno=${currentpageno+1}" class="w3-button"> > </a>
       <a href="page?currentpageno=${totalPage}" class="w3-button"> >> </a>
</c:if>
<c:if test="${currentpageno==totalPage}">
	 <a href="page?currentpageno=1" class="w3-button"> 1 </a>  
	 <a href="page?currentpageno=${currentpageno-1}" class="w3-button"> < </a>
</c:if>
<c:if test="${currentpageno==1}">  
       <a href="page?currentpageno=${currentpageno+1}" class="w3-button"> > </a>  
       <a href="page?currentpageno=${totalPage}" class="w3-button"> >> </a>  
</c:if>
<hr>
</body>
</html>