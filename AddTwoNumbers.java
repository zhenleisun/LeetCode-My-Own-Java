/*
 You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }

 */
package com.oj.practice;

public class AddTwoNumbers {
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
		@Override
		public String toString() {
			return "[val=" + val + ", next=" + next + "]";
		}
		
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode ln = null,pre=null,first=null,single=null, last = null;
    	int carryVal=0;
    	
    	while(null!=l1 && null!=l2){
    		ln = new ListNode(((l1.val+l2.val)%10+carryVal)%10);
    		
    		carryVal = ((l1.val+l2.val+ carryVal>9)?1:0);
    		
    		if(pre!=null){
    			pre.next = ln;
    		}
    		else
    			first = ln;
    		
    		pre = ln;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	
    	single = (null==l1)?l2:l1;
    	if(single == null && 0!=carryVal){
    		ln.next = new ListNode(1);
    		return first;
    	}
    	
    	ln.next = single;
    	
		while(null != single && 0!=carryVal){
			int tmp = single.val+carryVal;
			single.val = tmp%10;
			
			carryVal = tmp>9?1:0;
			last = single;
			single = single.next;
		}
		
		if(0!= carryVal)
			last.next = new ListNode(1);
    	
    	return first;
/**
* A better compact solution...
*/
    	/*
    	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	    ListNode head = new ListNode(0);
    	    ListNode result = head;
    	    int carry = 0;

    	    while (l1 != null || l2 != null || carry > 0) {
    	        int resVal = (l1 != null? l1.val : 0) + (l2 != null? l2.val : 0) + carry;
    	        result.next = new ListNode(resVal % 10);
    	        carry = resVal / 10;
    	        l1 = (l1 == null ? l1 : l1.next);
    	        l2 = (l2 == null ? l2 : l2.next);
    	        result = result.next;
    	    }

    	    return head.next;
    	}
    	*/
    }
    
	public static void main(String[] args) {
		AddTwoNumbers at = new AddTwoNumbers();
		ListNode l1 = at.new ListNode(1);
		ListNode l2 = at.new ListNode(0);
		ListNode l3 = at.new ListNode(9);
		
//		ListNode l4 = at.new ListNode(9);
//		ListNode l5 = at.new ListNode(9);
		ListNode l6 = at.new ListNode(9);
		ListNode l7 = at.new ListNode(9);
		
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
		
		ListNode res = at.addTwoNumbers(l1, l3);
		System.out.println(l1);
		System.out.println(l6);
		System.out.println(res);
	}

}
