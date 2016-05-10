package com.dsa.linear.list;

public class SingleLinkedListDeleteNode {

	public static void main(String args[]){
		Node n1= new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		deleteNode(n5);
		Node head=n1;
		while(n1!=null && n1.data!=-10001){
			System.out.println("DATA_AFTER_DELETE:"+n1.data);
			n1=n1.next;
		}
		
	}
	
	public static void deleteNode(Node n){
		if(n.next!=null){
			Node nextNode=n.next;
			n.data=nextNode.data;
			n.next=nextNode.next;
		}else{
			// For the last Node, make it NULL
			n.data=-10001;
		}
	}
	
	public static class Node {
		int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
	}
}
