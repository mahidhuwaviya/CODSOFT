//package com.codsoft.pojo;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//@Entity
//class UserATM {
//	@Id
//	private int atmId;
//	@OneToOne
//	@JoinColumn(name="accId",unique = true)
//	private UserAccount userAccId;
//	public int getAtmId() {
//		return atmId;
//	}
//	public void setAtmId(int atmId) {
//		this.atmId = atmId;
//	}
//	public UserAccount getUserAccId() {
//		return userAccId;
//	}
//	public void setUserAccId(UserAccount userAccId) {
//		this.userAccId = userAccId;
//	}
//	public UserATM(int atmId, UserAccount userAccId) {
//		super();
//		this.atmId = atmId;
//		this.userAccId = userAccId;
//	}
//	@Override
//	public String toString() {
//		return "UserATM [atmId=" + atmId + ", userAccId=" + userAccId + "]";
//	}
//	
//	
//	
//
//}
