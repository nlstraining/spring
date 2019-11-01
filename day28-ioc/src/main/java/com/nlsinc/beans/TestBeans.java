package com.nlsinc.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

// servlets - the web.xml file always willl be in web-inf
public class TestBeans {

	public static void main(String[] args) {
	
		BeanFactory factory = new XmlBeanFactory(
				                              new FileSystemResource("C:\\Users\\Anil\\git\\jee\\day28-ioc\\src\\main\\java\\beans.xml"));
		Object obj = factory.getBean("persist"); // lazy loading
		PerformPersistence p = (PerformPersistence) obj;
		Product product = (Product) factory.getBean("product");
		product.setDescription("Coca-Cola");
		product.setPrice(20);
		product.setProdId(101);
		p.save(product);
		

	}

}
