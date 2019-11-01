package com.nlsinc.beans;

import java.sql.Connection;


// this class provides an instantiated db connection
public class ConnectionSource {

	
	public static Connection connect(){
		Connection con = null;
		return con;
	}
}
