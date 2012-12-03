package LeetCode;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author Zheng Lu
 * @date Oct 16, 2012
 * 
 */
public class LongestValidParentheses
{

	public int longestValidParentheses(String s)
	{
		int n = s.length();
		int count = 0;
		int currentLen = 0;
		int maxLen = 0;

		// start from 0...n-1
		for (int i = 0; i < n; i++)
		{
			char c = s.charAt(i);
			if (c == '(')
			{
				count++;
				currentLen++;
			}
			if (c == ')')
			{
				count--;
				currentLen++;
			}
			if (count == 0 && currentLen > maxLen)
				maxLen = currentLen;

			if (count < 0)
			{
				count = 0;
				currentLen = 0;
			}
		}

		count = 0;
		currentLen = 0;
		// start from n-1...0
		for (int i = n - 1; i >= 0; i--)
		{
			char c = s.charAt(i);
			if (c == ')')
			{
				count++;
				currentLen++;
			}
			if (c == '(')
			{
				count--;
				currentLen++;
			}

			if (count == 0 && currentLen > maxLen)
				maxLen = currentLen;

			if (count < 0)
			{
				count = 0;
				currentLen = 0;
			}
		}

		return maxLen;
	}

	public static void main(String[] args)
	{

	}

}
