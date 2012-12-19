package LeetCode;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n. For example, If n = 4 and k = 2, a solution is:[ [2,4], [3,4],
 * [2,3], [1,2], [1,3], [1,4],]
 * 
 * @author Zheng Lu Sep 26, 2012
 * 
 */
public class Combinations
{
	public static ArrayList<ArrayList<Integer>> combine(int n, int k)
	{
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = i + 1;
		}
		return combineWithElement(arr, k, 0, new ArrayList<Integer>(),
				new ArrayList<ArrayList<Integer>>());
	}
	private static ArrayList<ArrayList<Integer>> combineWithElement(int[] arr, int k,
			int index, ArrayList<Integer> currentList,
			ArrayList<ArrayList<Integer>> solution)
	{
		if (currentList.size() == k)
		{
			solution.add(new ArrayList<Integer>(currentList));
			return solution;
		} else
		{
			while (index < arr.length)
			{
				currentList.add(arr[index]);
				combineWithElement(arr, k, index+1, currentList, solution);
				currentList.remove(currentList.size() - 1);
				index++;
			}
		}
		return solution;
	}

	public static void main(String[] args)
	{
		int n = 7;
		int k = 2;
		ArrayList<ArrayList<Integer>> solution = combine(n,k);
		for (ArrayList<Integer> s:solution)
			System.out.println(s);
	}
}
