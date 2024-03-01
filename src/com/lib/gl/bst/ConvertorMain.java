package com.lib.gl.bst;
import java.util.Scanner;

public class ConvertorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the number of nodes required for Binary search tree:");
		
		Scanner input = new Scanner(System.in);
	
		int noOfNodes = input.nextInt();
		
		BST bst_tree = new BST();
		
		for(int i = 1; i <= noOfNodes; i += 1) {
			System.out.printf("Enter the node %d for the tree:", i);
			int val = input.nextInt();
			bst_tree.insert(val);
		}
		
		
		System.out.println("Binary Tree before skew:");
		bst_tree.preOrderTraversal(bst_tree.root);
        System.out.println();
        
        bst_tree.root = SkewTreeConvertor.convertToSkewedTree(bst_tree.root);
        
        System.out.println("Binary Tree After skew:");
        bst_tree.preOrderTraversal(bst_tree.root);
        System.out.println();
		
		input.close();

	}

}
