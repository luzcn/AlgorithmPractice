package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 * 
 * @author Zheng Lu
 * @date Oct 28, 2012
 * 
 */

public class Permutations2
{
	private boolean[] canUse;

	public ArrayList<ArrayList<Integer>> permute(int[] num)
	{
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> numList = new ArrayList<Integer>();

		canUse = new boolean[num.length];

		for (int i = 0; i < num.length; i++)
			numList.add(num[i]);

		permRec(numList, solution, new ArrayList<Integer>());

		return solution;
	}

	private void permRec(ArrayList<Integer> numList,
			ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> current)
	{
		if (numList.size() == 0)
			solution.add(new ArrayList<Integer>(current));
		else
		{
			for (int i = 0; i < numList.size(); i++)
			{
				if (i == 0)
				{
					canUse[i] = false;
					current.add(numList.get(i));
					numList.remove(i);
					permRec(numList, solution, current);
					numList.add(i, current.get(current.size() - 1));
					current.remove(current.size() - 1);
					canUse[i] = true;
				}
				else
				{
					if (numList.get(i) == numList.get(i - 1) && canUse[i - 1])
						continue;

					canUse[i] = false;
					current.add(numList.get(i));
					numList.remove(i);
					permRec(numList, solution, current);
					numList.add(i, current.get(current.size() - 1));
					current.remove(current.size() - 1);
					canUse[i] = true;
				}
			}
		}
	}

	public static void main(String[] args)
	{
		int[] num = { 1, 1, 2 };
		Permutations2 p = new Permutations2();
		System.out.println(p.permute(num));
	}

}
