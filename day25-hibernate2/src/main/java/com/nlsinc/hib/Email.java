package com.nlsinc.hib;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
// Note: for unidiretional Employee - Email no configuration required in the Email class
//   for Bidirectional we have to configure ManyToOne and provide - Fetch and Join column ( )

@Entity
@Table(name = "email2")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String usermail;
	// For Bi-directional relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_mailid")
	private Employee4 employee;
      
	
	  public Employee4 getEmployee() { return employee; } 
	  public void setEmployee(Employee4 employee) { 
		  this.employee = employee; 
	  }
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	
}
