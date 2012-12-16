package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree,
 * 
 * 1 / \ 2 3 Return 6.
 * 
 * @author annie
 * 
 * @date Dec 15, 2012
 */
public class BinaryTreeMaximunPathSum
{
	int maxSum = -999;

	public int maxPathSum(TreeNode root)
	{
		if (root == null)
			return 0;

//		int leftMax = maxPathSumRec(root.left, 0);
//		int rightMax = maxPathSumRec(root.right, 0);
//
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(leftMax);
//		list.add(rightMax);
//		list.add(leftMax + root.val);
//		list.add(rightMax + root.val);
//		list.add(leftMax + root.val + rightMax);
//		list.add(root.val);
//		
//		System.out.println(list);
		return maxPathSumRec(root, 0);//Collections.max(list);
		
	}

	private int maxPathSumRec(TreeNode node, int sum)
	{
		if (node == null)
		{
			return maxSum;
		}

		sum += node.val;
		if (sum > maxSum)
			maxSum = sum;
		
		int leftMax = maxPathSumRec(node.left, 0);
		int rightMax = maxPathSumRec(node.right, 0);

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(leftMax);
		list.add(rightMax);
		list.add(leftMax + node.val);
		list.add(rightMax + node.val);
		list.add(leftMax + node.val + rightMax);
		list.add(node.val);
	

		return Collections.max(list);
	}

	public static void main(String[] args)
	{
		TreeNode n1 = new TreeNode(-2);
		TreeNode n2 = new TreeNode(-1);
		TreeNode n3 = new TreeNode(-3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		//n1.left = n2;
		n1.right = n3;
		//n3.left = n5;
		//n3.right = n4;

		BinaryTreeMaximunPathSum btm = new BinaryTreeMaximunPathSum();

		System.out.println(btm.maxPathSum(n1));
	}

}
