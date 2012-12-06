package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 * 1 / \ 2 2 / \ / \ 3 4 4 3
 * 
 * But the following is not:
 * 
 * 1 / \ 2 2 \ \ 3 3
 * 
 * Note: Bonus points if you could solve it both recursively and iteratively.
 * 
 * @author Zheng Lu
 * @date Nov 27, 2012
 * 
 */
public class SymmetricTree
{
	private boolean isSymmetricRec(TreeNode p, TreeNode q)
	{
		if (p == null && q == null)
			return true;
		if ((p != null && q == null) || (p == null && q != null))
			return false;
		return (p.val == q.val && isSymmetricRec(p.left, q.right) && isSymmetricRec(
				p.right, q.left));
	}

	public boolean isSymmetric(TreeNode root)
	{
		if (root == null)
			return true;
		
		//call recursive function
//		isSymmetricRec(root.left, root.right);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		inordernorec(root, list);

		int i = 0;
		int j = list.size() - 1;

		while (i < j)
		{
			if (list.get(i) != list.get(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	private void inorder(TreeNode root, ArrayList<Integer> list)
	{
		if (root == null)
			return;

		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);

	}

	private void inordernorec(TreeNode root, ArrayList<Integer> list)
	{
		if (root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		boolean done = false;
		TreeNode current = root;
		while (!done)
		{
			if (current != null)
			{
				s.push(current);
				current = current.left;
			} else if (!s.isEmpty())
			{
				current = s.pop();
				list.add(current.val);
				current = current.right;
			} else
				done = true;
		}
	}

	public static void main(String[] args)
	{

	}

}
