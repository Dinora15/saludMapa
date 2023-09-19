package unedMasterControlador;

import jakarta.servlet.ServletException;
import unedMasterJavaModelo.*; // Importa todas las clases del paquete del Modelo
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; // Importa para manejar sesiones

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

/**
 * Servlet implementation class AdministracionData
 */
@WebServlet("/Data")
public class AdministracionData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataDbd dataDbd; // Instancia de la clase DataDbd del Modelo
	private UsuarioDbd dbd; // Instancia de la clase UsuarioDbd del modelo
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor
     */
    public AdministracionData() {
        super();
        dbd=new UsuarioDbd();
        dataDbd = new DataDbd();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
  	 * Metodo de servicio principal del servlet
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession sesion = request.getSession(true);
		
		// Caso para agregar datos
		if ("Agregar".equals(request.getParameter("Agregar_Data"))) {
			// Obtiene los parametros de la solicitud para el nuevo dato
			String dataIndicadorcode = request.getParameter("indicadorcode");
			String datacountrycode = request.getParameter("countrycode");
			String datayear = request.getParameter("year");
			
			
			Data newdata = new Data(); // Crea una nueva instancia de la clase Data

			// Establece los atributos de la nueva instancia
			newdata.setIndicador_code(dataIndicadorcode);
			newdata.setCountry_code(datacountrycode); 
			newdata.setYear(datayear); 
		

			// Llama al metodo para crear el nuevo dato en la base de datos
			dataDbd.createData(newdata);

		// Caso para actualuzar datos existentes
		} else if ("Actualizar".equals(request.getParameter("Actualizar_Data"))) {
			
			String actualizardataIndicadorcode = request.getParameter("actualizarindicadorcode");
		    String actualizardataCountrycode = request.getParameter("actualizarcountrycode");
		    String actualizardatayear = request.getParameter("actualizaryear");
		    
		    
	        Data actualizarData = new Data(); // Crea una nueva instancia de la clase Data

		// Establece los nuevos atributos para actualizar
	        actualizarData.setIndicador_code(actualizardataIndicadorcode) ;
	        actualizarData.setCountry_code(actualizardataCountrycode); 
	        actualizarData.setYear(actualizardatayear);
	        
		    // Llama al método para actualizat el dato en la base de datos
		    dataDbd.updateData(actualizarData);
		
		// Caso para eliminar datos
		} else if ("Eliminar".equals(request.getParameter("Eliminar_Data"))) {
			// Obtiene los parametros para identificar el dato a eliminar
			String del = request.getParameter("eliminar");
			String del1 = request.getParameter("eliminar1");
			String del2 = request.getParameter("eliminar2");
		    System.out.print("button value"+ " " +del+del1+del2);

		// Llama al metodo para eliminar el dato en la base de datos
		    dataDbd.deleteData(del, del1, del2);
		
		}	
		
		
	
	
}
	
}
	


