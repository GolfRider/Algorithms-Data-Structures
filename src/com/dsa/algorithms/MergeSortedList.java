package com.dsa.algorithms;

import java.util.Arrays;

public class MergeSortedList {

	public static void main(String args[]){
		int a1[]={2,3,4,5,6};
		int a2[]={5,12,14,16};
		
		int[] finalSortedArray=mergeSortedArrays(a1, a2);
		System.out.println("ARRAY:"+Arrays.toString(finalSortedArray));
		
	}
	
	public static int[] mergeSortedArrays(int a1[],int a2[]){
		int[] finalSortedArray=new int[a1.length+a2.length];
		int i=0,j=0,k=0;
		
		while(i<a1.length && j<a2.length){
			
			if(a1[i]<a2[j]){
				finalSortedArray[k++]=a1[i++];
			}else{
				finalSortedArray[k++]=a2[j++];
			}
		}
		
		while(i<a1.length){
			finalSortedArray[k++]=a1[j++];
		}
		
		while(j<a2.length){
			finalSortedArray[k++]=a2[j++];
		}
		
		return finalSortedArray;
	}
	
}



