package com.java.binarysearchtree.usingabstractclass;
import java.util.Stack;

public class MyCustomBinarySearchTree implements BinarySearchTreeInterface {
	BinarySearchTreeInnerStructure binaryTree = null;

	public MyCustomBinarySearchTree() {
		System.out.println("Default MyCustomBinarySearchTree obj created");
	}
	
	public MyCustomBinarySearchTree(int value, String literal) {
		if (value > 0 || literal != null) {
			BinarySearchTreeInnerStructure newTree = new Node(value, literal);
			this.binaryTree = newTree;
		} else {
			System.out.println("Zero & null value not allowed in the tree");
		}

	}

	@Override
	public boolean add(int value, String literal) {
		BinarySearchTreeInnerStructure root = this.getRoot();
		BinarySearchTreeInnerStructure newNode;
		if (value > 0 && literal != null) {
			newNode = new Node(value, literal);
		} else {
			System.out.println("Zero & null value not allowed in the tree");
			return false;
		}

		if (root == null) {
			root = newNode;
			return true;
		}
		BinarySearchTreeInnerStructure current = this.getRoot();
		while (true) {
			int compare = current.compareTo(newNode);
			if (compare == 0) {
				System.out.println(newNode.getValue() + " already in the tree. Duplicates not allowed.");
				return false;
			} else if (compare > 0) {
				// i.e., current is greater than new node. So we go left
				if (current.getLeftChild() != null) {
					current = current.getLeftChild();
				} else {
					current.setLeftChild(newNode);
					return true;
				}
			} else if (compare < 0) {
				// i.e., the new node is greater than the current. So we go right
				if (current.getRigthChild() != null) {
					current = current.getRigthChild();
				} else {
					current.setRightChild(newNode);
					return true;
				}
			}
		}

		// Or we can add it in a little more concise way as below (Imtiaz's solution)
		/*
		 * BinarySearchTreeInnerStructure current = this.getRoot();
		 * BinarySearchTreeInnerStructure parent; while (true) { int compare =
		 * current.compareTo(newNode); parent = current; if (compare == 0) {
		 * System.out.println(newNode.getValue() +
		 * " already in the tree. Duplicates not allowed."); return false; } else if
		 * (compare > 0) { // i.e., current is greater than new node. So we go left
		 * current = current.getLeftChild(); if (current == null) {
		 * parent.goLeft(newNode); return true; }
		 * 
		 * } else if (compare < 0) { // i.e., the new node is greater than the current.
		 * So we go right current = current.getRigthChild(); if (current == null) {
		 * parent.goRight(newNode); return true; }
		 * 
		 * } }
		 */

	}

	@Override
	public boolean remove(int key) {

		BinarySearchTreeInnerStructure currentNode = binaryTree;
		BinarySearchTreeInnerStructure parentNode = binaryTree;
		boolean isLeftChild = false;
		System.out.println("Deleting node with key " + key);
		// Searching to find the node with the key to delete
		while (currentNode.getValue() != key) {
			parentNode = currentNode;
			if (key < currentNode.getValue()) {
				isLeftChild = true;
				currentNode = currentNode.getLeftChild();
			} else {
				currentNode = currentNode.getRigthChild();
				isLeftChild = false;
			}
			if (currentNode == null) {
				return false;
			}
		}

		// if node has one child

		// if node has 2 children (tricky)

		// found the node
		BinarySearchTreeInnerStructure nodeToDelete = currentNode;

		// if node is a leaf
		if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRigthChild() == null) {

			//
			if (nodeToDelete == binaryTree) {
				binaryTree = null;
			} else if (isLeftChild) {
				parentNode.setLeftChild(null);
			} else {
				parentNode.setRightChild(null);
			}

		}
		// if node has one child that is on the left
		else if (nodeToDelete.getRigthChild() == null) {
			if (nodeToDelete == binaryTree) {
				binaryTree = nodeToDelete.getLeftChild();
			} else if (isLeftChild) {
				parentNode.setLeftChild(nodeToDelete.getLeftChild());
			} else {
				parentNode.setRightChild(nodeToDelete.getLeftChild());
			}
		}
		// if node has one child that is on the right
		else if (nodeToDelete.getLeftChild() == null) {
			if (nodeToDelete == binaryTree) {
				binaryTree = nodeToDelete.getRigthChild();
			} else if (isLeftChild) {
				parentNode.setLeftChild(nodeToDelete.getRigthChild());
			} else {
				parentNode.setRightChild(nodeToDelete.getRigthChild());
			}
		}
		// if node has 2 children (tricky)
		else {

			BinarySearchTreeInnerStructure successor = getSuccessor(nodeToDelete);

			// connect parent of nodeToDelete to successor instead
			if (nodeToDelete == binaryTree) {
				binaryTree = successor;
			} else if (isLeftChild) {
				parentNode.setLeftChild(successor);
			} else {
				parentNode.setRightChild(successor);
			}

			successor.setLeftChild(nodeToDelete.getLeftChild());

		}

		return true;
	}

	private BinarySearchTreeInnerStructure getSuccessor(BinarySearchTreeInnerStructure nodeToDelete) {
		BinarySearchTreeInnerStructure successorParent = nodeToDelete;
		BinarySearchTreeInnerStructure successor = nodeToDelete;

		BinarySearchTreeInnerStructure current = nodeToDelete.getRigthChild(); // go to the right child

		while (current != null) { // start going left down the tree until node has no left child
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();
		}
		// if successor not a right child
		if (successor != nodeToDelete.getRigthChild()) {
			successorParent.setLeftChild(successor.getRigthChild());
			successor.setRightChild(nodeToDelete.getRigthChild());
		}
		return successor;

	}
	
	
	
	

	// @Override
	// ToDo - It is not working. Need to find out the issue, but that's for another day. 
	// Need to move on to the next topic for now.
	public boolean myRemoveMethod(int key) {
		// BinarySearchTreeInnerStructure nodeToDelete = null;
		BinarySearchTreeInnerStructure current = binaryTree;
		BinarySearchTreeInnerStructure parent = binaryTree;
		boolean isLeftChild = false;
		System.out.println("Deleting node with key " + key);

		if (binaryTree == null) {
			System.out.println("The tree is empty");
			return false;
		}

		/*
		 * while (current.getValue() != key) { parent = current; if (key <
		 * current.getValue()) { isLeftChild = true; current = current.getLeftChild(); }
		 * else { current = current.getRigthChild(); isLeftChild = false; } if (current
		 * == null) { return false; } }
		 */
		// found the node nodeToDelete = current;

		while (current.getValue() != key) {
			// int comparison = (currentItem.compareTo(item));
			if (current.getValue() < key) {
				isLeftChild = true;
				parent = current;
				current = current.getRigthChild();
			} else if (current.getValue() > key) {
				isLeftChild = true;
				parent = current;
				current = current.getLeftChild();
			} else {
				// equal: we've found the item so remove it
				deleteTheNode(isLeftChild, current, parent);
				return true;
			}
		}
		// nodeToDelete = current;
		// deleteTheNode(isLeftChild, nodeToDelete, parent);

		return false;

	}

	private void deleteTheNode(boolean isLeftChild, BinarySearchTreeInnerStructure nodeToDelete,
			BinarySearchTreeInnerStructure parent) {
		if (nodeToDelete == null) {
			System.out.println("Queried node not found in the tree");
			return;
		}

		// Cases to consider while deleting node
		// 1. The nodeToDelete is a leaf node
		if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRigthChild() == null) {
			if (nodeToDelete == getRoot()) {
				binaryTree = null;
			} else if (isLeftChild) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
			// return true;
		}

		// 2. The nodeToDelete has 1 child node - either left or right child
		else if (nodeToDelete.getLeftChild() == null) {

			if (nodeToDelete == getRoot()) {
				binaryTree = nodeToDelete.getRigthChild();
			} else if (isLeftChild) {
				parent.setLeftChild(nodeToDelete.getRigthChild());
			} else {
				parent.setRightChild(nodeToDelete.getRigthChild());
			}
			// return true;
		} else if (nodeToDelete.getRigthChild() == null) {
			if (nodeToDelete == getRoot()) {
				binaryTree = nodeToDelete.getLeftChild();
			} else if (isLeftChild) {
				parent.setLeftChild(nodeToDelete.getLeftChild());
			} else {
				parent.setRightChild(nodeToDelete.getLeftChild());
			}
			// return true;
		}

		// 3. The nodeToDelete has 2 child nodes - both left and right child
		else {
			BinarySearchTreeInnerStructure replacementNode = getNextLargestNode(nodeToDelete);
			if (replacementNode == getRoot()) {
				binaryTree = replacementNode;
				// return true;
			} else if (isLeftChild) {
				parent.setLeftChild(replacementNode);
				// return true;

			} else {
				parent.setRightChild(replacementNode);
				// return true;
			}
			replacementNode.setRightChild(nodeToDelete.getRigthChild());
			// return true;
		}

	}

	private BinarySearchTreeInnerStructure getNextLargestNode(BinarySearchTreeInnerStructure nodeToDelete) {
		BinarySearchTreeInnerStructure successor = nodeToDelete;
		BinarySearchTreeInnerStructure successorParent = nodeToDelete;
		BinarySearchTreeInnerStructure current = nodeToDelete.getRigthChild();
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();
		}

		if (successor != nodeToDelete.getRigthChild()) {
			successorParent.setLeftChild(successor.getRigthChild());
			successor.setRightChild(nodeToDelete.getRigthChild());
		}
		return successor;

	}

	@Override
	public void traverse(BinarySearchTreeInnerStructure binaryTree) {
		// System.out.println("Inside traverse");
		if (binaryTree != null) {
			// System.out.println("Object is not null");
			traverse(binaryTree.getLeftChild());
			System.out.println(binaryTree.getValue() + " - " + binaryTree.getLiteral());
			traverse(binaryTree.getRigthChild());
		}

		// System.out.println("<<<< Method ends >>>> ");
	}

	@Override
	public BinarySearchTreeInnerStructure getRoot() {
		return this.binaryTree;
	}

	public BinarySearchTreeInnerStructure findMin() {
		BinarySearchTreeInnerStructure root = this.getRoot();
		BinarySearchTreeInnerStructure min = null;
		while (root != null) {
			// min = root.getLeftChild();
			min = root;
			root = root.getLeftChild();
		}
		return min;
	}

	public BinarySearchTreeInnerStructure findMax() {
		BinarySearchTreeInnerStructure root = this.getRoot();
		BinarySearchTreeInnerStructure max = null;
		while (root != null) {
			// max = root.getLeftChild();
			max = root;
			root = root.getLeftChild();
		}
		return max;
	}

	
	
	public void displayTree() {
        Stack<BinarySearchTreeInnerStructure> globalStack = new Stack<>();
        globalStack.push(binaryTree);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        
        while(isRowEmpty == false) {
            Stack<BinarySearchTreeInnerStructure> localStack = new Stack<>();
            isRowEmpty = true;
            for(int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }
                
            while(globalStack.isEmpty() == false) {
            	BinarySearchTreeInnerStructure temp = globalStack.pop(); 
                if(temp != null) {
                    System.out.print(temp.getValue()); 
                    localStack.push(temp.getLeftChild()); 
                    localStack.push(temp.getRigthChild());
                    if(temp.getLeftChild() != null || temp.getRigthChild() != null) {
                        isRowEmpty = false; 
                    }
                } else {
                    System.out.print("--"); 
                    localStack.push(null); 
                    localStack.push(null);
                }
                
                for(int j = 0; j < nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
            nBlanks = nBlanks/2;
            
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() ); 
            }
        System.out.println( "......................................................");
 
 }
}
