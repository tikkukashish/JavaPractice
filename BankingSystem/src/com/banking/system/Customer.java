package com.banking.system;

public class Customer {
	private String customerId;
	private String name;
	private Account account;

	public Customer(String customerId, String name, Account account) {
		this.customerId = customerId;
		this.name = name;
		this.account = account;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public Account getAccount() {
		return account;
	}

	public void displayCustomerInfo() {
		System.out.println("Customer ID: " + customerId);
		System.out.println("Customer Name: " + name);
		account.displayInfo();
	}
}
