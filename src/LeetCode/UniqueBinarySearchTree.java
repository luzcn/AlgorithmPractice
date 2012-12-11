package LeetCode;

import java.util.ArrayList;
/***
 * 
 * @author annie
 * 
 *         Dec 11, 2012
 */
public class UniqueBinarySearchTree
{
	/**
	 * Given n, how many structurally unique BST's (binary search trees) that
	 * store values 1...n?
	 * 
	 * For example, Given n = 3, there are a total of 5 unique BST's.
	 * 1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	 * 
	 */
	public int numTrees(int n)
	{
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int num = 0;

		for (int i = 1; i <= n; i++)
		{
			num += numTrees(i - 1) * numTrees(n - i);
		}
		return num;
	}

	/***
	 * Given n, generate all structurally unique BST's (binary search trees)
	 * that store values 1...n.
	 * 
	 */
	public ArrayList<TreeNode> generateTrees(int n) 
	{
		return generateTreesRec(1,n);
	}
	private ArrayList<TreeNode> generateTreesRec(int left, int right)
	{
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (left > right)
		{
			result.add(null);
			return result;
		}
		else
		{
			ArrayList<TreeNode> leftChildren = null;
			ArrayList<TreeNode> rightChildren = null;
			
			for (int i = left;i<=right;i++)
			{
				leftChildren = generateTreesRec(left, i - 1);
				rightChildren = generateTreesRec(i + 1, right);
				
				for (TreeNode leftitem : leftChildren)
				{
					for (TreeNode rightitem: rightChildren)
					{
						TreeNode root = new TreeNode(i);
						root.left = leftitem;
						root.right = rightitem;
						result.add(root);
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
