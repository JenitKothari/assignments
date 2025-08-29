package com.aurionpro.model;

public class User {

	private int userId;
	private String username;
	private String password;
	private boolean isAdmin;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public User(int userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}


	public User(int userId, String username, String password, boolean isAdmin) {
	    super();
	    this.userId = userId;
	    this.username = username;
	    this.password = password;
	    this.isAdmin = isAdmin;
	}

	public int getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
