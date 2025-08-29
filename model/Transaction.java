package com.aurionpro.model;

import java.sql.Timestamp;

public class Transaction {
	
	private int transactionId;
	private int accountId;
	private Timestamp txnDate;
	private int otherAccountId;
	private TransactionType type;
	private double amount;
	
	public Transaction(int transactionId, int accountId, Timestamp txnDate, int otherAccountId,
			TransactionType type, double amount) {
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.txnDate = txnDate;
		this.otherAccountId = otherAccountId;
		this.type = type;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}
	public int getAccountId() {
		return accountId;
	}
	public int getOtherAccountId() {
		return otherAccountId;
	}
	public TransactionType getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
	public Timestamp getTxnDate() {
		return txnDate;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public void setOtherAccountId(int otherAccountId) {
		this.otherAccountId = otherAccountId;
	}
	public void setType(TransactionType type) {
		this.type = type;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setTxnDate(Timestamp txnDate) {
		this.txnDate = txnDate;
	}
}
