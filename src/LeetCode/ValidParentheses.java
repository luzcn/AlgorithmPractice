package LeetCode;

import java.util.Stack;

/***
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author annie
 * 
 */
public class ValidParentheses
{
	public boolean isValid(String s)
	{
		int n = s.length();
		if (n < 2 || n % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < n; i++)
		{
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else
			{
				if (!stack.isEmpty() && !checkValid(stack.pop(), c))
					return false;
			}
		}
		if (!stack.isEmpty())
			return false;

		return true;

	}

	private boolean checkValid(char s, char t)
	{

		if (s == '(' && t == ')')
			return true;
		if (s == '[' && t == ']')
			return true;
		if (s == '{' && t == '}')
			return true;

		return false;
	}

	public static void main(String[] args)
	{

	}

}
