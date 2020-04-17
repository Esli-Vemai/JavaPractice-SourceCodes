package com.java.generics.challenge.logics;

import com.java.generics.challenge.model.Sport;

public class Team<S extends Sport> implements Comparable<Team<S>> {
	private String name;
	private int win;
	private int lost;
	private int draw;

	public Team(String name) {
		super();
		this.name = name;
	}

	public Team(String name, int win, int lost, int draw) {
		super();
		this.name = name;
		this.win = win;
		this.lost = lost;
		this.draw = draw;
	}

	public void updateMatchResult(Team<S> opp, int ourScore, int theirScore) {
		String message;
		if (ourScore > theirScore) {
			win++;
			message = " beats ";
		} else if (ourScore < theirScore) {
			lost++;
			message = " lost against ";
		} else {
			draw++;
			message = " drew ";
		}

		if (opp != null) {
			//System.out.println(this.name + message + opp.name);
			opp.updateMatchResult(null, ourScore, theirScore);
		}
	}

	public int ranking() {
		return (win * 3) + draw;
	}

	@Override
	public int compareTo(Team<S> opponent) {
		if (this.ranking() > opponent.ranking()) {
			return -1;
		} else if (this.ranking() < opponent.ranking()) {
			return 1;
		} else {
			return 0;
		}

	}
//	@Override
//	public int compareTo(Team<S> opponent) {
//		if(this.getWin() > opponent.getWin()) {
//			return -1;
//		} else if (this.getWin() < opponent.getWin()) {
//			return 1;
//		} else {
//			return 0;
//		}
//		
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	@Override
	public String toString() {
		return "Team: " + name + " ( win: " + win + " lost: " + lost + " draw: " + draw + " )";
	}

}
