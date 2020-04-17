package com.java.generic.practice;

import java.util.ArrayList;

import com.java.generic.model.Player;

public class Team<T extends Player> implements Comparable<Team<T>>{
	private String name;
	private int won;
	private int lost;
	private int draw;
	ArrayList<T> members = 	new ArrayList<>();
	
	public Team(String name) {
		this.name = name;
		this.won = 0;
		this.lost = 0;
		this.draw = 0;

	}
	
	
	public Team(String name, int won, int lost, int draw) {
		super();
		this.name = name;
		this.won = won;
		this.lost = lost;
		this.draw = draw;
	}


	public boolean addPlayer(T player) {
		if(members.contains(player)) {
			System.out.println("Player is already in the team.");
			return false;
		} else {
			members.add(player);
			System.out.println(player.getName() + " picked by team " + this.name);
			return true;
		}
	}

	public T findPlayer(String name) {
		/*
		 * for (Iterator iterator = members.iterator(); iterator.hasNext();) { T t = (T)
		 * iterator.next();
		 * 
		 * }
		 */
		for (int i = 0; i < members.size(); i++) {
			String player = members.get(i).getName();
			if(name == player) {
				return members.get(i);
			}
		}
		return null;
	}
	
	public int numOfPlayers() {
		return this.members.size();
	}
	
	public void displaMathResult(Team<T> opponent, int ourScore, int theirScore) {
		String message;
		if (ourScore > theirScore) {
			won++;
			message = " beats ";
		} else if (ourScore < theirScore) {
			lost++;
			message = " lost against ";
		} else {
			draw++;
			message = " drew ";
		}
		
		if (opponent != null) {
			System.out.println(this.name + message + opponent.name);
			opponent.displaMathResult(null, ourScore, theirScore);
		}
	}
	
	public void displayPlayers() {
		members.forEach(a -> System.out.println(a));
	}
	public int ranking() {
		return (won * 3) + draw;
	}
	
	@Override
	public int compareTo(Team<T> member) {
		if(this.ranking() > member.ranking()) {
			return 1;
		} else if(this.ranking() < member.ranking()) {
			return -1;
		} else {
			return 0;
		}
	}

	public String getName() {
		return name;
	}

	public ArrayList<T> getMembers() {
		return members;
	}
}
