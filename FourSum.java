package com.oj.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class FourSum {
	public static final int SUM_NUMBER = 4;
	
	public static void main(String[] args){
		int[] num = {-3,-2,-1,0,0,1,2,3};
		int target = 0;
		
		FourSum fs = new FourSum();
		System.out.println("Start...");
		fs.fourSum(num, target);
	}
    public List<List<Integer>> fourSum(int[] num, int target) {
    	if(num.length<SUM_NUMBER){
    		System.out.println("The array is so short!!");
    		System.exit(0);
    	}
    	
    	Arrays.sort(num);
    	for(int i=0; i<num.length; i++){
    		System.out.print(":"+num[i]+",");
    	}
    	return findFourSum(num, target);
	}
    
    public List<List<Integer>> findFourSum(int[] num, int target){
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	List<Integer> fourList;
    	HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
    	int loopCounter1=0, loopCounter2=0;
    	int l=0, r=0, twoTarget=0;
    	
    	for(loopCounter1=0; loopCounter1<num.length-3; loopCounter1++){
    		for (loopCounter2=loopCounter1+1; loopCounter2<num.length-2; loopCounter2++){
    			twoTarget = target-num[loopCounter1]-num[loopCounter2];
    			l = loopCounter2+1;
    			r = num.length-1;
    			
    			while(l<r){
    				if(twoTarget<num[l]+num[r])
    					r--;
    				else if (twoTarget>num[l]+num[r])
    					l++;
    				else{
    					fourList = new ArrayList<Integer>();
    					fourList.add(num[loopCounter1]);
    					fourList.add(num[loopCounter2]);
    					fourList.add(num[l]);
    					fourList.add(num[r]);
    					hashSet.add(fourList);
    					l++;
    					r--;
    				}
    			}
    		}

    	}
    	Iterator<List<Integer>> it = hashSet.iterator();
    	while(it.hasNext()){
    		System.out.println("it...."+it.next().toString());
    		resultList.add((List<Integer>)it.next());
    	}
    	return resultList;
    }
    
}
