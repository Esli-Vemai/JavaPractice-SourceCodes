package com.java.abstractclass.part2.withInterface;

public abstract class Bird extends Animal implements FlyingAnimals{

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

	@Override
	public boolean flying() {
		System.out.println("Birds flap their wings to fly");
		return true;
	}
	
}
