package delete.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteByName
 */
@WebServlet("/DeleteByName")
public class DeleteByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteByName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imsc7it6","root","Aayrin30@#");
			PreparedStatement pst = con.prepareStatement("delete from fruitables where name=?");
		
			pst.setString(1,name);
			int rowsupdate = pst.executeUpdate();
			String linkurl = "index.jsp";
			if (rowsupdate >0) {
				out.println("deleted successfully");
				out.println("<a href=' "+linkurl+" '>Home</a>");
				out.println("<a href=\"display\">Display</a>");

			}
			else {
				response.sendRedirect("delete.jsp");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
