package com.codsoft.pojo;

public class Account {

	private int accno;
	private String custname;
	private String type;
	private double bal;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accno, String custname, String type, double bal) {
		super();
		this.accno = accno;
		this.custname = custname;
		this.type = type;
		this.bal = bal;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	
}
