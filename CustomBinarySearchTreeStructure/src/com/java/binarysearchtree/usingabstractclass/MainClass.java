package com.java.binarysearchtree.usingabstractclass;

public class MainClass {

	public static void main(String[] args) {
		MyCustomBinarySearchTree tree = new MyCustomBinarySearchTree(10, "ten");

		tree.traverse(tree.getRoot());
		System.out.println("===========");
		tree.add(10, "Ten");
		tree.add(20, "twenty");
		tree.add(22, "fifteen");
		tree.add(18, "fifteen");
		tree.add(19, "fifteen");
		tree.add(17, "fifteen");
		tree.add(24, "Twenty four");
		tree.add(21, "Twenty four");
		tree.add(4, "Four");
		tree.add(2, "Four");
		tree.add(5, "Four");
		tree.add(8, "Four");
		tree.add(9, "Four");
		tree.add(33, "Thirty three");

		/*
		 * tree.add(5, "five"); tree.add(7, "seven"); tree.add(2, "two"); tree.add(9,
		 * "nine"); tree.add(1, "one"); tree.add(6, "six"); tree.add(8, "eight");
		 * tree.add(3, "three"); tree.add(4, "four");
		 */
		tree.traverse(tree.getRoot());
		tree.displayTree();

		System.out.println("===========");

		tree.remove(4);
		tree.traverse(tree.getRoot());
		tree.displayTree();
		System.out.println("===========");

		tree.remove(5);
		tree.traverse(tree.getRoot());
		tree.displayTree();
		System.out.println("===========");

		tree.remove(9);
		tree.traverse(tree.getRoot());
		tree.displayTree();

		// recurse(4);
	}

	/*
	 * public static void recurse(int abc) { if(abc > 0) { recurse(abc - 2);
	 * System.out.println("First >>> " + (abc)); recurse(abc - 1);
	 * System.out.println("Second >>> " + (abc )); }
	 * 
	 * }
	 */
}
