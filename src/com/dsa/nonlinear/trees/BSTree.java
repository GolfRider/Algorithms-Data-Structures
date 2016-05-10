package com.dsa.nonlinear.trees;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 1. Create BST
 * 2. Search BST
 * 3. Traverse BST
 * 4. Compute Height of BST
 * 5. Compute Sum of BST
 * 6. Count Nodes
 * 7. Check BST Height/Balanced (TODO)
 * 8. Check given BinaryTree is BST or not (TODO)
 * 9.  DFS - Depth First Search (All recursive traversals: Inorder,PostOrder,PreOrder) (TODO)
 *         - Iterative (external stack)  
 * 10. BFS - Breadth First Search (For shortest paths) (TODO)
 *         - Iterative (External Queue)
 * 
 * 11. Recursion - Should Converge
 * 
 */
public class BSTree {

	
	private Node root=null;
	
	//Note: When constructing the Structure, you need to return the Node Reference
	public Node insertNode(Node root,int data){
		Node node= new Node(data);
		//Root Node Check
		if(root==null){
			root=node;
		}
		//Right Subtree Recursion (Neighbor) 
		if(data>root.data){
			root.right=insertNode(root.right,data);
		}
		//Left Subtree Recursion (Neighbor)
		if(data < root.data){
			root.left=insertNode(root.left, data);
		}
		//Return root/sub-root
		return root;
	}
	
	public Node getRoot(){
		return root;
	}
	
	public void traverseBST(Node root){
		//Root Node Check/Base Check / <Entry/Exit Checkpoints>
		if(root==null){
			return;
		}
		traverseBST(root.left); //Left (Neighbor) Recursion
		System.out.println("DATA:"+root.data); //Root Data
		traverseBST(root.right); //Right (Neighbor) Recursion
	}
	
	public int sumNode(Node root){
		//Root Check/Base Case
		if(root==null){
			return 0;
		}
		else{
			return root.data+sumNode(root.left)+sumNode(root.right);
		}
	}
	
	/**
	 * 0. Check Root Node is empty
	 * 1. Search Root Node
	 * 2. Search Left Tree (if key is smaller)
	 * 3. Search Right Tree (if key is greater)
	 * 4. return -1 (if not found)
	 * @param root
	 * @param key
	 * @return
	 */
			
			
	public int searchItem(Node root,int key){
		
		if(root==null){
			return 0;  //When at start/end 
		}
		if(root.data==key){ //Check Root
			return key;
		}else if(key<root.data){  //Recurse on left
			return searchItem(root.left, key);
		}else {
			return searchItem(root.right, key); //Recurse on right
		}
	}
	
      public int getHeight(Node root){
		
		if(root==null){
			return 0;
		}
		else{
			return 1+Math.max(getHeight(root.left),getHeight(root.right));
		}
	}
      
  	public int countNodes(Node root){
		if(root==null){
			return 0;
		}
		else {
			return 1+countNodes(root.left)+countNodes(root.right);
		}
	}	
	
	public static void main(String args[]){
		int numberArray[]={7,8,9,3,4,5,6,1};
		//int numberArray[]={7,8,9,3,4,5,6,1};
		System.out.println("No. of Inputs:"+numberArray.length);
		
		//2. Randomize the input
		List<int[]> list=Arrays.asList(numberArray);
		Collections.shuffle(list);
		
		
		BSTree bstTree= new BSTree();
		Node root=null;
		for(int item:numberArray){
			root=bstTree.insertNode(root, item);
		}
		
		bstTree.traverseBST(root);
		int treeHeight=bstTree.getHeight(root);
		System.out.println("Tree Height:"+treeHeight);
		System.out.println("BST:"+bstTree.sumNode(root));
		System.out.println("KEY:"+bstTree.searchItem(root, 7));
	}
	
	//Data + Pointers to neighboring node
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data=data;
			left=right=null;
		}
	}
}
