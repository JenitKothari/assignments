package com.aurionpro.exception;

public class MinimumBalanceException extends RuntimeException {
	private int balance;

	public MinimumBalanceException(int balance) {
		super();
		this.balance = balance;
	}

	public String getMessage() {
		return "balance " + balance + " is less than minimum balance.";
	}
}
