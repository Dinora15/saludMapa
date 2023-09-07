<% 
	if (session.getAttribute("usuarioAcceso") == null) {
		request.setAttribute("mensaje", "Debe autenticarse para ingresar al sistema");
		pageContext.forward("index.jsp");
	}
%>