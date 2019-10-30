package com.nlsinc.hib;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
// JEE - EJB's iBatis , TopLink, Hibernate - ORM  - JPA - session Bean , Entity Beans , MessageDriven Bean
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart implements Serializable{

	 @Id
	 @Column(name="cart_id")
     @GeneratedValue(strategy=GenerationType.AUTO)
	 private long id;
	 private double total;
	 @ManyToMany(targetEntity=Item.class, cascade=CascadeType.ALL)
	 @JoinTable( name="cart_items",
	                        joinColumns={ @JoinColumn(name="fkcart_id")},
	                        inverseJoinColumns={ @JoinColumn(name="fkitem_id")}
	   			 )
	 private  Set<Item> items= new HashSet<>();;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	 
}
