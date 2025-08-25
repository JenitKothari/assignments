package com.aurionpro.service;

import com.aurionpro.dao.UserDao;
import com.aurionpro.model.User;

public class UserService {

	private UserDao userDao = null;
	public UserService() {
		userDao = new UserDao();
	}
	public User checkUser(User user) {
		return userDao.checkUser(user);
	}
	
	
}
