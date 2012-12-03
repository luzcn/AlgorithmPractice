package LeetCode;

import java.util.ArrayList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure. Note: A solution using O(n)
 * space is pretty straight forward. Could you devise a constant space solution?
 * 
 * @author Zheng Lu
 * @date Oct 29, 2012
 * 
 */
public class RecoverBinarySearchTree
{
	ArrayList<TreeNode> list = new ArrayList<TreeNode>();

	public void recoverTree(TreeNode root)
	{
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;

		list = new ArrayList<TreeNode>();
		inordertree(root);

		TreeNode n1 = null;
		TreeNode n2 = null;

		for (int i = 0; i < list.size() - 1; i++)
		{
			if (list.get(i).val > list.get(i + 1).val)
			{
				n1 = list.get(i);
				break;
			}
		}

		for (int i = list.size() - 1; i > 0; i--)
		{
			if (list.get(i).val < list.get(i - 1).val)
			{
				n2 = list.get(i);
				break;
			}
		}

		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
	}

	private void inordertree(TreeNode root)
	{
		if (root == null)
			return;

		inordertree(root.left);
		this.list.add(root);
		inordertree(root.right);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
