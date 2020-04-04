package com.java.arraylist.phonebook;

public class Contacts {
	private String name;
	private int phoneNo;

	public Contacts(String name, int phoneNo) {
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "" + name + ", Phone No: " + phoneNo + ".";
	}
}