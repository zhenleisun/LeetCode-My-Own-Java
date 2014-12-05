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

public class MergeTwoSortedList {
	public class ListNode {
		 int val;
		 ListNode next;
		 
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(null ==l1 && null == l2)
    		return null;

        ListNode ln, first, result,tmp;
        if(l1.val<l2.val){
        	first = l1;
        	ln = l2;
        }
        else{
        	first = l2;
        	ln = l1;
        }
        result = first;
        
    	while(null != ln){
    		if(null != first.next){
    			if(first.next.val<ln.val){
    				first = first.next;
    			}
    			else{
    				tmp = new ListNode(ln.val);
    				tmp.next = first.next;
    				first.next = tmp;
    				first = tmp;
    				ln = ln.next;
    			}
    			
    		}
    		else{
    			first.next = ln;
    			break;
    		}
    	}
    	
        return result;
    }
    
	public static void main(String[] args) {
		
	}

}
