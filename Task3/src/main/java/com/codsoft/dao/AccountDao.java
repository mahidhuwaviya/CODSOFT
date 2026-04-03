package com.codsoft.dao;

import java.util.List;

import com.codsoft.pojo.Account;

public interface AccountDao {

	boolean openAcc(Account a);
	boolean updateAcc(Account a);
	boolean deleteAcc(Account a);
	double deposit(int accno,double amout);
	double withdraw(int accno,double amout);
	Account searchAcc(int accno);
	List<Account> getAllAccount();
}
