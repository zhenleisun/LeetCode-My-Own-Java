/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

Show Tags
*/

package com.oj.practice;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(null == s) return 0;
        Map<Character, Integer> map;
        int max = 0;
        
        for(int i=0; i<s.length()-max; i++){
        	map = new HashMap<Character, Integer>();
        	for(int j=i; j<s.length(); j++){
        		if(map.containsKey(s.charAt(j))){
        			i = map.get(s.charAt(j));
        			break;
        		}else{
        			map.put(s.charAt(j), j);
        		}
        	}
        	if(max<map.size()){
				max = map.size();
			}
        }
        
        return max;
        
/*       		O(n) time solution。。。  
        if (s == null)
            return 0;

        Map<Integer, Integer> dictionary = new HashMap<Integer, Integer>();


        int max = 0;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            length++;
            //If found repeating character, check if the character is in the current substring.
            if (dictionary.containsKey(s.codePointAt(i))&&length>(i-dictionary.get(s.codePointAt(i))))
                length =i - dictionary.get(s.codePointAt(i));
            //Get the longest substring.            
            max = Math.max(length, max);
            dictionary.put(s.codePointAt(i), i);
        }

        return max;
*/
    }
    
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		// TODO Auto-generated method stub
		String str="lengthOfLongestSubstring";
		System.out.println(l.lengthOfLongestSubstring(str));
		
		str="abcabcbb";
		System.out.println(l.lengthOfLongestSubstring(str));
		str="aaaaaaaaaab";
		System.out.println(l.lengthOfLongestSubstring(str));
	}

}
