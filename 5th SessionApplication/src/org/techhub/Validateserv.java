package org.techhub;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validateserv
 */
@WebServlet("/valid")
public class Validateserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validateserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        response.setContentType("text/html");
	        PrintWriter out=response.getWriter();
	
	        HttpSession session=request.getSession(true);
	        String sid=session.getId();
	        out.println("<h1>Session id of user is &nbsp;"+sid+"</h1>");
	        String username=request.getParameter("name");
	        String password=request.getParameter("pass");
	        session.setAttribute("u",username);//u is key and username is value
	        session.setAttribute("p",password);
	        
	        out.println("<a href='view'>View Session Data</a>");
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
