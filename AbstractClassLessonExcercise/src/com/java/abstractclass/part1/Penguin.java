package com.java.abstractclass.part1;

public class Penguin extends Bird{

	public Penguin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean fly() {
		System.out.println(getName() + " does not fly but is an expert swimmer");
		return false;
	}
	
}
