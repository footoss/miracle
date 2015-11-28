package com.footoss.miracle.service;

import com.footoss.miracle.dao.impl.UserDao;
import com.footoss.miracle.domain.User;

public class UserService extends BaseService<User>{

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
