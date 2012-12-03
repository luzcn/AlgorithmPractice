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
		return subsetsRec(S, 0);
	}

	private ArrayList<ArrayList<Integer>> subsetsRec(int[] S, int index)
	{
		ArrayList<ArrayList<Integer>> allsubsets = null;
		if (S.length == index)
		{
			// add the empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else
		{
			allsubsets = subsetsRec(S, index + 1);

			int item = S[index];
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> subset : allsubsets)
			{
				ArrayList<Integer> newSubset = new ArrayList<Integer>(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allsubsets.addAll(moreSubsets);
		}
		return allsubsets;
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
		return subsetsRec2(S, 0);
	}

	private ArrayList<ArrayList<Integer>> subsetsRec2(int[] S, int index)
	{
		ArrayList<ArrayList<Integer>> allsubsets = null;
		if (S.length == index)
		{
			// add the empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else
		{
			allsubsets = subsetsRec2(S, index + 1);
			int item = S[index];
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> subset : allsubsets)
			{
				ArrayList<Integer> newSubset = new ArrayList<Integer>(subset);
				newSubset.add(item);
				if (!moreSubsets.contains(newSubset))
					moreSubsets.add(newSubset);
			}
			if (!allsubsets.contains(moreSubsets))
				allsubsets.addAll(moreSubsets);
		}

		return allsubsets;

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
		ArrayList<ArrayList<Integer>> subset = sub
				.subsets2(new int[] {1,2,2});
		System.out.println(subset);

	}

}
