package com.nlsinc.hib;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TestManyToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessFactory =new AnnotationConfiguration().configure().buildSessionFactory();
		Session session= sessFactory.openSession();
		Transaction trans = session.beginTransaction();
	     
		 Item item1 = new Item();
		 item1.setDescription("SCJP Certification Guide");
		 item1.setPrice(300.75);
		 
		 Item item2 = new Item();
		 item2.setDescription("Java Paul Dietel and Dietel ");
		 item2.setPrice(275.32);
		 
		 Item item3 = new Item();
		 item3.setDescription("Thinking in Java - Bruce Ekel ");
		 item3.setPrice(475.32);
		 
		 Set<Item> items = new HashSet<>();
		 items.add(item1);
		 items.add(item2);
		 items.add(item3);
		 
		 
		 Cart cart = new Cart();
		 cart.setItems(items);
		 cart.setTotal(item1.getPrice() + item2.getPrice());
		 session.save(cart);
		 trans.commit();
		session.close();
		sessFactory.close();
		
	}

}
