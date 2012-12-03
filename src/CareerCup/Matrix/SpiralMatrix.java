package CareerCup.Matrix;

/***
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,	Given the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 4, 5, 6 ],
 * 	[ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * @author Zheng Lu
 *
 */
public class SpiralMatrix
{
	public static final int Row = 3;
	public static final int Column = 3;
	
	public static void SpiralPrint(int xSize, int ySize, int[][] matrix)
	{
		int row = 0;	//index of ySize
		int col = 0;	//index of xSize
		
		while(row<ySize && col<xSize)
		{
			/**
			 * print the first row of the matrix
			 * the row value increase by 1
			 */
			for (int i = row;i<ySize;i++)
				System.out.print(matrix[col][i]+" ");
			row++;
			
			/**
			 * print the right most column of the matrix
			 * the xSize is decreased by 1
			 */
			for (int i = row;i<ySize;i++)
				System.out.print(matrix[i][ySize-1]+" ");
			xSize--;
			
			/**
			 * print the bottom row of the matrix in reverse order
			 * the ySize is decreased by 1
			 */
			for (int i = xSize-1;i>=col;i--)
				System.out.print(matrix[ySize-1][i] + " ");
			ySize--;
			
			/**
			 * print the left most column of the matrix in reverse order
			 * the col value is increased by 1
			 */
			for (int i = ySize-1;i>= row;i--)
				System.out.print(matrix[i][col]+ " ");
			col++;
		}
	}
	
	public static void main(String[] args)
	{
		//build the matrix;
		int[][] matrix = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};	
		
		System.out.println("The matrix is: ");
		for (int i = 0;i<4;i++)
		{
			for (int j = 0;j<4;j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("The Spiral Print is: ");
		SpiralPrint(4, 4, matrix);
	}
}
