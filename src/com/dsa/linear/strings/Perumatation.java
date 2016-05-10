package com.dsa.linear.strings;

public class Perumatation {

	/*
	 * Use recursion.

     1. Try each of the letters in turn as the first letter and 
        then find all the permutations of the remaining letters using a recursive call.
     2. The base case is when the input is an empty string the only permutation is the empty string.
	 * 
	 */
	
	public static void permuation(String string){
		permutation("", string);
	}
	
	public static void permutation(String prefix,String str){
		int n=str.length();
		if(n==0){
			System.out.println("Permuation is :"+prefix);
		}else{
			for(int i=0;i<n;i++){
				permutation(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1,n));
			}
		}
	}
	
	public static void main(String args[]){
		permuation("ABCDEFGH");
	}
	
}
