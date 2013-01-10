package CareerCup.Matrix;

import java.util.ArrayList;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column is set to 0.
 * 
 * @author Zheng Lu
 * 
 */
public class ResetRow
{
	public void reset(int[][] M)
	{
		int[] row = new int[M.length];
		int[] col = new int[M[0].length];

		for (int i = 0; i < M.length; i++)
		{
			for (int j = 0; j < M[0].length; j++)
			{
				if (M[i][j] == 0)
				{
					row[i] = 1;
					col[j] = 1;
				}

			}
		}

		for (int i = 0; i < M.length; i++)
		{
			for (int j = 0; j < M[0].length; j++)
			{
				if (row[i] == 1 || col[j] == 1)
				{
					M[i][j] = 0;
				}
			}
		}
		print(M);
	}

	private void print(int[][] M)
	{
		for (int i = 0; i < M.length; i++)
		{
			for (int j = 0; j < M[0].length; j++)
			{
				System.out.print(M[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
