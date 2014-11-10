package com.oj.practice;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
		int reverseNum = 0;
		int tmp = x;
		
		while(0!=tmp){
			
			reverseNum = reverseNum*10 +tmp%10;
			
			tmp=tmp/10;
		}
		
		System.out.println(" reverseNum " + reverseNum);
		
		if(x==reverseNum){
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args){
		PalindromeNumber pn = new PalindromeNumber();
		int x;
		
		x = -412343214;
		System.out.println(x+" is a " + pn.isPalindrome(x));
		
		x = 1765434567;
		System.out.println(x+" is a " + pn.isPalindrome(x));
	}
}
