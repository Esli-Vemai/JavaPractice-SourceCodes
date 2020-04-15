package com.java.binarysearchtree.usingabstractclass;

public class Node extends BinarySearchTreeInnerStructure{

	public Node(int value, String literal) {
		super(value, literal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BinarySearchTreeInnerStructure getLeftChild() {
		return this.leftChild;
	}

	@Override
	public BinarySearchTreeInnerStructure setLeftChild(BinarySearchTreeInnerStructure binaryTree) {
		this.leftChild = binaryTree;
		return this.leftChild;
	}

	@Override
	public BinarySearchTreeInnerStructure getRigthChild() {
			return this.rightChild;
	}

	@Override
	public BinarySearchTreeInnerStructure setRightChild(BinarySearchTreeInnerStructure binaryTree) {
		this.rightChild = binaryTree;
		return this.rightChild;
	}

	@Override
	public int compareTo(BinarySearchTreeInnerStructure binaryTree) {
		if(binaryTree == null) {
			return 1;
		}
		int value = binaryTree.getValue();
		if (value == this.value) {
			return 0;
		}
		if (this.value > value) {
			return 1;
		} else {
			return -1;
		}
	}

}
