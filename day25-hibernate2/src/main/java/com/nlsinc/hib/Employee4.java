package com.nlsinc.hib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp43")
public class Employee4 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empno")
	 private long empno;
	 private String ename;
	 private double salary;
	 
	 //For Uni-directional mapping - we fetch from Employee email details - from email we cannot fetch employee details
	 //@OneToMany(orphanRemoval=true,cascade=CascadeType.ALL)
	// @JoinColumn(name="emp_mailid")  // for preventing creation of extra  join table which stores the relation in case of uni-directional relationship
	    // equivalent of a Foreign key column in db terminology
	 
	 // For Bi-directional
	 @OneToMany(orphanRemoval=true,cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 @JoinColumn(name="emp_mailid") 
	 private List<Email> emailList = new ArrayList<>();
	 
	public List<Email> getEmailList() {
		return emailList;
	}
	public void setEmailList(ArrayList<Email> emailList) {
		this.emailList = emailList;
		
	}
	// when we add these methods- there will be no need to create an ArrayList in test case for passing EmailList -
	// directly each Email object can be passed to added to the emailList 
	public void addEmail(Email email){
		
		  emailList.add(email);
	      email.setEmployee(this);
	}
	public void removeEmail(Email email){
		  
		      emailList.remove(email);
		       email.setEmployee(null);
	}
	
	
	public long getEmpno() {
		return empno;
	}
	public void setEmpno(long empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	 
}
