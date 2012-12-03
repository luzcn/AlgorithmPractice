package CareerCup.TreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import AlgorithmDataStructure.BinaryNode;
import AlgorithmDataStructure.BinarySearchTree;

/**
 * @author Zheng Lu
 * @date Oct 22, 2012
 * 
 */
public class CreateLevelSiblingList
{

	public static ArrayList<ArrayList<BinaryNode>> createLeveSiblinglList(
			BinaryNode root)
	{
		ArrayList<ArrayList<BinaryNode>> resultList = new ArrayList<ArrayList<BinaryNode>>();
		ArrayList<BinaryNode> levelList = new ArrayList<BinaryNode>();
		
		if (root == null) return null;
		Queue<BinaryNode> que1 = new LinkedList<BinaryNode>();
		Queue<BinaryNode> que2 = new LinkedList<BinaryNode>();
		
		que1.add(root);
		
		while(!que1.isEmpty())
		{
			BinaryNode current = que1.poll();
			levelList.add(current);
			if (current.left != null) que2.add(current.left);
			if (current.right != null) que2.add(current.right);
			
			if (que1.isEmpty())
			{
				resultList.add(levelList);
				levelList = new ArrayList<BinaryNode>();
				
				que1 = que2;
				que2 = new LinkedList<BinaryNode>();
			}
		}
		
		return resultList;
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

		ArrayList<ArrayList<BinaryNode>> list = CreateLevelSiblingList
				.createLeveSiblinglList(bst.root);

		for (ArrayList<BinaryNode> l : list)
		{
			for (int i = 0; i < l.size(); i++)
				System.out.print(l.get(i).key + "    ");
			System.out.println();
		}

	}

}
