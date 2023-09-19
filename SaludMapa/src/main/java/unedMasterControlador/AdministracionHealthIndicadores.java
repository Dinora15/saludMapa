package unedMasterControlador;

// Importe de las librerias necesarias

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import unedMasterJavaModelo.*;
/**
 * Servlet implementation class AdministracionHealthIndicadores
 * Definicion y configuracion del servlet
 */
@WebServlet("/HealthIndicadores")
public class AdministracionHealthIndicadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HealthIndicadoresDbd healthIndicadoresDbd;  // Clase para la gestión de datos
    	private UsuarioDbd dbd; // Clase para la gestión de usuarios

    /**
     * @see HttpServlet#HttpServlet()
     * Constructor del servlet
     */
    public AdministracionHealthIndicadores() {
        super();
        
        dbd = new UsuarioDbd();  // Instancia de gestión de usuarios
        healthIndicadoresDbd = new HealthIndicadoresDbd(); // Instancia de gestión de datos
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
  	 * // Método que maneja las peticiones y respuestas HTTP
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession sesion = request.getSession(true); // Obtiene la sesión actual
		
		// Acción de agregar un nuevo registro de datos
		if ("Agregar".equals(request.getParameter("Agregar_Indicador"))) {
			// Obtiene los parámetros del formulario
			String indicadorcode = request.getParameter("indicadorcode");
			String indicadorname = request.getParameter("indicadorname");
			String sourcenote = request.getParameter("sourcenote");
			String sourceorganization = request.getParameter("sourceorganization");
			
			HealthIndicadores newindicador = new HealthIndicadores(); 
	    		// Anhade los parametros 
			newindicador.setIndicadores_code(indicadorcode);
			newindicador.setIndicadores_name(indicadorname); 
			newindicador.setSource_note(sourcenote); 
			newindicador.setSource_organization(sourceorganization);
			
			// Agrega el nuevo registro a la base de datos
			healthIndicadoresDbd.addHealthIndicadores(newindicador); 
		
		// Acción de actualizar un registro de datos existente
		} else if ("Actualizar".equals(request.getParameter("Actualizar_Indicador"))) {
			// Obtiene los parámetros del formulario
			String actualizarindicadorcode = request.getParameter("actualizarindicadorcode");
			String actualizarindicadorname = request.getParameter("actualizarindicadorname");
			String actualizarsourcenote = request.getParameter("actualizarsourcenote");
			String actualizarsourceorganization = request.getParameter("actualizarsourceorganization");
		    
	        HealthIndicadores actualizarindicadores = new HealthIndicadores(); 
	  
	        actualizarindicadores.setIndicadores_code(actualizarindicadorcode); 
	        actualizarindicadores.setIndicadores_name(actualizarindicadorname); 
	        actualizarindicadores.setSource_note(actualizarsourcenote);
	        actualizarindicadores.setSource_organization(actualizarsourceorganization);
		    
		    healthIndicadoresDbd.updateHealthIndicadores(actualizarindicadores);

		// Acción de eliminar un registro de datos
		} else if ("Eliminar".equals(request.getParameter("Eliminar_Indicador"))) {
			//Delete
			String gi = request.getParameter("eliminar");
		    System.out.print("button value"+ " " +gi);
	       
		    healthIndicadoresDbd.deleteHealthIndicador(gi);
		
		}
		 
		response.sendRedirect("CRUDIndicador.jsp");
	}

}
