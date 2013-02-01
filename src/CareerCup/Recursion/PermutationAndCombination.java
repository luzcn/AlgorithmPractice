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
			permutations = new ArrayList<String>();
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

	private void permutationRec(char[] arr, int pos)
	{
		if (pos == arr.length)
		{
			System.out.println(new String(arr));
			return;
		}

		for (int i = pos; i < arr.length; i++)
		{
			if (pos != i)
				swap(arr, i, pos);
			permutationRec(arr, pos + 1);
			if (pos != i)
				swap(arr, i, pos);
		}
	}

	private void swap(char[] nums, int i, int j)
	{
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static String insertCharToString(String str, char c, int index)
	{
		String firstSubStr = str.substring(0, index);
		String secondSubStr = str.substring(index);

		return firstSubStr + c + secondSubStr;
	}

	/**
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
	 * s2.
	 * 
	 * For example, Given: s1 = "aabcc", s2 = "dbbca",
	 * 
	 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return
	 * false.
	 * 
	 * 
	 */
	public static ArrayList<String> stringInterleaving(String s, String t)
	{
		ArrayList<String> solution = new ArrayList<String>();
		if (s.isEmpty())
			solution.add(t);
		else if (t.isEmpty())
			solution.add(s);
		else
		{
			for (int i = 0; i <= s.length(); i++)
			{
				char first = t.charAt(0);
				String left = s.substring(0, i);
				String right = s.substring(i);

				for (String str : stringInterleaving(right, t.substring(1)))
					solution.add(left + first + str);
			}
		}
		return solution;
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

	private boolean[] canuse;
	private ArrayList<ArrayList<Integer>> solution;

	public ArrayList<ArrayList<Integer>> permutationWithDup(int[] nums)
	{
		solution = new ArrayList<ArrayList<Integer>>();
		if (nums.length == 0)
			return solution;

		canuse = new boolean[nums.length];

		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++)
			numList.add(nums[i]);

		permutationWithDupRec(numList, new ArrayList<Integer>());
		return solution;
	}

	private void permutationWithDupRec(ArrayList<Integer> numList,
			ArrayList<Integer> current)
	{
		if (numList.size() == 0)
		{
			solution.add(new ArrayList<Integer>(current));
			return;
		}
		for (int i = 0; i < numList.size(); i++)
		{
			if (i == 0)
			{
				canuse[i] = false;
				current.add(numList.get(i));
				numList.remove(i);

				permutationWithDupRec(numList, current);

				numList.add(i, current.get(current.size() - 1));
				current.remove(current.size() - 1);
				canuse[i] = true;
			}
			else
			{
				if (numList.get(i) == numList.get(i - 1) && canuse[i - 1])
					continue;

				canuse[i] = false;
				current.add(numList.get(i));
				numList.remove(i);

				permutationWithDupRec(numList, current);

				numList.add(i, current.get(current.size() - 1));
				current.remove(current.size() - 1);
				canuse[i] = true;
			}
		}
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
