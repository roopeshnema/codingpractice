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
	
	/**
         *  Find max element in BST (With Recursion).
         *  Solution : Search max in leftSubTree, rightSubTree recursively and compare with rootdata
         *  which ever is max returned that value.
         */
        public int maxInBinarySearchTreeR(TreeNode root){            
            int data = 0;
            int maxLeft = 0;
            int maxRight = 0;
            if(root == null){
                return data;
            }
            maxLeft = maxInBinarySearchTreeR(root.getLeftnode());
            maxRight = maxInBinarySearchTreeR(root.getRightnode());
            
            if(maxLeft > maxRight) {
                data = maxLeft;
            } else {
                data = maxRight;
            }
            
            if(root.getData() > data) {
                data = root.getData();
            }
            return data;
        }

        /**
         *  Find max element in BST (Without Recursion).
         *  Solution : Search max in leftSubTree, rightSubTree recursively and compare with rootdata
         *  which ever is max returned that value.
         */
        
        public int maxInBinarySearchTreeWR(TreeNode root){
            int maxData = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if(temp.getData() > maxData) {
                    maxData = temp.getData();
                }
                if(temp.getLeftnode() != null) {
                    queue.offer(temp.getLeftnode());
                }
                if(temp.getRightnode() != null) {
                    queue.offer(temp.getRightnode());
                }
            }            
            return maxData;
        }
        
        /**
         * Search an element is BST (Recursion).
         * 
         * @param root
         * @param searchData
         * @return 
         */
        public boolean searchElementInBSTR(TreeNode root, int searchData) {
            if(root == null) {
                return false;
            }
            
            if(root.getData() == searchData) {
                return true;
            }
            return (searchElementInBSTR(root.getLeftnode(),searchData) || searchElementInBSTR(root.getRightnode(),searchData));
        }
        
        /**
         * Search an element is BST (Without Recursion).
         */
        public boolean searchElementInBSTWR(TreeNode root, int searchData) {
            if(root == null) {
                return false;
            }            
            Queue<TreeNode> queue = new LinkedList<>();            
            queue.offer(root);
            while(!queue.isEmpty()) {
             TreeNode treeNode = queue.poll();
             if(treeNode.getData() == searchData) {
                 return true;
             }
             
             if(treeNode.getLeftnode() != null) {
                 queue.offer(treeNode.getLeftnode());
             }
             if(treeNode.getRightnode() != null) {
                 queue.offer(treeNode.getRightnode());
             }             
            }
            return false;
        }
       
    public TreeNode insertIntoBST(TreeNode root, int data) {
                
        TreeNode newNode = new TreeNode();
        newNode.setData(data);        
        return insertNode2(root,newNode);        
    }    
    
    private TreeNode insertNode2(TreeNode root, TreeNode newNode){
        if(root == null) {
            this.setRoot(newNode);
            return newNode;
        }
        
        if(newNode.getData() > root.getData()) {
            
            if(root.getRightnode() == null) {
                root.setRightnode(newNode);
            }else {
                insertNode2(root.getRightnode(),newNode);
            }            
            
        } else {
            if(root.getLeftnode() == null) {
                root.setLeftnode(newNode);
            } else {
                insertNode2(root.getLeftnode(),newNode);
            }
        }
       return root; 
    }
    
    public TreeNode insertIntoBSTWR(TreeNode root, int data) {                
        TreeNode newNode = new TreeNode();
        newNode.setData(data);        
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
         
            TreeNode node = queue.poll();
            if(data > node.getData()) {
                if(node.getRightnode() == null) {
                    node.setRightnode(newNode);
                } else {
                   queue.offer(node.getRightnode());
                }
            } else {
                if(node.getLeftnode() == null) {
                    node.setLeftnode(newNode);
                } else {
                    queue.offer(node.getLeftnode());
                }
            }
        }
        return root;
    }
	
} 
