package LeetCode;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author Zheng Lu
 * @date Nov 12, 2012
 * 
 */
public class MinDepthBinaryTree
{

	private int minDepth;

	public int minDepth(TreeNode root)
	{
		// Start typing your Java solution below
		// DO NOT write main() function
		minDepth = Integer.MAX_VALUE;
		if (root == null)
			return 0;
		minDepthRec(root, 0);
		return minDepth;
	}

	private void minDepthRec(TreeNode root, int currentDepth)
	{
		if (root == null)
			return;
		if (root.left == null && root.right == null)
		{
			currentDepth++;
			if (currentDepth < minDepth)
				minDepth = currentDepth;

			return;
		}

		minDepthRec(root.left, currentDepth + 1);
		minDepthRec(root.right, currentDepth + 1);
	}
}
