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
	private TreeNode prev = null;
	private TreeNode prevRev = null;
	private TreeNode first;
	private TreeNode second;

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

	public void recoverTree2(TreeNode root)
	{
		prev = null;
		prevRev = null;
		first = null;
		second = null;

		if (root == null)
			return;

		inOrder(root);
		inOrderReverse(root);

		if (first != null && second != null)
		{
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}

		System.out.println(prev.val);
		System.out.println(prevRev.val);
	}

	private void inOrder(TreeNode node)
	{
		if (node == null)
			return;

		inOrder(node.left);
		if (prev != null && prev.val >= node.val)
		{
			first = prev;
			return;
		}
		prev = node;

		inOrder(node.right);
	}

	private void inOrderReverse(TreeNode node)
	{
		if (node == null)
			return;

		inOrderReverse(node.right);
		if (prevRev != null && prevRev.val <= node.val)
		{
			second = prevRev;
			return;
		}
		prevRev = node;

		inOrderReverse(node.left);
	}

	public static void main(String[] args)
	{

	}

}
