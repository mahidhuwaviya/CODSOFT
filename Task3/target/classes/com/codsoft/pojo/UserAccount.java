package com.codsoft.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount {
	@Id
	private int userId;
	private String userName;
	private int userBalance;
	
	
	public UserAccount(int userId, String userName, int userBalance) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userBalance = userBalance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
