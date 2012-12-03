package LeetCode;

import java.util.ArrayList;

/**
 * @author Zheng Lu Oct 1, 2012
 * 
 */
public class GenerateParentheses
{
	public static ArrayList<String> generateParenthesis(int n)
	{
		ArrayList<String> solution = new ArrayList<String>();
		printPar(n, n, new char[n * 2], 0, solution);
		return solution;
	}

	public static void printPar(int l, int r, char[] str, int count,
			ArrayList<String> solution)
	{
		if (l < 0 || r < l)
			return;
		if (l == 0 && r == 0)
		{
			solution.add(new String(str));
			// System.out.println(str);
		} else
		{
			if (l > 0)
			{
				str[count] = '(';
				printPar(l - 1, r, str, count + 1, solution);
			}
			if (r > l)
			{
				str[count] = ')';
				printPar(l, r - 1, str, count + 1, solution);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int n = 3;
		ArrayList<String> solution = generateParenthesis(n);

		for (String s : solution)
			System.out.println(s);
	}

}
