package com.nlsinc.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestAnnots {

	private static void save(Session session) {

		Employee emp = new Employee();
		emp.setEname("John Doe");
		emp.setSalary(65000);
		session.save(emp);

		Employee emp2 = new Employee();
		emp2.setEname("Rod Johnson");
		emp2.setSalary(87000);
		session.save(emp2);

		Employee emp3 = new Employee();
		emp3.setEname("Dennis Richie");
		emp3.setSalary(97000);
		session.save(emp3);

		Employee emp4 = new Employee();
		emp4.setEname("Bryan Stroutup");
		emp4.setSalary(37000);
		session.save(emp4);

		Employee emp5 = new Employee();
		emp5.setEname("James Gosling");
		emp5.setSalary(99000);
		session.save(emp5);

		Employee emp6 = new Employee();
		emp6.setEname("Barbara Liskov");
		emp6.setSalary(65000);
		session.save(emp6);

		Employee emp7 = new Employee();
		emp7.setEname("Guido Van Rossum");
		emp7.setSalary(45000);
		session.save(emp7);

		Employee emp8 = new Employee();
		emp8.setEname("Bill Gates");
		emp8.setSalary(105000);
		session.save(emp8);

		Employee emp9 = new Employee();
		emp9.setEname("Kathy Siera");
		emp9.setSalary(35000);
		session.save(emp9);

		Employee emp10 = new Employee();
		emp10.setEname("Joshua Bloch");
		emp10.setSalary(75000);
		session.save(emp10);

	}

	public static void main(String[] args) {

		SessionFactory sessFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sessFactory.openSession();
		Transaction trans = session.beginTransaction();
	 //   save(session);
                  // HBQL HQL or CRITERIA api               
		Employee emp = (Employee) session.get(Employee.class,8);
		System.out.println(emp.getEname());
		emp.setSalary(emp.getSalary()  * 1.1);
		session.update(emp);
		trans.commit();
		System.out.println(emp.getSalary());
		session.close();
		sessFactory.close();

	}

}
