package com.oj.practice;

import java.util.ArrayList;
import java.util.ListIterator;

public class MinStack {
	
	ArrayList<Integer> al = new ArrayList<Integer>();

    int min = Integer.MAX_VALUE;
    int minCount = 1;
    boolean needCount = false;
    
    public void push(int x) {
    	al.add(x);
    	if(x<min){
    		min = x;
    		minCount = 1;
    	}
    	else if(x == min){
    		minCount++;
    	}
    }

    public void pop() {
    	int tmp = al.remove(al.size()-1);
    	
    	if(tmp==min){
    		if(--minCount == 0){
    			min = Integer.MAX_VALUE;
    			needCount = true;
    		}
    	}
    	
    }

    public int top() {
    	return al.get(al.size()-1);
    }

    public int getMin() {
    	if(needCount == false){
    		return min;
    	}
    	else{
	        for(int i=0; i<al.size(); i++){
	        	int next = al.get(i);
	        	if(min>next){
	        		min = next;
	        		minCount = 1;
	        	}
	        }
	        needCount = false;
	        return min;
    	}
    }
    
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		
		System.out.println("minmum value:"+ms.getMin());
		ms.push(-10); 
		ms.push(14);
		System.out.println("minmum value:"+ms.getMin());
		System.out.println("minmum value:"+ms.getMin());
		ms.push(-20);
		System.out.println("minmum value:"+ms.getMin());
		System.out.println("minmum value:"+ms.getMin());
		System.out.println("minmum value:"+ms.top());
		

		System.out.println("minmum value:"+ms.getMin());
		ms.pop();
		
		ms.push(10);
		ms.push(-7);

		System.out.println("minmum value:"+ms.getMin());
		
		ms.push(-7);
		
		ms.pop();
		
		System.out.println("minmum value:"+ms.top());
		
		System.out.println("minmum value:"+ms.getMin());
		ms.pop();
		
			
	}

}
