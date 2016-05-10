package com.dsa.bitwise;

public class DuplicateIntegerBitWise {
	
    public static void main(String args[]){
    
    	int deliveryId[]={1,2,3,4,5,4,3,2,1};
    	int uniqueId=0;
    	for(int i=0;i<deliveryId.length;i++){
    		uniqueId=uniqueId^deliveryId[i];
    	}
    	
    	System.out.println("THe number is :"+uniqueId);
    	long num=2;
    	System.out.println("NEW NUM IS:"+(num>>3));
    }
    
 //OR -| , AND-> &, NOT-~ , XOR -> ^, bitwise operators   
	
}
