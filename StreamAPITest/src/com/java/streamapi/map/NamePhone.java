package com.java.streamapi.map;

public class NamePhone {
	@Override
	public String toString() {
		return "NamePhone [name=" + name + ", phoneNo=" + phoneNo + "]";
	}

	String name;
	String phoneNo;
	
	public NamePhone(String name, String phoneNo) {
		this.name = name;
		this.phoneNo = phoneNo;
	}
	
	
}
