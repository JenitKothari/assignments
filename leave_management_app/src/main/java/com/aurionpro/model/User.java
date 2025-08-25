package com.aurionpro.model;

public class User {
	private int userId;
	private String name;
	private String password;
	private boolean isAdmin;
	
	public User(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
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
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
