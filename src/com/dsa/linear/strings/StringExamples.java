package com.dsa.linear.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StringExamples {

	public static void main(String args[]){
	  
		  String text="ICVICX";
		  String expression="{{}}[][]{}";
		  String parenText="123456(123)1234()";
		  
		  boolean palindromResult=checkForPalindrome(text);
		  boolean checkPairs= checkBracketsPairs(expression);
		  int closingParenthesis=getParenthesisPosition(parenText, 15);
		  
		  System.out.println("CHECK_PAIRS:"+checkPairs);
		  System.out.println("PALINDROME_RESULT:"+palindromResult);
		  System.out.println("CLOSING_PAREN_POSITION:"+closingParenthesis);
	}
	
	/* PROBLEM # 30
	 * 1. Count the no of each characters, except one odd, rest all have to be even
	 * For ANY COmbination
	 */
	
	/**
	 * @param text
	 * @return
	 */
	public static boolean checkForPalindrome(String text){

		Map<Character,Boolean> parityMap= new HashMap<Character,Boolean>();
		for(char elem:text.toCharArray()){
			if(parityMap.containsKey(elem)){
				parityMap.put(elem, !parityMap.get(elem));
			}else{
				parityMap.put(elem, true);
			}
		}
		
		//Check for no. of ODDS.
		boolean oddSeen=false;
		for(boolean oddElem:parityMap.values()){
			if(oddElem){
				if(oddSeen){
					return false;
				}
				oddSeen=true;
			}
		}
		
		return true;
			
	}
	
	/* PROBLEM NO: 29
	 * 1. Sequence  of allowed Brackets.
	 * 2. Check for valid pairs
	 * 3. Push opening brackets into stack.
	 * 4. Pop when the closing bracket comes up.
	 * 5. By the end of string,stack has to be empty.
	 *  
	 */
	public static boolean checkBracketsPairs(String expression){
		Map<Character,Character> charMap= new HashMap<Character,Character>();
	    charMap.put('(', ')');
        charMap.put('[', ']');	
        charMap.put('{', '}');
        
        Set<Character> openingBrackets=charMap.keySet();
        Set<Character> closingBrackets=new HashSet<Character>(charMap.values());
        Stack<Character> openBracketStack= new Stack<Character>();
        for(char elem:expression.toCharArray()){
        	if(openingBrackets.contains(elem)){
        		openBracketStack.push(elem);
        	}
        	if(closingBrackets.contains(elem)){
        		if(openBracketStack.isEmpty()){
        			return false;
        		}
        		char lastOpeningBracket=openBracketStack.pop();
        		if(elem!=charMap.get(lastOpeningBracket)){
        			return false;
        		}
        	}
        }
        return openBracketStack.empty();
	}
  
	/*
	 * PROBLEM: 28 
	 * 1. Initialize the position to positon+1
	 * 2. Check for open/close parenthesis
	 * 3. init parenthesis depth=0;
	 * 
	 */
	public static int getParenthesisPosition(String text,int position){
        if(text.charAt(position)!='('){
		   throw new IllegalArgumentException("Please specify a valid value");	
		}
        
        int positionBegin=position+1;
		int innerParenthesis=0;
		
		for(int i=positionBegin;i<=text.length();i++){
			char elem=text.charAt(i);
			if(elem=='('){
				innerParenthesis++;
			}else if(elem==')'){
				if(innerParenthesis==0){
					return i;
				}else{
					innerParenthesis--;
	
				}
			}
	}
	 return -1;	
  }
}