package LeetCode;

import CareerCup.Matrix.RotateMatrix;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author Zheng Lu
 * @date Nov 5, 2012
 * 
 */
public class RotateImage
{
	public static void rotate(int[][] m)
	{
		int n = m.length;
		int column = 0;
		int row = 0;

		while (n > 1)
		{
			for (int i = row; i < n - row - 1; i++)
			{
				for (int j = column; j < n - column - 1; j++)
				{
					int temp1 = m[i][j];
					m[i][j] = m[n - 1 - j][i];

					int temp2 = m[j][n - 1 - i];
					m[j][n - 1 - i] = temp1;

					int temp3 = m[n - 1 - i][n - 1 - j];
					m[n - 1 - i][n - 1 - j] = temp2;

					m[n - 1 - j][i] = temp3;
				}
				column++;
			}
			n--;
			row++;
		}
	}

	public static void main(String[] args)
	{
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix.length; j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("-----------------");
		RotateMatrix.rotateMatrix2(matrix);

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix.length; j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
