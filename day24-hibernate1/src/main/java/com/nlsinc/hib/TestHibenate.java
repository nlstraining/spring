package com.nlsinc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHibenate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// what is Maven ?
		// 1. the directory structure
		// frameworks - hibernate, spring etc demands - resource files

		Configuration config = new Configuration(); // it is for reading the hibernate.cfg.xml file
		config = config.configure();
		SessionFactory sessFactory = config.buildSessionFactory();
		// maintain / create hibernate environment : 1. jdbc 2. Session(cache)
		// 3. Transaction
		Session session = sessFactory.openSession(); // getConnection()
		System.out.println(session.isOpen());
		Transaction tran = session.beginTransaction();
		Employee emp = new Employee();
		//emp.setEmpid(empid);
		emp.setEmpname("Jane Doe");
		emp.setSalary(85000);
		session.save(emp);
		tran.commit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Employee emp = new Employee(); emp.setEmpname("Abimbola");
		 * emp.setSalary(90000); Transaction trans = session.beginTransaction();
		 * session.save(emp);
		 

		Employee emp2 = new Employee();
		emp2.setEmpname("Michael Davis");
		emp2.setSalary(90000);
		Transaction trans = session.beginTransaction();
		session.save(emp2);
		
		Employee emp3 = new Employee();
		emp3.setEmpname("Chika");
		emp3.setSalary(90000);

		session.save(emp3);
         
		trans.commit();
		*/
		
		//1 insert is achieved through save method
		
		//2 select or fetch an object from db with hibernate, we have to search with primary key
		
		// I method of getting data
		//Object obj = session.get(Employee.class,3);
		
		//Employee retrievedEmp = (Employee) obj;
		
		/*Employee retrievedEmp = (Employee) session.get(Employee.class,2);
		if ( retrievedEmp != null)
		System.out.println(retrievedEmp.getEmpname() + ","+ retrievedEmp.getSalary());
		
		System.out.println("--------------------------");
		
		
		// II method of getting data 
		retrievedEmp = (Employee) session.load(Employee.class, 3);
		System.out.println(retrievedEmp.getEmpname() + ","+ retrievedEmp.getSalary());
		
*/	
		// 3. Update  ( after insert, select ... comes update)  
	/*
		Transaction trans = session.beginTransaction();
		trans.begin();
		Employee retrievedEmp = (Employee) session.get(Employee.class,2);
		if ( retrievedEmp != null){
		//System.out.println(retrievedEmp.getEmpname() + ","+ retrievedEmp.getSalary());
		        double oldSal = retrievedEmp.getSalary();
		        double newSal = oldSal + 5000;
		        retrievedEmp.setSalary(newSal);
		        
		        
		}
*/	
		//trans.commit();
		session.close();
		sessFactory.close();

	}

}
