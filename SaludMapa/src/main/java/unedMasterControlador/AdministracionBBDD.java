package unedMasterControlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unedMasterJavaModelo.CountryDbd;

import java.io.IOException;
import java.util.List;

import unedMasterJavaModelo.*;
/**
 * Servlet implementation class AdministracionBBDD
 */
@WebServlet("/administracion")
public class AdministracionBBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CountryDbd countryDbd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministracionBBDD() {
        super();
        countryDbd = new CountryDbd();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(true);
		String forward="";
		 String action = request.getParameter("action");
		
if ("Agregar".equals(request.getParameter("Agregar_Country"))) {
	    	
	    	response.getWriter().append("Agregar");
			String country_code = request.getParameter("country_code_agregar");
			String country_name = request.getParameter("country_name_agregar");
			
			if ((country_code.length() == 3) && (country_name.length() > 0)) {
				Country pais = new Country();
				pais.setCountry_code(country_code);
				pais.setCountry_name(country_name);
				
				

				if (countryDbd.ExisteCountry(pais)) {
					
					response.sendRedirect("CRUDCountry.jsp?estadobbdd=addexiste");
				} else {
					countryDbd.addCountry(pais);
					request.setAttribute("mensaje", "Registro realizado");
					response.sendRedirect("CRUDCountry.jsp?estadobbdd=addok");
				}
				
			} else {
				response.sendRedirect("CRUDCountry.jsp?estadobbdd=addnook");
			}
	        
	      } else if ("Actualizar".equals(request.getParameter("Actualizar_Country"))) {
	    	  
	    	  	response.getWriter().append("Actualizar");
				String country_code = request.getParameter("country_code_up");
				String country_name = request.getParameter("country_name_up");
				
				if ((country_code.length() == 3) && (country_name.length() > 0)) {
					Country pais = new Country();
					pais.setCountry_code(country_code);
					pais.setCountry_name(country_name);
					
					if (countryDbd.ExisteCountry(pais)) {
						countryDbd.updateCountry(pais);
						response.sendRedirect("CRUDCountry.jsp?estadobbdd=upok");
					} else {
						response.sendRedirect("CRUDCountry.jsp?estadobbdd=upnoexiste");
					}
				} else {
					response.sendRedirect("CRUDCountry.jsp?estadobbdd=upnook");
				}
		        
	      } else if ("Eliminar".equals(request.getParameter("Eliminar_Country"))) {
	    	  response.getWriter().append("Eliminar");
	    	  
				String country_code = request.getParameter("eliminar");
				
				if (country_code.length() == 3) {
					Country pais = new Country();
					pais.setCountry_code(country_code);
					pais.setCountry_name(null);
				
					if (countryDbd.ExisteCountry(pais)) {
						countryDbd.deleteCountry(country_code);
						response.sendRedirect("CRUDCountry.jsp?estadobbdd=delok");
					} else {
						response.sendRedirect("CRUDCountry.jsp?estadobbdd=delnoexiste");
					}
				} else {
					response.sendRedirect("CRUDCountry.jsp?estadobbdd=delnook");
				}			
				
	      } 

{
	    	  response.getWriter().append("ERROR");
	      }



}

	    
	}
	