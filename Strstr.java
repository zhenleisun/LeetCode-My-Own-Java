/**
 * Implement strStr().
*
* Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*
* Update (2014-11-02):
* The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
*
*/
package com.oj.practice;

public class Strstr {

	public int strStr(String haystack, String needle) {
		int stackLength = haystack.length();
		int needleLength = needle.length();
		
		if(needleLength==0){
			return 0;
		}
		else if(stackLength==0 || needleLength>stackLength){
        	return -1;
        }
        
        for(int i=0; i<stackLength; i++){
        	int j=0;
        	
        	if((stackLength-i)<needleLength){
        		return -1;
        	}
        	while(haystack.charAt(i) == needle.charAt(j)){
        		i++;
        		j++;
        		if(j==needle.length())
        			return i-j;
        		else if(i>=stackLength)
        			break;
        	}
        	i=i-j;
        }
        return -1;
    }
}
