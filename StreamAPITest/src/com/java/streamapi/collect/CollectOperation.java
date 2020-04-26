package com.java.streamapi.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author esliv Getting a collection from a given stream
 */
public class CollectOperation {

	public static void main(String[] args) {
		List<NamePhoneMail> npm = new ArrayList<>();
		npm.add(new NamePhoneMail("Matthew", "1223", "matthew@gopel.com"));
		npm.add(new NamePhoneMail("Mark", "2343", "mark@gospel.com"));
		npm.add(new NamePhoneMail("Luke", "6886", "luke@gospel.com"));
		npm.add(new NamePhoneMail("John", "67332", "john@gospel.com"));
		npm.add(new NamePhoneMail("John", "67332", "john@gospel.com"));
		npm.add(new NamePhoneMail("John", "343434", "john@epistal.com"));
		print(npm);
		
		Stream<NamePhone> npmStream = npm.stream().map((n) -> new NamePhone(n.name, n.phoneNo));
		// interface Collector<T, A, R>
		// public static <T> Collector<T, ?, List<T>> toList()
		// Collector has many methods, but for simplicity we will use predefined static
		// toList() method
		// of Collectors class
		List<NamePhone> np = npmStream.collect(Collectors.toList());
		// ArrayList<NamePhone> np = (ArrayList<NamePhone>)
		// npmStream.collect(Collectors.toList());
		for (NamePhone namePhone : np) {
			System.out.println(namePhone);
		}
		System.out.println("Using Set");
		Set<NamePhone> npSet = npm.stream().map(n -> new NamePhone(n.name, n.phoneNo)).collect(Collectors.toSet());
		np.forEach(a -> System.out.println(a + " "));

		secondTypeOfCollectMethod(npm);
	}

	private static void secondTypeOfCollectMethod(List<NamePhoneMail> npm) {
		System.out.println("\nsecondTypeOfCollectMethod() method");
		Stream<NamePhone> np = npm.stream().map(a -> new NamePhone(a.name, a.phoneNo));
		LinkedList<NamePhone> linked = np.collect(() -> new LinkedList<>(), (list, element) -> list.add(element),
						(listA, listB) -> listA.addAll(listB));
		// We can use any method of linkedList to add - like addFirst(), addLast(), etc
		for (NamePhone namePhone : linked) {
			System.out.println(namePhone);
		}
		
		//We can also use Method reference and Constructor reference
		Stream<NamePhone> npConst = npm.stream().map(a -> new NamePhone(a.name, a.phoneNo));
		HashSet<NamePhone> hashSet = npConst.collect(HashSet::new, HashSet::add, HashSet::addAll);
		System.out.println("Hash Set");
		for (NamePhone namePhone : hashSet) {
			System.out.println(namePhone);
		}
	}
	
	public static void print(List<NamePhoneMail> list) {
		Stream<NamePhoneMail> stream = list.stream();
		stream.forEach(a -> System.out.println(a + " "));
		System.out.println("using distinct operation");
		list.stream().distinct().forEach(a -> System.out.println(a + " "));
	}
	

}
