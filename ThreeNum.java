package com.oj.practice;

import java.util.*;

public class ThreeNum {
	
	public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> list;
        
        if(null == num)
        	return results;
        
        Arrays.sort(num);
        
        for(int i=0; i<num.length-2; i++){
        	int j = num.length-1;
        	int l=i+1;
        	
        	if((i-1>=0) && num[i]==num[i-1]){
        		continue;
        	}
        	
        	while(l<j){
        		if((l-1>i) && (num[l]==num[l-1])){
        			l++;
        			continue;
        		}
        		if(num[l]+num[j]+num[i]<0){
        			l++;
        		}
        		else if(num[l]+num[j]+num[i]>0){
        			j--;
        		}
        		else{
        			list = new ArrayList<Integer>();
        			list.add(num[i]);
        			list.add(num[l]);
        			list.add(num[j]);
        			results.add(list);
        			l++;
        			j--;
        		}
        	}
        	
        }
        return results;
    }
	
	public static void main(String args[]){
		ThreeNum tn = new ThreeNum();
		
		System.out.println(tn.threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
}
