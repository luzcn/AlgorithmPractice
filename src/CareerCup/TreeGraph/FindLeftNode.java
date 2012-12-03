package CareerCup.TreeGraph;

import java.util.LinkedList;
import java.util.Queue;

import AlgorithmDataStructure.TreeNode;


public class FindLeftNode
{

	public TreeNode<Integer> findLeftNode(TreeNode<Integer> tree, int target)
	{
		if (tree == null)
			return null;
		
		Queue<TreeNode<Integer>> que = new LinkedList<TreeNode<Integer>>();
		que.add(tree);
		Queue<TreeNode<Integer>> leftNodeQue = new LinkedList<TreeNode<Integer>>();
		TreeNode<Integer> left = null;
		
		while(!que.isEmpty())
		{
			/** BFS **/
			TreeNode<Integer> currentNode = que.poll();
			if (currentNode.left != null) que.add(currentNode.left);
			if (currentNode.right != null) que.add(currentNode.right);
			
			if (!leftNodeQue.isEmpty() && leftNodeQue.contains(currentNode.parent))
			{
				leftNodeQue.clear();
				left = null;
			}
			
			if (currentNode.key == target)
				return left;//leftNodeQue.poll();
			else
			{
				left = currentNode;
				leftNodeQue.add(currentNode);
			}
		}
		
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeNode<Integer> tree = new TreeNode<Integer>(5);
		
		TreeNode<Integer> n1 = new TreeNode<Integer>(4);
		TreeNode<Integer> n2 = new TreeNode<Integer>(7);
		TreeNode<Integer> n3 = new TreeNode<Integer>(2);
		TreeNode<Integer> n4 = new TreeNode<Integer>(3);
		TreeNode<Integer> n5 = new TreeNode<Integer>(6);
		TreeNode<Integer> n6 = new TreeNode<Integer>(8);
		TreeNode<Integer> n7 = new TreeNode<Integer>(9);
		TreeNode<Integer> n8 = new TreeNode<Integer>(1);
		TreeNode<Integer> n9 = new TreeNode<Integer>(10);
		
		tree.addLeftChild(n1);
		tree.addRightChild(n2);
		
		n1.addLeftChild(n3);
		n1.addRightChild(n4);
		
		n2.addLeftChild(n5);
		n2.addRightChild(n6);
		
		n3.addLeftChild(n8);
		n6.addRightChild(n7);
		n7.addRightChild(n9);
		
		FindLeftNode fn = new FindLeftNode();
		TreeNode<Integer> result = fn.findLeftNode(tree, 10);
		if (result != null)
			System.out.println(result.key);
		else
			System.out.println("No left node");
	}

}
