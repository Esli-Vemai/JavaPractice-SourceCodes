/**
 * 
 */
package com.java.practice;

import java.util.Scanner;

import com.java.practice.interfaz.ICharacter;
import com.java.practice.interfaz.impl.Monster;
import com.java.practice.interfaz.impl.Player;

import java.util.List;
import java.util.ArrayList;

/**
 * @author esliv
 *
 */
public class GameCharacterMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a simple interface that allows an object to be saved to some sort of
		// storage medium.
		// The exact type of medium is not known to the interface (nor to the classes
		// that implement it).
		// The interface will just specify 2 methods, one to return an ArrayList of
		// values to be saved
		// and the other to populate the object's fields from an ArrayList.
		//
		// Create some sample classes that implement your saveable interface (we've used
		// the idea of a game,
		// with Players and Monsters, but you can create any type of classes that you
		// want).
		//
		// Override the toString() method for each of your classes so that they can be
		// easily printed to enable
		// the program to be tested easier.
		//
		// In Main, write a method that takes an object that implements the interface as
		// a parameter and
		// "saves" the values.
		// We haven't covered I/O yet, so your method should just print the values to
		// the screen.
		// Also in Main, write a method that restores the values to a saveable object.
		// Again, we are not going to use Java file I/O; instead use the readValues()
		// method below to
		// simulate getting values from a file – this allows you to type as many values
		// as your class
		// requires, and returns an ArrayList.

		Player player = new Player("John Doe", "Sword", 65.98);
		System.out.println(player);
		saveObject(player);
		player = new Player("Esli Vemai", "Lightsaber", 100.00);
		System.out.println(player);
		loadObject(player);
		System.out.println(player);

		ICharacter werewolf = new Monster("Werewolf", "super durability", 80);
		System.out.println("Strength = " + ((Monster) werewolf).getHitPower());
		// but cant do like werewolf.getHitPower, coz of using interface. We need 
		// to cast to the class type.
		System.out.println(werewolf);
		saveObject(werewolf);
	}

	private static List<String> readValue() {
		List<String> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		boolean start = true;
		int index = 0;

		while (start) {
			System.out.println("Enter your choice " + "\n1 - Exit App.. " + "\n2 - Input data...");
			int choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
			case 1:
				start = false;
				System.out.println("Exiting the switch");
				break;
			case 2:
				if (index > 3) {
					start = false;
				}
				System.out.println("Enter String input");
				String input = scan.nextLine();

				list.add(index, input);
				index++;

				break;

			}
		}
		scan.close();
		return list;

	}

	private static void saveObject(ICharacter character) {
		int length = character.writeTo().size();
		for (int a = 0; a < length; a++) {
			System.out.println("Saving " + character.writeTo().get(a) + " to the storage divice");
		}
	}

	private static void loadObject(ICharacter character) {
		List<String> attributes = readValue();
		character.readFrom(attributes);
	}
}
