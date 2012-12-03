package LeetCode;

import java.util.ArrayList;

/**
 * @author Zheng Lu
 * @date Nov 24, 2012
 * 
 */
public class SubstringwithConcatenationofAllWords
{
	public ArrayList<Integer> findSubstring(String S, String[] L)
	{
		int n = L.length;
		if (n == 0)
			return null;
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			numList.add(i);

		ArrayList<ArrayList<Integer>> sol = getPermutation(numList,
				new ArrayList<ArrayList<Integer>>(), new ArrayList<Integer>());

		ArrayList<Integer> indexList = new ArrayList<Integer>();

		StringBuffer sb = null; // new StringBuffer();
		boolean isSubString = true;
		for (ArrayList<Integer> list : sol)
		{
			sb = new StringBuffer();
			for (int i = 0; i < list.size(); i++)
			{
				sb.append(L[list.get(i)]);
			}
//			indexList.addAll(getSubstringIndex(S, sb.toString()));
			for (int i = 0; i <= S.length() - sb.toString().length(); i++)
			{
				isSubString = true;
				for (int j = 0; j < sb.toString().length(); j++)
				{
					if (S.charAt(i + j) != sb.toString().charAt(j))
					{
						isSubString = false;
						break;
					}
				}
				if (isSubString && !indexList.contains(i))
					indexList.add(i);
			}
		}
		return indexList;
	}

	public ArrayList<Integer> getSubstringIndex(String s, String t)
	{
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		boolean isSubString = true;
		for (int i = 0; i < s.length() - t.length(); i++)
		{
			isSubString = true;
			for (int j = 0; j < t.length(); j++)
			{
				if (s.charAt(i + j) != t.charAt(j))
				{
					isSubString = false;
					break;
				}
			}
			if (isSubString)
				indexList.add(i);
		}
		return indexList;
	}

	private ArrayList<ArrayList<Integer>> getPermutation(
			ArrayList<Integer> num, ArrayList<ArrayList<Integer>> solution,
			ArrayList<Integer> current)
	{
		if (num.size() == 0)
		{
			solution.add(new ArrayList<Integer>(current));
			return solution;
		}
		else
		{
			for (int i = 0; i < num.size(); i++)
			{
				int item = num.get(i);
				current.add(item);
				num.remove(i);
				getPermutation(num, solution, current);
				// num.add(i, current.size() - 1);
				num.add(i, item);
				current.remove(current.size() - 1);
			}
		}
		return solution;
	}

	public static void main(String[] args)
	{
		SubstringwithConcatenationofAllWords swc = new SubstringwithConcatenationofAllWords();

		System.out.println(swc.findSubstring(
				"aaaaaa",
				new String[] { "aaa", "aaa"}));

	}

}
