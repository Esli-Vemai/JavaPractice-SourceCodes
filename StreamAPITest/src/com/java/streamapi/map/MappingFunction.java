package com.java.streamapi.map;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingFunction {

	public static void main(String[] args) {
		ArrayList<Double> doubleList = new ArrayList<>();
		doubleList.add(12.3);
		doubleList.add(5.6);
		doubleList.add(23.3);
		doubleList.add(9.13);
		doubleList.add(10.4);
		doubleList.add(15.7);
		
		System.out.println(doubleList.toString());
		//Creating new stream of type Integer from - of type Double
		Stream<Double> ceildouble = doubleList.stream();
		Stream<Integer> ceilInt = ceildouble.map(a -> (int)Math.ceil(a));
		ceilInt.forEach(c -> System.out.print(c + " "));
		
		IntStream ceil = doubleList.stream().mapToInt(a -> (int)Math.ceil(a));
		ceil.forEach(c -> System.out.print(c + " "));
		
		
		
		
		// Implementing the ReduceOpwithParallel class using map() function
		Stream<Double> stream = doubleList.stream().map(a -> Math.sqrt(a));
		Double sqrt = stream.reduce(1.0, (a,b) -> a*b);
		System.out.println("\nSQRT: " + sqrt);
	}

}
