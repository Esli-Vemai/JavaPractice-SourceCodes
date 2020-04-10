/**
 * 
 */
package com.java.abstractclass.part1;

public class Hornbill extends Bird{

	public Hornbill(String name) {
		super(name);
		
	}

	
	@Override
	public boolean fly() {
		System.out.println(getName() + " is an expert at flying");
		return true;
	}

}
