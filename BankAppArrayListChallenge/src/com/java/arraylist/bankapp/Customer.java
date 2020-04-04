/**
 * 
 */
package com.java.arraylist.bankapp;
import java.util.ArrayList;

/**
 * @author esliv
 *
 */
public class Customer {
	private String name;
	private ArrayList<Double> transactions;
	
	/**
	 * @param name
	 * @param transactions
	 */
	public Customer(String name, double initialTransaction) {
		this.name = name;
		this.transactions = new ArrayList<>();
		addTransaction(initialTransaction);
	}

	
	public boolean addTransaction(double transaction) {
		return transactions.add(transaction);
		
	}
	
	
	public String getName() {
		return name;
	}

	/*
	 * public void setName(String name) { this.name = name; }
	 */

	public ArrayList<Double> getTransactions() {
		return transactions;
	}

	/*
	 * public void addTransactions(double amount) { this.transactions.add(amount); }
	 */

	@Override
	public String toString() {
		return "Customer: " + name + "\nTransactions: " + transactions + "\n";
	}
	
	

}
