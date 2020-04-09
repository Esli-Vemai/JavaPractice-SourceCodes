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
public class Monster implements ICharacter{
	private String name;
	private double health;
	private String ability;
	private double hitPower;
	
	/**
	 * @param name
	 * @param ability
	 * @param hitPower
	 */
	public Monster(String name, String ability, double hitPower) {
		super();
		this.name = name;
		this.ability = ability;
		this.hitPower = hitPower;
		this.health = defaultHealth;
	}

	
	@Override
	public void readFrom(List<String> list) {
		if(!list.isEmpty() && list != null) {
			this.name = list.get(0);
			this.health = Double.parseDouble(list.get(1));
			this.ability = list.get(2);
			this.hitPower = Double.valueOf(list.get(3));
		} else {
			System.out.println("List is empty");
		}
		
	}


	@Override
	public List<String> writeTo() {
		List<String> list = new ArrayList<>();
		list.add(0, this.name);
		list.add(1, String.valueOf(this.health));
		list.add(2, this.ability);
		list.add(3, Double.toString(this.hitPower));
		return list;
	}


	public String getName() {
		return name;
	}

	public double getHealth() {
		return health;
	}

	public String getAbility() {
		return ability;
	}

	public double getHitPower() {
		return hitPower;
	}

	@Override
	public String toString() {
		return String.format("Monster {name=%s, health=%s, ability=%s, hitPower=%s}", name, health, ability, hitPower);
	}
	
	
}
