package com.dsa.linear.list;

public class DoubleLinkedList {

	
	public static void main(String args[]){
		int[] a={1,2,3,4,5};
		DLL dll= new DLL();
		for(int item:a){
			dll.addNode(item);
		}
		dll.printSLL();
		dll.printReverse();
		dll.printReverseRecursive(dll.getHead());
		dll.printKthFormLast(dll.getHead(),1);
		
	}
	static class DLL{
		Node head;
		Node tail;
		
		public void addNode(int item){
			Node node=new Node(item);
			if(head==null){
				head=node;
				tail=head;
			}else{
				tail.next=node;
				node.prev=tail;
				tail=node;
			}
		}
		
		public void printSLL(){
			Node runner=head;
			while(runner!=null){
				System.out.println("DATA:"+runner.data);
			    runner=runner.next;
			}
		}
		
		public void printReverse(){
			Node runner=tail;
			while(runner!=null){
				System.out.println("RData:"+runner.data);
				runner=runner.prev;
			}
		}
		
		public void printReverseRecursive(Node head){
			if(head==null){
				return;
			}
			
			printReverseRecursive(head.next);
			System.out.println("DATA_RECUR:"+head.data);
		}
		
		public int printKthFormLast(Node head,int k){
			
			if(head==null){
				return 0;
			}
			
			int i=1+printKthFormLast(head.next, k);
			if(i==k){
				System.out.println("KTH Elem:"+head.data);
			}
			return i;
		}

		public Node getHead() {
			return head;
		}

		public Node getTail() {
			return tail;
		}
		
	}
	
	static class Node {
		int data;
		Node next,prev;
		
		public Node(int data){
			this.data=data;
			next=prev=null;
		}
	}
	
}


