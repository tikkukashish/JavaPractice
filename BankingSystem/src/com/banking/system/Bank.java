package com.banking.system;

import java.util.ArrayList;

public class Bank {
	private String bankName;
	private ArrayList<Customer> customers;

	public Bank(String bankName) {
		this.bankName = bankName;
		this.customers = new ArrayList<>();
	}

	public String getBankName() {
		return bankName;
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
		System.out.println("Customer " + customer.getName() + " added successfully.");
	}

	public Customer findCustomer(String customerId) {
		for (Customer c : customers) {
			if (c.getCustomerId().equals(customerId)) {
				return c;
			}
		}
		return null;
	}

	public void displayAllCustomers() {
		if (customers.isEmpty()) {
			System.out.println("No customers found.");
			return;
		}
		System.out.println("=== All Customers of " + bankName + " ===");
		for (Customer c : customers) {
			System.out.println();
			c.displayCustomerInfo();
		}
	}
}
