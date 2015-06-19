package com.learning.datastructure.tree;

public class TreeApplication {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		// Insert into BST.
		bst.insertIntoBST(50,bst.getRoot());
		bst.insertIntoBST(60,bst.getRoot());
		bst.insertIntoBST(40,bst.getRoot());
		bst.insertIntoBST(20,bst.getRoot());
		bst.insertIntoBST(10,bst.getRoot());
		bst.insertIntoBST(70,bst.getRoot());
		bst.insertIntoBST(45,bst.getRoot());
		bst.insertIntoBST(55,bst.getRoot());
		
		// Traversal : Inorder 
		//bst.InorderTraversalNR(bst.getRoot());
		
		// Traversal : Preorder
		//bst.preOrderTraversal(bst.getRoot());
		//bst.preOrderTraversalNR(bst.getRoot());
		
		// Traversal :  Postorder
		//bst.postorder(bst.getRoot());
		
		// Traversal :  Level Order 
		bst.levelOrderTraversal(bst.getRoot());		
	}
}
