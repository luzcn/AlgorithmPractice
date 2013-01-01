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

	/**
	 * connect function for complete binary tree
	 * 
	 * @param root
	 */
	public void connectPerfectTree(TreeLinkNode root)
	{
		if (root == null)
			return;

		if (root.left == null || root.right == null)
			return;

		root.left.next = root.right;
		root.right.next = (root.next != null) ? root.next.left : null;
		connectPerfectTree(root.left);
		connectPerfectTree(root.right);

	}

	public void connectAnyTreeNonRec(TreeLinkNode root)
	{
		if (root == null)
			return;

		TreeLinkNode head = root;
		while (head != null)
		{
			TreeLinkNode p = head;
			while (p != null)
			{
				TreeLinkNode rightSibling = getNextRight(p);
				if (p.left != null)
				{
					if (p.right != null)
					{
						p.left.next = p.right;
						p.right.next = rightSibling;
					}
					else
						p.left.next = rightSibling;
				}
				else if (p.right != null)
					p.right.next = rightSibling;

				p = p.next;
			}

			if (head.left != null)
				head = head.left;
			else if (head.right != null)
				head = head.right;
			else
				head = getNextRight(head);
		}
	}

	/**
	 * recursive function for any binary tree
	 * 
	 * @param p
	 */
	public void connectAnyTree(TreeLinkNode root)
	{
		root.next = null;
		connectRec(root);
	}

	private void connectRec(TreeLinkNode p)
	{
		if (p == null)
			return;
		if (p.next != null)
			connectRec(p.next);

		if (p.left != null)
		{
			if (p.right != null)
			{
				p.left.next = p.right;
				p.right.next = getNextRight(p);
			}
			else
				p.left.next = getNextRight(p);

			connectRec(p.left);
		}
		else if (p.right != null)
		{
			p.right.next = getNextRight(p);
			connectRec(p.right);
		}
		else
			connectRec(getNextRight(p));
	}

	private TreeLinkNode getNextRight(TreeLinkNode p)
	{
		TreeLinkNode temp = p.next;
		while (temp != null)
		{
			if (temp.left != null)
				return temp.left;
			else if (temp.right != null)
				return temp.right;

			temp = temp.next;
		}
		return null;
	}

	/**
	 * need extra space
	 * 
	 * @param root
	 */
	private void connectBFS(TreeLinkNode root)
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