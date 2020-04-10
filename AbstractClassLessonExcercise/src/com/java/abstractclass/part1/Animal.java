package com.java.abstractclass.part1;

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
