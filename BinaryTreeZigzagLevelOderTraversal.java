/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
*/
package com.oj.practice;

import java.util.*;

public class BinaryTreeZigzagLevelOderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        ArrayList<TreeNode> list =  new ArrayList<TreeNode>();
        
    	if(null == root){
    		return res;
    	}
    	
    	int count=0;
    	list.add(root);
    	
		while (!list.isEmpty()) {
			ArrayList<TreeNode> nextlist = new ArrayList<TreeNode>();
			ArrayList<Integer> intlist = new ArrayList<Integer>();
			TreeNode tn;

			for (int i = list.size() - 1; i >= 0; i--) {
				tn = list.get(i);
				intlist.add(tn.val);
				if (1 == count % 2) {
					if (null != tn.right)
						nextlist.add(tn.right);
					if (null != tn.left)
						nextlist.add(tn.left);
				} else {
					if (null != tn.left)
						nextlist.add(tn.left);
					if (null != tn.right)
						nextlist.add(tn.right);
				}
			}

			res.add(intlist);
			list = nextlist;
			count++;
    	}
       
    	return res;
       
    }
    
}









