package com.oj.practice;

public class StringToInteger {
	
	public int stringToI(String str){

		int i=0, j =0;
		long sum = 0l;
		
		char sign = ' ';
		
		boolean finished = false;
		if(null == str){
			return 0;
		}
		
		j = str.length()-1;
		
		while((i<str.length()) && str.charAt(i) == ' '){
			i++;
		}
		
		while((0==j) && (str.charAt(j) == ' ')){
			j--;
		}
		
		if ( (i==str.length()) || (j<0)){
		    return 0;
		}
		
		if(str.charAt(i) == '+' || str.charAt(i) == '-'){
			sign = str.charAt(i);
			i++;
		}
		
		str = str.substring(i, j+1);
		
		for(i=0; i<str.length() && !finished; i++){
			if(str.charAt(i)>='0' && str.charAt(i)<='9'){
				sum = sum*10 + str.charAt(i)-'0';
			}
			else{
				finished = true;
			}

			if(sum>Integer.MAX_VALUE){
				if(sign!='-'){
					return Integer.MAX_VALUE;
				}
			}
			if(sum>(0l-Integer.MIN_VALUE)){
				return Integer.MIN_VALUE;
			}
		}
		
		return (int)(sign=='-'?(-sum):(sum));
	}
	
	
	public static void main(String[] args){
		StringToInteger si = new StringToInteger();
		
		System.out.println(si.stringToI("-12345"));
		System.out.println(si.stringToI("-2147483649"));
		System.out.println(si.stringToI("-2147483647"));
		System.out.println(si.stringToI("-2147483648"));
	}

}
