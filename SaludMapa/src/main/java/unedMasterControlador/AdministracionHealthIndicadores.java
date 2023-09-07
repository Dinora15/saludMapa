package unedMasterControlador;

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
 */
@WebServlet("/HealthIndicadores")
public class AdministracionHealthIndicadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HealthIndicadoresDbd healthIndicadoresDbd;  
    private UsuarioDbd dbd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministracionHealthIndicadores() {
        super();
        
        dbd = new UsuarioDbd();
        healthIndicadoresDbd = new HealthIndicadoresDbd();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession sesion = request.getSession(true);
		
		
		if ("Agregar".equals(request.getParameter("Agregar_Indicador"))) {
			// Add HealthIndicator
			String indicadorcode = request.getParameter("indicadorcode");
			String indicadorname = request.getParameter("indicadorname");
			String sourcenote = request.getParameter("sourcenote");
			String sourceorganization = request.getParameter("sourceorganization");
			
			HealthIndicadores newindicador = new HealthIndicadores(); 
	    
			newindicador.setIndicadores_code(indicadorcode);
			newindicador.setIndicadores_name(indicadorname); 
			newindicador.setSource_note(sourcenote); 
			newindicador.setSource_organization(sourceorganization);
	
			healthIndicadoresDbd.addHealthIndicadores(newindicador); 
		
		} else if ("Actualizar".equals(request.getParameter("Actualizar_Indicador"))) {
			
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
		
		} else if ("Eliminar".equals(request.getParameter("Eliminar_Indicador"))) {
			//Delete
			String gi = request.getParameter("eliminar");
		    System.out.print("button value"+ " " +gi);
	       
		    healthIndicadoresDbd.deleteHealthIndicador(gi);
		
		}
		 
		response.sendRedirect("CRUDIndicador.jsp");
	}

}
