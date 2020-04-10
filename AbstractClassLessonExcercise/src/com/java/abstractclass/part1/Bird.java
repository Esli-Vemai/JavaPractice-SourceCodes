package com.java.abstractclass.part1;

public abstract class Bird extends Animal{

	public Bird(String name) {
		super(name);
		
	}

	@Override
	public void breath() {
		System.out.println(getName() + " is breathing in and out ");
		
	}

	@Override
	public void eat() {
		System.out.println(getName() + " is pecking food and swallowing whole without chewing");
	}
	
	public abstract boolean fly();

}
