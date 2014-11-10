package com.oj.practice;

public class SymmetricTree {

	public class TreeNode{
		int val;
		
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}
		
	}
	
	public boolean isSymmetric(TreeNode root){
		if(null == root){
			return true;
		}

		return compareTreeNode(root.left, root.right);
		
	}
	
	public boolean compareTreeNode(TreeNode leftNode, TreeNode rightNode){
		if(((null == leftNode) && (null != rightNode)) ||
				((null != leftNode) && (null == rightNode))){
			return false;
			
		}
		else if ((null == leftNode) && (null == rightNode)){
			return true;
		}
		else if(leftNode.val != rightNode.val){
			return false;
		}
		else{
			return compareTreeNode(leftNode.left, rightNode.right) &&
					compareTreeNode(leftNode.right, rightNode.left);
		}
		
	}
	
	public TreeNode buildTree(int[] dataIn, int index){
		
		TreeNode node = new TreeNode(dataIn[index]);
		
		if ((2*index+1) < dataIn.length){
			node.left = buildTree(dataIn, 2*index+1);
		}
		if((2*index+2)< dataIn.length){
			node.right = buildTree(dataIn,2*index+2);
		}
		
		return node;
	}
	
	public static void main(String args[]){
		SymmetricTree st = new SymmetricTree();
		int[] root = {1,2,2,0,3,0,3};
		
		System.out.println("root is "+st.isSymmetric(st.buildTree(root, 0)));
		
	}
}
