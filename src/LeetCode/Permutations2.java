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
	public ArrayList<ArrayList<Integer>> permute(int[] num)
	{
		HashSet<ArrayList<Integer>> solution = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> numList = new ArrayList<Integer>();

		for (int i = 0; i < num.length; i++)
			numList.add(num[i]);

		permRec(numList, solution, new ArrayList<Integer>());

		return new ArrayList<ArrayList<Integer>>(solution);
	}

	private void permRec(ArrayList<Integer> numList,
			HashSet<ArrayList<Integer>> solution, ArrayList<Integer> current)
	{
		if (numList.size() == 0)
			solution.add(new ArrayList<Integer>(current));
		else
		{
			for (int i = 0; i < numList.size(); i++)
			{
				current.add(numList.get(i));
				numList.remove(i);
				permRec(numList, solution, current);
				numList.add(i, current.get(current.size() - 1));
				current.remove(current.size() - 1);
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
