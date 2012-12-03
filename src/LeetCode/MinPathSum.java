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
//		return minPathRec(grid, grid.length - 1, grid[0].length - 1);
	}

	private int minPathIterative(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		
		int[][] pathSum = new int[rows][columns];
		pathSum[0][0]=grid[0][0];
		for (int i = 1;i<rows;i++)
			pathSum[i][0]=grid[i][0]+pathSum[i-1][0];
		for (int j = 1;j<columns;j++)
			pathSum[0][j]=grid[0][j]+pathSum[0][j-1];
		
		for (int i = 1;i<rows;i++)
		{
			for (int j = 1;j<columns;j++)
			{
				pathSum[i][j] = grid[i][j]+Math.min(pathSum[i-1][j], pathSum[i][j-1]);
			}
		}
		
		
		return pathSum[rows-1][columns-1];
	}
	
	/***
	 * recursive solution
	 * @param grid
	 * @param i
	 * @param j
	 * @return
	 */
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
		// TODO Auto-generated method stub

	}

}
