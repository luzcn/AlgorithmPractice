/***
 * 4.4 Given a binary search tree, design an algorithm which creates a linked list of all 
 * the nodes at each depth (i.e., if you have a tree with depth D, you’ll have D linked lists).
 */
package CareerCup.TreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import AlgorithmDataStructure.BinaryNode;
import AlgorithmDataStructure.BinarySearchTree;

public class CreateLevelListInBST
{

	public static ArrayList<ArrayList<BinaryNode>> createLevelList(
			BinaryNode root)
	{
		ArrayList<ArrayList<BinaryNode>> levelList = new ArrayList<ArrayList<BinaryNode>>();

		// perform a BFS on the tree
		Queue<BinaryNode> que = new LinkedList<BinaryNode>();
		que.add(root);
		ArrayList<BinaryNode> nodeList = new ArrayList<BinaryNode>();
		while (!que.isEmpty())
		{
			BinaryNode currentNode = que.poll();
			if (currentNode.left != null)
				que.add(currentNode.left);
			if (currentNode.right != null)
				que.add(currentNode.right);

			if (nodeList.isEmpty())
				nodeList.add(currentNode);
			else
			{
				BinaryNode prevNode = nodeList.get(nodeList.size() - 1);
				if (currentNode.key < prevNode.key) // a new level
				{
					levelList.add(nodeList);
					nodeList = new ArrayList<BinaryNode>();
					nodeList.add(currentNode);
				} else
				{
					/**
					 * The currentNode can be the right sibling of prevNode or
					 * the right child of the prevNode
					 **/
					if (prevNode.right != currentNode)
						nodeList.add(currentNode);
					else
					{
						levelList.add(nodeList);
						nodeList = new ArrayList<BinaryNode>();
						nodeList.add(currentNode);
					}
				}
			}
		}
		levelList.add(nodeList);
		return levelList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(7);
		bst.insert(4);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(8);
		bst.insert(6);
		bst.insert(9);
		bst.insert(10);
		bst.insert(13);

		ArrayList<ArrayList<BinaryNode>> list = CreateLevelListInBST
				.createLevelList(bst.root);

		for (ArrayList<BinaryNode> l : list)
		{
			for (int i = 0; i < l.size(); i++)
				System.out.print(l.get(i).key + "    ");
			System.out.println();
		}
	}

}
