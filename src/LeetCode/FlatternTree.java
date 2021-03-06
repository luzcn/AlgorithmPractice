package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/***
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, Given
 * 
 * 1 / \ 2 5 / \ \ 3 4 6 The flattened tree should look like: 1 \ 2 \ 3 \ 4 \ 5
 * \ 6
 * 
 * Hints: If you notice carefully in the flattened tree, each node's right child
 * points to the next node of a pre-order traversal.
 * 
 * @author annie
 * 
 * @date Dec 17, 2012
 */
public class FlatternTree
{
	public void flattern(TreeNode root)
	{
		if (root == null)
			return;

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode pre = null;
		TreeNode current = null;

		s.push(root);
		while (!s.isEmpty())
		{
			pre = s.pop();
			if (pre.right != null)
				s.push(pre.right);
			if (pre.left != null)
				s.push(pre.left);

			pre.left = null;
			pre.right = null;

			if (pre == root)
				current = pre;
			else
				current.right = pre;
		}
	}

	/**
	 * with extra space
	 * 
	 * @param root
	 */
	public void flatternWithList(TreeNode root)
	{
		if (root == null)
			return;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		preOrder(root, list);

		for (int i = 0; i < list.size() - 1; i++)
		{
			list.get(i).left = null;
			list.get(i).right = list.get(i + 1);
		}
	}

	private void preOrder(TreeNode root, ArrayList<TreeNode> list)
	{
		if (root == null)
			return;

		list.add(root);
		preOrder(root.left, list);
		preOrder(root.right, list);
	}

	public static void main(String[] args)
	{

	}

}
