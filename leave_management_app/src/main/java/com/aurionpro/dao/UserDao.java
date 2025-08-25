package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.database.DBConnector;
import com.aurionpro.model.User;

public class UserDao {
	
	private Connection connection = null;
	public UserDao() {
		connection = DBConnector.connect();
	}

	public User checkUser(User user) {
		ResultSet result = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from users where user_id = ?");
			statement.setInt(1, user.getUserId());
			result = statement.executeQuery();
			if(result.next())
			{
				String password = result.getString("password");
				if(!password.equals(user.getPassword()))
					return null;
				String name = result.getString("name");
				boolean isAdmin = result.getBoolean("is_admin");
				user.setName(name);
				user.setAdmin(isAdmin);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
