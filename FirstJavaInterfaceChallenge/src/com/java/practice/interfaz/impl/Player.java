/**
 * 
 */
package com.java.practice.interfaz.impl;

import java.util.List;
import java.util.ArrayList;

import com.java.practice.interfaz.ICharacter;

/**
 * @author esliv
 *
 */
public class Player implements ICharacter{
	private String name;
	private double health;
	private String weapon;
	private double hitPower;
	

	/**
	 * @param name
	 * @param weapon
	 * @param hitPower
	 */
	public Player(String name, String weapon, double hitPower) {
		super();
		this.name = name;
		this.weapon = weapon;
		this.hitPower = hitPower;
		this.health = defaultHealth;
	}
	
	
	@Override
	public List<String> writeTo() {
		List<String> list = new ArrayList<>();
		list.add(0, this.name);
		list.add(1, Double.toString(this.health));
		list.add(2, this.weapon);
		list.add(3, Double.toString(this.hitPower));
		
		return list;
	}

	@Override
	public void readFrom(List<String> list) {
		if(!list.isEmpty() && list != null) {
			this.name = list.get(0);
			this.health = Double.valueOf(list.get(1));
			this.weapon = list.get(2);
			this.hitPower = Double.valueOf(list.get(3));
		} else {
			System.out.println("List is empty");
		}
		
	}
	

	public String getName() {
		return name;
	}

	public double getHealth() {
		return health;
	}

	public String getWeapon() {
		return weapon;
	}

	public double getHitPower() {
		return hitPower;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", health=" + health + ", weapon=" + weapon + ", hitPower=" + hitPower + "]";
	}
	
	
}
