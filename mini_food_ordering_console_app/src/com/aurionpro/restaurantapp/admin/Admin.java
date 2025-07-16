package com.aurionpro.restaurantapp.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.restaurantapp.customer.Customer;
import com.aurionpro.restaurantapp.deliveryagent.DeliveryAgent;
import com.aurionpro.restaurantapp.exceptions.DeliveryAgentNotExistsException;
import com.aurionpro.restaurantapp.food.MainMenu;
import com.aurionpro.restaurantapp.order.Order;
import com.aurionpro.restaurantapp.order.OrderPrinter;

public class Admin {

	private static String adminId = "admin";
	private static String password = "admin@123";
	private static List<DeliveryAgent> agents = new ArrayList<>();
	public static MainMenu mainMenu = new MainMenu();
	private static List<Order> orders = new ArrayList<>();
	private static List<Customer> customers = new ArrayList<>();
	
	public Admin()
	{
		agents.add(new DeliveryAgent("Raj","9876234912"));
		agents.add(new DeliveryAgent("Shaan","8976357465"));
		agents.add(new DeliveryAgent("Rajiv","9846836489"));
	}
	
	public void addFood(Scanner scanner)
	{
		mainMenu.addFood(scanner);
	}
	
	public void removeFood(Scanner scanner)
	{
		mainMenu.deleteFood(scanner);
	}
	
	public static void displayMenu(Scanner scanner)
	{
		mainMenu.displayMenu(scanner);
	}
	
	
	//to be assigned after placing order
	public static void assignDeliveryAgent(Order order)
	{
		for(DeliveryAgent agent : agents)
		{
			if(agent.getIsFree())
			{
				order.setAgent(agent);
				agent.setIsFree(false);
				agent.setOrderId(order.getOrderId());
				return;
			}
		}
		System.out.println("No delivery agents available");
	}
	
	public void viewOrders()
	{
		if(orders==null || orders.isEmpty())
		{
			System.out.println("No orders placed.");
			return;
		}
		
		for(Order order : orders)
		{
			OrderPrinter.printInvoice(order);
		}
	}

	public void addDeliveryAgent(Scanner scanner) {
		System.out.println("Enter the name of agent:");
		String agentName = scanner.nextLine();
		System.out.println("Enter the mobile number:");
		String mobileNumber = scanner.nextLine();
		DeliveryAgent agent = new DeliveryAgent(agentName, mobileNumber);
		agents.add(agent);
		System.out.println("Delivery agent successfully added.");
	}
		
	public void removeDeliveryAgent(Scanner scanner) {
		System.out.println("Enter the ID of delivery agent");
		int id = scanner.nextInt();
		DeliveryAgent agent = null;
		try {
			agent = Utility.deliveryAgentExists(id);
			if(agent == null)
				throw new DeliveryAgentNotExistsException(id);
			agents.remove(agent);
			System.out.println("Delivery agent with Id : "+id+" successfully removed.");
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());;
		}
		
	}
	
	public void showAllDeliveryAgent() 
	{
		System.out.println("All Delivery agents:");
		for(DeliveryAgent agent : agents)
		{
			System.out.println(agent.toString());
			System.out.println();
		}
	}
	
	public static String getAdminId() {
		return adminId;
	}

	public static String getPassword() {
		return password;
	}

	public static List<DeliveryAgent> getAgents() {
		return agents;
	}

	public static MainMenu getMainMenu() {
		return mainMenu;
	}

	public static void setMainMenu(MainMenu mainMenu) {
		Admin.mainMenu = mainMenu;
	}

	public static void setAdminId(String adminId) {
		Admin.adminId = adminId;
	}

	public static void setPassword(String password) {
		Admin.password = password;
	}

	public static void setAgents(List<DeliveryAgent> agents) {
		Admin.agents = agents;
	}

	public static List<Order> getOrders() {
		return orders;
	}

	public static List<Customer> getCustomers() {
		return customers;
	}

	public static void setOrders(List<Order> orders) {
		Admin.orders = orders;
	}

	public static void setCustomers(List<Customer> customers) {
		Admin.customers = customers;
	}

}
