package org.techhub;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/register")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");
	    String contact=request.getParameter("contact");
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	
	     try
	     {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sujeetmanish","root","system");
	       if(conn!=null)
	       {
	       PreparedStatement stmt=conn.prepareStatement("insert into demoreg values('0',?,?,?,?,?)");
	           stmt.setString(1, name);
	           stmt.setString(2,email);
	           stmt.setString(3, contact);
	           stmt.setString(4, username);
	           stmt.setString(5, password);
	       int value=stmt.executeUpdate();
	       
	          if(value>0)
	          {
	        	  out.println("<h1>Registration Success....</h1>");
	          }
	          else
	          {
	        	  out.println("<h1>Registration Failed......</h1>");
	          }
	        	  
	       }
	       else
	       {
	    	   out.println("Not Connected");
	       }
	    	 
	     }
	     catch(Exception ex)
	     {
	    	 out.println("Error is "+ex);
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
