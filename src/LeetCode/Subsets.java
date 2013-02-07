package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order. The solution set must
 * not contain duplicate subsets.
 * 
 * For example, If S = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author Zheng Lu
 * @date Nov 24, 2012
 * 
 */
public class Subsets
{
	public ArrayList<ArrayList<Integer>> subsets(int[] S)
	{
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();

		return powerSetRec(S, solution, new ArrayList<Integer>(), 0);
	}

	private ArrayList<ArrayList<Integer>> powerSetRec(int[] arr,
			ArrayList<ArrayList<Integer>> solution,
			ArrayList<Integer> currentList, int index)
	{
		solution.add(new ArrayList<Integer>(currentList));
		if (index >= arr.length)
			return solution;

		for (int i = index; i < arr.length; i++)
		{
			currentList.add(arr[i]);
			powerSetRec(arr, solution, currentList, i + 1);
			currentList.remove(currentList.size() - 1);
		}
		return solution;
	}

	/***
	 * Given a collection of integers that might contain duplicates, S, return
	 * all possible subsets.
	 * 
	 * Note:
	 * 
	 * Elements in a subset must be in non-descending order. The solution set
	 * must not contain duplicate subsets.
	 * 
	 * For example, If S = [1,2,2], a solution is:
	 * 
	 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
	 * 
	 * @param S
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> subsets2(int[] S)
	{
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		if (S.length == 0)
			return solution;
		boolean[] canUse = new boolean[S.length];

		return subsetsRec2(S, solution, new ArrayList<Integer>(), canUse, 0);
	}

	private ArrayList<ArrayList<Integer>> subsetsRec2(int[] S,
			ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> current,
			boolean[] canUse, int index)
	{
		solution.add(new ArrayList<Integer>(current));
		if (index >= S.length)
			return solution;

		for (int i = index; i < S.length; i++)
		{
			if (i == 0)
			{
				canUse[i] = false;
				current.add(S[i]);
				subsetsRec2(S, solution, current, canUse, i + 1);
				current.remove(current.size() - 1);
				canUse[i] = true;
			}
			else
			{
				if (S[i] == S[i - 1] && canUse[i - 1])
					continue;

				canUse[i] = false;
				current.add(S[i]);
				subsetsRec2(S, solution, current, canUse, i + 1);
				current.remove(current.size() - 1);
				canUse[i] = true;
			}
		}
		return solution;
	}

	public ArrayList<ArrayList<Integer>> subsetsNonRec(int[] S)
	{
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int n = S.length;

		for (int i = 0; i < (1 << n); i++)
		{
			ArrayList<Integer> sub = new ArrayList<Integer>();
			for (int j = 0; j < n; j++)
			{
				if (((i >> j) & 1) == 1)
				{
					sub.add(S[j]);
				}
			}
			allsubsets.add(sub);
		}

		return allsubsets;
	}

	public static void main(String[] args)
	{
		Subsets sub = new Subsets();
		ArrayList<ArrayList<Integer>> subset = sub.subsets2(new int[] { 1, 2,
				2, 2 });
		System.out.println(subset);

	}

}
