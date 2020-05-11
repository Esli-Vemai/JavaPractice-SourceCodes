package com.collection.set;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
	private final String name;
	private final double orbitalDuration;
	private final Set<HeavenlyBody> satellites;
	
	public HeavenlyBody(String name, double orbitalDuration) {
		this.name = name;
		this.orbitalDuration = orbitalDuration;
		this.satellites = new HashSet<>();
	}

	public boolean addMoon(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}
	
	public String getName() {
		return name;
	}

	public double getOrbitalDuration() {
		return orbitalDuration;
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(this.satellites);
	}
	
	
}
