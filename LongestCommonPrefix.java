/*
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
 */
package com.oj.practice;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
    	StringBuilder sb = new StringBuilder();
    	
    	if(null == strs)
    		return "";
    	
    	if(1==strs.length)
    		return strs[0];
    	
    	char ch;
    	int j=0;
    	
    	while(j<strs[0].length()){
    		
    		ch = strs[0].charAt(j);
    		
	    	for(int i=1; i<strs.length; i++){
	    		if(j == strs[i].length())
	    			return strs[i];
	    		
	    		if(ch == strs[i].charAt(j)){
	    			continue;
	    		}
	    		else
	    			return sb.toString();
	    	}
	    	
	    	sb.append(ch);
	    	j++;
    	}
    	sb.append("");
		return sb.toString();
    }
    
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		String[] strs = {"abc", "arf", ""};
		System.out.println("xx"+lcp.longestCommonPrefix(strs));
	}

}
