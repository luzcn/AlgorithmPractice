package LeetCode;

import java.util.ArrayList;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] You should return
 * [1,2,3,6,9,8,7,4,5].
 * 
 * @author annie
 * 
 * @date Jan 13, 2013
 */
public class SpiralMatrix
{

	public ArrayList<Integer> spiralMatrix(int[][] M)
	{
		ArrayList<Integer> solution = new ArrayList<Integer>();
		if (M.length == 0)
			return solution;
		if (M[0].length == 0)
			return solution;

		int m = M.length;
		int n = M[0].length;

		int col1 = 0;
		int col2 = n - 1;

		int row1 = 0;
		int row2 = m - 1;

		while (row1 <= row2 && col1 <= col2)
		{
			// print the top row in order
			for (int j = col1; j <= col2; j++)
				solution.add(M[row1][j]);
			row1++;

			// print the last column in order
			for (int i = row1; i <= row2; i++)
				solution.add(M[i][col2]);
			col2--;

			// if there is only one row or one column left.
			// do not need to output in reverse order
			if (row1 > row2 || col1 > col2)
				break;

			// print the last row in reverse order
			for (int j = col2; j >= col1; j--)
				solution.add(M[row2][j]);
			row2--;

			// print the first column in reverse order
			for (int i = row2; i >= row1; i--)
				solution.add(M[i][col1]);
			col1++;
		}
		return solution;
	}

	/**
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order.
	 * 
	 * For example, Given n = 3,
	 * 
	 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7,
	 * 6, 5 ] ]
	 * 
	 * @param n
	 * @return
	 */
	public int[][] spiralMatrix2(int n)
	{
		if (n <= 0)
			return new int[0][0];

		int[][] M = new int[n][n];
		int num = 1;

		int row1 = 0;
		int row2 = n - 1;
		int col1 = 0;
		int col2 = n - 1;

		while (row1 <= row2 && col1 <= col2)
		{
			for (int j = col1; j <= col2; j++)
				M[row1][j] = num++;
			row1++;

			for (int i = row1; i <= row2; i++)
				M[i][col2] = num++;
			col2--;

			if (row1 > row2 || col2 < col1)
				break;

			for (int j = col2; j >= col1; j--)
				M[row2][j] = num++;
			row2--;

			for (int i = row2; i >= row1; i--)
				M[i][col1] = num++;
			col1++;

		}
		return M;
	}

	private void print(int[][] M)
	{
		for (int i = 0; i < M.length; i++)
		{
			for (int j = 0; j < M[0].length; j++)
				System.out.print(M[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		SpiralMatrix sm = new SpiralMatrix();
		sm.print(sm.spiralMatrix2(4));
	}

}
