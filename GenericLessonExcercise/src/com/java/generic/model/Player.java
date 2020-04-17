package com.java.generic.model;

public abstract class Player {
	String name;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Player: " + name;
	}
	
	
}
