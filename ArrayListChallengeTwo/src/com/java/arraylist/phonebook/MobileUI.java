package com.java.arraylist.phonebook;

import java.util.ArrayList;
import java.util.Scanner;

public class MobileUI {
	private static final Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone();

	public static void main(String[] args) {
		String name = null;
		int phoneNo = 0;
		startPhone();
		printInstructions();
		boolean quit = true;
		while (quit) {
			System.out.println("Enter option of your choice:");
			boolean isInt = scanner.hasNextInt();
			if (isInt) {
				int option = scanner.nextInt();
				scanner.nextLine();

				switch (option) {
				case 0:
					printInstructions();
					break;
				case 1:
					mobilePhone.printContacts();
					break;
				case 2:
					System.out.println("Enter the name & phoneNo you want to add:");
					name = scanner.nextLine();
					phoneNo = isInteger(scanner);
					addToContactList(new Contacts(name, phoneNo));
					break;
				case 3:
					System.out.println("Enter the name you want to modify:");
					String oldName = scanner.nextLine();
					System.out.println("Enter the new name & phoneNo:");
					name = scanner.nextLine();
					phoneNo = isInteger(scanner);
					modifyContactList(oldName, new Contacts(name, phoneNo));
					break;
				case 4:
					System.out.println("Enter the name you want to delete:");
					name = scanner.nextLine();
					removeFromContactList(name);
					break;
				case 5:
					System.out.println("Enter the name you want to find:");
					name = scanner.nextLine();
					findContactInList(name);
					break;
				case 6:
					System.out.println("Available contacts are:");
					getTheContactList().forEach(c -> System.out.println(c));
					break;
				case 7:
					quit = false;
					System.out.println("Thank you for using the App...");
					break;
				}
			} else {
				System.out.println("Enter option in integer, not string.");
				scanner.nextLine();
			}

		}

	}

	private static void startPhone() {
		System.out.println("Strating phone...");

	}

	private static void printInstructions() {
		System.out.println("0) - Print instructions.");
		System.out.println("1) - Print Contact list.");
		System.out.println("2) - Add contact to the list.");
		System.out.println("3) - Modify contact in the list.");
		System.out.println("4) - Remove contact from the list.");
		System.out.println("5) - Find contact in the list.");
		System.out.println("6) - Get the contact list.");
		System.out.println("7) - Exit the application.");
	}

	private static void addToContactList(Contacts contacts) {
		boolean added = mobilePhone.addContact(contacts);
		if (added)
			System.out.println(contacts.getName() + " added to the list");
		else
			System.out.println("Error occured while adding " + contacts.getName() + " to the list");
	}

	private static void modifyContactList(String name, Contacts newContact) {
		boolean modified = mobilePhone.updateContact(name, newContact);
		if (modified)
			System.out.println(name + " replaced with " + newContact.getName() + " in the list");
		else
			System.out.println("Error occured while modifying the list");

	}

	private static void removeFromContactList(String name) {
		boolean removed = mobilePhone.removeContact(name);
		if (removed)
			System.out.println(name + " removed from the list");
		else
			System.out.println("No contact found with name " + name + " to remove");

	}

	private static void findContactInList(String name) {
		Contacts foundContact = mobilePhone.findAContact(name);
		if (foundContact.getName() != null) {
			System.out.println("Found contact for " + name + ":");
			System.out.println(foundContact.toString());
		} else {
			System.out.println("Contact details not found for" + name);
		}
	}

	private static ArrayList<Contacts> getTheContactList() {
		ArrayList<Contacts> contactList = new ArrayList<Contacts>();
		contactList = mobilePhone.getContactList();
		return contactList;
	}

	private static int isInteger(Scanner scanner) {
		int phoneNo = 0;
		boolean isTrue = true;
		while (isTrue) {
			if (scanner.hasNextInt()) {
				phoneNo = scanner.nextInt();
				isTrue = false;
			} else {
				System.out.println("Enter phoneNo in integer, not string.");
			}
			scanner.nextLine();
		}
		return phoneNo;
	}

}
