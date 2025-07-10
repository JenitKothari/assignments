package com.aurionpro.model;

import java.util.Random;

public class AccountBasic {
	private String accountNumber;
	private String name;
	private int balance;
	public AccountType accountType;
	
	public AccountBasic()
	{}
	
	public AccountBasic(String name, int balance, AccountType accountType) {
		super();
		this.accountNumber = generateAccountNumber();
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void viewBalance()
	{
		System.out.println("Current Balance : Rs."+getBalance());
	}
	
	public String generateAccountNumber()
	{
		Random r = new Random();
		String accountNumber = "IDBI1000";
		for(int i=0; i<4; i++)
		{
			accountNumber += r.nextInt(10);
		}
		return accountNumber;
	}
	
	
}
