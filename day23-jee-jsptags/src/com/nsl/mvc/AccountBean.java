package com.nsl.mvc;

import java.io.Serializable;

public class AccountBean implements Serializable{

	private int actno;
	private String name;
	private double balance;
	
	public AccountBean() {
		// TODO Auto-generated constructor stub
	}
	public int getActno() {
		return actno;
	}
	public void setActno(int actno) {
		this.actno = actno;
		System.out.println(this.actno);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
		System.out.println(balance);
	}

	
	
}
