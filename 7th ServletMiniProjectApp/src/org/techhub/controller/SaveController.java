package org.techhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.Register;
import org.techhub.service.RegisterServiceImpl;

/**
 * Servlet implementation class SaveController
 */
@WebServlet("/save")
public class SaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveController() {
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
		 
		Register r = new Register();
		r.setName(name);
		r.setEmail(email);
		r.setContact(contact);
		r.setUsername(username);
		r.setPassword(password);
		
		RegisterServiceImpl regService=new RegisterServiceImpl();
		boolean b=regService.isRegister(r);//b is false 
		if(b)
		{
			out.println("<h1>Record Save Success....</h1>");
		}
		else
		{
		    out.println("<h1>Some problem is there....</h1>");
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
