package LeetCode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author annie
 * 
 * @date Dec 22, 2012
 */
public class MaximumDepthOfBinaryTree
{
	public int maxDepth(TreeNode root)
	{
		if (root == null)
			return 0;
		return maxDepthRec(root);
	}

	private int maxDepthRec(TreeNode node)
	{
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return 1 + Math.max(maxDepthRec(node.left), maxDepthRec(node.right));
	}
}
