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
public class Permutation
{

	public static ArrayList<String> getPerms(String s)
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
		ArrayList<String> words = getPerms(remainder);

		for (String word : words)
		{
//			for (int i = 0;i<s.length(); i++)
			for (int i = 0; i <= word.length() ; i++)
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
	public static ArrayList<ArrayList<Integer>> permute(int[] num)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++)
			list.add(num[i]);

		return getPerms(list, 0, new ArrayList<Integer>(),
				new ArrayList<ArrayList<Integer>>());
	}

	private static ArrayList<ArrayList<Integer>> getPerms(
			ArrayList<Integer> numlist, int index, ArrayList<Integer> current,
			ArrayList<ArrayList<Integer>> solution)
	{
		if (numlist.size() == 0)
		{
			solution.add(new ArrayList<Integer>(current));
			return solution;
		}

		for (int i = index; i < numlist.size(); i++)
		{
			current.add(numlist.get(i));
			numlist.remove(i);
			getPerms(numlist, index, current, solution);
			numlist.add(i, current.get(current.size() - 1));
			current.remove(current.size() - 1);
		}

		return solution;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] num = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> sol = permute(num);
		System.out.println(sol);
	}

}
