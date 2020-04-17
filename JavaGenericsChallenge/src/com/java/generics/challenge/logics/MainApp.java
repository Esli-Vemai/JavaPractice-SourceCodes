package com.java.generics.challenge.logics;

import com.java.generics.challenge.model.Basketball;
import com.java.generics.challenge.model.Cricket;
import com.java.generics.challenge.model.Football;

public class MainApp {
	 // Create a generic class to implement a league table for a sport.
    // The class should allow teams to be added to the list, and store
    // a list of teams that belong to the league.
    //
    // Your class should have a method to print out the teams in order,
    // with the team at the top of the league printed first.
    //
    // Only teams of the same type should be added to any particular
    // instance of the league class - the program should fail to compile
    // if an attempt is made to add an incompatible team.

	public static void main(String[] args) {
	League<Football> epl = new League<>("EPL");
	League<Basketball> nba = new League<>("NBA");
	League<Cricket> ipl = new League<>("IPL");
	
	Team<Football> mancity = new Team<>("Manchester City FC");
	Team<Football> chelsea = new Team<>("Chelsea FC");
	Team<Football> manunited = new Team<>("Manchester United FC");
	Team<Football> leicester = new Team<>("Leicester City FC");
	Team<Football> tottenham = new Team<>("Tottenham Hostpur FC");
	Team<Football> liverpool = new Team<>("Liverpool FC");
	
	Team<Basketball> golden = new Team<>("Golden States Warriors");
	Team<Cricket> cricket1 = new Team<>("Chennai Super Kings");
	
	
	System.out.println("===== Football League Table =====");
	epl.addTeam(mancity);
	// epl.addTeam(basket1); - will not allow
	epl.addTeam(manunited);
	epl.addTeam(chelsea);
	epl.addTeam(liverpool);
	epl.addTeam(tottenham);
	epl.addTeam(leicester);
	System.out.println("");
	epl.updateMatchResult(mancity, chelsea, 3, 1);
	epl.updateMatchResult(mancity, manunited, 6, 1);
	epl.updateMatchResult(manunited, chelsea, 2, 0);
	epl.updateMatchResult(liverpool, mancity, 0, 3);
	epl.updateMatchResult(tottenham, liverpool, 2, 4);
	epl.updateMatchResult(leicester, manunited, 2, 0);
	epl.updateMatchResult(liverpool, manunited, 4, 3);

	epl.printLeague();
	
	System.out.println("\n===== Basketball League Table =====");
	nba.addTeam(golden);
	golden.setWin(6);
	golden.setDraw(1);
	golden.setLost(1);
	//nba.addTeam(mancity); - not allowed
	// to make addition easier, I've created a new construtor with win, lost and draw parameter 
	nba.addTeam(new Team<Basketball>("Milwaukee Bucks", 4, 2, 2)); // No need to specify <Basketball> again
	// it will infer from the League<Basketball> nba obj definition.
	nba.addTeam(new Team<>("Denver Nuggets", 1, 2, 5));	
	nba.addTeam(new Team<>("Los Angeles Clippers", 3, 2, 3));
	nba.addTeam(new Team<>("Toronto Raptors", 2, 1, 5));
	System.out.println("");
	nba.printLeague();
	
	
	}

}
