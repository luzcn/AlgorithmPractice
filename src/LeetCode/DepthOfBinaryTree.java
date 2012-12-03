package LeetCode;


import AlgorithmDataStructure.BinaryNode;
/**
 * @author Zheng Lu
 * Sep 30, 2012
 *
 */
public class DepthOfBinaryTree
{
	/***
	 * recursive solution
	 * @param root
	 * @return
	 */
	public static int depth(BinaryNode root)
	{
		if (root == null) return 0;
		
		return 1+ Math.max(depth(root.left),depth(root.right));
	}
	
	/***
	 * non-recursive solution
	 * BFS the tree, when reach a new level, increase the height
	 * @param root
	 * @return
	 */
	public static int maxHeight(BinaryNode root)
	{
		return 0;
	}
	
	public static void main(String[] args)
	{
		
	}

}
