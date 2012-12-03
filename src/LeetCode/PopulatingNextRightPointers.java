package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zheng Lu
 * @date Oct 29, 2012
 * 
 */
public class PopulatingNextRightPointers
{

	public void connect(TreeLinkNode root)
	{
		if (root == null)
			return;

		Queue<TreeLinkNode> que1 = new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> que2 = new LinkedList<TreeLinkNode>();
		que1.add(root);

		while (!que1.isEmpty())
		{
			TreeLinkNode current = que1.poll();
			current.next = que1.peek();

			if (current.left != null)
				que2.add(current.left);
			if (current.right != null)
				que2.add(current.right);

			if (que1.isEmpty())
			{
				que1 = que2;
				que2 = new LinkedList<TreeLinkNode>();
			}
		}
	}

	public static void main(String[] args)
	{

	}
}

class TreeLinkNode
{
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x)
	{
		val = x;
	}
}