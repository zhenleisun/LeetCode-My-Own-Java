/* 
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

package com.oj.practice;

import java.util.*;

public class Combinations {
	 List<List<Integer>> res = new ArrayList<List<Integer>>();
     
     
    public  List<List<Integer>> combine(int n, int k) {
        if(n<k || k<1)
        	return null;
        
        List<Integer> combin, listInt;
        
        if(1==k){
        	for(int i=1; i<=n; i++){
        		combin = new ArrayList<Integer>();
        		combin.add(i);
        		res.add(combin);
        	}
        	return res;
        }
        
        res = combine(n,k-1);
        int resSize = res.size();
        
        for(int i=0; i<resSize; i++){
        	List<Integer> list = res.remove(0);
        	int listSize  = list.size();
        	int nextValue = list.get(listSize-1)+1;
        	
        	for(int j=nextValue; j<=n; j++){
        		listInt = new ArrayList<Integer>();
            	for(int t=0; t<listSize; t++){
            		listInt.add(list.get(t));
            	}
            	listInt.add(j);
        		res.add(listInt);
        	}
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations c = new Combinations();
		
		System.out.println(c.combine(5, 2));
	}

}
