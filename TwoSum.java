/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */

package com.oj.practice;

import java.util.HashMap;

public class TwoSum {
	/**
	 * HashTable solution:
	 * time complexity O(n)
	 * place complexity O(n)
	 * 
	 * We can also solve this problem by Brute force: O(n2) runtime, O(1) space
	 * */
    public int[] twoSum(int[] numbers, int target) {
    	
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        
        for (int i=0; i<numbers.length;i++){
        	if(hashMap.containsKey(target-numbers[i])){
        		res[0] = hashMap.get(target-numbers[i]);
        		res[1] = i+1;
        		return res;
        	}
        	
    		hashMap.put(numbers[i], i+1);
        }
        
        throw new IllegalArgumentException("Can't find the two num!!");
    }
}
