/*
 *
 	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    
 */
package com.oj.practice;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] num, int target) {
		if (num.length < 3) {
			return 0;
		}

		Arrays.sort(num);

		int minDiff = Integer.MAX_VALUE;
		int reSum = 0;

		for (int i = 0; i < num.length - 2; i++) {
			int l = i + 1;
			int t = num.length - 1;
			int sum = 0;
			boolean neg = false, pos = false;
			
			while (l < t) {
				sum = num[l] + num[t] + num[i];

				if (sum == target) {
					return sum;
				} 
				
				if (Math.abs(minDiff) > (sum - target)){
					minDiff = sum-target;
					reSum = sum;
				}
				
				if (sum > target) {
					pos = true;
					t--;
//					if (neg == true)
//						break;
				} 
				else {
					neg = true;
					l++;
//					if (pos == true)
//						break;
				}
			}
		}

		return reSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClosest tsc = new ThreeSumClosest();

		int[] num;
		int target;

		num = new int[] { -3, 2, 9 };
		target = 5;
		System.out.println("num:" + num + ", closest:"
				+ tsc.threeSumClosest(num, target));

		num = new int[] { -3, 2, 9, 8, 0 };
		target = 5;
		System.out.println("num:" + num + ", closest:"
				+ tsc.threeSumClosest(num, target));

		num = new int[] {1,2,4,8,16,32,64,128};
		target = 82;
		System.out.println("num:" + num + ", closest:"
				+ tsc.threeSumClosest(num, target));
	}

}
