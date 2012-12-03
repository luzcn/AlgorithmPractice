/***
 * 4.5 Write an algorithm to find the ‘next’ node 
 * (i.e., in-order successor) of a given node in a binary search tree 
 * where each node has a link to its parent.
 */

package CareerCup.TreeGraph;

public class FindSuccessor
{

	public static Node findInOrderSuccessor(Node node)
	{
		if (node == null)
			return null;

		if (node.right != null)
			return leftMostNode(node.right);
		else
		{
			if (node.parent != null)
			{
				if (isLeftChild(node.parent, node)) // left node
					return node.parent;
				else
				{
					Node parentNode = node.parent;
					while (parentNode.parent != null
							&& !isLeftChild(parentNode.parent, parentNode))
					{
						parentNode = parentNode.parent;
					}
					return parentNode.parent;
				}
			}

		}
		return null;
	}

	private static Node leftMostNode(Node node)
	{
		Node leftChild = node;
		while (node.left != null)
			leftChild = node.left;
		return leftChild;
	}

	private static boolean isLeftChild(Node parent, Node child)
	{
		if (parent == null || child == null)
			return false;
		return (parent.left == child);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		FindSuccessor.Node root = new FindSuccessor.Node(8);

		FindSuccessor.Node n1 = new FindSuccessor.Node(4);
		FindSuccessor.Node n2 = new FindSuccessor.Node(10);
		FindSuccessor.Node n3 = new FindSuccessor.Node(2);
		FindSuccessor.Node n4 = new FindSuccessor.Node(6);
		FindSuccessor.Node n5 = new FindSuccessor.Node(9);
		FindSuccessor.Node n6 = new FindSuccessor.Node(11);
		FindSuccessor.Node n7 = new FindSuccessor.Node(1);
		FindSuccessor.Node n8 = new FindSuccessor.Node(3);
		FindSuccessor.Node n9 = new FindSuccessor.Node(5);
		FindSuccessor.Node n10 = new FindSuccessor.Node(7);
		FindSuccessor.Node n11 = new FindSuccessor.Node(12);

		root.add(n1, n2);
		n1.add(n3, n4);
		n2.add(n5, n6);
		n3.add(n7, n8);
		n4.add(n9, n10);
		n6.addRight(n11);

		FindSuccessor.Node node = FindSuccessor.findInOrderSuccessor(n6);
		if (node != null)
			System.out.println(node.key);
		else
			System.out.println("No successor");
	}

	/********************************************************/
	private static class Node
	{
		public int key;
		public Node left;
		public Node right;
		public Node parent;

		public Node()
		{
			this.left = null;
			this.right = null;
			this.parent = null;
			this.key = 0;
		}

		public Node(int key)
		{
			this();
			this.key = key;
		}

		public void addLeft(Node node)
		{
			this.left = node;
			node.parent = this;
		}

		public void addRight(Node node)
		{
			this.right = node;
			node.parent = this;
		}

		public void add(Node left, Node right)
		{
			this.left = left;
			this.right = right;
			left.parent = this;
			right.parent = this;
		}
	}
}
