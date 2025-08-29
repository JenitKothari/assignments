package com.aurionpro.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public boolean registerUser(User user)
	{
		boolean registered = false;
		
		if(userDao.registerUser(user)>0)
		{
			registered=true;
		}
		return registered;
	}
	
	public List<User> getAllUsers()
	{
		List<User> users = new ArrayList<User>();
		ResultSet result = userDao.getAllUsers();
		if(result==null)
		{
			return null;
		}
		try {
			while(result.next())
			{
				int userId = result.getInt("user_id");
				String username = result.getString("username");
				User user = new User(userId, username);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	

}
