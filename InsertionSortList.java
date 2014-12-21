/*
Insertion Sort List Total Accepted: 30177 Total Submissions: 118224 My Submissions Question Solution 
Sort a linked list using insertion sort.

Show Tags
*/

package com.oj.practice;

public class InsertionSortList {
	public static class ListNode {
		 int val;
		 ListNode next;
		 
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	
	public ListNode getPre(ListNode res, int val){
		ListNode pre = res;
		ListNode next = res.next;
		
		while(null!=next && next.val<val){
			pre = next;
			next=next.next;
		}
		return pre;
	}
    public ListNode insertionSortList(ListNode head) {
 	    if(null == head || null==head.next){
 	    	return head;
 	    }
 	    
 	    ListNode res = new ListNode(0);
 	    res.next = null;
 	    ListNode insertPre = res;
 	    ListNode next;
 	    
 	    while(null != head){
 	    	//在链表res中查找要插入的前一个节点的位置
 	    	next = head.next;
 	    	
 			insertPre = res;
 			ListNode resNext = res.next;
 			
 			while(null!=resNext && resNext.val<head.val){
 				insertPre = resNext;
 				resNext=resNext.next;
 			}
 			
 	    	head.next = insertPre.next;
 	    	insertPre.next = head;
 	    	head=next;
 	    }
 	    return res.next;
    }
    
    public static void main(String[] args){
    	InsertionSortList is = new InsertionSortList();
    	ListNode head = new ListNode(100), ln,head1=head;
    	
    	for(int i=0; i<20; i++){
    		ln = new ListNode(i);
    		head1.next = ln;
    		head1 = head1.next;
    	}
    	head1=head;
    	while(null != head1){
    		System.out.print(head1.val+":");
    		head1=head1.next;
    	}
    	
    	System.out.println();
    	
    	ListNode res = is.insertionSortList(head);
    	
    	while(null != res){
    		System.out.print(res.val+":");
    		res=res.next;
    	}
    }
}
