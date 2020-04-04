/**
 * 
 */
package com.java.linkedlist.firstdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author esliv
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> string = new ArrayList<>();
		string.add("aa");
		string.add("bb");
		string.add("cc");
		string.add("dd");
		string.add("ee");
		string.add("ee");
		
		print(string);
		string.remove(3);
		print(string);
		
		
		
		LinkedList<String> linkedList = new LinkedList<>();
		ListIterator listIterato = linkedList.listIterator();
		listIterato.next();
	}
	
	private static void print(ArrayList<String> string) {
		string.forEach(a -> System.out.println(a));
	}

}
