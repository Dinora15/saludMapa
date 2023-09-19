package unedMasterControlador;

// Importe de librerias y clases necesarias
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;
import unedMasterJavaModelo.*;
import java.util.*;

/**
 * Servlet implementation class PageServelet
 */

@WebServlet("/page")
public class PageServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  //Constructor
    public PageServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
     	* Método para manejar las peticiones y respuestas HTTP.
     	* @param request Objeto que contiene la petición del cliente.
    	 * @param response Objeto que contiene la respuesta del servidor.
     	* @throws ServletException si un error específico de Servlet ocurre.
    	 * @throws IOException si un error de I/O ocurre.
   	  */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPageNo = request.getParameter("currentpageno");
		int pageNo = 1;
		if(currentPageNo!=null) {
			pageNo =Integer.parseInt(currentPageNo);
		}
		// Obtiene la lista de paisas para la pagina actual
		ArrayList<Country> countryList=CountryDbd.getCountryList(pageNo);
		
		request.setAttribute("countryList", countryList);
		request.setAttribute("currentpageno", pageNo);
		request.setAttribute("totalPage", CountryDbd.getTotalPage());

		// Envia la peticion y respuesta al archivo JSP de paises
		request.getRequestDispatcher("country.jsp").forward(request, response);
		
	}

}
