/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/
package com.oj.practice;

public class IntersectionofTwoLinkedLists {
	
	public class ListNode {
		 int val;
		 ListNode next;
		 
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(null == headA || null == headB)
    		return null;
    	
    	int lengthA=0, lengthB=0;
    	ListNode ln1=headA, ln2=headB;
    	
    	while(null != ln1){
    		lengthA++;
    		ln1 = ln1.next;
    	}
    	
    	while(null != ln2){
    		lengthB++;
    		ln2 = ln2.next;
    	}
    	
    	while(lengthA>lengthB){
    		lengthA--;
    		headA=headA.next;
    	}
    	
    	while(lengthA<lengthB){
    		lengthB--;
    		headB=headB.next;
    	}
    	
    	while(null != headA){
    		if(headA == headB){
    			return headA;
    		}
    		
    		headA = headA.next;
    		headB = headB.next;
    	}
    	
    	return null;
    }
    
    public int getLength(ListNode ln){
    	int length = 0;
    	while(null != ln){
    		length++;
    		ln = ln.next;
    	}
    	
    	return length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
