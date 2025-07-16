package com.aurionpro.restaurantapp.payment;

import java.util.Scanner;

import com.aurionpro.restaurantapp.customer.Customer;

public interface IPayment {

	String getPaymentMode();
	boolean pay(Scanner scanner, double amount, Customer customer);
}
