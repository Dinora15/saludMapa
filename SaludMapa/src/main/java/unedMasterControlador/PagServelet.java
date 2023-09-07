package unedMasterControlador;

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
     */
    public PagServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPageNo = request.getParameter("currentpageno");
		int pageNo = 1;
		if(currentPageNo!=null) {
			pageNo =Integer.parseInt(currentPageNo);
		}
		
		ArrayList<HealthIndicadores> listadoIndicadores1=HealthIndicadoresDbd.getHealthIndicadoresList(pageNo);
		
		
		
		request.setAttribute("listadoIndicadores1", listadoIndicadores1);
		request.setAttribute("currentpageno", pageNo);
		request.setAttribute("totalPage", HealthIndicadoresDbd.getTotalPage());
		request.getRequestDispatcher("/CRUDIndicador.jsp").forward(request, response);
		
	}

}
