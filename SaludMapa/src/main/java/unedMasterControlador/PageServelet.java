package unedMasterControlador;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServelet() {
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
		ArrayList<Country> countryList=CountryDbd.getCountryList(pageNo);
		
		request.setAttribute("countryList", countryList);
		request.setAttribute("currentpageno", pageNo);
		request.setAttribute("totalPage", CountryDbd.getTotalPage());
		request.getRequestDispatcher("country.jsp").forward(request, response);
		
	}

}
