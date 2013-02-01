package AlgorithmDataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree
{
	public BinaryNode root;
	private BinaryNode prev;

	/**********************************************/
	public BinarySearchTree()
	{
		this.root = null;
	}

	public void insert(int key)
	{
		root = insert(root, key);
	}

	private BinaryNode insert(BinaryNode node, int key)
	{
		if (node == null)
			node = new BinaryNode(key);
		else if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);

		return node;
	}

	public boolean find(int key)
	{
		return find(key, root);
	}

	private boolean find(int key, BinaryNode node)
	{
		if (node == null)
			return false;
		else if (key < node.key)
			return find(key, node.left);
		else if (key == node.key)
			return true;
		else
			return find(key, node.right);
	}

	public int findMin()
	{
		return findMin(root);
	}

	private int findMin(BinaryNode node)
	{
		while (node.left != null)
			node = node.left;
		return node.key;
	}

	public void inOrder(BinaryNode node)
	{
		if (node == null)
			return;
		inOrder(node.left);
		System.out.println(node.key);
		inOrder(node.right);
	}

	public void preOrder(BinaryNode node)
	{
		if (node == null)
			return;
		System.out.println(node.key);
		preOrder(node.left);
		preOrder(node.right);
	}

	/**
	 * pre-order traverse the tree using a stack
	 * 
	 * @param node
	 */
	public void preOrderTreeWithStack(BinaryNode node)
	{
		if (node == null)
		{
			System.out.println("Not Valid");
			return;
		}
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		s.push(node);
		while (!s.isEmpty())
		{
			BinaryNode n = s.pop();
			System.out.println(n.key);
			if (n.right != null)
				s.push(n.right);
			if (n.left != null)
				s.push(n.left);
		}
	}

	public void inOrderTreeWithStack(BinaryNode node)
	{
		if (node == null)
		{
			System.out.println("Not Valid");
			return;
		}
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		// Stack<BinaryNode> inorderStack = new Stack<BinaryNode>();
		BinaryNode current = node;
		// s.push(node);
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
				System.out.println(current.key);
				current = current.right;
			}
			else
				done = true;
		}
	}

	/**
	 * Function to traverse binary tree without recursion and without stack
	 * 
	 * 1. Initialize current as root 
	 * 2. While current is not NULL 
	 * If current does not have left child 
	 * 		a) Print current's data 
	 * 		b) Go to the right, i.e., current = current->right 
	 * Else 
	 * 		a) Find the rightmost node in current's left subtree save as "pre"
	 * 		b) Make current as right child of "pre"
	 * 		c) Go to this left child, i.e., current = current->left
	 * 
	 * @param node
	 */
	public void morrisTreeTraversal(BinaryNode root)
	{
		if (root == null)
		{
			System.out.println("Not Valid");
			return;
		}
		BinaryNode current = root;
		BinaryNode pre = null;
		while(current != null)
		{
			if (current.left == null)
			{
				System.out.println(current.key);
				current = current.right;
			}
			else
			{
				/* Find the inorder predecessor of current */
			      pre = current.left;
			      while(pre.right != null && pre.right != current)
			    	  pre = pre.right;
			      
			      /* Make current as right child of its inorder predecessor */
			      if (pre.right == null)
			      {
			    	  pre.right = current;
			    	  current = current.left;
			      }
			      /*Revert the changes made in if part to restore the original
			        tree i.e., fix the right child of predecssor*/
			      else
			      {
			    	  pre.right = null;
			    	  System.out.println(current.key);
			    	  current = current.right;
			      }
			}
		}
	}

	/**
	 * breadth first search in a Tree data structure by using queue
	 * 
	 * @param node
	 */
	public void BFS(BinaryNode node)
	{
		if (node == null)
		{
			System.out.println("Not Valid");
			return;
		}
		Queue<BinaryNode> que = new LinkedList<BinaryNode>();
		que.add(node);
		while (!que.isEmpty())
		{
			BinaryNode currentNode = que.poll();
			System.out.println(currentNode.key);
			if (currentNode.left != null)
				que.add(currentNode.left);
			if (currentNode.right != null)
				que.add(currentNode.right);
		}
	}

	public void printAllPath(BinaryNode node)
	{
		if (node == null)
		{
			System.out.println("Not Valid");
			return;
		}
		int[] A = new int[2 << 9];

		printPath(node, A, 0);
	}

	/**
	 * print all the path from root to leaf
	 * 
	 * @param node
	 * @param a
	 * @param i
	 */
	private void printPath(BinaryNode node, int[] a, int i)
	{
		if (node == null)
			return;
		a[i] = node.key;
		printPath(node.left, a, i + 1);

		// remove the if statement, if need to print out
		// all the path including the inner nodes.
		// if (node.left == null && node.right == null)
		printArray(a, 0, i);

		printPath(node.right, a, i + 1);

	}

	private void printArray(int[] a, int startindex, int endindex)
	{
		for (int i = startindex; i <= endindex; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	/**
	 * CareerCup 24.7 You are given a binary tree in which each node contains a
	 * value. Design an algorithm which prints all paths which sum up to that
	 * value. Note that it can be any path in the tree - it does not have to
	 * start at the root.
	 * 
	 * @param node
	 *            : The tree root
	 * @param value
	 *            : The given sumup value
	 */
	public void findSum(BinaryNode node, int value)
	{
		if (node == null)
		{
			System.out.println("Not Valid");
			return;
		}

		int[] A = new int[2 << 9];
		findSum(node, A, 0, value);
	}

	private void findSum(BinaryNode node, int[] a, int i, int value)
	{
		if (node == null)
			return;

		a[i] = node.key;
		findSum(node.left, a, i + 1, value);
		findSum(node.right, a, i + 1, value);

		// compute the sum
		int sum = 0;
		for (int j = i; j >= 0; j--)
		{
			sum += a[j];
			if (sum == value)
				printArray(a, j, i);
		}
	}

	private int max(int a, int b)
	{
		return (a >= b) ? a : b;
	}

	public int computeHeight(BinaryNode node)
	{
		if (node == null)
			return 0;
		// if (node.left == null && node.right == null) return 1;
		return 1 + max(computeHeight(node.left), computeHeight(node.right));
	}

	public boolean isBST(BinaryNode node)
	{
		if (node != null)
		{
			isBST(node.left);
			if (prev != null && prev.key >= node.key)
				return false;
			prev = node;
			isBST(node.right);
		}
		return true;
	}

	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(4);
		bst.insert(2);
		bst.insert(5);

		// bst.insert(5);
		bst.insert(7);
		// bst.insert(4);
		// bst.insert(2);
		// bst.insert(3);
		bst.insert(1);
		// bst.insert(8);
		// bst.insert(6);
		// bst.insert(9);
		// bst.insert(10);

		// System.out.println(bst.computeHeight(bst.root));
		// bst.BFS(bst.root);
		// bst.inOrder(bst.root);
//		bst.inOrderTreeWithStack(bst.root);
		bst.morrisTreeTraversal(bst.root);
		// bst.printAllPath(bst.root);
		// bst.findSum(bst.root, 9);

		// bst.BFSTreeWithStack(bst.root);
		// bst.preOrder(bst.root);

	}
}
