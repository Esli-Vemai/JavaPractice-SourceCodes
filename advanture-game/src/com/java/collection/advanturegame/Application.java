package com.java.collection.advanturegame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
	private static final Map<Integer, Location> locations = new HashMap<>();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Map<String, Integer> tempExits = new HashMap<>();
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExits));

		tempExits = new HashMap<>();
		tempExits.put("W", 2);
		tempExits.put("E", 3);
		tempExits.put("S", 4);
		tempExits.put("N", 5);
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));

		tempExits = new HashMap<>();
		tempExits.put("N", 5);
		locations.put(2, new Location(2, "You are at the top of a hill", tempExits));
		
		tempExits = new HashMap<>();
		tempExits.put("W", 1);
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));
		
		tempExits = new HashMap<>();
		tempExits.put("N", 1);
		tempExits.put("W", 2);
		locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));
		
		tempExits = new HashMap<>();
		tempExits.put("S", 1);
		tempExits.put("W", 2);
		locations.put(5, new Location(5, "You are in the forest", tempExits));

		int loc = 1;
		while (true) {
			System.out.println(locations.get(loc).getDescription());
			if (loc == 0) {
				break;
			}
			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.print("Available directions are: ");
			for (String key : exits.keySet()) {
				System.out.print(key + ", ");
			}
			System.out.println("\r");
			String direction = scanner.nextLine().toUpperCase();
			if (direction.length() > 1) {
				// My implementation
				/*
				 * String[] strArray = direction.split(" "); 
				 * for (String key: strArray) {
				 * 	direction = processInput(key); 
				 * 		if(containsKey(direction)) break;
				 * 
				 * }
				 */

				// Tim's implementation
				Map<String, String> vocabulary = new HashMap<>();
				vocabulary.put("NORTH", "N");
				vocabulary.put("WEST", "W");
				vocabulary.put("EAST", "E");
				vocabulary.put("SOUTH", "S");
				vocabulary.put("QUIT", "Q");
				String[] strArray = direction.split(" ");
				for (String key : strArray) {
					if (vocabulary.containsKey(key)) {
						direction = vocabulary.get(key);
						break;
					}
				}
			}

			if (exits.containsKey(direction)) {
				loc = exits.get(direction);
			} else {
				System.out.println("You cannot go in that direction");
			}

		}
	}

	// for my implementation
	private static boolean containsKey(String key) {
		return ("W".equals(key) || "E".equals(key) || "N".equals(key) || "S".equals(key) || "Q".equals(key));
	}

	// for my implementation
	private static String processInput(String direction) {
		if ("W".equals(direction) || "E".equals(direction) || "N".equals(direction) || "S".equals(direction)
				|| "Q".equals(direction)) {
			return direction;
		} else if ("WEST".equals(direction)) {
			return "W";
		} else if ("EAST".equals(direction)) {
			return "E";
		} else if ("NORTH".equals(direction)) {
			return "W";
		} else if ("SOUTH".equals(direction)) {
			return "S";
		} else if ("QUIT".equals(direction)) {
			return "Q";
		} else {
			return "X";
		}

	}

}
