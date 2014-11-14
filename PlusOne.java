/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

package com.oj.practice;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        
		return nPlusOne(digits, digits.length-1);
    }
	
	public int[] nPlusOne(int[] digits, int n){
		
		if(n<0){
			int[] newDigits = new int[digits.length+1];
			for(int i=0; i<digits.length; i++){
				newDigits[i+1] = digits[i];
			}
			newDigits[0] = 1;
			return newDigits;
		}
		if(9 == digits[n]){
			digits[n] = 0;
			return nPlusOne(digits, n-1);
		}
		else{
			digits[n] += 1;
			
			return digits;
		}
	}
// Below is a better ways.
/*
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = 1 + digits[i];
			if (digits[i] == 10) {
				digits[i] = 0;
			} else {

				return digits;
			}
		}

		// don't forget over flow case
		int[] ans = new int[digits.length + 1];
		ans[0] = 1;
		for (int i = 0; i < digits.length; i++) {
			ans[i + 1] = digits[i];
		}
		return ans;
	}
*/
}
