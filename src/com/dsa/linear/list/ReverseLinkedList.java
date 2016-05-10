package com.dsa.linear.list;

public class ReverseLinkedList {

	public static void main(String args[]){
		Node mode1=new Node(5);
		Node mode2=new Node(4);
		Node mode3=new Node(3);
		Node mode4=new Node(2);
		Node mode5=new Node(1);
		
		mode1.next=mode2;
		mode2.next=mode3;
		mode3.next=mode4;
		mode4.next=mode5;
		
		Node head=mode1;
		
		/*
		 * Reverse the pointers
		 *                      : a1->a2->a3
		 * 1. nextNode=a2
		 * 2. currNode=a1
		 * 3. 
		 * 
		 */
		Node currentNode=head;
		Node prevNode=null;
		Node nextNode=null;
		//NCP , next,current,previous,then iterate
		while(currentNode!=null){
			nextNode=currentNode.next;
			currentNode.next=prevNode;
			prevNode=currentNode;
			currentNode=nextNode;			
		}
		
		Node newHead=prevNode; //NEW HEAD
		while(newHead!=null){
			System.out.println("DATAA:"+newHead.data);
		     newHead=newHead.next;
		}
	}
	
	
	
	
	
	static class Node {
		int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
		
	}
	
}
