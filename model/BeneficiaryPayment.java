package com.aurionpro.model;

public class BeneficiaryPayment {

	private int accountId;
	private String name;
	private String accountNumber;
	private String ifsc;
	public BeneficiaryPayment(int accountId, String name, String accountNumber, String ifsc) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.ifsc = ifsc;
	}
	
	
	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
	public void setName(String name) {
		this.name = name;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	
}
