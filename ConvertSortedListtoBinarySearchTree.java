/*
Convert Sorted List to Binary Search Tree Total Accepted: 26862 Total Submissions: 98012 My Submissions Question Solution 
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

package com.oj.practice;

import java.util.LinkedList;

public class ConvertSortedListtoBinarySearchTree {
	/* Definition for singly-linked list. */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/* Definition for binary tree */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private ListNode cur;

	public TreeNode sortedListToBST(ListNode head) {
		cur = head;
		return generate(count(head));
	}

	private TreeNode generate(int n) {
		if (0 == n)
			return null;
		TreeNode node = new TreeNode(0);
		node.left = generate(n / 2);
		node.val = cur.val;
		cur = cur.next;
		node.right = generate(n - n / 2 - 1);
		return node;
	}

	private int count(ListNode h) {
		int size = 0;
		while (h != null) {
			++size;
			h = h.next;
		}
		return size;
	}

	public static void main(String args[]) {
		ConvertSortedListtoBinarySearchTree c = new ConvertSortedListtoBinarySearchTree();

		ListNode head = new ListNode(0);
		ListNode root = new ListNode(1), tmp;
		head.next = root;

		for (int i = 2; i < 8; i++) {
			tmp = new ListNode(i);
			root.next = tmp;
			root = root.next;
		}

		root = head;
		while (null != root) {
			System.out.print(root.val + "::");
			root = root.next;
		}
		System.out.println();

		TreeNode rt = c.sortedListToBST(head);
		int lvl = 0;

		LinkedList<TreeNode> ls = new LinkedList<TreeNode>();
		ls.add(rt);
		while (!ls.isEmpty()) {
			rt = ls.remove();
			System.out.println(lvl + ":" + rt.val);
			if (null != rt.left)
				ls.add(rt.left);
			if (null != rt.right)
				ls.add(rt.right);
			lvl++;
		}

	}
}
