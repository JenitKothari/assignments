package com.aurionpro.restaurantapp.order;

import java.time.LocalDate;
import java.util.List;

import com.aurionpro.restaurantapp.customer.Customer;
import com.aurionpro.restaurantapp.deliveryagent.DeliveryAgent;

public class Order {
	
	private static int index = 0;
	private int orderId;
	private LocalDate date;
	//set by customer
	private List<LineItem> items;
	private Customer customer;
	//set by customer 
	private String paymentMode;
	//to be calc by customer
	private double total;
	private static double discount=10;
	private double finalPrice;
	//To be set by admin
	private DeliveryAgent agent;
	
	public Order(Customer customer) {
		super();
		this.orderId = index++;
		this.date = LocalDate.now();
		this.customer = customer;
		this.items = null;
//		this.total = calculateTotal();
//		this.finalPrice = calculateFinalPrice(total,discount);
		
	}

	public void calculateFinalPrice() {
		double finalPrice = (double)total*(100-discount)/100;
		 this.finalPrice = finalPrice;
	}

	public void calculateTotal() {
		double sum=0;
		for(LineItem item : items)
			sum+=item.getTotal();
		this.total=sum;
	}

	public static int getIndex() {
		return index;
	}

	public int getOrderId() {
		return orderId;
	}

	public LocalDate getDate() {
		return date;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public double getTotal() {
		return total;
	}

	public static double getDiscount() {
		return discount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public DeliveryAgent getAgent() {
		return agent;
	}

	public static void setIndex(int index) {
		Order.index = index;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static void setDiscount(double discount) {
		Order.discount = discount;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public void setAgent(DeliveryAgent agent) {
		this.agent = agent;
	}
}
