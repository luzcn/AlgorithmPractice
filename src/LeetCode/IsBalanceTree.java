package LeetCode;

import AlgorithmDataStructure.BinaryNode;

public class IsBalanceTree
{
	private static int MaxDepth(BinaryNode node)
	{
		if (node == null)
			return 0;
		return 1 + Math.max(MaxDepth(node.left), MaxDepth(node.right));
	}

	private static int MinDepth(BinaryNode node)
	{
		if (node == null)
			return 0;
		return 1 + Math.min(MinDepth(node.left), MinDepth(node.right));
	}

	/**
	 * For the purposes of this question, a balanced tree is defined to be a
	 * tree such that no two leaf nodes differ in distance from the root by more
	 * than one.
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBalancedTree(BinaryNode root)
	{
		if (root == null)
			return false;
		return (MaxDepth(root) - MinDepth(root) <= 1);
	}

	/***
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 * 
	 */
	public static boolean isBalancedTree2(BinaryNode root)
	{
		if (root == null)
			return false;
		return (Math.abs(height(root.left) - height(root.right)) <= 1
				&& isBalancedTree2(root.left) && isBalancedTree2(root.right));
	}
	private static int height(BinaryNode node)
	{
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public static void main(String[] args)
	{
	}

}
