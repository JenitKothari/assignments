package com.aurionpro.restaurantapp.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.restaurantapp.admin.Admin;
import com.aurionpro.restaurantapp.admin.Utility;
import com.aurionpro.restaurantapp.exceptions.FoodNotFoundException;
import com.aurionpro.restaurantapp.exceptions.NegativeAmountException;
import com.aurionpro.restaurantapp.food.Food;
import com.aurionpro.restaurantapp.food.MainMenu;
import com.aurionpro.restaurantapp.order.LineItem;
import com.aurionpro.restaurantapp.order.Order;
import com.aurionpro.restaurantapp.order.OrderPrinter;
import com.aurionpro.restaurantapp.payment.PaymentMenu;


public class Customer {
	
	private String customerName;
	private String address;
	private String mobileNumber;
	private String upiId;
	private String pin;
	private String userId;
	private String password;
	
	private List<Order> customerOrders = new ArrayList<>();
	
	public Customer(String customerName, String address, String mobileNumber, String userId, String password) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.upiId = customerName+"@okaxis";
		this.pin = "1234";
		this.userId = userId;
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getAddress() {
		return address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getUpiId() {
		return upiId;
	}

	public String getPin() {
		return pin;
	}

	public List<Order> getCustomerOrders() {
		return customerOrders;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void addCustomerOrder(Order order) {
		this.customerOrders.add(order);
	}
	
	
	public void displayMenu(Scanner scanner)
	{
		Admin.displayMenu(scanner);
	}
	
	public void placeNewOrder(Scanner scanner)
	{
		Order order = new Order(this);
		List<LineItem> items = new ArrayList<>();
		int choice=0;
		while(choice!=3)
		{
			System.out.println("1 = Add new item\n2 = View cart\n3 = Confirm order");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				
				System.out.println("Enter food id:");
				int foodId = scanner.nextInt();
				System.out.println("Enter quantity");
				int quantity = 0;
				try {
					quantity = scanner.nextInt();
					if(quantity<0)
						throw new NegativeAmountException(quantity);
				}catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
				
				Food food = null;
				try {
					food = MainMenu.checkFoodExistsById(foodId);
					if(food==null)
						throw new FoodNotFoundException(foodId);
					int index = checkFoodInCart(foodId,items);
					if(index!=-1)
					{
						LineItem previousItem = items.get(index);
						int previousQuantity = previousItem.getQuantity();
						int newOuantity = previousQuantity+quantity;
						items.get(index).setQuantity(newOuantity);
						items.get(index).setTotal((newOuantity)*previousItem.getFood().getPrice());
						continue;
					}
					LineItem item = new LineItem(food, quantity);
					items.add(item);
				}
				catch(Exception exception)
				{
					System.out.println(exception.getMessage());
				}
				break;
			case 2:
				Utility.printCart(items);
				break;
			case 3:
				order.setItems(items);
				order.calculateTotal();
				order.calculateFinalPrice();
				boolean paid = PaymentMenu.paymentGateway(order,scanner);
				while(!paid)
				{
					System.out.println("Retry payment");
					paid = PaymentMenu.paymentGateway(order,scanner);
				}
				Admin.assignDeliveryAgent(order);
				customerOrders.add(order);
				Admin.getOrders().add(order);
				OrderPrinter.printInvoice(order);
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	public void showOrderHistory()
	{
		if(customerOrders==null || customerOrders.isEmpty())
		{
			System.out.println("No orders found.");
			return;
		}
		System.out.println("Order history:");
		System.out.println();
		int i=1;
		for(Order order : customerOrders)
		{
			System.out.println("Order "+i+" :");
			OrderPrinter.printInvoice(order);
			i++;
		}
	}
	
	
	private int checkFoodInCart(int foodId, List<LineItem> items) 
	{
		for(int i=0; i<items.size();i++)
		{
			if(items.get(i).getFood().getFoodId()==foodId)
				return i;
		}
		return -1;
	}
	
	
}

