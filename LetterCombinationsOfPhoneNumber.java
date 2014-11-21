/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
package com.oj.practice;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        digits = digits.trim();
        String[] str = new String[]{" ", "1", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        if(digits.length()<1){
        	list.add(digits);
        	return list;
        }
        String numStr = str[digits.charAt(0)-'0'];
        
		for(int j=0; j<numStr.length(); j++)
			list.add(String.valueOf(numStr.charAt(j)));
		
        for(int i=1; i<digits.length(); i++){
        	if(digits.charAt(i) == ' '){
        		numStr = " ";
        	}
        	else
        		numStr = str[digits.charAt(i)-'0'];

    		int size = list.size();
    		for(int l=0; l<size; l++){
    			for(int j=0; j<numStr.length(); j++){
    				list.add(list.get(0)+String.valueOf(numStr.charAt(j)));
    			}
    			list.remove(0);
    		}
        }
        
        return list;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsOfPhoneNumber lc = new LetterCombinationsOfPhoneNumber();
		
		System.out.println(lc.letterCombinations("23"));
	}

}
