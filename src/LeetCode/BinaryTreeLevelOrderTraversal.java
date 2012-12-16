package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 * return its level order traversal as: [ [3], [9,20], [15,7] ]
 * 
 * @author annie
 * 
 * @date Dec 15, 2012
 */
public class BinaryTreeLevelOrderTraversal
{

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.add(root);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!q1.isEmpty())
		{
			TreeNode current = q1.poll();
			if (current.left != null)
				q2.add(current.left);
			if (current.right != null)
				q2.add(current.right);

			list.add(current.val);
			if (q1.isEmpty())
			{
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
				result.add(new ArrayList<Integer>(list));
				list = new ArrayList<Integer>();
			}
		}
		return result;
	}

	/***
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();

		q1.add(root);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!q1.isEmpty())
		{
			TreeNode current = q1.poll();
			if (current.left != null)
				q2.add(current.left);
			if (current.right != null)
				q2.add(current.right);

			list.add(current.val);
			if (q1.isEmpty())
			{
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
				stack.push(new ArrayList<Integer>(list));
				list = new ArrayList<Integer>();
			}
		}
		while (!stack.isEmpty())
		{
			result.add(stack.pop());
		}
		return result;
	}

	/***
	 * Given a binary tree, return the zigzag level order traversal of its
	 * nodes' values. (ie, from left to right, then right to left for the next
	 * level and alternate between).
	 * 
	 * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7
	 * return its zigzag level order traversal as: [ [3], [20,9], [15,7] ]
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		// bfs
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.add(root);
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (!q1.isEmpty())
		{
			TreeNode current = q1.poll();

			if (current.left != null)
				q2.add(current.left);
			if (current.right != null)
				q2.add(current.right);

			list.add(current.val);

			if (q1.isEmpty())
			{
				if (count % 2 == 0)
					result.add(new ArrayList<Integer>(list));
				else
				{
					Collections.reverse(list);
					result.add(new ArrayList<Integer>(list));
				}
				list = new ArrayList<Integer>();
				q1 = q2;
				q2 = new LinkedList<TreeNode>();
				count++;
			}
		}
		return result;
	}

	public static void main(String[] args)
	{

	}

}
