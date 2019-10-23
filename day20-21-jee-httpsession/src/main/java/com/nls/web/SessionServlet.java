package com.nls.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//do we need to manage client session? - artitist, specialist, 
		// clients visits a page-> check first visit or second visit 
		// first visit-> creates a seperate session for user with an id
		// sends the id along with response
		// and the same user visits another page of the same site -> browser also sends the id along with request
		//container verifies the session expired or not
		// not expired -> it will associate the id with the session object
		// expired -> user is asked to login again
		
		
		
		HttpSession session =request.getSession();
		
		if(session.isNew()){
			
			int count = 1;
			session.setAttribute("visits", count);
			
			out.println(session.getAttribute("visits").toString() + session.getId());
		}else{
			int hits = (Integer) session.getAttribute("visits" );
			hits++;
			session.setAttribute("visits",hits);
		out.println(session.getAttribute("visits").toString()+ session.getId());
		
		// create a form with one field : a number : and print the current and also the previous numbers
		}
		
	}

}
