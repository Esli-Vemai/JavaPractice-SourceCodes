package com.java.custom.linkedlist;

public class Node extends CustomLinkedListInnerStructure {

	public Node(Object value) {
		super(value);
	}

	@Override
	public CustomLinkedListInnerStructure getNext() {
		return this.next;
	}

	@Override
	public CustomLinkedListInnerStructure setNext(CustomLinkedListInnerStructure abstractList) {
		//if(abstractList != null) {
		this.next = abstractList;
		//}
		return this.next;
	}

	@Override
	public CustomLinkedListInnerStructure getPrevious() {
		return this.previous;
	}

	@Override
	public CustomLinkedListInnerStructure setPrevious(CustomLinkedListInnerStructure abstractList) {
		//if (abstractList != null) {
			this.previous = abstractList;
		//}
		return this.previous;
	}

	@Override
	public int compareTo(CustomLinkedListInnerStructure abstractList) {
		if (abstractList != null) {
			return ((String) super.getValue()).compareTo((String) abstractList.getValue());
		}
		return -1;
	}

}
