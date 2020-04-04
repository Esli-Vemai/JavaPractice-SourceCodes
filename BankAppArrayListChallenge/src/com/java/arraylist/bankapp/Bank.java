/**
 * 
 */
package com.java.arraylist.bankapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author esliv
 *
 */
public class Bank {
	private String name;
	private ArrayList<Branch> branches;
	

	/**
	 * @param name
	 * @param branches
	 */
	public Bank(String name) {
		this.name = name;
		this.branches = new ArrayList<>();
	}

	public boolean addBranch(Branch branch) {
		if (findBranch(branch.getName()) == -1) {			
			return branches.add(branch);
		} else {
			System.out.println("Addition failed. Duplicate branch names are not allowed.");
			return false;
		}

	}

	public boolean addCutomer(String customerName, double transaction, String branchName) {
		int index = findBranch(branchName);
		if (index >= 0) {
			return branches.get(index).addCustomer(customerName, transaction);
		} else {
			return false;
		}

	}

	public boolean addTransaction(String customerName, double transaction, String branchName) {
		int index = findBranch(branchName);
		if (index >= 0) {			
			return branches.get(index).addTransactions(transaction, customerName);
		} else {
			return false;
		}
	}

	public boolean displayCustomersInBranch(String branchName, boolean showTransactions) {
		int index = findBranch(branchName);
		if (index >= 0) {
			ArrayList<Customer> customers = branches.get(index).getCustomers();
			if (showTransactions) {
				for(Customer oneCustomer : customers) {
					System.out.println(oneCustomer.toString());
					//displayTransactionsForCustomer(oneCustomer);					
				}
				
			} else {
				displayCustomerList(customers);
			}
			return true;
		} else {
			System.out.println("Given branch name does not exist.");
			return false;
		}
	}

	private void displayTransactionsForCustomer(Customer customer) {
		ArrayList<Double> transactions = customer.getTransactions();
		System.out.println("Transaction History:");
		transactions.forEach(a -> System.out.println(a));
		
	}
	
	private void displayCustomerList(ArrayList<Customer> list) {		
		list.forEach(c -> System.out.println(c.getName()));
	}

	private int findBranch(String branchName) {
		int index = -1;
		for (int i = 0; i < branches.size(); i++) {
			if (branchName.equalsIgnoreCase(branches.get(i).getName())) {
				index = i;
				return index;
			}
		}

		return index;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<Branch> getBranches() {
		return branches;
	}

}
