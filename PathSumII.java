/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
package com.oj.practice;
import java.util.*;

import com.oj.practice.BalencedBinaryTree.TreeNode;

public class PathSumII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();
	List<Integer> listResult = new ArrayList<Integer>();
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
    	if(null == root){
        	return result;
        }
    	
    	list.add(root.val);
    	
    	if(root.left==null && root.right==null){
    		if(sum-root.val==0){
    			for(int i=0; i<list.size(); i++)
    				listResult.add(list.get(i));
    			
    			result.add(listResult);
    			//clear the listResult
        		listResult = new ArrayList<Integer>();
    		}
    	}
    	if(null != root.left){
    		pathSum(root.left, sum-root.val);
    		list.remove(list.size()-1);
    	}
    	if(null != root.right){
    		pathSum(root.right, sum-root.val);
    		list.remove(list.size()-1);
    	}
    	
    	return result;
    	
    }
    
    public static void main(String args[]){
		int[] root = {1,-2,-3,1,3,-2,0,-1};
		PathSumII ps = new PathSumII();
		TreeNode tree = BalencedBinaryTree.buildTree(root, 0);
		
		System.out.println(ps.pathSum(tree, -4));
		
    }
}
