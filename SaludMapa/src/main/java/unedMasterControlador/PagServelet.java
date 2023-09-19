package unedMasterControlador;

// Importe de librerias
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import unedMasterJavaModelo.Data;
import unedMasterJavaModelo.DataDbd;
import unedMasterJavaModelo.HealthIndicadores;
import unedMasterJavaModelo.HealthIndicadoresDbd;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class PagServelet
 */
@WebServlet("/pag")
public class PagServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Constructor
     */
    public PagServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 // Método que maneja las peticiones y respuestas HTTP
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Obtiene el numero de pagina actual desde la peticion
		String currentPageNo = request.getParameter("currentpageno");
		int pageNo = 1; // Numero de pagina por defecto
		if(currentPageNo!=null) {
			// Convierte el numero de pagina a entero 
			pageNo =Integer.parseInt(currentPageNo);
		}

		// Obtiene la lista de indicadores de salud para la pagina actual
		ArrayList<HealthIndicadores> listadoIndicadores1=HealthIndicadoresDbd.getHealthIndicadoresList(pageNo);
		
		
		// Establece los atributos para la vista
		request.setAttribute("listadoIndicadores1", listadoIndicadores1);
		request.setAttribute("currentpageno", pageNo);
		request.setAttribute("totalPage", HealthIndicadoresDbd.getTotalPage());
		request.getRequestDispatcher("/CRUDIndicador.jsp").forward(request, response);
		
	}

}
