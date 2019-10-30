package com.nlsinc.hib;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestOnetoMany {

	public static void main(String[] args) {
	
		SessionFactory sessFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		Session session = sessFactory.openSession();
		Transaction trans = session.beginTransaction();

		Email email1 = new Email();
		email1.setUsermail("Ken Thomson@spring.io.com");

		Email email2 = new Email();
		email2.setUsermail("KenThomson@bell.com");
		
	

		Employee4 emp = new Employee4();
		emp.setEname("Ken Thomson ");
		emp.setSalary(535000);

		ArrayList<Email> list = new ArrayList<>();
		list.add(email1);
		list.add(email2);
		
		emp.setEmailList(list);
		session.save(emp);

		trans.commit();
		session.close();
		sessFactory.close();
	}

}
