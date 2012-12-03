package LeetCode;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * @author Zheng Lu
 * @date Nov 20, 2012
 * 
 */
public class SetMatrixZeroes
{
	public void setZeroes(int[][] matrix)
	{
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;

		int[][] zeros = new int[m][n];

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (matrix[i][j] == 0)
					zeros[i][j] = 1;
			}
		}

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (zeros[i][j] == 1)
				{
					setZerosForRow(matrix, i);
					setZerosForCol(matrix, j);
				}
			}
		}

	}
	private void setZerosForRow(int[][] m, int row)
	{
		for (int j = 0; j < m[0].length; j++)
			m[row][j] = 0;
	}
	private void setZerosForCol(int[][] m, int col)
	{
		for (int i = 0; i < m.length; i++)
			m[i][col] = 0;
	}

	public static void main(String[] args)
	{

	}

}
