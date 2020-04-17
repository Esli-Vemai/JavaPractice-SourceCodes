package com.java.generics.challenge.model;

public abstract class Sport {
	private String sportType;

	public Sport(String sportType) {
		this.sportType = sportType;
	}

	public String getSportType() {
		return sportType;
	}
	
}
