package CareerCup.TreeGraph;

import AlgorithmDataStructure.TreeNode;

/**
 * @author Zheng Lu
 *
 */
public class MirrorTree
{

	public TreeNode mirrorTree(TreeNode root)
	{
		if (root == null)
			return null;
		
		mirrorTreeRec(root);
		return root;
	}
	
	private void mirrorTreeRec(TreeNode p)
	{
		if (p == null)
			return;
		
		mirrorTreeRec(p.left);
		mirrorTreeRec(p.right);
		
		TreeNode t = p.left;
		p.left = p.right;
		p.right = t;
	}
	
	private void preOrder(TreeNode n)
	{
		if (n == null)
			return;
		
		System.out.println(n.key);
		preOrder(n.left);
		preOrder(n.right);
	}
	
	public static void main(String[] args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		
		n1.addLeftChild(n2);
		n1.addRightChild(n3);
		n3.addLeftChild(n4);
		
		
		MirrorTree mt = new MirrorTree();
		mt.preOrder(n1);
		
		System.out.println("---");
		
		TreeNode t = mt.mirrorTree(n1);
		mt.preOrder(t);
	}

}
