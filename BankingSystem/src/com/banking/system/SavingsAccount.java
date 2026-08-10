package com.banking.system;

public class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
		super(accountNumber, holderName, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn: " + amount);
		} else if (amount > balance) {
			System.out.println("Insufficient balance! Available: " + balance);
		} else {
			System.out.println("Invalid amount");
		}
	}

	public void addInterest() {
		double interest = balance * interestRate / 100;
		balance += interest;
		System.out.println("Interest added: " + interest);
	}

	@Override
	public void displayInfo() {
		System.out.println("--- Savings Account ---");
		super.displayInfo();
		System.out.println("Interest Rate: " + interestRate + "%");
	}
}
