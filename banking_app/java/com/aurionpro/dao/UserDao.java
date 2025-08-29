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
			PreparedStatement statement = connection.prepareStatement("select * from users where username = ?");
			statement.setString(1, user.getUsername());
			result = statement.executeQuery();
			if(result.next())
			{
				String password = result.getString("password");
				if(!password.equals(user.getPassword()))
					return null;
				
				int userId = result.getInt("user_id");
				boolean isAdmin = result.getBoolean("is_admin");
				user.setUserId(userId);
				user.setAdmin(isAdmin);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int registerUser(User user)
	{
		int rows = 0;
		String sql = "INSERT INTO users (username, password) VALUES (?,?)";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			rows = statement.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	public ResultSet getAllUsers()
	{
		ResultSet result = null;
		String sql = "select user_id, username from users";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	



}
