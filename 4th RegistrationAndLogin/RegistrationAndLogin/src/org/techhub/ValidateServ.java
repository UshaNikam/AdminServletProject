package org.techhub;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class ValidateServ
 */
@WebServlet("/valid")
public class ValidateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		  response.setContentType("text/html");
		    PrintWriter out=response.getWriter();
		  String username=request.getParameter("username");
		  String password=request.getParameter("password");
		  
		  try
		  {
			  Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sujeetmanish","root","system");
	     
		  if(conn!=null)
		  {
	PreparedStatement stmt=conn.prepareStatement("select *from demoreg where username=? and pasword=?");
				stmt.setString(1,username);
				stmt.setString(2,password);
		     ResultSet rs=stmt.executeQuery();
		        if(rs.next())
		        {
		        	RequestDispatcher r=request.getRequestDispatcher("welcome.html");
		        	r.forward(request,response);
		        }
		        else
		        {
		        	RequestDispatcher r=request.getRequestDispatcher("login.html");
		        	r.include(request,response);
		        	out.println("<center>invalid username and password</center>");
		        }
		  }
		  else
		  {
			  out.println("Database is not connected");
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
