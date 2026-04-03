package com.codsoft.dao;

import com.codsoft.pojo.UserInfo;

public interface UserInfoDao {
	
	boolean addNewUser(UserInfo u);
	UserInfo checkUserCredential(UserInfo u);

}
