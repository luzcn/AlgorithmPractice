package CareerCup.Matrix;

/**
 * Given a matrix in which each row and each column is sorted, 
 * write a method to find an element in it.
 * @author Zheng Lu
 */

public class FindElemInMatrix
{
	public static final int Row = 3;
	public static final int Column = 3;
	
	public static void main(String[] args)
	{
		int[][] matrix = new int[Row][Column];	
		matrix[0][0] = 1;
		matrix[0][1] = 4;
		matrix[0][2] = 6;
		
		matrix[1][0] = 2;
		matrix[1][1] = 8;
		matrix[1][2] = 23;
		
		matrix[2][0] = 4;
		matrix[2][1] = 12;
		matrix[2][2] = 63;
		
		for (int i = 0;i<Row;i++)
		{
			for (int j = 0;j<Column;j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		
		findElement(matrix, 4);
	}
	
	public static void findElement (int[][] matrix, int key)
	{
		//start from the left corner matrix[row][0]
		//if the key > matrix[row][0], move right
		//if the key < matrix[row][0], move up
		int row = Row - 1;
		int col = 0; 
		while(row >= 0 && col < Column)
		{
			if (matrix[row][col] > key)	//move up
				row--;
			else if (matrix[row][col] < key)
				col++;
			else 
			{
				System.out.println(row + " " + col);
				row--;
			}
		}
		
//		if (row<0 || col == Column) System.out.println("Not Found");
	}

}
