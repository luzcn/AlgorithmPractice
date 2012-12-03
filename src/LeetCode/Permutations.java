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

	/**
	 * represent the result as string
	 * @param num
	 * @param index
	 * @return
	 */
	private static ArrayList<String> getAllCombination(int[] num, int index)
	{
		ArrayList<String> sol = new ArrayList<String>();
		if (index == num.length)
		{
			// sol = new ArrayList<String>();
			sol.add("");
			return sol;
		}
		else
		{
			ArrayList<String> strList = getAllCombination(num, index + 1);
			String character = Integer.toString(num[index]);
			for (String s : strList)
			{
				for (int i = 0; i <= s.length(); i++)
				{
					sol.add(insertChar(s, i, character));
				}
			}
		}
		return sol;
	}
	private static String insertChar(String s, int index, String c)
	{
		return s.substring(0, index) + c + s.substring(index);
	}
	
	
	public static void main(String[] args)
	{
		int[] num = {0,1,2 };
		ArrayList<ArrayList<Integer>> sol = permute(num);
		System.out.println(getAllCombination(num,0));
		System.out.println(sol);
	}

}
