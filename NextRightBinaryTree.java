/*
 Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
package com.oj.practice;

public class NextRightBinaryTree {
	public class TreeLinkNode{
		int val;
		TreeLinkNode right, left, next;
		private TreeLinkNode(int x){
			val = x;
		}
	}
	
    public void connect(TreeLinkNode root) {
        if((null ==  root))
        	return;
        
        root.next = null;
        
        if(null == root.left || null == root.right)
        	return;
        
        root.left.next = root.right;
        root.right.next = null;
        
        connectAjacent(root.left);
        connectAjacent(root.right);
    }

	private void connectAjacent(TreeLinkNode node) {
		if(null == node)
			return;
		
		if(null == node.left){
			return;
		}
		
		node.left.next = node.right;
		
		if(null != node.next)
			node.right.next = node.next.left;
		else
			node.right.next = null;
		
		connectAjacent(node.left);
		connectAjacent(node.right);
	}
}
