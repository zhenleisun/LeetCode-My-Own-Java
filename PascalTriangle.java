package com.oj.practice;

import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
        List<Integer> list;
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        
        for(int i=1; i<=numRows; i++){
        	list = generateRow(i);
        	result.add(list);
        }
        return result;
    }
	
	private List<Integer> generateRow(int numRows){
		List<Integer> list, previousList;
		list = new ArrayList<Integer>();
		
		if(numRows<=0){
			return list;
		}
		else if(1 == numRows){
        	list.add(1);
        	return list;
        }
        else if(2 == numRows){
        	list.add(1);
        	list.add(1);
        	return list;
        }
        else{
        	previousList = generateRow(numRows-1);
        	list.add(1);
        	for(int i=0; i<previousList.size()-1; i++){
        		list.add(previousList.get(i)+previousList.get(i+1));
        	}
        	list.add(1);
        	return list;
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
