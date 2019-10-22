package com.nls.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FormServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		          String uid = request.getParameter("uid");	      
	          
	              if(uid.equals("superman"))
	              {
	            	  // inter servlet communication
	            	  
	            	   ServletContext context = getServletConfig().getServletContext();
	            	   RequestDispatcher dispatcher = context.getRequestDispatcher("/welcome");
	            	   dispatcher.forward(request, response);
	              }      
	     	}
}
