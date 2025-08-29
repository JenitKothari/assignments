package com.aurionpro.model;

public class AccountDetails {

	private int accountId;
	private int userId;
	private String name;
	private String accountNumber;
	private String ifsc;
	private String mobileNumber;
	private String address;
	private double balance;
	private ActionStatus status;
	
	public AccountDetails(int accountId, int userId, String name, String accountNumber, String ifsc,
			String mobileNumber, String address, double balance) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.balance = balance;
	}
	
	public AccountDetails(int userId, String name, String accountNumber, String ifsc,
			String mobileNumber, String address, double balance) {
		super();
		this.userId = userId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.balance = balance;
	}			
	
	public AccountDetails(int userId, String name, String ifsc, String mobileNumber, String address, double balance) {
		super();
		this.userId = userId;
		this.name = name;
		this.ifsc = ifsc;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.balance = balance;
	}

	public AccountDetails(int accountId, int userId, String name, String ifsc, String mobileNumber, String address,
			double balance, ActionStatus status) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.name = name;
		this.ifsc = ifsc;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.balance = balance;
		this.status = status;
	}

	
	
	public ActionStatus getStatus() {
		return status;
	}

	public void setStatus(ActionStatus status) {
		this.status = status;
	}

	public int getAccountId() {
		return accountId;
	}
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getIfsc() {
		return ifsc;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public double getBalance() {
		return balance;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
