package CareerCup.TreeGraph;

import java.util.ArrayList;

import AlgorithmDataStructure.*;

/**
 * CareerCup 24.1 Given a sorted (increasing order) array, write an algorithm to 
 * create a binary tree with minimal height.
 * @author Zheng Lu
 *
 */
public class CreateMinalHeightTree
{
	public CreateMinalHeightTree()
	{
		
	}
	
	public BinarySearchTree create(int[] list)
	{
		BinarySearchTree bst = new BinarySearchTree();
		create(bst, list,0, list.length);
		return bst;
	}
	
	private void create(BinarySearchTree node, int[] list, int l, int r)
	{
		if (l>=r) return;
		int p = (l+r)/2;
		
		node.insert(list[p]);
		create(node, list, l, p);
		create(node, list, p+1, r);
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[]{1,2,3,4,5,6};
		
		CreateMinalHeightTree cmt = new CreateMinalHeightTree();
		BinarySearchTree bst = cmt.create(a);
		bst.preOrder(bst.root);
	}
}
