package com.java.binarysearchtree.usingabstractclass;

public interface BinarySearchTreeInterface {
	boolean add(int value, String literal);
	boolean remove(int value);
	void traverse(BinarySearchTreeInnerStructure binary);
	BinarySearchTreeInnerStructure getRoot();
}
