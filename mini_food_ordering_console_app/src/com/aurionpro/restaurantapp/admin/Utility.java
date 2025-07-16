package com.aurionpro.restaurantapp.admin;

import java.util.List;

import com.aurionpro.restaurantapp.customer.Customer;
import com.aurionpro.restaurantapp.deliveryagent.DeliveryAgent;
import com.aurionpro.restaurantapp.food.Food;
import com.aurionpro.restaurantapp.order.LineItem;

public class Utility {

	public static boolean checkCustomerExists(String userId)
	{
		for(Customer customer : Admin.getCustomers())
		{
			if(customer.getUserId().equals(userId))
				return true;
		}
		return false;
	}
	
	public static Customer customerAuthentication(String userId, String password)
	{
		Customer customer = getCustomer(userId);
		if(customer!=null && customer.getPassword().equals(password))
			return customer;
		System.out.println("Invalid credentials");
		return null;
	}
	
	public static Customer getCustomer(String userId)
	{
		for(Customer customer : Admin.getCustomers())
		{
			if(customer.getUserId().equals(userId))
				return customer;
		}
		return null;
	}
	
	public static void printCart(List<LineItem> items)
	{
		if (items == null || items.isEmpty()) {
	        System.out.println("Your cart is empty.");
	        return;
	    }

	    System.out.println("\n==================== 🛒 CART ====================");
	    System.out.printf("%-5s %-20s %-10s %-10s %-10s%n", "ID", "Item", "Price", "Qty", "Total");

	    double grandTotal = 0;

	    for (LineItem item : items) {
	        Food food = item.getFood();
	        int qty = item.getQuantity();
	        double price = food.getPrice();
	        double total = item.getTotal();
	        grandTotal += total;

	        System.out.printf("%-5d %-20s ₹%-9.2f %-10d ₹%-9.2f%n",
	                food.getFoodId(),
	                food.getFoodName(),
	                price,
	                qty,
	                total);
	    }

	    System.out.println("--------------------------------------------------");
	    System.out.printf("%-47s ₹%-9.2f%n", "Total Amount:", grandTotal);
	    System.out.println("==================================================\n");
	}
	
	public static DeliveryAgent deliveryAgentExists(int id)
	{
		for(DeliveryAgent agent : Admin.getAgents())
		{
			if(agent.getAgentId()==id)
				return agent;
		}
		return null;
	}
}
