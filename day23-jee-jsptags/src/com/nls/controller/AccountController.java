package com.nls.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nsl.mvc.AccountBean;

/**
 * Servlet implementation class AccountController
 */
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("from account controller......");
		AccountBean bean = (AccountBean) request.getAttribute("actBean");
		if(bean != null){
			
			   double balance = bean.getBalance();
			   bean.setBalance(balance + (balance/2));
			   System.out.println(bean.getBalance());
			   request.setAttribute("actBean", bean);
		}
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/confirmation.jsp");
		dispatcher.forward(request, response);
		
	
	}

}
