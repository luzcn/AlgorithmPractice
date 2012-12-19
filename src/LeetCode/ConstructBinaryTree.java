package LeetCode;

import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * @author annie
 * 
 * @date Dec 17, 2012
 */

public class ConstructBinaryTree
{
	HashMap<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();

	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		mapIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
			mapIndex.put(inorder[i], i);

		// return buildTreeRec(preorder, inorder, 0, inorder.length, 0);
		return buildTreeRec(preorder, inorder, 0, inorder.length, 0);
	}

	private TreeNode buildTreeRec(int[] pre, int[] in, int preIndex, int size,
			int offset)
	{
		if (size == 0)
			return null;

		int value = pre[preIndex];
		int rootPos = mapIndex.get(value) - offset;

		TreeNode root = new TreeNode(value);

		root.left = buildTreeRec(pre, in, preIndex + 1, rootPos, offset);
		root.right = buildTreeRec(pre, in, preIndex + rootPos + 1, size
				- rootPos - 1, offset + rootPos + 1);

		return root;
	}

	// private TreeNode buildTreePostRec(int[] post, int[] in, int size, int
	// offset)
	// {
	// if (size == 0)
	// return null;
	//
	// int value = post[size - 1];
	// int rootPos = mapIndex.get(value) - offset;
	//
	// TreeNode root = new TreeNode(value);
	//
	// root.left = buildTreePostRec(post, in, rootPos, offset);
	// root.right = buildTreePostRec(post, in, size - rootPos - 1, offset
	// + rootPos + 1);
	//
	// return root;
	// }

	private void inorder(TreeNode root)
	{
		if (root == null)
			return;

		inorder(root.left);

		System.out.println(root.val);

		inorder(root.right);
	}

	public static void main(String[] args)
	{
		int[] inorder = { 4, 10, 3, 1, 7, 11, 8, 2 };
		int[] preorder = { 7, 10, 4, 3, 1, 2, 8, 11 };
		int[] postorder = { 11, 8, 2, 1, 3, 4, 10, 7 };

		ConstructBinaryTree cb = new ConstructBinaryTree();

		TreeNode t = cb.buildTree(preorder, inorder);
		cb.inorder(t);
	}

}
