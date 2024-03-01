package com.lib.gl.bst;

public class BstSkewTreeConvertorTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        BST tree = new BST();

	        // Inserting data into BST
	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(60);
	        tree.insert(10);
	        tree.insert(55);

	        // Displaying node values using in-order traversal
	        System.out.println("Binary Tree before skew:");
	        tree.preOrderTraversal(tree.root);
	        System.out.println();
	        
	        tree.root = SkewTreeConvertor.convertToSkewedTree(tree.root);
	        
	        System.out.println("Binary Tree After skew:");
	        tree.preOrderTraversal(tree.root);
	        System.out.println();

	}

}
