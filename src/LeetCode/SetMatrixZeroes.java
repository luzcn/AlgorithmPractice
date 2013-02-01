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

	public void setMatrixZeros(int[][] matrix)
	{
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		boolean zeroRow0 = false;
		boolean zeroCol0 = false;

		for (int i = 0; i < m; i++)
			if (matrix[i][0] == 0)
			{
				zeroCol0 = true;
				break;
			}
		for (int j = 0; j < n; j++)
			if (matrix[0][j] == 0)
			{
				zeroRow0 = true;
				break;
			}

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
			{
				if (matrix[i][j] == 0)
				{
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
			{
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}

		if (zeroRow0)
		{
			for (int j = 0; j < n; j++)
				matrix[0][j] = 0;
		}

		if (zeroCol0)
		{
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}
	}

	private void print(int[][] M)
	{
		for (int i = 0; i < M.length; i++)
		{
			for (int j = 0; j < M[0].length; j++)
			{
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		int[][] matrix = { { 1, 1, 1, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
				{ 1, 2, 1, 3 }, { 1, 0, 1, 1 } };

		SetMatrixZeroes smz = new SetMatrixZeroes();
		smz.print(matrix);
		System.out.println();

		smz.setMatrixZeros(matrix);
	}

}
