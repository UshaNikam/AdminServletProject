package org.techhub;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewStudent
 */
@WebServlet("/addstudent")
public class AddNewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	      out.println("<html>");
	    out.println("<head>");
	    out.println("<link rel='stylesheet' href='css/style.css' />");
	    out.println("</head>");
	    out.println("<body>");
	    RequestDispatcher r=request.getRequestDispatcher("master.html");
	    r.include(request,response);
	 
	     out.println("<center>");
	     out.println("<input type='text' name='name' value='' class='control'/><br><br>");
	     out.println("<input type='text' name='email' value='' class='control'/><br><br>");
	     out.println("<input type='text' name='contact' value='' class='control'/><br><br>");
	     out.println("<input type='text' name='username' value='' class='control'/><br><br>");
	     out.println("<input type='password' name='password' value='' class='control'/><br><br>");
	     out.println("<input type='submit' name='s' value='Add New Student' class='control'/><br><br>");
	     
	     
	     
	     out.println("</center>");
	   
	    
	    out.println("</body>");
	    out.println("</html>");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




