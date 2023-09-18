package unedMasterControlador;

import jakarta.servlet.RequestDispatcher; // Import para reenvío de peticiones
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; //Import para manejo de sesiones
import unedMasterJavaModelo.CountryDbd; //Import la clase del Modelo

import java.io.IOException;
import java.util.List;

import unedMasterJavaModelo.*;
/**
 * Define el mapeo del servlet. Servlet implementation class AdministracionBBDD
 */
@WebServlet("/administracion")
public class AdministracionBBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Declara una instancia de la clase CountryDbd del Modelo
	private CountryDbd countryDbd;
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor
     */
    public AdministracionBBDD() {
        super();
	
	// Inicializa countryDbd
        countryDbd = new CountryDbd();
        
    }

	/**
	* @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	* Metodo de servicio principal	 
  	*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Crea o obtiene la sesion existente
		HttpSession sesion = request.getSession(true);
		String forward="";
		//Optiene el parametro "action" de la solicitud
		 String action = request.getParameter("action");

	//Caso para anhadir un nuevo pais
	if ("Agregar".equals(request.getParameter("Agregar_Country"))) {
	    	
	    	response.getWriter().append("Agregar");
			//Obtiene los detalles del pais desde la solicitud
			String country_code = request.getParameter("country_code_agregar");
			String country_name = request.getParameter("country_name_agregar");

			//Valida los detalles del pais
			if ((country_code.length() == 3) && (country_name.length() > 0)) {
				Country pais = new Country();
				pais.setCountry_code(country_code);
				pais.setCountry_name(country_name);
				
				
				
				//Comprueba si el pais ya existe
				if (countryDbd.ExisteCountry(pais)) {
					
					response.sendRedirect("CRUDCountry.jsp?estadobbdd=addexiste");
				} else {
					// Anhade el pais si no existe
					countryDbd.addCountry(pais);
					request.setAttribute("mensaje", "Registro realizado");
					response.sendRedirect("CRUDCountry.jsp?estadobbdd=addok");
				}
				
			} else {
				response.sendRedirect("CRUDCountry.jsp?estadobbdd=addnook");
			}
		// Caso para actualizar un país existente
	      	} else if ("Actualizar".equals(request.getParameter("Actualizar_Country"))) {
	    	  	// Obtiene y valida los detalles del país
	    	  	response.getWriter().append("Actualizar");
				String country_code = request.getParameter("country_code_up");
				String country_name = request.getParameter("country_name_up");
				
				if ((country_code.length() == 3) && (country_name.length() > 0)) {
					Country pais = new Country();
					pais.setCountry_code(country_code);
					pais.setCountry_name(country_name);

					//Actualiza el pais si existe
					if (countryDbd.ExisteCountry(pais)) {
						countryDbd.updateCountry(pais);
						response.sendRedirect("CRUDCountry.jsp?estadobbdd=upok");
					} else {
						response.sendRedirect("CRUDCountry.jsp?estadobbdd=upnoexiste");
					}
				} else {
					response.sendRedirect("CRUDCountry.jsp?estadobbdd=upnook");
				}
		// Caso para eliminar un pais        
	      	} else if ("Eliminar".equals(request.getParameter("Eliminar_Country"))) {
	    	  response.getWriter().append("Eliminar");
	    	  		// Obtiene y valdia el codigo del pais
				String country_code = request.getParameter("eliminar");
				
				if (country_code.length() == 3) {
					Country pais = new Country();
					pais.setCountry_code(country_code);
					pais.setCountry_name(null);
					// Elimina el pais si existe
					if (countryDbd.ExisteCountry(pais)) {
						countryDbd.deleteCountry(country_code);
						response.sendRedirect("CRUDCountry.jsp?estadobbdd=delok");
					} else {
						response.sendRedirect("CRUDCountry.jsp?estadobbdd=delnoexiste");
					}
				} else {
					response.sendRedirect("CRUDCountry.jsp?estadobbdd=delnook");
				}			
				
	      }else {
			//Si no se da ninguno de los casos anteriores, muestra Error. 
	    	  response.getWriter().append("ERROR");
	      }



}

	    
	}
	
