package LeetCode;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 * 
 * @author Zheng Lu
 * @date Oct 18, 2012
 * 
 */
public class MaximalRectangle
{

	/**
	 * The brutal force solution O(n^6)
	 * 
	 * @param M
	 * @return
	 */
	private int maxRectangleBF(int[][] M)
	{
		int max = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;

		for (i = 0; i < M.length; i++)
		{
			for (j = 0; j < M[0].length; j++)
			{
				for (k = i; k < M.length; k++)
				{
					for (l = j; l < M[0].length; l++)
					{
						if (allOnes(M, i, j, k, l) && area(M, i, j, k, l) > max)
						{
							max = area(M, i, j, k, l);
						}
					}
				}
			}
		}
		return max;
	}

	private int area(int[][] M, int i, int j, int k, int l)
	{
		if (i > k || j > l)
			return 0;
		else
			return (k - i + 1) * (l - j + 1);
	}

	private boolean allOnes(int[][] M, int i, int j, int k, int l)
	{
		for (int indexX = i; indexX <= k; indexX++)
		{
			for (int indexY = j; indexY <= l; indexY++)
			{
				if (M[indexX][indexY] == 0)
					return false;
			}
		}
		return true;
	}

	public int maxRectangleDP(int[][] M)
	{
		if (M.length == 0)
			return 0;

		int m = M.length;
		int n = M[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (M[i][j] == 1)
				{
					if (j == 0)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i][j - 1] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (M[i][j] == 1)
				{
					int k = i;
					int min = dp[i][j];
					while (k >= 0 && M[k][j] == 1)
					{
						min = Math.min(min, dp[k][j]);
						max = Math.max(max, min * (i - k + 1));
						k--;
					}
				}
			}
		}
		return max;
	}
	public int maximalRectangle(char[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] auxilary = new int[rows][columns];

		if (rows == 0)
			return 0;

		// copy matrix to auxilary
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				auxilary[i][j] = Character.getNumericValue(matrix[i][j]);
			}
		}
		for (int i = 1; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				if (auxilary[i][j] == 1)
					auxilary[i][j] = auxilary[i - 1][j] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < rows; i++)
		{
			int maxInRow = largestRectangle(auxilary[i]);
			if (maxInRow > max)
				max = maxInRow;
		}
		return max;
	}

	private int largestRectangle(int[] h)
	{
		if (h.length == 0)
			return 0;
		int[] width = new int[h.length];
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < h.length; i++)
		{
			while (!stack.isEmpty())
			{
				if (stack.peek() >= h[i])
					stack.pop();
				else
					break;
			}
			if (stack.isEmpty())
				width[i] = i;
			else
				width[i] = i - stack.peek() - 1;

			stack.push(i);
		}

		stack.clear();
		for (int i = h.length - 1; i >= 0; i--)
		{
			while (!stack.isEmpty())
			{
				if (stack.peek() >= h[i])
					stack.pop();
				else
					break;
			}

			if (stack.isEmpty())
				width[i] += h.length - i + 1;
			else
				width[i] += stack.peek() - i + 1;

			stack.push(i);
		}
		for (int i = 0; i < h.length; i++)
		{
			int area = h[i] * (width[i] + 1);
			if (area > max)
				max = area;
		}
		return max;
	}

	public static void main(String[] args)
	{
		int[][] M = { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1, 1 },
				{ 0, 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 1, 1 } };
	}

}
