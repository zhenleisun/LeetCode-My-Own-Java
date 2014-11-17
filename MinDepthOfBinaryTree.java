package com.oj.practice;

import com.oj.practice.BalencedBinaryTree.TreeNode;

public class MinDepthOfBinaryTree {
	
	
    public int minDepth(TreeNode root) {
    	int leftDepth=0;
    	int rightDepth =0;
    	
        if(root == null){
        	return 0;
        }
        else if(root.left==null && root.right==null){
        	return 1;
        }
        
        if(root.left==null || root.right==null){
        	leftDepth = minDepth(root.left);
        	rightDepth = minDepth(root.right);
        	
        	return leftDepth==0?(rightDepth+1):(leftDepth+1);
        }
        else{
        	leftDepth = minDepth(root.left);
        	rightDepth = minDepth(root.right);
        	return leftDepth<rightDepth?(leftDepth+1):(rightDepth+1);
        }
    }
}
