/**
 * 
 */
package com.java.abstractclass.part2.withInterface;

/**
 * @author esliv
 * Bats are not bird but they can fly. So implement the FlyingAnimals without extending Bird
 */
public class Bat extends Animal implements FlyingAnimals{

	public Bat(String name) {
		super(name);
		
	}

	@Override
	public boolean flying() {
		System.out.println("Who says only birds can fly? I am a mammal but I am also an "
				+ "expert at flying");
		return true;
	}

	@Override
	public void breath() {
		System.out.println(getName() + " breaths in and out");
		
	}

	@Override
	public void eat() {
		System.out.println(getName() + ": they say sucks human blood");
		
	}

}
