package LeetCode;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * @author Zheng Lu
 * @date Oct 28, 2012
 * 
 */
public class PathSum2
{

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum)
	{
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return solution;
		pathSumRec(root, solution, new ArrayList<Integer>(), sum);
		return solution;
	}

	private void pathSumRec(TreeNode root,
			ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> current,
			int target)
	{
		if (root == null)
			return;

		current.add(root.val);
		pathSumRec(root.left, solution, current, target);
		pathSumRec(root.right, solution, current, target);

		if (root.left == null && root.right == null)
		{
			int sum = 0;
			for (int i = 0; i < current.size(); i++)
			{
				sum += current.get(i);
			}
			if (sum == target)
				solution.add(new ArrayList<Integer>(current));
		}

		current.remove(current.size() - 1);
	}

	public static void main(String[] args)
	{
	}
}
