package com.aurionpro.model;

public class AccountInfo {
	
	private String accountNumber;
	private String ifsc;
	private Double balance;
	public AccountInfo(String accountNumber, String ifsc, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getIfsc() {
		return ifsc;
	}
	public Double getBalance() {
		return balance;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountInfo [accountNumber=" + accountNumber + ", ifsc=" + ifsc + ", balance=" + balance + "]";
	}
	
	
}
