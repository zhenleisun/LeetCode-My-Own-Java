/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

package com.oj.practice;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	

    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	ArrayList<TreeNode> level = new ArrayList<TreeNode>();
    	
        if(null == root)
        	return res;
        
        level.add(root);
        
        while(!level.isEmpty()){
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	ArrayList<TreeNode> nextLvl = new ArrayList<TreeNode>();
        	
        	for(TreeNode tn:level){
        		list.add(tn.val);
        		if(tn.left!=null)
        			nextLvl.add(tn.left);
        		if(tn.right!=null)
        			nextLvl.add(tn.right);
        	}
        	res.add(list);
        	
        	level = nextLvl;
        }
        
        return res;
	}
}
