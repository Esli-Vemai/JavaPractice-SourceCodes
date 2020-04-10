package com.java.abstractclass.part2.withInterface;

public abstract class Animal {
	private String name;

	public Animal(String name) {
		this.name = name;
	}
	
	public abstract void breath();
	public abstract void eat();

	public String getName() {
		return name;
	}
	
}
