package CareerCup.Recursion;

import java.util.ArrayList;

/**
 * 8.4 Write a method to compute all permutations of a string For example, give
 * a string "abc", return {abc, bac, bca, acb, cab, cba}
 * 
 * The idea is
 * 
 * @author Zheng Lu Sep 20, 2012
 * 
 */
public class PermutationAndCombination
{
	public static ArrayList<String> getStringPermutation(String s)
	{
		ArrayList<String> permutations = new ArrayList<String>();
		if (s == null)
			return null;
		else if (s.length() == 0)
		{
			permutations.add("");
			return permutations;
		}
		char first = s.charAt(0); // get the first character
		String remainder = s.substring(1); // remove the first character;
		ArrayList<String> words = getStringPermutation(remainder);

		for (String word : words)
		{
			// for (int i = 0;i<s.length(); i++)
			for (int i = 0; i <= word.length(); i++)
			{
				// insert the first character to the word for each position
				permutations.add(insertCharToString(word, first, i));
			}

		}
		return permutations;
	}

	private static String insertCharToString(String str, char c, int index)
	{
		String firstSubStr = str.substring(0, index);
		String secondSubStr = str.substring(index);

		return firstSubStr + c + secondSubStr;
	}

	/***
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
	 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * 
	 * @param num
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> permutation(int[] num)
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

	/**
	 * Given two integers n and k, return all possible combinations of k numbers
	 * out of 1 ... n. For example, If n = 4 and k = 2, a solution is:[ [2,4],
	 * [3,4], [2,3], [1,2], [1,3], [1,4],]
	 * 
	 */
	public ArrayList<ArrayList<Integer>> combination(int n, int k)
	{
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		if (n == 0 || n < k)
			return solution;

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;

		combRec(arr, k, solution, new ArrayList<Integer>(), 0);
		return solution;
	}

	private void combRec(int[] arr, int k,
			ArrayList<ArrayList<Integer>> solution, ArrayList<Integer> current,
			int index)
	{
		if (current.size() == k)
		{
			solution.add(new ArrayList<Integer>(current));
			return;
		}
		else
		{
			for (int i = index; i < arr.length; i++)
			{
				current.add(arr[i]);
				combRec(arr, k, solution, current, i + 1);
				current.remove(current.size() - 1);
			}
		}
	}

	public static void main(String[] args)
	{
		int[] num = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> sol = permutation(num);
		System.out.println(sol);
		
		String s = "123";
		ArrayList<String> ss = getStringPermutation(s);
		System.out.println(ss);
		
	}

}
