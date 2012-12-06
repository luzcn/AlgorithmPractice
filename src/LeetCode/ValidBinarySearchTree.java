package LeetCode;

import java.util.Stack;

/***
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * 
 * @author annie
 * 
 *         Dec 6, 2012
 */
public class ValidBinarySearchTree
{
	public boolean isValidBST(TreeNode root)
	{
		if (root == null)
			return true;

		TreeNode current = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode prev = null;

		boolean done = false;
		while (!done)
		{
			if (current != null)
			{
				s.push(current);
				current = current.left;
			}
			else if (!s.isEmpty())
			{
				current = s.pop();

				if (prev != null && prev.val >= current.val)
					return false;

				prev = current;
				current = current.right;
			}
			else
				done = true;
		}
		return true;
	}

	public static void main(String[] args)
	{

	}

}
