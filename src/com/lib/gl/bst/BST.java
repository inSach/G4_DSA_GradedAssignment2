package com.lib.gl.bst;

public class BST {
    Node root;

    public BST() {
        root = null;
    }

    // Insert a new node into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.getData()) {
            root.setLeftNode(insertRec(root.getLeftNode(), data));
        } else if (data > root.getData()) {
            root.setRightNode(insertRec(root.getRightNode(), data));
        }

        return root;
    }

    // pre-order traversal to display node values
    public void preOrderTraversal(Node root) {
        if (root != null) {
        	  System.out.print(root + " ");
              preOrderTraversal(root.getLeftNode());
              preOrderTraversal(root.getRightNode());
        }
    }

}
