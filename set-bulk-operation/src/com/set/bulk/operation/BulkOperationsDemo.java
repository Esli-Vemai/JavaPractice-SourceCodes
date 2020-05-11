package com.set.bulk.operation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BulkOperationsDemo {

	public static void main(String[] args) {
		Set<Integer> squares = new HashSet<>();
		Set<Integer> cubes = new HashSet<>();
		for(int a = 1; a < 50; a++) {
			squares.add(a * a);
			cubes.add(a * a * a);
		}
		
		System.out.println("Square set contains " + squares.size() + " elements");
		System.out.println("Cube set contains " + cubes.size() + " elements");
		
		//Union of sets
		Set<Integer> union = new HashSet<>(squares);
		union.addAll(cubes);
		System.out.println("Union of set contains " + union.size() + " elements");
		
		//Intersection of sets
		Set<Integer> intersection = new HashSet<>(squares);
		intersection.retainAll(cubes);
		System.out.println("Intersection of set contains " + intersection.size() + " elements");
		for (int i : intersection) {
			System.out.println(i + " is the square of " + Math.sqrt(i) + " and cube of " + Math.cbrt(i));
		}
		
		
		
		// Difference - Set returns assymetric difference by default
		Set<String> natureSet = new HashSet<>();
		String[] natural = "all nature is but art unknown to thee".split(" ");
		natureSet.addAll(Arrays.asList(natural));
		
		Set<String> divineSet = new HashSet<>();
		String[] divine = "to err is human to forgive divine".split(" ");
		divineSet.addAll(Arrays.asList(divine));
		
		// difference one
		Set<String> diff1 = new HashSet<>(natureSet);
		diff1.removeAll(divineSet);
		System.out.println("natureSet - divineSet contians " + diff1.size());
		printSet(diff1);
		
		System.out.println("\n==============");
		// difference two
		Set<String> diff2 = new HashSet<>(divineSet);
		diff2.removeAll(natureSet);
		System.out.println("natureSet - divineSet contians " + diff2.size());
		printSet(diff2);
		
		
		// To obtain symmetric difference;
		Set<String> unionStr = new HashSet<>(natureSet);
		unionStr.addAll(divineSet);
		Set<String> intersec = new HashSet<>(natureSet);
		intersec.retainAll(divineSet);
		
		System.out.println("\n ========= Symetric difference =========");
		Set<String> symDif = new HashSet<>(unionStr);
		symDif.removeAll(intersec);
		printSet(symDif);
		
		
		System.out.println("\nContains all operation");
		if(divineSet.containsAll(natureSet)) {
			System.out.println("Divine is a subset of nature");
		}
		if(natureSet.containsAll(intersec)) {
			System.out.println("intersec is a subset of natureSet");
		}
		if(divineSet.containsAll(intersec)) {
			System.out.println("intersec is a subset of divineSet");
		}
		
	}

	
	private static void printSet(Set<String> set) {
		for (String string : set) {
			System.out.print(string + " ");
		}
	}
}
