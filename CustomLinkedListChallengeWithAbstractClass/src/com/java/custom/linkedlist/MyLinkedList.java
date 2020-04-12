package com.java.custom.linkedlist;

public class MyLinkedList implements CustomLinkedListRequiredMethods {
	private CustomLinkedListInnerStructure structure;

	public MyLinkedList(CustomLinkedListInnerStructure structure) {
		this.structure = structure;
	}

	public CustomLinkedListInnerStructure getRoot() {
		return this.structure;
	}

	@Override
	public boolean addItem(CustomLinkedListInnerStructure newItem) {
		if (getRoot() == null) {
			System.out.println("We are at the start of list");
			this.structure = newItem;
			return true;
		}
		CustomLinkedListInnerStructure current = this.getRoot();

		while (current != null) {
			int compare = current.compareTo(newItem);
			if (compare > 0) {
				if (current.getPrevious() == null) {
					current.setPrevious(newItem);
					newItem.setNext(current);
					this.structure = newItem;
				} else {
					current.getPrevious().setNext(newItem);
					newItem.setPrevious(current.getPrevious());
					newItem.setNext(current);
					current.setPrevious(newItem);
				}
				return true;

			} else if (compare < 0) {
				if (current.getNext() != null) {
					current = current.getNext();
				} else {
					current.setNext(newItem);
					newItem.setPrevious(current);
					return true;
				}

			} else {
				System.out.println(newItem.getValue() + " already in the list - not added");
				return false;
			}
		}

		return false;

	}

	@Override
	public boolean removeItem(CustomLinkedListInnerStructure deleteItem) {
		if (deleteItem != null) {
			System.out.println("Deleting item " + deleteItem.getValue());
		}
		CustomLinkedListInnerStructure current = this.structure;
		while (current != null) {
			int compare = current.compareTo(deleteItem);
			if (compare == 0) {
				if (current == this.structure) {
					this.structure = current.getNext();
				} else {
					current.getPrevious().setNext(current.getNext());
					if (current.getNext() != null) {
						current.getNext().setPrevious(current.getPrevious());
					}

				}

				return true;
			} else if (compare < 0) {
				current = current.getNext();

			} else {
				// We are at an item greater than the one to be deleted
				// so the item is not in the list
				return false;
			}

		}
		// We have reached the end of the list without finding the item to delete
		return false;
	}

	@Override
	public void traverse(CustomLinkedListInnerStructure items) {
		if (items == null) {
			System.out.println("The list is empty");
			// return;
		} else {
			while (items != null) {
				System.out.println("Current: " + items.getValue());
				items = items.getNext();
			}
		}

	}

}