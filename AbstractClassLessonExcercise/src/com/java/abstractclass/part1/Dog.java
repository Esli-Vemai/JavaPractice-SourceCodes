package com.java.abstractclass.part1;

public class Dog extends Animal{

	public Dog(String name) {
		super(name);
		
	}

	@Override
	public void breath() {
		System.out.println(getName() + " is breathing in and out");
		
	}

	@Override
	public void eat() {
		System.out.println(getName() + " is chewing and swallowing food");
		
	}
	
}
