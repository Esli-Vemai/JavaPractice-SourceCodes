package com.java.streamapi.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MappingList {
	
	public static void main(String[] args) {
		List<NamePhoneMail> listNPE = new ArrayList<>();
		listNPE.add(new NamePhoneMail("Matthew", "1223", "matthew@gopel.com"));
		listNPE.add(new NamePhoneMail("Mark", "2343", "mark@gospel.com"));
		listNPE.add(new NamePhoneMail("Luke", "6886", "luke@gospel.com"));
		listNPE.add(new NamePhoneMail("John", "67332", "john@gospel.com"));
		listNPE.add(new NamePhoneMail("John", "343434", "john@epistal.com"));
		
		listNPE.forEach(a -> System.out.println(a + " "));
		Stream<NamePhoneMail> npm = listNPE.stream();
		Stream<NamePhone> np = npm.map((n) -> new NamePhone(n.name, n.phoneNo));
		np.forEach(a -> System.out.println(a + " "));
		
		
		/*
		 * We can pipeline more than one intermediate operation together to perform
		 * powerful actions as below
		 */
		
		Stream<NamePhone> npFiler = listNPE.stream().filter(a -> a.name.equalsIgnoreCase("John"))
						.map((b) -> new NamePhone(b.name, b.phoneNo));
		System.out.println("\nOnly John will be displayed");
		npFiler.forEach(c -> System.out.println(c));
	}
	
	
	
	

}
