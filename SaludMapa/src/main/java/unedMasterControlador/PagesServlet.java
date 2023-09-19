
// Importación de las bibliotecas y clases necesarias
package unedMasterControlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import unedMasterJavaModelo.Country;
import unedMasterJavaModelo.CountryDbd;
import unedMasterJavaModelo.Data;
import unedMasterJavaModelo.DataDbd;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class PagesServlet
 */
@WebServlet("/pages")
public class PagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public PagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Obtiene el número de la página actual desde la petición
		String currentPageNo = request.getParameter("currentpageno");
		int pageNo = 1;
		if(currentPageNo!=null) {
			pageNo =Integer.parseInt(currentPageNo);
		}
		
		// Obtiene la lista de datos para la página actual
		ArrayList<Data> dataList=DataDbd.getDataList(pageNo);
		
		
		// Establece los atributos que se enviarán a la vista
		request.setAttribute("dataList", dataList);
		request.setAttribute("currentpageno", pageNo);
		request.setAttribute("totalPage", DataDbd.getTotalPage());
		// Envía la petición y respuesta al archivo JSP de CRUD de datos
		request.getRequestDispatcher("/CRUDData.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Método doPost para manejar peticiones POST
  	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
