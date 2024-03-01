package com.lib.gl.bst;

public class SkewTreeConvertor {
    // Convert BST to a right-skewed tree
	    static Node convertToSkewedTree(Node root) {
	    	 if (root == null) {
	             return root;
	         }

	         Node leftSubtree = convertToSkewedTree(root.getLeftNode());
	         Node rightSubtree = root.getRightNode();

	         root.setLeftNode(null);
	         root.setRightNode(convertToSkewedTree(rightSubtree));

	         if (leftSubtree != null) {
	             Node temp = leftSubtree;
	             while (temp.getRightNode() != null) {
	                 temp = temp.getRightNode();
	             }
	             temp.setRightNode(root);

	             return leftSubtree;
	         } else {
	             return root;
	         }
	    }
}