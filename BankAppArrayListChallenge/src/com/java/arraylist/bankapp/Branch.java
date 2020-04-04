/**
 * 
 */
package com.java.arraylist.bankapp;
import java.util.ArrayList;

/**
 * @author esliv
 *
 */
public class Branch {
	private String name;
	private ArrayList<Customer> customers;
	
	
	/**
	 * @param name
	 * @param customers
	 */
	public Branch(String name) {
		this.name = name;
		this.customers = new ArrayList<>();
	}


	
	public boolean addCustomer(String cusName, double transaction) {		
		if(findCustomer(cusName) != null) {
			System.out.println(cusName + " already in the list");
			return false;
		} else {
			return customers.add(new Customer(cusName, transaction));
		}
	}
	
	public boolean addTransactions(double amount, String customerName) {
		Customer customerObj = findCustomer(customerName);
		if(customerObj != null) {
			return customerObj.addTransaction(amount);
		} else {
			System.out.println(customerName + " already in the list");
			return false;
		}
	}
	private Customer findCustomer(String cusName) {
		Customer foundCustomer = null;
		for(Customer cus : customers) {
			if(cusName.equalsIgnoreCase(cus.getName())) {
				foundCustomer =  cus;
			}
		}
		return foundCustomer;
	}


	public String getName() {
		return name;
	}

	/*
	 * public void setName(String name) { this.name = name; }
	 */

	public ArrayList<Customer> getCustomers() {
		return customers;
	}


	/*
	 * public void setCustomers(ArrayList<Customer> customers) { this.customers =
	 * customers; }
	 */

	@Override
	public String toString() {
		return "Branch: " + name + "\nCustomers: " + customers + "\n";
	}
	
}
