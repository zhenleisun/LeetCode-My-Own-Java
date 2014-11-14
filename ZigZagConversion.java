/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
package com.oj.practice;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
    	if(s.length()<=nRows || nRows==1)
    		return s;
    	
    	StringBuilder[] sb = new StringBuilder[nRows];
    	
    	for(int i=0;i<nRows; i++){
    		sb[i] = new StringBuilder();
    	}
    	
    	for(int i=0; i<s.length(); ){
    		for(int j=0; i<s.length() && j<nRows; j++){
    			sb[j].append(s.charAt(i++));
    		}
    		for(int t=nRows-2; i<s.length() && t>0; t--){
    			sb[t].append(s.charAt(i++));
    		}
    	}
    	for(int i=1; i<nRows; i++){
    		sb[0].append(sb[i].toString());
    	}
        return sb[0].toString();
    }
    
    public static void main(String args[]){
		ZigZagConversion zzc = new ZigZagConversion();
		String str;
		
		str = "ABCDEFGHIJKL";
		System.out.println(str+" after convert: \n"+zzc.convert(str, 3));
		
		str = "PAYPALISHIRING";
		System.out.println(str+" after convert: \n"+zzc.convert(str, 3));
		
		str = "ABCD";
		System.out.println(str+" after convert: \n"+zzc.convert(str, 2));
    }
}
