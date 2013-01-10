package LeetCode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author annie
 * 
 */
public class UniquePaths
{
	public int uniquePaths(int m, int n)
	{
		if (m < 0 || n < 0)
			return 0;
		if (m == 0 || n == 0)
			return 1;

		int[][] table = new int[m][n];

		for (int i = 0; i < m; i++)
			table[i][0] = 1;
		for (int j = 0; j < n; j++)
			table[0][j] = 1;

		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
				table[i][j] = table[i - 1][j] + table[i][j - 1];
		}
		return table[m - 1][n - 1];
	}

	/**
	 * Space O(m+n)
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n)
	{
		if (m <= 0 || n <= 0)
			return 0;

		int[] rowArr = new int[n];
		int[] colArr = new int[m];

		for (int i = 0; i < n; i++)
			rowArr[i] = 1;
		for (int i = 0; i < m; i++)
			colArr[i] = 1;

		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				int val = rowArr[j] + colArr[i];
				rowArr[j] = val;
				colArr[i] = val;
			}
		}

		return rowArr[n - 1];
	}

	/***
	 * Follow up for "Unique Paths":
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique
	 * paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the
	 * grid.
	 * 
	 * For example, There is one obstacle in the middle of a 3x3 grid as
	 * illustrated below.
	 * 
	 * [ [0,0,0], [0,1,0], [0,0,0] ] The total number of unique paths is 2.
	 * 
	 * Note: m and n will be at most 100.
	 * 
	 * @param obstacleGrid
	 * @return
	 */

	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (m < 0 || n < 0)
			return 0;

		if (m == 0 || n == 0)
			return 1;

		if (obstacleGrid[0][0] == 1)
			return 0;

		int[][] table = new int[m][n];

		table[0][0] = 1;
		for (int i = 1; i < m; i++)
		{
			if (obstacleGrid[i][0] != 1)
				table[i][0] = table[i - 1][0];
			else
				table[i][0] = 0;
		}
		for (int j = 1; j < n; j++)
		{
			if (obstacleGrid[0][j] != 1)
				table[0][j] = table[0][j - 1];
			else
				table[0][j] = 0;
		}

		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				if (obstacleGrid[i][j] != 1)
					table[i][j] = table[i - 1][j] + table[i][j - 1];
				else
					table[i][j] = 0;
			}
		}
		return table[m - 1][n - 1];
	}
}
