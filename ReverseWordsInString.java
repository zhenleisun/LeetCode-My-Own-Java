/*
Reverse Words in a String Total Accepted: 46164 Total Submissions: 324077 My Submissions Question Solution 
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
Show Tags
*/

package com.oj.practice;

public class ReverseWordsInString {

public String reverseWords(String s) {
    	
    	if(null == s){
    		return null;
    	}
    	
    	StringBuilder word = new StringBuilder("");
    	
    	StringBuilder res = new StringBuilder();
    	
        s=reverseString(s.trim());
        for(int i=0; i<s.length(); i++){
        	if(' ' == s.charAt(i)){
        		//skip continuous spaces
        		if(word.length()<1){
        			continue;
        		}
        		
        		//reverse a word and add it
        		res.append(reverseString(word.toString()));
        		res.append(' ');
        		word = new StringBuilder("");
        	}
        	else
        		word.append(s.charAt(i));
        }
        
        if(word.length()>0){
        	res.append(reverseString(word.toString()));
        }

        return res.toString();
    }
    
    public String reverseString(String s){
    	if (1==s.length())
    		return s;
    	
    	int j = s.length()-1;
    	char c;
    	char[] array = s.toCharArray();
    	
    	for(int i=0; i<j; i++,j--){
    		c=array[i];
    		array[i] = array[j];
    		array[j] = c;
    	}
    	
    	return new String(array);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		ReverseWordsInString rws = new ReverseWordsInString();
		
		s="a    word     abcd";
		System.out.println(s+"--"+rws.reverseWords(s));
	}

}
