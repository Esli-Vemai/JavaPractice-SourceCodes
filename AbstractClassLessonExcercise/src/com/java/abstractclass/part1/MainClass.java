package com.java.abstractclass.part1;

public class MainClass {

	public static void main(String[] args) {
		Animal dog = new Dog("German Shepherd");
		dog.breath();
		dog.eat();
		
		Animal bird = new Hornbill("Oriental Hornbill");
		bird.breath();
		bird.eat();
		((Bird) bird).fly();
		
		Bird penguin = new Penguin("Emperior Penguin");
		penguin.fly();
	}

}
