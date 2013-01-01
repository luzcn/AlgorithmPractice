package LeetCode;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author Zheng Lu
 * @date Oct 23, 2012
 * 
 */
public class MinimumWindowSubstring
{
	public static String minWindow(String S, String T)
	{
		HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
		String result = "";
		int minLen = Integer.MAX_VALUE;

		if (S.length() == 0 || T.length() == 0)
			return result;

		for (int i = 0; i < T.length(); i++)
		{
			if (needToFind.get(T.charAt(i)) == null)
				needToFind.put(T.charAt(i), 1);
			else
				needToFind.put(T.charAt(i), needToFind.get(T.charAt(i)) + 1);
		}

		int count = 0;

		for (int begin = 0, end = 0; end < S.length(); end++)
		{
			char c = S.charAt(end);

			if (needToFind.get(c) != null)
			{
				if (hasFound.get(c) == null)
					hasFound.put(c, 1);
				else
					hasFound.put(c, hasFound.get(c) + 1);

				if (hasFound.get(c) <= needToFind.get(c))
					count++;

				if (count == T.length()) // find a window
				{
					// increase the begin index as far as you can
					while (needToFind.get(S.charAt(begin)) == null
							|| hasFound.get(S.charAt(begin)) > needToFind.get(S
									.charAt(begin)))
					{
						if (hasFound.get(S.charAt(begin)) != null)
							hasFound.put(S.charAt(begin),
									hasFound.get(S.charAt(begin)) - 1);
						begin++;
					}
					int currentLen = end - begin + 1;
					if (currentLen < minLen)
					{
						result = S.substring(begin, end + 1);
						minLen = currentLen;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		String s = "cabefgecdaecf";
		String t = "cae";

		System.out.println(minWindow(s, t));
	}

}
