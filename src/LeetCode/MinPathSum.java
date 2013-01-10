package LeetCode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author Zheng Lu
 * @date Oct 19, 2012
 * 
 */
public class MinPathSum
{
	public int minPathSum(int[][] grid)
	{
		if (grid.length == 0)
			return 0;
		if (grid[0].length == 0)
			return 0;

		return minPathIterative(grid);
		// return minPathRec(grid, grid.length - 1, grid[0].length - 1);
	}

	/**
	 * Space complexity O(m*n)
	 * 
	 * @param grid
	 * @return
	 */
	private int minPathIterative(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;

		int[][] pathSum = new int[rows][columns];
		pathSum[0][0] = grid[0][0];

		for (int i = 1; i < rows; i++)
			pathSum[i][0] = grid[i][0] + pathSum[i - 1][0];
		for (int j = 1; j < columns; j++)
			pathSum[0][j] = grid[0][j] + pathSum[0][j - 1];

		for (int i = 1; i < rows; i++)
		{
			for (int j = 1; j < columns; j++)
			{
				pathSum[i][j] = grid[i][j]
						+ Math.min(pathSum[i - 1][j], pathSum[i][j - 1]);
			}
		}
		return pathSum[rows - 1][columns - 1];
	}

	/**
	 * Space O(m+n)
	 * 
	 * @param grid
	 * @return
	 */
	private int maxPathSum(int[][] grid)
	{
		if (grid.length == 0)
			return 0;
		if (grid[0].length == 0)
			return 0;

		int rows = grid.length;
		int cols = grid[0].length;

		int[] colArr = new int[rows];
		int[] rowArr = new int[cols];

		colArr[0] = grid[0][0];
		rowArr[0] = grid[0][0];

		for (int i = 1; i < cols; i++)
			rowArr[i] = rowArr[i - 1] + grid[0][i];

		for (int i = 1; i < rows; i++)
			colArr[i] = colArr[i - 1] + grid[i][0];

		for (int i = 1; i < rows; i++)
		{
			for (int j = 1; j < cols; j++)
			{
				int value = Math.max(rowArr[j], colArr[i]) + grid[i][j];
				rowArr[j] = value;
				colArr[i] = value;
			}
		}
		return rowArr[cols - 1];
	}

	private int minPathRec(int[][] grid, int i, int j)
	{
		if (i == 0 && j == 0)
			return grid[i][j];
		else if (i == 0)
			return grid[i][j] + minPathRec(grid, i, j - 1);
		else if (j == 0)
			return grid[i][j] + minPathRec(grid, i - 1, j);
		else
			return grid[i][j]
					+ Math.min(minPathRec(grid, i - 1, j),
							minPathRec(grid, i, j - 1));
	}

	public static void main(String[] args)
	{
		MinPathSum mps = new MinPathSum();
		int[][] grid = { { 2,2,4,2 }, {0,3,0,1},{1,2,2,1},{4,1,2,2,} };
		System.out.println(mps.maxPathSum(grid));

	}

}
