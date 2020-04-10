/**
 * 
 */
package com.java.abstractclass.part2.withInterface;

public class Hornbill extends Bird{

	public Hornbill(String name) {
		super(name);
		
	}

	
	@Override
	public boolean flying() {		
		boolean fly = super.flying();
		System.out.println(getName() + " is an expert at flying");
		return fly;
	}

}
