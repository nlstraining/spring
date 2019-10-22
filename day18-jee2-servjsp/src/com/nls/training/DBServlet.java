package com.nls.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBServlet
 */
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //  format got to do with the player - driver
		 //type 4 driver
		 //2. User DriverManager for obtaining connection with the mysql db
		 //http://google.com
		 String url= "jdbc:mysql://localhost:3306/music";  // protocol uniform and universal 
		 String username="root";
		 String password="test";
		 try {
			Connection con = DriverManager.getConnection(url,username,password);
		    System.out.println("Connected to db");
		      Statement st = con.createStatement();
		      String sql = "select * from song";
		      ResultSet rs = st.executeQuery(sql);
		      PrintWriter out = response.getWriter();
		      while(rs.next()){
		    	  
		    	   String id = rs.getString(1);
		    	   String singer = rs.getString(2);
		    	   String title = rs.getString(3);
		    	   out.println(id + ":" + singer +":"+ title);
		    	   
		    	   
		      }
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
