package book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/µÇÂ¼")
public class µÇÂ¼ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public µÇÂ¼() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset:utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if("admin".equals(username) && "123".equals(password)) {
			
		request.getRequestDispatcher("searchbook.html").forward(request,response);
		}
		else
			request.getRequestDispatcher("login.html").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}






