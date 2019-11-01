package com.nlsinc.beans;

public class PerformPersistence {

	ConnectionSource source;
	
	 PerformPersistence(ConnectionSource source){
		 System.out.println("constructor called by container....");
		  this.source = source;
	 }
	
	public int save(Product product){
		 //db insert operation happens here
		source.connect();
		//next push the object to db
		
		
		return 1;
	}
	
	
}
