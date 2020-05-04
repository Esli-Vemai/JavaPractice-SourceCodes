package com.java.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapPartone {
	
	static Map<String, String> proLanguages = new HashMap<>();
	public static void main(String[] args) {
		
		proLanguages.put("Java", "a compiled high level, object-oriented, platform independent language");

		proLanguages.put("Python",
				"an interpreted, object-oriented, high-level programming language with dynamic semantics");
		proLanguages.put("Algol", "an algorithmic language");
		proLanguages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");

		System.out.println("Java: " + proLanguages.get("Java"));
		if(!proLanguages.containsKey("Java")) {
			proLanguages.put("Java", "Another Object Oriented program");
			
		} else {
			System.out.println("Java is already in the map");
			String prevVal = proLanguages.put("Java", "Another Object Oriented program");
			System.out.println("prevVal: " + prevVal);
		}
		
		
		printMap();
		
	}
	
	
	private static void printMap() {
		System.out.println("================================");
		for (String key : proLanguages.keySet()) {
			System.out.println(key + ": " + proLanguages.get(key));
		}
	}

}
