/**
 * 
 */
package com.java.arraylist.bankapp;

import java.util.Scanner;

/**
 * @author esliv
 *
 */
public class BankApp {
	private static final Scanner scan = new Scanner(System.in);
	private static Bank bank = new Bank("HDFC");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		startApp();
		boolean start = true;
		printInstructions();

		while (start) {
			System.out.println("Enter option of your choice:");
			if (scan.hasNextInt()) {
				int option = scan.nextInt();
				scan.nextLine();
				switch (option) {
				case 1:
					printInstructions();
					break;
				case 2:
					addABranch();
					break;
				case 3:
					addACustomer();
					break;
				case 4:
					addATransaction();
					break;
				case 5:
					displayCutomerAndTransactions();
					break;
				case 6:
					start = false;
					System.out.println("Thank you for using the Bank App...");
					break;

				}
			} else {
				System.out.println("Enter your option in number, not letters");
				scan.nextLine();
			}
		}

	}

	private static void startApp() {
		System.out.println("Starting the Bank App...");
	}

	private static void printInstructions() {
		System.out.println("1 - Print instructions");
		System.out.println("2 - Add a branch to the bank");
		System.out.println("3 - Add a customer to the branch");
		System.out.println("4 - Add transactions to the customer account at a particular branch");
		System.out
				.println("5 - Display list of customers of a branch, along with their " + " transactions if you want");
		System.out.println("6 -  Exit the Bank App");
	}

	private static void addABranch() {
		System.out.println("Enter branch name:");
		String branch = scan.nextLine();
		boolean branchAdded = bank.addBranch(new Branch(branch));
		if (branchAdded) {
			System.out.println("Branch added successful");
		} else {
			System.out.println("Branch addition error");
		}
	}

	private static void addACustomer() {
		System.out.println("Enter branch name the customer belongs to:");
		String branchName = scan.nextLine();
		System.out.println("Enter customer name & initial transaction amount:");
		String customerName = scan.nextLine();
		double transaction = isDouble();
		boolean customerAdded = bank.addCutomer(customerName, transaction, branchName);

		if (customerAdded) {
			System.out.println("Customer added to the branch");
		} else {
			System.out.println("Customer addition error");
		}
	}

	private static void addATransaction() {
		System.out.println("Enter the customer name:");
		String customerName = scan.nextLine();
		System.out.println("Enter the branch the customer belongs to:");
		String branchName = scan.nextLine();
		System.out.println("Enter the transaction amount:");
		double transaction = isDouble();
		boolean transactionAdded = bank.addTransaction(customerName, transaction, branchName);

		if (transactionAdded) {
			System.out.println("Transactions added for the customer");
		} else {
			System.out.println("Transactions addition error");
		}
	}

	private static void displayCutomerAndTransactions() {
		boolean displayTransactions = false;
		System.out.println("Enter the branch name:");
		String branchName = scan.nextLine();
		System.out.println("Display transaction? Y/N");
		String display = scan.nextLine();
		if ("Y".equalsIgnoreCase(display)) {
			displayTransactions = true;
		}
		bank.displayCustomersInBranch(branchName, displayTransactions);
	}

	private static double isDouble() {
		boolean flag = true;
		double index = 0.0;
		while (flag) {
			if (scan.hasNextDouble()) {
				index = scan.nextDouble();
				flag = false;
			} else {
				System.out.println("Enter transaction amount in numbers, not letters");
				scan.nextLine();
			}
		}
		return index;
	}

}
