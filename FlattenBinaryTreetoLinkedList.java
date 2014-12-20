/*
Flatten Binary Tree to Linked List Total Accepted: 31675 Total Submissions: 112038 My Submissions Question Solution 
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
*/

package com.oj.practice;

public class FlattenBinaryTreetoLinkedList {

	/* Definition for binary tree */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public void flatten(TreeNode root) {
        if(null == root)
        	return;
        
        
		if(null != root.left) {
			
			findTheMostRight(root.left).right = root.right;
			root.right = root.left;
			root.left = null;
        }
		flatten(root.right);
    }
    
    public TreeNode findTheMostRight(TreeNode node){
    	
    	while(null!=node){
    		if(null==node.right){
    			return node;
    		}
    		else
    			node = node.right;
    	}
    	
    	return node;
    }
	
}
