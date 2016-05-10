package com.dsa.linear.list;

public class ListKthFromLast {

	public static void main(String args[]){
		Node node1=new Node(5);
		Node node2= new Node(4);
		Node node3=new Node(3);
		Node node4=new Node(2);
		Node node5=new Node(1);
		// 5,4,3,2,1
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		Node head=node1;
		Node currentNode=head;
		Node kthNode=head;
		int i=0; int k=4;
		// 2 LOOPS USED
		while(currentNode!=null && i<k-1){
			currentNode=currentNode.next;
			i++;
		}
		kthNode=currentNode;
		currentNode=head;
		System.out.println("KTH:"+currentNode.data);
		
		while(kthNode.next!=null){
			currentNode=currentNode.next;
			kthNode=kthNode.next;
		}
		System.out.println("KTH:"+currentNode.data);
		
		
		
		
		
	}
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data){
			this.data=data;
		}
	}	
	
}


