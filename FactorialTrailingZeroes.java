/**
 * Factorial Trailing Zeroes
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * */
package com.oj.practice;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
    	int res = 0;
    	int power = 1;
    	int divide = n/5;
    	
    	while(true){
    		res += divide;
    		divide = (int) ((int)n/Math.pow(5, ++power));
    		
    		if(divide==0){
    		    return res;
    		}
    	}
    }
    
}
