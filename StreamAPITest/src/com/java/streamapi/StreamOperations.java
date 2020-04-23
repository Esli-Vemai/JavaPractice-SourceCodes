package com.java.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(12);
		arrayList.add(22);
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(434);
		arrayList.add(65);
		arrayList.add(15);
		arrayList.add(13);
		arrayList.add(3);
		arrayList.add(9);
		print(arrayList);
		
		Stream<Integer> listStream = arrayList.stream();
		print(sortOperation(listStream));
		print(mapOperation(arrayList.stream()).sorted());
		print(filterOperation1(arrayList.stream()));
		print(filterOperation2(arrayList.stream()));
		System.out.println(maxOperation(arrayList.stream()));
		System.out.println(minOperation(arrayList.stream()));
		mapOperationINT(arrayList.stream());

	}
	
	public static Stream<Integer> sortOperation(Stream<Integer> listStream) {
		return listStream.sorted();
	}
	
	public static Stream<Integer> mapOperation(Stream<Integer> listStream) {
		Stream<Integer> streamIncrement = listStream.map(a -> a+2);
		//listStream.mapToInt(a -> a+2);
		return streamIncrement;
	} 
	
	public static IntStream mapOperationINT(Stream<Integer> listStream) {
		IntStream streamIncrement = listStream.mapToInt(a -> a+2);
		streamIncrement.sorted().forEach(a -> System.out.print(a + " "));
		return streamIncrement;
	} 
	
	public static Stream<Integer> filterOperation1(Stream<Integer> listStream) {
		Stream<Integer> odd = listStream.filter(a -> a%2 != 0);
		
		return odd;
	}
	
	public static Stream<Integer> filterOperation2(Stream<Integer> listStream) {
		Stream<Integer> oddGreat = listStream.filter(a -> a%2 != 0).filter(a -> a> 10);
		
		return oddGreat;
	}
	
	
	public static int minOperation(Stream<Integer> listStream) {
		Optional<Integer> min = listStream.min(Integer::compare);
		if(min.isPresent()) 
			return min.get();
		
		return 0;
	}
	
	public static int maxOperation(Stream<Integer> listStream) {
		Optional<Integer> max = listStream.max(Integer::compare);
		if(max.isPresent()) 
			return max.get();
		
		return 0;
	}
	
	
	
	public static void print(List<Integer> list ) {
		list.forEach(a -> System.out.print(a + " "));
		System.out.println("\n===========");
	}

	public static void print(Stream<Integer> listStream ) {
		listStream.forEach(a -> System.out.print(a + " "));
		System.out.println("\n===========");
	}

}
