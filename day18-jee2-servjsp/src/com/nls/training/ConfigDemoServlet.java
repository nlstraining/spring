package com.nls.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfigDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig config = null;

	
	public ConfigDemoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		try {
			String drivername = config.getInitParameter("drivername");
			Class.forName(drivername);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
	
		return this.config;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "demonstrating scope objects and life cycle methods";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	/*
	 * container-> Context -> servlet and Config both are created at the same time
	 *            pust Context to Config -> ServletConfig)
	 *            
	 *            pilot talks to ATC and it talks to other pilots
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int count = 0;
		// root, application path, application context or web context
		ServletContext contxt = config.getServletContext(); //getServletConfig().getServletContext();
            System.out.println(contxt);
		int hits = Integer.parseInt(contxt.getInitParameter("requestcounts"));
		
		hits++;
		System.out.println("context hits..."+ hits);
		

		try {

			String url = config.getInitParameter("url");
			String username = config.getInitParameter("username");
			String password = config.getInitParameter("password");
			Connection con = DriverManager.getConnection(url, username,
					password);
			System.out.println("Connected to db");
			Statement st = con.createStatement();
			String sql = "select * from song";
			ResultSet rs = st.executeQuery(sql);
			PrintWriter out = response.getWriter();

			while (rs.next()) {

				String id = rs.getString(1);
				String singer = rs.getString(2);
				String title = rs.getString(3);
				count++;
				out.println(id + ":" + singer + ":" + title);
				request.setAttribute("counter", count);
              /// System.out.println(request.getAttribute("counter"));
			}
//			out.println("<h3><font color='red'> " + hits + "</font></h3>");
			out.close();
			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
