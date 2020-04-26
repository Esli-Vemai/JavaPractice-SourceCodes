package com.java.streamapi.reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReductionOperation {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(12);
		arrayList.add(22);
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(65);
		arrayList.add(15);
		arrayList.add(13);
		arrayList.add(3);
		arrayList.add(9);

		arrayList.forEach(a -> System.out.print(a + " "));
		
		Stream<Integer> intStream = arrayList.stream();
		Optional<Integer> product = intStream.reduce((a,b) -> a*b);
		if(product.isPresent()) {
			System.out.println("Product of list: " + product.get());
		}
		
		Integer inte = arrayList.stream().reduce(1, (a,b) -> a*b);
		System.out.println("Product with different reduce method: " + inte);
	
		
		Integer pro = arrayList.stream().reduce(1, (a,b) -> {
			if(b%2 == 0) {
				return a*b;
			} else {
				return a;
			}
		});
		
		System.out.println("product of evens: " + pro);
		
		
		System.out.println("======== Parallel stream ==========");
		System.out.println(arrayList.parallelStream().reduce((a,b) -> a*b).get());
		System.out.println(arrayList.parallelStream().reduce(1, (a,b) -> (a*b), 
					(a,b) -> a*b));
		
		
		
		
		
		
		
		
		
	}

}
