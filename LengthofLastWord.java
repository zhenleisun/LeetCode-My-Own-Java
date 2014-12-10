/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

package com.oj.practice;

public class LengthofLastWord {
	
    public int lengthOfLastWord(String s) {
    	if(null == s)
    		return 0;
    	
    	int length = 0;
    	int index = s.length()-1;
    	
    	while(index>=0){
    		if(' ' == s.charAt(index))
    			index--;
    	}
    	
    	if(0>index)
    		return 0;
    	
    	while(index>=0 && ' ' != s.charAt(index)){
    		index--;
    		length++;
    	}
    	
        return length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthofLastWord ll = new LengthofLastWord();
		String str = "a bb   ";
		
		System.out.println(str+":"+ll.lengthOfLastWord(str));
	}

}
