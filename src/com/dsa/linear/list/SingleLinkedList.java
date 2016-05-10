package com.dsa.linear.list;

public class SingleLinkedList{
	public static Node head=null;
	public static Node last=null;
	
	public static void main(String args[]){
	   int[] arrayNum={3,4,51,2,3};
	   for(int i:arrayNum){
		   insertNode(i);
	   }
	   printReverse(head);
	   printList(head);
	}
	
	public static void insertNode(int data){
		if(head==null){
			head= new Node(data);
			last=head;
		}else{
			while(last.next!=null){
				last=last.next;
			}
			last.next=new Node(data);
		}
	}
	
	public static void printReverse(Node head){
		if(head==null){
			return;
		}
		printReverse(head.next);
		System.out.println("DATA:"+head.data);
	}
	
	public static void printList(Node head){
		if(head==null){
			return;
		}
		else{
			while(head!=null){
				System.out.println("DATA1:"+head.data);
				head=head.next;
			}
		}
	}
	
}

class Node {
	int data;
	Node next;
	public Node(int data){
		this.data=data;
	}
}