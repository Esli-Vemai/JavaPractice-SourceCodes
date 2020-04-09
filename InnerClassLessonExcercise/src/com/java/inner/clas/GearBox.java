/**
 * 
 */
package com.java.inner.clas;
import java.util.ArrayList;
/**
 * @author esliv
 *
 */
public class GearBox {	
	private ArrayList<Gear> gears;
	private int currentGear;
	private int maxGear;
	boolean clutchIsIn;
	
	
	public GearBox(int maxGear) {
		this.currentGear = 0;
		this.maxGear = maxGear;
		this.gears = new ArrayList<>();
		Gear innerGear = new Gear(0, 0.0);
		this.gears.add(innerGear);
		
		for(int i = 0; i < maxGear; i++) {
			addGears(i, i*5.0);
		}
	}

	public boolean operateClutch(boolean in) {
		return this.clutchIsIn = in;
	}
	private void addGears(int newGear, double ratio) {
		if(newGear > 0 && newGear <= maxGear) {
			this.gears.add(new Gear(newGear, ratio));
		} else {
			
		}
	}

	public void changeGear(int newGear) {
		if(newGear > 0 && newGear <= maxGear && newGear < this.gears.size() && this.clutchIsIn) {
			this.currentGear = newGear;
			System.out.println("Gear " + newGear + " selected.");
		} else {
			System.out.println("Grind");
			this.currentGear = 0;
		}
	}
	
	public double wheelSpeed(int revs) {
		if(this.clutchIsIn) {
			System.out.println("Scream!!!");
			return 0.0;
		} else {
			return revs * (gears.get(currentGear)).getRatio();
		}
	}
	public int getCurrentGear() {
		return currentGear;
	}


	public int getMaxGear() {
		return maxGear;
	}

	
	
	
	// it makes sense to declare Gear private coz we will only use it within the GearBox class
	private class Gear {
		private int gearNo;
		private double ratio;
		
		public Gear(int gearNo, double ratio) {
			super();
			this.gearNo = gearNo;
			this.ratio = ratio;
		}

		public double driveSpeed(int revs) {
			return revs * this.ratio;
		}
		
		public int getGearNo() {
			return gearNo;
		}

		public double getRatio() {
			return ratio;
		}
		
	}
}
