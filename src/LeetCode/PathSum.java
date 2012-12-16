package LeetCode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22,
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ \ 7 2 1
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * @author Zheng
 * @date Oct 28, 2012
 * 
 */
public class PathSum
{
	private boolean hasPath = false;

	public boolean hasPathSum(TreeNode root, int sum)
	{
		hasPath = false;
		pathSumRec(root, new int[255], 0, sum);
		return hasPath;
	}

	/***
	 * Given a binary tree and a sum, determine if the tree has a root-to-anynode
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 * 
	 */
	private void pathSumRec(TreeNode root, int[] array, int index, int target)
	{
		if (root == null)
			return;

		array[index] = root.val;
		pathSumRec(root.left, array, index + 1, target);
		pathSumRec(root.right, array, index + 1, target);

		if (root.left == null && root.right == null)
		{
			if (computeSum(array, 0, index) == target)
				hasPath = true;
		}
	}
	private int computeSum(int[] a, int startindex, int endindex)
	{
		int sum = 0;
		for (int i = startindex; i <= endindex; i++)
			sum += a[i];

		return sum;
	}

	/***
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
	 * path such that adding up all the values along the path equals the given
	 * sum.
	 * 
	 */
	private boolean pathSumRootToLeafRec(TreeNode node, int target, int sum)
	{
		if (node == null)
			return false;

		if (node.left == null && node.right == null)
		{
			sum += node.val;
			if (sum == target)
				return true;
			else
				return false;
		}

		sum += node.val;
		return (pathSumRootToLeafRec(node.left, target, sum) || pathSumRootToLeafRec(
				node.right, target, sum));

	}
}

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x)
	{
		val = x;
	}
}