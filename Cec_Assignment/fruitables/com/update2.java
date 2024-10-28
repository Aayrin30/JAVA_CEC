package fruitables.com;

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
 * Servlet implementation class update2
 */
@WebServlet("/update2")
public class update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imsc7it6","root","Aayrin30@#");
			PreparedStatement pst = con.prepareStatement("update fruitables set name=?,quantity=?,price=? where id=?");
		
			pst.setString(1,name);
			pst.setString(2,quantity);
			pst.setString(3,price);
			pst.setString(4,id);

			int rowsupdate = pst.executeUpdate();
			if(rowsupdate >0) {
				out.println("updated successfully");
				 out.println("<a href=\"display\"> Display </a>");

			}else {
				out.println("updated not done");
				response.sendRedirect("update.jsp");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
