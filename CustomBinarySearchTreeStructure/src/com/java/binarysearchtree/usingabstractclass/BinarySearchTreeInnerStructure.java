package com.java.binarysearchtree.usingabstractclass;

public abstract class BinarySearchTreeInnerStructure {
	protected int value;
	protected String literal;
	protected BinarySearchTreeInnerStructure leftChild;
	protected BinarySearchTreeInnerStructure rightChild;
	
	
	public BinarySearchTreeInnerStructure(int value, String literal) {
		this.value = value;
		this.literal = literal;
	}
	
	public abstract BinarySearchTreeInnerStructure getLeftChild();
	public abstract BinarySearchTreeInnerStructure setLeftChild(BinarySearchTreeInnerStructure binaryTree);
	public abstract BinarySearchTreeInnerStructure getRigthChild();
	public abstract BinarySearchTreeInnerStructure setRightChild(BinarySearchTreeInnerStructure binaryTree);
	public abstract int compareTo(BinarySearchTreeInnerStructure binaryTree);
	
	
	public int getValue() {
		return value;
	}
	public String getLiteral() {
		return literal;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
