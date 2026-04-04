package com.codsoft.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.codsoft.dao.AccountDao;
import com.codsoft.pojo.Account;

@Component
public class AccountDaoImpl implements AccountDao{

	@Autowired
	private JdbcTemplate jTemplate;
	
	@Override
	public boolean openAcc(Account a) {
		try {
			int count= jTemplate.update("insert into account values(?,?,?,?)",
					new Object[] {a.getAccno(),a.getCustname(),a.getType(),a.getBal()});
			if (count>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;		
		}
	}

	@Override
	public boolean updateAcc(Account a) {
		try {
			int count= jTemplate.update("update account set custname =?,type=?, bal =? where accno =?",
					new Object[] {a.getCustname(),a.getType(),a.getBal(),a.getAccno()});
			if (count>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;		
		}
	}

	@Override
	public boolean deleteAcc(Account a) {
		try {
			int count= jTemplate.update("delete from account where accno =?",
					a.getAccno());
			if (count>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;		
		}
	}

	@Override
	public Account deposit(int accno, double amout) {
		try {
			Account a= searchAcc(accno);
		    double newAmt= a.getBal()+amout;
			a.setBal(newAmt);
			return a;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;		
		}
	}

	@Override
	public Account withdraw(int accno, double amout) {
		try {
			Account a= searchAcc(accno);
			if(a.getBal()>amout) {
				double newAmt= a.getBal()-amout;
				a.setBal(newAmt);
				return a;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;		
		}
	}

	@Override
	public Account searchAcc(int accno) {
		try {
			Account a= jTemplate.queryForObject("select * from account where accno=?", 
					new BeanPropertyRowMapper<Account>(Account.class),accno);
			return a;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("returns null");
			return null;		
		}
	}

	@Override
	public List<Account> getAllAccount() {
		try {
			List<Account> lst= jTemplate.query("select * from account", 
					new BeanPropertyRowMapper<Account>(Account.class));
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("returns null");
			return null;		
		}
	}

	
	
}
