/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

package com.oj.practice;

public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int length = A.length;
        int count=0;
        
        for(int i=0; i<A.length; i++){
        	if(A[i] == elem){
        		count++;
        	}
        	else{
        		A[i-count] = A[i];
        	}
        }
        
        return length-count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
