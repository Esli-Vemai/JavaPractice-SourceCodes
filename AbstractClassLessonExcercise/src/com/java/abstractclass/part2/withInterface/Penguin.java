package com.java.abstractclass.part2.withInterface;

public class Penguin extends Bird{

	public Penguin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean flying() {
		//super.flying();
		System.out.println(getName() + " does flaps their wings but don not fly. "
				+ "They are expert swimmers though");
		return false;
	}
	
}
