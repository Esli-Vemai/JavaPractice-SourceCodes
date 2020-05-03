package com.collections.binarysearch;

public class Main {

	public static void main(String[] args) {
		Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();
		if (theatre.reserveSeat("B111")) {
			System.out.println("Please pay");
		} else {
			System.out.println("Sorry, seat is taken");
		}
		if (theatre.reserveSeat("B11")) {
			System.out.println("Please pay");
		} else {
			System.out.println("Sorry, seat is taken");
		}
	}
}
