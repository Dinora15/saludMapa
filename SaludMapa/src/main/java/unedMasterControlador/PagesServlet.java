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
		
		String currentPageNo = request.getParameter("currentpageno");
		int pageNo = 1;
		if(currentPageNo!=null) {
			pageNo =Integer.parseInt(currentPageNo);
		}
		
		ArrayList<Data> dataList=DataDbd.getDataList(pageNo);
		
		
		
		request.setAttribute("dataList", dataList);
		request.setAttribute("currentpageno", pageNo);
		request.setAttribute("totalPage", DataDbd.getTotalPage());
		request.getRequestDispatcher("/CRUDData.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
