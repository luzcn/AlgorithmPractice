package LeetCode;

import java.util.ArrayList;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping: 'A' -> 1,'B' -> 2...'Z' -> 26 Given an encoded message
 * containing digits, determine the total number of ways to decode it. For
 * example,Given encoded message "12", it could be decoded as "AB" (1 2) or "L"
 * (12). The number of ways decoding "12" is 2.
 * 
 * @author Zheng Lu Sep 27, 2012
 * 
 */
public class DecodeWays
{
	public static int numDecodings(String s)
	{
		if (s.length() == 0)
			return 0;
//		return decodingNonRec(s);
		 return decodingRec(s, new ArrayList<Integer>()).size();
	}

	private static int decodingNonRec(String s)
	{
		int len = s.length();
		if (len <= 0)
			return 0;
		int a = 1;
		// the first character is not 0
		int b = (Character.getNumericValue(s.charAt(0)) > 0) ? 1 : 0;
		
		for (int i = 1; i < len; i++)
		{
			int c = 0;
			int prev = Character.getNumericValue(s.charAt(i - 1));
			int current = Character.getNumericValue(s.charAt(i));

			if (prev == 1 || (prev == 2 && current <= 6))
				c += a;
			if (current > 0)
				c += b;

			a = b;
			b = c;
		}
		return b;
	}

	/****
	 * The recursive solution
	 * 
	 * @param s
	 * @param solution
	 * @return
	 */
	private static ArrayList<Integer> decodingRec(String s,
			ArrayList<Integer> solution)
	{
		if (s.length() == 0)
		{
			solution.add(1);
			return solution;
		}
		else
		{
			int value = Character.getNumericValue(s.charAt(0));
			if (value <= 9 && value > 0)
				decodingRec(s.substring(1), solution);
			if (s.length() >= 2)
			{
				int value1 = Character.getNumericValue(s.charAt(0));
				int value2 = Character.getNumericValue(s.charAt(1));
				if (value1 == 1)
					decodingRec(s.substring(2), solution);
				else if (value1 == 2 && value2 >= 0 && value2 <= 6)
					decodingRec(s.substring(2), solution);
			}
		}
		return solution;
	}

	public static void main(String[] args)
	{
		System.out.println(numDecodings("10"));
	}

}
