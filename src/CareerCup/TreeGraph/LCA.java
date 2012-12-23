package CareerCup.TreeGraph;

import AlgorithmDataStructure.BinaryNode;
import AlgorithmDataStructure.BinarySearchTree;

/***
 * Lowest common ancestor Given the values of two nodes in a binary search tree,
 * write a program to find the lowest common ancestor
 * 
 * The main idea of the solution is : While traversing Binary Search Tree from
 * top to bottom, the first node n we encounter with value between n1 and n2,
 * i.e., n1 < n < n2 is the Lowest or Least Common Ancestor(LCA) of n1 and n2
 * (where n1 < n2).
 * 
 * So just traverse the BST in pre-order, if you find a node with value in
 * between n1 and n2 then n is the LCA, if it's value is greater than both n1
 * and n2 then our LCA lies on left children of the node, if it's value is
 * smaller than both n1 and n2 then LCA lies on right children.
 * 
 * @author Zheng Lu
 * 
 */
public class LCA
{

	public BinaryNode leastCommonAncestor(BinaryNode root, int n1, int n2)
	{
		/***
		 * if it is a leaf node then LCA doesn't exist
		 */
		if (root == null || root.key == n1 || root.key == n2)
			return null;
		/**
		 * If any of the input nodes is child of the current node we have
		 * reached the LCA
		 */
		if (root.right != null && (root.right.key == n1)
				|| root.right.key == n2)
			return root;
		if (root.left != null && (root.left.key == n1 || root.left.key == n2))
			return root;

		if (root.key > n1 && root.key < n2)
			return root;
		if (root.key > n1 && root.key > n2)
			return leastCommonAncestor(root.left, n1, n2);
		if (root.key < n1 && root.key < n2)
			return leastCommonAncestor(root.right, n1, n2);

		return null;
	}

	/****
	 * 1. Top down solution We traverse the nodes from the top to the bottom: 1.
	 * If the current node is one of the two nodes, it must be the LCA of the
	 * two nodes. 2. If not, we count the number of nodes that matches either p
	 * or q in the left subtree. If totalMatches equals 1, then we know the
	 * right subtree will contain the other node. Therefore, the current node
	 * must be the LCA. 3. If totalMatches equals 2, we know that both nodes are
	 * contained in the left subtree, so we traverse to its left child. Similar
	 * with the case where totalMatches equals 0 where we traverse to its right
	 * child
	 * 
	 * @param node
	 * @param n1
	 * @param n2
	 * @return
	 */
	public BinaryNode LCA_BT(BinaryNode node, int n1, int n2)
	{
		if (node == null)
			return null;
		if (node.key == n1 || node.key == n2)
			return node;

		int matches = this.totalCount(node.left, n1, n2);
		if (matches == 1)
			return node;
		else if (matches == 2)
			return LCA_BT(node.left, n1, n2);
		else
			return LCA_BT(node.right, n1, n2);
	}

	private int totalCount(BinaryNode currentNode, int n1, int n2)
	{
		if (currentNode == null)
			return 0;
		int count = totalCount(currentNode.left, n1, n2)
				+ totalCount(currentNode.right, n1, n2);

		if (currentNode.key == n1 || currentNode.key == n2)
			return count + 1;
		else
			return count;
	}

	/****
	 * 2. Bottom-Up solution we traverse from the bottom, and once we reach a
	 * node which matches one of the two nodes, we pass it up to its parent. The
	 * parent would then test its left and right subtree if each contain one of
	 * the two nodes.
	 * 
	 * If yes, then the parent must be the LCA and we pass its parent up to the
	 * root. If not, we pass the lower node which contains either one of the two
	 * nodes (if the left or right subtree contains either p or q), or NULL (if
	 * both the left and right subtree does not contain either p or q) up.
	 * 
	 * @param currentNode
	 * @param n1
	 * @param n2
	 * @return
	 */
	public BinaryNode LCA_BottomUp(BinaryNode currentNode, int n1, int n2)
	{
		if (currentNode == null)
			return null;
		if (currentNode.key == n1 || currentNode.key == n2)
			return currentNode;
		
		BinaryNode L = LCA_BottomUp(currentNode.left, n1, n2);
		BinaryNode R = LCA_BottomUp(currentNode.right, n1, n2);

		if (L != null && R != null)
			return currentNode;
		else if (L != null)
			return L;
		else
			return R;
	}

	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(8);
		bst.insert(22);
		bst.insert(4);
		bst.insert(12);
		bst.insert(10);
		bst.insert(14);

		LCA lca = new LCA();
		BinaryNode node = lca.leastCommonAncestor(bst.root, 4, 8);

		System.out.println(node.key);
		// bst.inOrder(bst.root);
		// bst.preOrder(bst.root);
	}

}
