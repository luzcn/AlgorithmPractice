package CareerCup.TreeGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 3 basic tree traversal iterative algorithm and morris traversal
 * 
 * @author annie
 * 
 * @date Jan 17, 2013
 */
public class BasicTreeTraversal
{

	public void preOrder(TreeNode root)
	{
		if (root == null)
			return;

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);

		while (!s.isEmpty())
		{
			TreeNode current = s.pop();
			if (current.right != null)
				s.push(current.right);
			if (current.left != null)
				s.push(current.left);

		}

	}

	public void inOrder(TreeNode root)
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
			}
			else if (!s.isEmpty())
			{
				current = s.pop();
				System.out.println(current.val);
				current = current.right;
			}
			else
				done = true;
		}
	}

	/**
	 * post order with two stacks
	 * 
	 * @param root
	 */
	public void postOrder(TreeNode root)
	{
		if (root == null)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();
		TreeNode current = null;

		s.push(root);
		while (!s.isEmpty())
		{
			current = s.pop();
			output.push(current);

			if (current.left != null)
				s.push(current.left);
			if (current.right != null)
				s.push(current.right);
		}

		while (!output.isEmpty())
			System.out.println(output.pop().val);
	}

	public void morrisTree(TreeNode root)
	{
		if (root == null)
			return;

		TreeNode current = root;
		TreeNode pre = null;
		while (current != null)
		{
			if (current.left == null)
			{
				System.out.println(current.val);
				current = current.right;
			}
			else
			{
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				if (pre.right == null)
				{
					pre.right = current;
					current = current.left;
				}
				else
				{
					pre.right = null;
					System.out.println(current.val);
					current = current.right;
				}
			}
		}
	}

	public void BFS(TreeNode root)
	{
		if (root == null)
			return;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);

		while (!que.isEmpty())
		{
			TreeNode current = que.poll();
			System.out.println(current.val);
			if (current.left != null)
				que.add(current.left);
			if (current.right != null)
				que.add(current.right);
		}
	}

	public static void main(String[] args)
	{

	}

}
