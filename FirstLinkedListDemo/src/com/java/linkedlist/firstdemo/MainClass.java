/**
 * 
 */
package com.java.linkedlist.firstdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author esliv
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		LinkedList<String> linkedList = new LinkedList<>();
		/*
		 * 
		 * linkedList.add("Shillong"); linkedList.add("Guwahati");
		 * linkedList.add("Senapati"); linkedList.add("Kohima");
		 * linkedList.add("Gangtok"); linkedList.add("Aizwal");
		 * linkedList.add("Itenagar");
		 * 
		 * print(linkedList);
		 */

		System.out.println("===========================");
		addAlphabatically(linkedList, "Shillong");
		addAlphabatically(linkedList, "Guwahati");
		addAlphabatically(linkedList, "Senapati");
		addAlphabatically(linkedList, "Kohima");
		addAlphabatically(linkedList, "Gangtok");
		addAlphabatically(linkedList, "Aizwal");
		addAlphabatically(linkedList, "Itenagar");
		addAlphabatically(linkedList, "Gangtok");
		print(linkedList);
		System.out.println("===========================\n");
		visitCities(linkedList);
		
		/*
		 * System.out.println("==========================="); addInOrder(linkedList,
		 * "Shillong"); addInOrder(linkedList, "Guwahati"); addInOrder(linkedList,
		 * "Senapati"); addInOrder(linkedList, "Kohima"); addInOrder(linkedList,
		 * "Gangtok"); addInOrder(linkedList, "Aizwal"); addInOrder(linkedList,
		 * "Itenagar"); print(linkedList);
		 */

	}

	private static void print(LinkedList<String> string) {
		string.forEach(a -> System.out.println(a));
	}

	private static boolean addAlphabatically(LinkedList<String> list, String element) {
		ListIterator<String> listIterator = list.listIterator();

		while (listIterator.hasNext()) {
			int compare = listIterator.next().compareTo(element);
			if (compare == 0) {
				System.out.println(element + " City already in the list");
				return false;
			} else if (compare > 0) {
				listIterator.previous();
				listIterator.add(element);
				return true;
			}
		}

		listIterator.add(element);
		return true;
	}

	private static void visitCities(LinkedList<String> cities) {
		Scanner scanner = new Scanner(System.in);
		ListIterator<String> citiesIterator = cities.listIterator();
		boolean quit = false;
		boolean forward = true;
		
		if(cities.isEmpty()) {
			System.out.println("No cities in the itenary.");
			scanner.close();
			return;
		} else {
			System.out.println("Now visiting " + citiesIterator.next());
			printInstructions();
		}
		
		while(!quit) {
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
				case 0:
					System.out.println("Holiday over");
					quit = true;
					break;
				case 1:
					if(!forward) {
						if(citiesIterator.hasNext()) {
							citiesIterator.next();
						}
						forward = true;
						
					}
					if(citiesIterator.hasNext()) {
						System.out.println("Now visiting " + citiesIterator.next());
					} else {
						System.out.println("Reached end of list");
						forward = false;
						}
				
					break;
				case 2:
					if(forward) {
						if(citiesIterator.hasPrevious()) {
							citiesIterator.previous();
						}
						forward = false;
					}
					if(citiesIterator.hasPrevious()) {
						System.out.println("Now visiting " + citiesIterator.previous());
					} else {
						System.out.println("We are at the starting of list");
						forward = true;
					}
					break;
				case 3:
					printInstructions();
					break;
			}
		}
		
		scanner.close();
	}

	private static void printInstructions() {
		System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
	}

}
