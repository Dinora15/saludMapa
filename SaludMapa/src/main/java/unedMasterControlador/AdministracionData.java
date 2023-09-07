package unedMasterControlador;

import jakarta.servlet.ServletException;
import unedMasterJavaModelo.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

/**
 * Servlet implementation class AdministracionData
 */
@WebServlet("/Data")
public class AdministracionData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataDbd dataDbd;
	private UsuarioDbd dbd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministracionData() {
        super();
        dbd=new UsuarioDbd();
        dataDbd = new DataDbd();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession sesion = request.getSession(true);
		
		
		if ("Agregar".equals(request.getParameter("Agregar_Data"))) {
			// Add HealthIndicator
			String dataIndicadorcode = request.getParameter("indicadorcode");
			String datacountrycode = request.getParameter("countrycode");
			String datayear = request.getParameter("year");
			
			
			Data newdata = new Data(); 
	    
			newdata.setIndicador_code(dataIndicadorcode);
			newdata.setCountry_code(datacountrycode); 
			newdata.setYear(datayear); 
		
	
			dataDbd.createData(newdata);
		
		} else if ("Actualizar".equals(request.getParameter("Actualizar_Data"))) {
			
			String actualizardataIndicadorcode = request.getParameter("actualizarindicadorcode");
		    String actualizardataCountrycode = request.getParameter("actualizarcountrycode");
		    String actualizardatayear = request.getParameter("actualizaryear");
		    
		    
	        Data actualizarData = new Data(); 
	  
	        actualizarData.setIndicador_code(actualizardataIndicadorcode) ;
	        actualizarData.setCountry_code(actualizardataCountrycode); 
	        actualizarData.setYear(actualizardatayear);
	        
		    
		    dataDbd.updateData(actualizarData);
		
		} else if ("Eliminar".equals(request.getParameter("Eliminar_Data"))) {
			//Delete
			String del = request.getParameter("eliminar");
			String del1 = request.getParameter("eliminar1");
			String del2 = request.getParameter("eliminar2");
		    System.out.print("button value"+ " " +del+del1+del2);
	       
		    dataDbd.deleteData(del, del1, del2);
		
		}	
		
		
	
	
}
	
}
	


