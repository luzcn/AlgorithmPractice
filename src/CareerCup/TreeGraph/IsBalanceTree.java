package CareerCup.TreeGraph;

import AlgorithmDataStructure.BinaryNode;

public class IsBalanceTree
{
	private static int MaxDepth(BinaryNode node)
	{
		if (node == null) return 0;
		return 1+Math.max(MaxDepth(node.left), MaxDepth(node.right));
	}
	private static int MinDepth(BinaryNode node)
	{
		if (node == null) return 0;
		return 1+Math.min(MinDepth(node.left), MinDepth(node.right));
	}
	
	public static boolean isBalancedTree(BinaryNode root)
	{
		if (root == null) return false;
		return (MaxDepth(root)-MinDepth(root)<=1);
	}
	
	public static void main(String[] args)
	{	
	}

}
