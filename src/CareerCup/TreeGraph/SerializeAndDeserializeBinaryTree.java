package CareerCup.TreeGraph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import AlgorithmDataStructure.TreeNode;

/**
 * 
 * @author annie
 * 
 * @date Dec 17, 2012
 */
public class SerializeAndDeserializeBinaryTree
{
	private int index = 0;
	BufferedWriter bw;
	BufferedReader br;
	File file = new File("");

	public SerializeAndDeserializeBinaryTree()
	{
		try
		{
			bw = new BufferedWriter(new FileWriter(file));
			br = new BufferedReader(new FileReader(file));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void Serialization(TreeNode<Integer> root) throws IOException
	{
		if (root == null)
		{
			bw.write("#");
			return;
		}
		bw.write(root.key);
		Serialization(root.left);
		Serialization(root.right);
	}

	public TreeNode<Integer> Deserialization(String[] preorder)
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
			TreeNode<Integer> root = new TreeNode<Integer>(val);
			index++;

			root.left = Deserialization(preorder);
			root.right = Deserialization(preorder);

			return root;
		}
	}

	private void inorder(TreeNode<Integer> node)
	{
		if (node == null)
			return;

		inorder(node.left);
		System.out.print(node.key + "  ");
		inorder(node.right);
	}

	/**
	 * re-construct a BST from the preorder of this BST
	 * 
	 * @param preorder
	 * @param min
	 * @param max
	 * @return
	 */
	public TreeNode<Integer> constructBST(int[] preorder, int min, int max)
	{
		if (index == preorder.length)
			return null;

		int val = preorder[index];
		if (val < max && val > min)
		{
			TreeNode<Integer> root = new TreeNode<Integer>(val);
			index++;
			root.left = constructBST(preorder, min, val);
			root.right = constructBST(preorder, val, max);
			return root;
		}
		else
			return null;
	}

	public static void main(String[] args)
	{
		String[] preorder = { "30", "10", "50", "#", "#", "#", "20", "45", "#",
				"#", "35", "#", "#" };

		SerializeAndDeserializeBinaryTree rbst = new SerializeAndDeserializeBinaryTree();
		TreeNode<Integer> t = rbst.Deserialization(preorder);
		rbst.inorder(t);
	}
}
