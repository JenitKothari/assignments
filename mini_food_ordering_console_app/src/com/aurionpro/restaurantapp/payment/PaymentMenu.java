package com.aurionpro.restaurantapp.payment;

import java.util.Scanner;

import com.aurionpro.restaurantapp.order.Order;

public class PaymentMenu {
	
	
	
	public static boolean paymentGateway(Order order, Scanner scanner)
	{
		boolean paid = false;
		IPayment paymentMode;
		System.out.println("Select mode of payment:");
		System.out.println("1 = COD\n2 = UPI");
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			paymentMode = new CodPayment();
			paid = paymentMode.pay(scanner, order.getFinalPrice(), order.getCustomer());
			if(paid)
			{
				order.setPaymentMode(paymentMode.getPaymentMode());
			}
			break;
		case 2:
			paymentMode = new UpiPayment();
			paid = paymentMode.pay(scanner, order.getFinalPrice(), order.getCustomer());
			if(paid)
			{
				order.setPaymentMode(paymentMode.getPaymentMode());
			}
			break;
		default:
			System.out.println("Invalid choice");
		}
		return paid;
	}
}
