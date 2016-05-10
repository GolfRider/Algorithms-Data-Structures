package com.dsa.linear.strings;

public class ReverseStringExample {

	/*
	 * 1. Reverse the sentence
	 * 2. Then Reverse the word
	 * 
	 */
	public static void main(String args[]){
		
		String text="find you will pain only go you recordings security the into if";
		char[] textArray=text.toCharArray();
		reverseText(textArray, 0, text.length()-1);
		System.out.println("REVERSE_TEXT_1:"+new String(textArray));
		
		
		int wordBegin=0;
		for(int i=0;i<textArray.length;i++){
			//System.out.println("CHARR:"+textArray[i]);
			if(textArray[i]==' '){
				reverseText(textArray,wordBegin,i-1);
				wordBegin=i+1;
			}
			else if(i==textArray.length-1){//last word
				reverseText(textArray,wordBegin,i);
				wordBegin=i+1;
			}
			
		} //for
		System.out.println("REVERSE_TEXT_2:"+new String(textArray));
	}
	
	
	/*
	 * 1. Reverse the string
	 * 2. 
	 * 
	 */	
	
	public static void reverseText(char[] textArray,int begin,int end){
		while(begin<end){
			char temp=textArray[begin];
			textArray[begin]=textArray[end];
			textArray[end]=temp;
			begin++;
			end--;
		}
		
 	}
}
