package book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updateservlet1
 */
@WebServlet("/Updateservlet1")
public class Updateservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Updateservlet1() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset:utf-8");
		String name=(String)request.getParameter("name");
		Integer bookcount=Integer.valueOf((String) request.getParameter("bookcount"));
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
			String sql="update books set bookcount=? where name=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, bookcount);
			ps.setString(2, name);
			
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		response.sendRedirect("SelectAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
