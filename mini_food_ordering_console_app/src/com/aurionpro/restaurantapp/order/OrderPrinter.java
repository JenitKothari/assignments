package com.aurionpro.restaurantapp.order;

public class OrderPrinter {

	public static void printInvoice(Order order) 
	{
		System.out.println("\n================== INVOICE ==================");
		System.out.printf("Order ID     : %d%n", order.getOrderId());
		System.out.printf("Date         : %s%n", order.getDate());
		System.out.printf("Customer     : %s%n", order.getCustomer().getCustomerName());
		System.out.printf("Address      : %s%n", order.getCustomer().getAddress());
		System.out.printf("Payment Mode : %s%n", order.getPaymentMode());

		if (order.getAgent() != null) {
			System.out.printf("Delivery By  : %s%n", order.getAgent().getAgentName());
			System.out.printf("Agent Mobile : %s%n", order.getAgent().getMobileNumber());
		}

		System.out.println("\n------------------ Items -------------------");
		System.out.printf("%-25s %-10s %-10s %-10s%n", "Item Name", "Qty", "Price", "Total");

		for (LineItem item : order.getItems()) {
			String name = item.getFood().getFoodName();
			int qty = item.getQuantity();
			double price = item.getFood().getPrice();
			double total = item.getTotal();
			System.out.printf("%-25s %-10d ₹%-9.2f ₹%-9.2f%n", name, qty, price, total);
		}

		System.out.println("--------------------------------------------");
		System.out.printf("Subtotal     : ₹%.2f%n", order.getTotal());
		System.out.printf("Discount (%.0f%%): ₹%.2f%n", Order.getDiscount(), order.getTotal() - order.getFinalPrice());
		System.out.printf("Final Total  : ₹%.2f%n", order.getFinalPrice());
		System.out.println("============================================\n");

	}
}
