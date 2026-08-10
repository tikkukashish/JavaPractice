package com.banking.system;

import java.util.Scanner;

public class BankingApp {
	static Bank bank = new Bank("MyBank");
	static Scanner sc = new Scanner(System.in);
	static int accountCounter = 1001;
	static int customerCounter = 1;

	public static void main(String[] args) {
		int choice;

		do {
			System.out.println("\n===== Banking System =====");
			System.out.println("1. Create Savings Account");
			System.out.println("2. Create Current Account");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Check Balance");
			System.out.println("6. Add Interest (Savings Account)");
			System.out.println("7. Display All Customers");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				createSavingsAccount();
				break;
			case 2:
				createCurrentAccount();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				checkBalance();
				break;
			case 6:
				addInterest();
				break;
			case 7:
				bank.displayAllCustomers();
				break;
			case 8:
				System.out.println("Thank you for using Banking System!");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		} while (choice != 8);
	}

	static void createSavingsAccount() {
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		System.out.print("Enter initial deposit: ");
		double deposit = sc.nextDouble();
		System.out.print("Enter interest rate: ");
		double rate = sc.nextDouble();

		String accNo = "ACC" + accountCounter++;
		String custId = "C" + customerCounter++;

		SavingsAccount sa = new SavingsAccount(accNo, name, deposit, rate);
		Customer customer = new Customer(custId, name, sa);
		bank.addCustomer(customer);

		System.out.println("Account created! Account Number: " + accNo + ", Customer ID: " + custId);
	}

	static void createCurrentAccount() {
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		System.out.print("Enter initial deposit: ");
		double deposit = sc.nextDouble();
		System.out.print("Enter overdraft limit: ");
		double limit = sc.nextDouble();

		String accNo = "ACC" + accountCounter++;
		String custId = "C" + customerCounter++;

		CurrentAccount ca = new CurrentAccount(accNo, name, deposit, limit);
		Customer customer = new Customer(custId, name, ca);
		bank.addCustomer(customer);

		System.out.println("Account created! Account Number: " + accNo + ", Customer ID: " + custId);
	}

	static void deposit() {
		System.out.print("Enter Customer ID: ");
		String id = sc.nextLine();
		Customer c = bank.findCustomer(id);

		if (c == null) {
			System.out.println("Customer not found!");
			return;
		}

		System.out.print("Enter amount to deposit: ");
		double amount = sc.nextDouble();
		c.getAccount().deposit(amount);
		System.out.println("Current Balance: " + c.getAccount().getBalance());
	}

	static void withdraw() {
		System.out.print("Enter Customer ID: ");
		String id = sc.nextLine();
		Customer c = bank.findCustomer(id);

		if (c == null) {
			System.out.println("Customer not found!");
			return;
		}

		System.out.print("Enter amount to withdraw: ");
		double amount = sc.nextDouble();
		c.getAccount().withdraw(amount);
		System.out.println("Current Balance: " + c.getAccount().getBalance());
	}

	static void checkBalance() {
		System.out.print("Enter Customer ID: ");
		String id = sc.nextLine();
		Customer c = bank.findCustomer(id);

		if (c == null) {
			System.out.println("Customer not found!");
			return;
		}

		c.displayCustomerInfo();
	}

	static void addInterest() {
		System.out.print("Enter Customer ID: ");
		String id = sc.nextLine();
		Customer c = bank.findCustomer(id);

		if (c == null) {
			System.out.println("Customer not found!");
			return;
		}

		if (c.getAccount() instanceof SavingsAccount) {
			SavingsAccount sa = (SavingsAccount) c.getAccount();
			sa.addInterest();
			System.out.println("Updated Balance: " + sa.getBalance());
		} else {
			System.out.println("Interest can only be added to Savings Account.");
		}
	}
}
