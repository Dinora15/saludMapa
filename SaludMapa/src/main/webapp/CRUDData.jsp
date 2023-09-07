<jsp:include page="validar.jsp" />
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.lang.String, unedMasterJavaModelo.*, java.util.List, java.util.Iterator, java.util.ArrayList" %>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Data</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
</head>
<body>

<%
	HttpSession sesion = request.getSession(true); 


%>
<div class="w3-container w3-teal">
  <h3>HEALTH MAP</h3>
  <h4>Data</h4>
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
  <h4>Agregar Nueva Data</h4>
</div>

<form class="w3-container" action="./Data" method="get">
  <p>
  <label>Codigo Indicador</label>
  <input class="w3-input w3-border" type="text" name="indicadorcode"/></p>
  <p>
  <label>Codigo Pais</label>
  <input class="w3-input w3-border" type="text" name="countrycode"/></p>
  <p>
  <label>Ano</label>
  <input class="w3-input w3-border" type="text" name="year"/></p>
  <p>
   <input type="submit" class="w3-button w3-black" name="Agregar_Data" value="Agregar"/></p>
</form>    
  </div>
  <div class="w3-col m2 l9">
    
  </div>
   <div class="w3-col m5 l9">
    <div class="w3-container w3-blue w3-border">
  <h4>Actualizar Data</h4>
</div>

<form class="w3-container" name="editData"  action="./Data" method="get" >
  <p>
  <label>Codigo Indicador</label>
  <input class="w3-input w3-border" type="text" name="actualizarindicadorcode"/></p>
  <p>
  <label>Codigo Pais</label>
  <input class="w3-input w3-border" type="text" name="actualizarcountrycode"/></p>
  <p>
  <label>Ano</label>
  <input class="w3-input w3-border" type="text" name="actualizaryear"/></p>
  <p>
   <input type="submit" class="w3-button w3-black" name="Actualizar_Data" value="Actualizar" /></p>
</form>    
  </div>
</div>
<hr>
<table class="w3-table">

<tr>
   <th>INDICADOR</th>
     <th>CODIGO PAIS</th>
     <th>ANO</th>
     <th>Eliminar</th>
</tr>
<tr>
</tr>
 <c:forEach items="${dataList}" var="datas">
  			<tr>
            	<td> <c:out value="${datas.indicador_code}" /> </td>
                <td> <c:out value="${datas.country_code}" /> </td>
                <td> <c:out value="${datas.year}" /> </td>
 
 <td>
    <form action="./Data"method="get">
        <input type="submit" class="button" name="Eliminar_Data" value="Eliminar" />
         <input type="hidden" name="eliminar" value="${datas.country_code}" />
         
    </form>
</td>
</tr> 
</c:forEach> 
</table>
<hr>

<c:if test="${currentpageno>1}">  
       <a href="pages?currentpageno=1" class="w3-button"> 1 </a>  
       <a href="pages?currentpageno=${currentpageno-1}" class="w3-button"> < </a>
       <a href="pages?currentpageno=${currentpageno+1}" class="w3-button"> > </a>
       <a href="pages?currentpageno=${totalPage}" class="w3-button"> >> </a>
</c:if>
<c:if test="${currentpageno==totalPage}">
	 <a href="pages?currentpageno=1" class="w3-button"> 1 </a>  
	 <a href="pages?currentpageno=${currentpageno-1}" class="w3-button"> < </a>
</c:if>
<c:if test="${currentpageno==1}">  
       <a href="pages?currentpageno=${currentpageno+1}" class="w3-button"> > </a>  
       <a href="pages?currentpageno=${totalPage}" class="w3-button"> >> </a>  
</c:if>
</body>
</html>