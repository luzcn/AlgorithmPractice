package LeetCode;

import java.util.ArrayList;

/**
 * * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author Zheng Lu
 * @date Oct 25, 2012
 * 
 */
public class Permutations
{
	public static ArrayList<ArrayList<Integer>> permute(int[] num)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++)
			list.add(num[i]);

		return getPerms(list, new ArrayList<Integer>(),
				new ArrayList<ArrayList<Integer>>());
	}

	private static ArrayList<ArrayList<Integer>> getPerms(
			ArrayList<Integer> numlist, ArrayList<Integer> current,
			ArrayList<ArrayList<Integer>> solution)
	{
		if (numlist.size() == 0)
		{
			solution.add(new ArrayList<Integer>(current));
			return solution;
		}

		for (int i = 0; i < numlist.size(); i++)
		{
			current.add(numlist.get(i));
			numlist.remove(i);

			getPerms(numlist, current, solution);

			numlist.add(i, current.get(current.size() - 1));
			current.remove(current.size() - 1);
		}

		return solution;
	}

	public static void main(String[] args)
	{
		int[] num = {1,2,3};
		ArrayList<ArrayList<Integer>> sol = permute(num);
		System.out.println(sol);
	}
}
