package com.dsa.linear.stack;

import java.util.Stack;

public class StackMax {

	private Stack<Integer> stack= new Stack<Integer>();
	private Stack<Integer> maxStack= new Stack<Integer>();
	
	public int push(int item){
		this.stack.push(item);
		if(maxStack.isEmpty() || item>=maxStack.peek()){
			maxStack.push(item);
		}
		return item;
	}
	
	public int pop(){
		int poppedItem=stack.pop();
		
		if(poppedItem==maxStack.peek()){
			maxStack.pop();
		}
		return poppedItem;
	}
	
	public int getMax(){
		return maxStack.peek();
	}
	
	public static void main(String args[]){
		StackMax stackMax= new StackMax();
		stackMax.push(1);
		stackMax.push(3);
		stackMax.push(0);
		System.out.println("MAX_ELEM:"+stackMax.getMax());
		
	}
	
	
	
}


