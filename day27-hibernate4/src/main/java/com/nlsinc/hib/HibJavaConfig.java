package com.nlsinc.hib;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
                  //   Hibernate 5.3.7.Final version
public class HibJavaConfig {  // SpringBoot
	
	static SessionFactory factory;
	
	public static SessionFactory getSessionFactory(){
		Configuration config = new Configuration();
		try{
			
			Properties props = new Properties();
			props.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			props.setProperty(Environment.URL,"jdbc:mysql://localhost:3306/hib");
			props.setProperty(Environment.USER, "root");
			props.setProperty(Environment.PASS, "test");
			props.setProperty(Environment.SHOW_SQL, "true");
			props.setProperty(Environment.HBM2DDL_AUTO,"create");
			props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			config.setProperties(props);
		    //config.addAnnotatedClass(Employee.class);
			//ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			//factory =  config.buildSessionFactory(registry);
		}catch(Exception e){e.printStackTrace();}
		
		
		
		
		return factory;
	}
	

}
