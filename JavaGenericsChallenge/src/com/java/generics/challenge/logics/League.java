package com.java.generics.challenge.logics;

import java.util.ArrayList;
import java.util.Collections;

import com.java.generics.challenge.model.Sport;

public class League<S extends Sport> {
	private String league;
	private ArrayList<Team<S>> teams;
	
	public League(String league) {
		this.league = league;
		this.teams = new ArrayList<>();
	}
	
	public boolean addTeam(Team<S> team) {
		if(team == null) {
			System.out.println("Team of type \"Null\" is not allowed");
			return false;
		}
		if(teams.contains(team)) {
			System.out.println(team.getName() + " is already in the league");
		} else {
			teams.add(team);
			System.out.println(team.getName() + " added to the league " + this.league);
			return true;
		}
		return false;
	}
	
	
	public void updateMatchResult(Team<S> our, Team<S> opp, int ourScore, int theirScore) {
		our.updateMatchResult(opp, ourScore, theirScore);
		
		/*
		 * if(our != null && opp != null) { if(ourScore > theirScore) { our.setWin(1);
		 * opp.setLost(1); } else if(ourScore < theirScore) { our.setLost(1);
		 * opp.setWin(1); } else { our.setDraw(1); opp.setDraw(1); }
		 * 
		 * }
		 */
	}
	
	/*
	 * public int ranking() {
	 * 
	 * }
	 */
	
	
	public void printLeague() {
		Collections.sort(teams);
		teams.forEach(t -> System.out.println(t));
	}
	
	
	
	public String getLeague() {
		return league;
	}
	public ArrayList<Team<S>> getTeams() {
		return teams;
	}
	
}
