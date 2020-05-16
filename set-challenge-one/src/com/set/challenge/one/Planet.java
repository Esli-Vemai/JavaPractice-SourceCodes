package com.set.challenge.one;

public final class Planet extends HeavenlyBody{

	public Planet(String name, double orbitalDuration) {
		super(name, orbitalDuration, Type.valueOf("PLANET"));
		
	}
	
	
	@Override
	public boolean addSatellite(HeavenlyBody moon) {
		if(moon.getBodyType() == Type.MOON) {
		// or if (this.getBodyType == moon.getBodyType)
			return super.addSatellite(moon);
		} else {
			System.out.println("Only satallite of type moon are allowed for planets");
			return false;
		}
		
	}

}
