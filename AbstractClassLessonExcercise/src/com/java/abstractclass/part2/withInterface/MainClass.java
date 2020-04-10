package com.java.abstractclass.part2.withInterface;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("======== Hello from Part 2 =========\n");
		Animal dog = new Dog("German Shepherd");
		dog.breath();
		dog.eat();
		
		Animal bird = new Hornbill("Oriental Hornbill");
		bird.breath();
		bird.eat();
		((Bird) bird).flying();
		
		Bird penguin = new Penguin("Emperior Penguin");
		penguin.flying();
		
		Bat bat = new Bat("Ebola Bat");
		bat.breath();
		bat.eat();
		bat.flying();
	}

}
