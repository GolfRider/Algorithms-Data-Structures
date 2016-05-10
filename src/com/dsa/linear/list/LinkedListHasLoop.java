package com.dsa.linear.list;

public class LinkedListHasLoop {

	public static void main(String args[]){
		Node node1= new Node(1);
		Node node2= new Node(2);
		Node node3= new Node(3);
		Node node4= new Node(4);
		Node node5= new Node(5);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		
		//node5.next=node4;
		
		Node head=node1;
		Node slowRunner=head;
		Node fastRunner=head;
		boolean hasLoop=false;
		while(fastRunner!=null && fastRunner.next!=null){
			fastRunner=fastRunner.next.next;
			slowRunner=slowRunner.next;
			
			if(slowRunner==fastRunner){
				hasLoop=true;
				break;
			}
		}
		System.out.println("HAS_LOOP:"+hasLoop);
		
	}
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data=data;
		}
	}
}
