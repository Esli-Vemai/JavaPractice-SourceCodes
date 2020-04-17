package com.java.generic.practice;

import com.java.generic.model.CricketPlayer;
import com.java.generic.model.FootbalPlayer;
import com.java.generic.model.MartialArtist;

public class MainClass {

	public static void main(String[] args) {
		FootbalPlayer footballer = new FootbalPlayer("Kevin DeBruyne");
		CricketPlayer cricketer = new CricketPlayer("Virat Kholi");
		MartialArtist fighter = new MartialArtist("Jorge Masvidal");
		
		Team<FootbalPlayer> footballTeam = new Team<>("Man City");
		Team<FootbalPlayer> opponent = new Team<>("Real Madric");
		Team<FootbalPlayer> seria = new Team<>("Juventus");
		
		Team<CricketPlayer> cricketTeam = new Team<>("RCB");
		Team<MartialArtist> martialArts = new Team<>("UFC");
		
		footballTeam.addPlayer(footballer);
		footballTeam.addPlayer(new FootbalPlayer("Kun Aguero"));
		opponent.addPlayer(new FootbalPlayer("Kroos"));
		opponent.addPlayer(new FootbalPlayer("Isco"));
		seria.addPlayer(new FootbalPlayer("Ronaldo"));
		cricketTeam.addPlayer(cricketer);
		cricketTeam.addPlayer(new CricketPlayer("Cris Gayle"));
		martialArts.addPlayer(fighter);
		martialArts.addPlayer(new MartialArtist("Khabib"));
		
		footballTeam.displaMathResult(opponent, 2, 1);
		footballTeam.displaMathResult(seria, 3, 0);
		opponent.displaMathResult(seria, 2, 5);
		
		System.out.println("Table Ranking ");
		System.out.println(footballTeam.getName() + ": " + footballTeam.ranking());
		System.out.println(seria.getName() + ": " + seria.ranking());
		System.out.println(opponent.getName() + ": " + opponent.ranking());
		
		System.out.println(footballTeam.compareTo(opponent));
		System.out.println(seria.compareTo(opponent));
		System.out.println(opponent.compareTo(seria));
		System.out.println(footballTeam.compareTo(seria));
		
		footballTeam.displayPlayers();
		//Collections.sort(footballTeam.getMembers());
	}

}
