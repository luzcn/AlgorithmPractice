package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

import AlgorithmDataStructure.Sort;

/***
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2,...,ak) must be in non-descending order.
 * 
 * The solution set must not contain duplicate combinations For example, given
 * candidate set 2,3,6,7 and target 7, A solution set is: [7] [2, 2, 3]
 * 
 * @author Zheng Lu
 * 
 */
public class CombinationSum
{

	public ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target)
	{
		return getCombSum(arr, target, 0, 0, new ArrayList<Integer>(),
				new ArrayList<ArrayList<Integer>>());
	}

	public ArrayList<ArrayList<Integer>> getCombSum(int[] arr, int target,
			int sum, int index, ArrayList<Integer> currentCandidates,
			ArrayList<ArrayList<Integer>> solution)
	{
		if (sum > target)
			return solution;
		if (sum == target)
		{
			ArrayList<Integer> valid = new ArrayList<Integer>(currentCandidates);
			solution.add(valid);
			return solution;
		}
		for (int i = index; i < arr.length; i++)
		{
			currentCandidates.add(arr[i]);
			getCombSum(arr, target, sum + arr[i], i, currentCandidates,
					solution);
			currentCandidates.remove(currentCandidates.size() - 1);
		}
		return solution;
	}

	/***
	 * Given a collection of candidate numbers (C) and a target number (T), find
	 * all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * Each number in C may only be used once in the combination Note:
	 * 
	 * All numbers (including target) will be positive integers Elements in a
	 * combination (a1, a2,.., ak) must be in non-descending order
	 * 
	 * The solution set must not contain duplicate combinations.
	 * 
	 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution
	 * set is: [1, 7][1, 2, 5][2, 6][1, 1, 6]
	 * 
	 * @param candicates
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] arr, int target)
	{
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < arr.length; i++)
			getCombSum2(arr, target, 0, i, new ArrayList<Integer>(), solution);

		return solution;
	}

	private ArrayList<ArrayList<Integer>> getCombSum2(int[] arr, int target,
			int sum, int index, ArrayList<Integer> currentCandidates,
			ArrayList<ArrayList<Integer>> solution)
	{
		currentCandidates.add(arr[index]);

		if (sum + arr[index] > target)
			return solution;
		if (sum + arr[index] == target)
		{
			ArrayList<Integer> valid = new ArrayList<Integer>(currentCandidates);
			solution.add(valid);
			return solution;
		}
		else
		{
			for (int i = index + 1; i < arr.length; i++)
			{
				getCombSum2(arr, target, sum + arr[index], i,
						currentCandidates, solution);
				currentCandidates.remove(currentCandidates.size() - 1);
			}
		}
		return solution;
	}

	public static void main(String[] args)
	{
		int[] nums = { 1,2 };
		Arrays.sort(nums);
		CombinationSum cs = new CombinationSum();
		ArrayList<ArrayList<Integer>> solution = cs.combinationSum2(nums, 2);

		for (ArrayList<Integer> s : solution)
			System.out.println(s.toString());
	}

}
