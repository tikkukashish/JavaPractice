package com.banking.system;

public class CurrentAccount extends Account {
	private double overdraftLimit;

	public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
		super(accountNumber, holderName, balance);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	@Override
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance + overdraftLimit) {
			balance -= amount;
			System.out.println("Withdrawn: " + amount);
			if (balance < 0) {
				System.out.println("Warning: You are using overdraft. Balance: " + balance);
			}
		} else if (amount > balance + overdraftLimit) {
			System.out.println("Exceeds overdraft limit! Max withdrawal: " + (balance + overdraftLimit));
		} else {
			System.out.println("Invalid amount");
		}
	}

	@Override
	public void displayInfo() {
		System.out.println("--- Current Account ---");
		super.displayInfo();
		System.out.println("Overdraft Limit: " + overdraftLimit);
	}
}
