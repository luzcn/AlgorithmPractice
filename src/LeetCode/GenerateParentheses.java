package LeetCode;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author Zheng Lu Oct 1, 2012
 * 
 */
public class GenerateParentheses
{
	public static ArrayList<String> generateParenthesis(int n)
	{
		ArrayList<String> solution = new ArrayList<String>();
		if (n == 0)
			return solution;

		generateRec(solution, new String(), n, n);
		return solution;
	}

	private static void generateRec(ArrayList<String> solution, String current,
			int l, int r)
	{
		if (l == 0 && r == 0)
		{
			solution.add(current);
			return;
		}
		if (r < l)
			return;

		if (l > 0)
			generateRec(solution, current + "(", l - 1, r);
		if (r > 0)
			generateRec(solution, current + ")", l, r - 1);
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
		}
		else
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
