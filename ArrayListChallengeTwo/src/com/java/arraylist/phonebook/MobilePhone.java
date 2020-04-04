/**
 * 
 */
package com.java.arraylist.phonebook;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
	private ArrayList<Contacts> contactList = new ArrayList<>();
	private static final Scanner scan = new Scanner(System.in);

	
	
	
	public void printContacts() {
		System.out.println("List of Contacts:");
		contactList.forEach(contact -> System.out.println("#)" + contact));
	}

	public boolean addContact(Contacts contacts) {
		String name = contacts.getName();

		if (getContactIndex(name) != -1) {
			System.out.println(name + " is already in the list. No duplicates are allowed.");
			return false;
		} else {
			return contactList.add(contacts);
		}
	}

	public boolean updateContact(String oldName, Contacts newContact) {
		int index = getContactIndex(oldName);
		boolean added = true;
		if (index < 0) {
			System.out.println(oldName + " not found for replacement in the list. " + "\nDo you want to add "
					+ newContact.getName() + " as a new contact to the list? Y/N");
			String answer = scan.nextLine();
			added = addAsNewContact(answer, newContact);
		} else if (getContactIndex(newContact.getName()) != -1) {
			System.out.println(newContact.getName() + " already in the list. Duplicates not allowed.");
			added = false;
		}
		contactList.set(index, newContact);
		return added;
	}

	public boolean removeContact(String name) {
		int index = getContactIndex(name);
		if (index >= 0) {
			contactList.remove(index);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Contacts> getContactList() {
		return this.contactList;
	}

	public Contacts findAContact(String name) {
		if (contains(name)) {
			return contactList.get(getContactIndex(name));
		} else {
			return null;
		}
	}

	private boolean addAsNewContact(String answer, Contacts newContact) {
		boolean added = false;
		if (answer.equalsIgnoreCase("Y")) {
			contactList.add(newContact);
			added = true;
		}
		return added;

	}

	private int getContactIndex(String contactName) {
		int index = -1;
		for (Contacts con : contactList) {
			if (contactName.equalsIgnoreCase(con.getName())) {
				index = contactList.indexOf(con);
			}
		}
		return index;
	}

	private boolean contains(String contactName) {
		Contacts con = null;
		for (Contacts contact : contactList) {
			if (contactName.equalsIgnoreCase(contact.getName())) {
				con = contact;
			}
		}
		if (con == null) {
			return false;
		} else {
			return contactList.contains(con);
		}

	}

}
