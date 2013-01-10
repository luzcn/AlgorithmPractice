package LeetCode;

import java.util.HashMap;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * @author annie
 * 
 * @date Jan 10, 2013
 */
public class ScrambleString
{
	private HashMap<String, Boolean> map;

	public boolean isScramble(String s1, String s2)
	{
		if (s1 == null || s2 == null)
			return false;
		map = new HashMap<String, Boolean>();

		return isScrambleRec(s1, s2);
	}

	private boolean isScrambleRec(String s1, String s2)
	{
		if (s1.equals(s2))
			return true;

		if (s1.length() != s2.length())
			return false;

		String key = s1 + s2;
		if (s1.compareTo(s2) > 0)
			key = s2 + s1;

		if (map.containsKey(key))
			return map.get(key);

		for (int i = 1; i < s1.length(); i++)
		{
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);

			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);

			if (isScrambleRec(s11, s21) && isScrambleRec(s12, s22))
			{
				map.put(key, true);
				return true;
			}

			s21 = s2.substring(s2.length() - i);
			s22 = s2.substring(0, s2.length() - i);
			if (isScrambleRec(s11, s21) && isScrambleRec(s12, s22))
			{
				map.put(key, true);
				return true;
			}
		}
		map.put(key, false);
		return false;
	}

	public static void main(String[] args)
	{
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("great", "rgeta"));
	}

}
