package com.codsoft.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.codsoft.dao.UserInfoDao;
import com.codsoft.pojo.UserInfo;

@Component
public class UserInfoDaoImpl implements UserInfoDao{

	private JdbcTemplate jTemplate;
	@Autowired
	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}

	@Override
	public boolean addNewUser(UserInfo u) {
	
		try {
			int count = jTemplate.update("insert into"
					+ " userinfo (username,password) values(?,?)",
					new Object[] {u.getUsername(),u.getPassword()});
			if(count>0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserInfo checkUserCredential(UserInfo u) {
		try {
			UserInfo user = 
					jTemplate.queryForObject("select * from userinfo"
					+ " where username = ? and password = ?",
					new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
					new Object[] {u.getUsername(),u.getPassword()});
			if(user!=null)
				return user;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
