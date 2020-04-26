package com.java.streamapi.reduce;

import java.util.ArrayList;
import java.util.List;

public class ReduceOpwithParallel {

	public static void main(String[] args) {
		List<Double> arrayList = new ArrayList<>();
		arrayList.add(12.4);
		arrayList.add(22.2);
		arrayList.add(2.5);
		arrayList.add(5.1);
		arrayList.add(65.0);
		arrayList.add(15.3);
		arrayList.add(13.9);
		arrayList.add(3.1);
		arrayList.add(9.0);

		arrayList.forEach(a -> System.out.print(a + " "));
		
		
		/* 
		 * Uses the below reduce() variant for parallelism
		 * <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);
		 */
		double prod = arrayList.parallelStream().reduce(1.0, (a,b) -> a*Math.sqrt(b), (a,b) -> a*b);
		System.out.println("\nProd: " + prod);
		
		// This will not work for parallel stream, but will work for sequential.
		// ...coz this operation when two partial results are combined, their sqrt are
		//multiplied together rather than the partial result themselves.
		
		//double parall = arrayList.parallelStream().reduce(1.0, (a,b) -> a*Math.sqrt(b), (a,b) -> a*Math.sqrt(b));
		double parall = arrayList.parallelStream().reduce(1.0, (a,b) -> a*Math.sqrt(b));
		System.out.println("Parallel " + parall);
		
		// This will work for coz there is no need to combine two partial results 
		// in sequential stream.
		double sqrt = arrayList.parallelStream().sequential().reduce(1.0, (a,b) -> a*Math.sqrt(b));
		System.out.println("Sequential " + sqrt);
		
		
	}

}
