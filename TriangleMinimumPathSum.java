/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
package com.oj.practice;

import java.util.*;

public class TriangleMinimumPathSum {
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	
    	if(null == triangle)
    		return 0;
    	
    	if(triangle.size()<=1){
    		return triangle.get(0).get(0);
    	}
    	
    	int[] store = new int[triangle.size()];
    	for(int i=0; i<store.length; i++){
    		store[i] = 0;
    	}
    	return computeSum(0,0, store, triangle);
    }
    
    private int computeSum(int i, int j, int[] storeSum, List<List<Integer>> triangle ){
    	int sum=triangle.get(i).get(j);
    	int rightSum=0;
    	int leftSum=0;
    	
    	//return when compute the second last rows
    	if(i==triangle.size()-2){
    		return sum+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
    	}
    	
    	if(0==j){
    		leftSum = computeSum(i+1, j, storeSum, triangle);
    	}
    	else{
    		leftSum = storeSum[i];
    	}
		
    	rightSum = computeSum(i+1, j+1,storeSum, triangle);
    	storeSum[i] = rightSum;
		
    	if(leftSum>rightSum){
    		return sum + rightSum;
    	}
    	else{
    		return sum + leftSum;
    	}
    }
}
