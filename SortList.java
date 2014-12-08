/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
/*
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

package com.oj.practice;

public class SortList {
	public class ListNode {
		 int val;
		 ListNode next;
		 
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	
	//使用归并排序
    public ListNode sortList(ListNode head) {
        if(null == head || null == head.next)
        	return null;
        
        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null;
       
        return merge(sortList(head), sortList(right));
    }
    
    public ListNode merge(ListNode left, ListNode right){
    	ListNode head = new ListNode(0);
    	ListNode ln = head;
    	
    	while(null != left && null !=right){
    		if(left.val>right.val){
    			ln.next=right;
    			right= right.next;
    			ln = ln.next;
    		}
    		else if(left.val<right.val){
    			ln.next=left;
    			left= left.next;
    			ln = ln.next;
    		}
    		else{
    			ln.next = left;
    			ln.next.next = right;
    			ln = ln.next.next;
    			left = left.next;
    			right = right.next;
    		}
    	}
    	
    	if(null == left){
    		ln.next = right;
    	}
    	
    	if(null == right){
    		ln.next = left;
    	}
    		
    	return head.next;
    }
    
    public ListNode getMiddle(ListNode head){

    	ListNode fast = head, slow = head;
        while(true)
        {
            if(fast.next != null)
            {
                fast = fast.next;
                if(fast.next != null)
                    fast = fast.next;
                else
                    break;
                slow = slow.next;
            }
            else
                break;
        }

        return slow;
 /*   	
    	while(fast.next!=null){
    		fast = fast.next;
    		if(null != fast.next){
    			fast = fast.next;
    			slow = slow.next;
    		}
    	}
    	*/
    	
    }
    
    public static void main(String[] args){
    	SortList st = new SortList();
    	
    	SortList.ListNode ln = st.new ListNode(13);
    	ln.next = st.new ListNode(5);
    	
    	SortList.ListNode res = st.sortList(ln);
    	
    	while(null!=res){
    		System.out.println(res.val+"..");
    		res = res.next;
    	}
    	
    }
}
