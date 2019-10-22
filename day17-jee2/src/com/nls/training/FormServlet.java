package com.nls.training;

import java.io.IOException;
import java.io.PrintWriter;

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
	              PrintWriter writer = response.getWriter();
	              writer.println("<h3 align='center'>  Welcome to home page  " + uid  + "</h3>");      
	     	}
}
