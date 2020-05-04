package com.collection.comparotor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Theater {
	private final String theaterName;
	private List<Seat> seats;

	static final Comparator<Seat> PRICE_ORDER = new Comparator<Theater.Seat>() {

		@Override
		public int compare(Seat seat1, Seat seat2) {
			if (seat1.getPrice() == seat2.getPrice()) {
				return 0;
			} else if (seat1.getPrice() > seat2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		}
	};

	public Theater(String theaterName, int rows, int seatsPerRow) {
		this.theaterName = theaterName;
		this.seats = new ArrayList<>();

		int lastRow = 'A' + (rows - 1);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				double price = 12.00;

				if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
					price = 14.00;
				} else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
					price = 7.00;
				}
				Seat seat = new Seat(row + String.format("%02d", seatNum), price);
				seats.add(seat);
			}
		}
	}

	public boolean reserveSeat(String seatNo) {
		Seat searchSeat = new Seat(seatNo, 0.0);
		int seatIndex = Collections.binarySearch(seats, searchSeat, null);
		if (seatIndex >= 0) {
			return seats.get(seatIndex).reservedSeat();
		} else {
			System.out.println("There is no seat " + seatNo);
			return false;
		}
		// return true;
	}

	public void print() {
		seats.stream().forEach(a -> System.out.print(a.getSeatNo() + " "));
		System.out.println("");
	}

	public Collection<Seat> getSeats() {
		return seats;
	}

	class Seat implements Comparable<Seat> {
		private final String seatNo;
		private double price;
		private boolean reserved = false;

		public Seat(String seatNo, double price) {
			this.seatNo = seatNo;
			this.price = price;
		}

		private boolean reservedSeat() {
			if (!this.reserved) {
				this.reserved = true;
				System.out.println("Seat no. " + seatNo + " reserved successfully");
				return true;
			} else {
				//this.reserved = false;
				return false;
			}

		}

		public String getSeatNo() {
			return seatNo;
		}

		public double getPrice() {
			return price;
		}

		@Override
		public String toString() {
			return "Seat: seatNo=" + seatNo + ", price=" + price + ", reserved=" + reserved;
		}

		@Override
		public int compareTo(Seat seatArg) {
			return this.seatNo.compareToIgnoreCase(seatArg.seatNo);
		}

	}
}
