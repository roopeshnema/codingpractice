package com.learning.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	private TreeNode root = null;
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public void insertIntoBST(int data,TreeNode root) {
		TreeNode node = new TreeNode();
		node.data = data;
		node.setLeftnode(null);
		node.setRightnode(null);
		insertNode(node,root);
	}
	
	private void insertNode(TreeNode node, TreeNode root) {
		if(node == null) return;
		
		if(this.getRoot() == null) {
			this.setRoot(node);
			return;
			
		} 		
		if(node.getData() > root.getData()){
			if(root.getRightnode() == null){
				root.setRightnode(node);
			} else {				
				insertNode(node,root.getRightnode());
			}
		} else {
			if(root.getLeftnode() == null) {
				root.setLeftnode(node);
			} else {
				insertNode(node, root.getLeftnode());
			}
		}
		
	}
	
	public void displayBST(TreeNode node) {
		if(node == null) return;
		
		displayBST(node.getLeftnode());
		System.out.println(node.getData());
		displayBST(node.getRightnode());
	}
	
	/**
	 *  Inorder traversal :  Recursive version
	 * @param node
	 */
	public void InorderTraversal(TreeNode node) {
		if(node == null) return;
		
		displayBST(node.getLeftnode());
		System.out.println(node.getData());
		displayBST(node.getRightnode());
	}
	
	/**
	 * 
	 * @param node
	 */
	public void InorderTraversalNR(TreeNode root) {
		if(root == null) return;
		
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		while(true) {
			while(root != null) {
				nodeStack.push(root);
				root = root.getLeftnode();				
			}
			if(nodeStack.isEmpty())
				break;
			
			root = nodeStack.pop();
			System.out.println(root.getData());
			root = root.getRightnode();
		}
		return;
	}
	
	/**
	 *  Preorder traversal : Recursive.
	 * @param root
	 */
	
	public void preOrderTraversal(TreeNode root) {
		if(root == null) return;
		System.out.println(root.getData());
		preOrderTraversal(root.getLeftnode());
		preOrderTraversal(root.getRightnode());
	}
	
	/**
	 * Preorder traversal : Non Recursive.
	 * @param root
	 */
	public void preOrderTraversalNR(TreeNode root) {
		
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		while(true) {
			while( root != null) {
				System.out.println(root.getData());
				nodeStack.push(root);
				root = root.getLeftnode();
			}
			
			if(nodeStack.isEmpty()) 
				break;
			
			root = nodeStack.pop();
			if(root != null)
				root = root.getRightnode();
		}
		
		return;
	}
	
	/**
	 * Post order Traversal: Recursive 
	 */
	public void postorder(TreeNode root) {
		if(root == null) return;
		
		postorder(root.getLeftnode());
		postorder(root.getRightnode());
		System.out.println(root.getData());
	}
	
	/**
	 *  Level order Traversal 
	 */
	
	public void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {			
			TreeNode node = queue.remove();
			if(node == null) {
				if(queue.isEmpty()) return;
				queue.add(null);
				System.out.println("");
			} else {
				System.out.print(" " + node.getData());
				if(node.getLeftnode() != null)
					queue.add(node.getLeftnode());

				if(node.getRightnode() != null)
					queue.add(node.getRightnode());				
			}
		}	
	}
} 
