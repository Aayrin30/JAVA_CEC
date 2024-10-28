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
 * Servlet implementation class updateDetails
 */
@WebServlet("/updateDetails")
public class updateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");

		 out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Product Form</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h2>Update Product </h2>");
	        
	        // Build the form
	        out.println("<form action='update2' method='POST'>");  

	        // ID field
	        out.println("<label for='id'>Product ID:</label>");
	        out.println("<input type='text' id='id' name='id' value='"+id+"' readonly><br><br>");

	        // Name field
	        out.println("<label for='name'>Product Name:</label>");
	        out.println("<input type='text' id='name' name='name' value='"+name+"' required><br><br>");

	        // Quantity field
	        out.println("<label for='quantity'>Quantity:</label>");
	        out.println("<input type='text' id='quantity' name='quantity' value='"+quantity+"' required><br><br>");

	        // Price field
	        out.println("<label for='price'>Price:</label>");
	        out.println("<input type='text' step='0.01' id='price' name='price' value='"+price+"' required><br><br>");

	        // Submit button
	        out.println("<input type='submit' value='Submit'>");

	        // Close the form
	        out.println("</form>");

	        // Close the HTML structure
	        out.println("</body>");
	        out.println("</html>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
	}

}
