package com.java.collection.advanturegame;

import java.util.HashMap;
import java.util.Map;

/**
 * @author esliv
 *
 */
public class Location {
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits;
	
	public Location(int locationId, String description) {
		this.locationId = locationId;
		this.description = description;
		this.exits = new HashMap<>();
		this.exits.put("Q", 0);
	}
	
	
	public void addExits(String direction, int location) {
		if(!exits.containsKey(direction)) {
			exits.put(direction, location);
		} else {
			System.out.println(direction + " has already been added. ");
		}
	}


	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}


	
	/**
	 * @return a new HashMap
	 * In certain scenarios, it is useful to return a new Map 
	 * (with the contents of the old man) to make sure that the old Map is 
	 *  not been modified illegally.
	 */
	public Map<String, Integer> getExits() {
		return new HashMap<>(exits) ;
	}
	
	
}
