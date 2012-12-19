package CareerCup.TreeGraph;

import AlgorithmDataStructure.TreeNode;

/**
 * re-construct a BST from the preorder of this BST
 * 
 * @author annie
 * 
 * @date Dec 17, 2012
 */
public class RestoreBST
{
	int index = 0;

	public TreeNode constructBST(int[] preorder, int min, int max)
	{

		if (index == preorder.length)
			return null;

		int val = preorder[index];
		if (val < max && val > min)
		{
			TreeNode root = new TreeNode(val);
			index++;
			root.left = constructBST(preorder, min, val);
			root.right = constructBST(preorder, val, max);
			return root;
		}
		else
			return null;
	}

	public TreeNode constructTree(String[] preorder)
	{
		if (index == preorder.length)
			return null;
		
		if (preorder[index].equals("#"))
		{
			index++;
			return null;
		}
		else
		{
			int val = Integer.parseInt(preorder[index]);
			TreeNode root = new TreeNode(val);
			index++;
			
			root.left = constructTree(preorder);
			root.right = constructTree(preorder);
			
			return root;
		}
	}


	private void inorder(TreeNode node)
	{
		if (node == null)
			return;

		inorder(node.left);
		System.out.print(node.key + "  ");
		inorder(node.right);
	}

	public static void main(String[] args)
	{
		// int[] preorder = {30,20,10,40,35,50};
		String[] preorder = { "30", "10", "50", "#", "#", "#", "20", "45", "#",
				"#", "35", "#", "#" };
		
		RestoreBST rbst = new RestoreBST();
		TreeNode t = rbst.constructTree(preorder);
		
		
		// TreeNode t = rbst.constructBST(preorder,Integer.MIN_VALUE,
		// Integer.MAX_VALUE);
		rbst.inorder(t);
	}
}
