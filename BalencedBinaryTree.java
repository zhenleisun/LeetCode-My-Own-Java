package com.oj.practice;

import com.oj.practice.SymmetricTree.TreeNode;

public class BalencedBinaryTree {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}
	}
	public static class Solution {
		
		public boolean isBalanced = true;
		
	    public boolean isBalanced(TreeNode root) {
	    	
	    	countTreeDepth(root);
	    	
        	return isBalanced;
	    }
	    public int countTreeDepth(TreeNode root){
	    	int depthL=0, depthR=0;
	    	
	    	if(null == root){
	    		return 0;
	    	}
	    	depthL = countTreeDepth(root.left);
	        depthR = countTreeDepth(root.right);
	        
	        if(Math.abs(depthL-depthR)>=2){
	        	isBalanced = false;
	        }
	        
	        return (Math.max(depthL,depthR)+1);
	    }
	}
	
	public static TreeNode buildTree(int[] dataIn, int index){
		if(dataIn[index]!=0){

			TreeNode node = new TreeNode(dataIn[index]);
			
			if ((2*index+1) < dataIn.length){
				node.left = buildTree(dataIn, 2*index+1);
			}
			if((2*index+2)< dataIn.length){
				node.right = buildTree(dataIn,2*index+2);
			}
			
			return node;
		
		}
		else
			return null;
	}
	
	public static void main(String[] args){
		int[] root = {1,2,2,4,3,0,0,5};
		
		Solution ss = new Solution();
		TreeNode tree = buildTree(root, 0);
		
		System.out.println("depth:"+ss.countTreeDepth(tree.left)+"Balanced Result is "+ss.isBalanced(tree));

	}
	
}
