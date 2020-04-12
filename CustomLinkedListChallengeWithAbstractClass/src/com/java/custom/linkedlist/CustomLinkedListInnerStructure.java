package com.java.custom.linkedlist;

public abstract class CustomLinkedListInnerStructure {
	protected Object value;
	protected CustomLinkedListInnerStructure previous;
	protected CustomLinkedListInnerStructure next;
	
	public CustomLinkedListInnerStructure(Object value) {
		super();
		this.value = value;
	}

	
	public abstract CustomLinkedListInnerStructure getNext();
	public abstract CustomLinkedListInnerStructure setNext(CustomLinkedListInnerStructure abstractList);
	public abstract CustomLinkedListInnerStructure getPrevious();
	public abstract CustomLinkedListInnerStructure setPrevious(CustomLinkedListInnerStructure abstractList);
	public abstract int compareTo(CustomLinkedListInnerStructure abstractList);
	
	
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "Current object: "
				+ "\nvalue: " + value + ""
				+ "\nprevious: " + previous + ""
				+ "\nnext: " + next;
	}	
}
