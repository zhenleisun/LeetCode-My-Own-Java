package com.oj.practice;

import java.util.Arrays;

public class SingleNumber {
	
    public int singleNumber(int[] A) {
    	int i=0;
    	
    	Arrays.sort(A);
    	for(i=0; i<A.length-2;){
    		if(A[i]!=A[i+2]){
    			if(A[i]==A[i+1]){
    				return A[i+2];
    			}
    			else
    				return A[i];
    		}
    		else
    			i+=3;
    	}
    	return A[i];
    }
    
    /* constant space solution
    int singleNumber(int A[], int n) {
        int count[32] = {0};
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < n; j++) {
                if ((A[j] >> i) & 1) {
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
    */
    
    /*bitmask solution
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
    */
}
