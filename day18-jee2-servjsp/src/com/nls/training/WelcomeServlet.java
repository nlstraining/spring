package com.nls.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WelcomeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// this method is going to handle GET method of http requests
		PrintWriter writer = response.getWriter();
		for(int  i=1;i<10;i++){
		writer.println("<h3>hello this is from my first HttpServlet - Welcome ....</h3>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this method is going to handle GET method of http requests
			PrintWriter writer = response.getWriter();
			for(int  i=1;i<10;i++){
			writer.println("<h3>hello this is from my first HttpServlet - Welcome ....</h3>");
			}
		}

}
