/*
Find Minimum in Rotated Sorted Array Total Accepted: 19259 Total Submissions: 60053 My Submissions Question Solution 
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.

Show Tags
*/

package com.oj.practice;

public class MinimumInRotatedSortedArray {
	
	    public int findMin(int[] num) {
	        int i=0;
	        int j=num.length-1;
	        int mid =0;
	        
	        while(i<j){
	            mid = (i+j)/2;
	            
	            if(num[j]<num[mid]){
	                i=mid+1;
	            }
	            else{
	                j=mid;
	            }
	            
	        }
	        
	        return num[i];
	    }
}
