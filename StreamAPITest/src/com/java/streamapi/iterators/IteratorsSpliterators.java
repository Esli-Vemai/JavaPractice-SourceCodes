package com.java.streamapi.iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class IteratorsSpliterators {

	public static void main(String[] args) {
		List<String> string = new ArrayList<>();
		string.add("Apple");
		string.add("Mango");
		string.add("Orange");
		string.add("Banana");
		string.add("Avokado");
		
		Stream<String> stream = string.stream();
		var iterator = stream.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
		
		
		
		// Using Spliterator
		System.out.println("\nUsing Spliterator");
		Stream<String> split = string.stream();
		var spiterator = split.spliterator();
		while (spiterator.tryAdvance(a -> System.out.println(a + "is a fruit ")));

		spiterator.forEachRemaining(a -> System.out.println(a + " is not a fruit"));
		
		// using trySplit()
		System.out.println("\nUsing trySplit()");
		Stream<String> trySplit = string.stream();
		var trySpliterator = trySplit.spliterator();
		var trySpliterator2 = trySpliterator.trySplit();
		if(trySpliterator2 != null) {
			System.out.println("trySpliterator2 output");
			trySpliterator2.forEachRemaining(a -> System.out.print(a + " "));
		}
		System.out.println("\ntrySpliterator output");
		trySpliterator.forEachRemaining(a -> System.out.print(a + " "));

	}

}
