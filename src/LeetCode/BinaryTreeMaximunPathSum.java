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
	private int maxValue;
	public int maxPathSum(TreeNode root)
	{
		if (root == null)
			return 0;
		maxValue = root.val;

		int leftSum = maxSubPathSum(root.left);
		int rightSum = maxSubPathSum(root.right);

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(maxValue);
		list.add(root.val + leftSum);
		list.add(root.val + rightSum);
		list.add(root.val + leftSum + rightSum);

		return Collections.max(list);
	}

	private int maxSubPathSum(TreeNode node)
	{
		if (node == null)
			return 0;

		int leftSum = maxSubPathSum(node.left);
		int rightSum = maxSubPathSum(node.right);

		int maxSinglePathSum = Math.max(node.val,
				Math.max(node.val + leftSum, node.val + rightSum));

		maxValue = Math.max(Math.max(maxValue, maxSinglePathSum), node.val + leftSum
				+ rightSum);

		return maxSinglePathSum;
	}

	public static void main(String[] args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);

		n1.left = n2;
		n1.right = n3;

		BinaryTreeMaximunPathSum btm = new BinaryTreeMaximunPathSum();

		System.out.println(btm.maxPathSum(n1));
	}

}
