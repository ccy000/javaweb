package book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Addbook
 */
@WebServlet("/Addbook")
public class Addbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset:utf-8");
		
		try{
        	Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/books"	, "root","root");
			
			String sql="insert into book(name,price,bookcount,author,tel,where) values(?,?,?,?,?,?)";
			
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		    
			Book book=new Book();
			ps.setString(1, book.getName());
			ps.setInt(2, book.getPrice());
			ps.setInt(3, book.getBookcount());
			ps.setString(4,book.getAuthor());
			ps.setString(5,book.getTel());
			ps.setString(6,book.getWhere());
			
			int row=ps.executeUpdate();//���²���
			if(row>0)
			{
				System.out.print("�ɹ������"+row+"������!");	
			}
			else
				System.out.println("���ʧ�ܣ�");
			ps.close();
			conn.close();	
        }
    catch(SQLException e)
    {
    	System.out.print("ͼ����Ϣ���ʧ�ܣ�");
    	e.printStackTrace();
    } catch (ClassNotFoundException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
		 request.getRequestDispatcher("searchbook.html").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
