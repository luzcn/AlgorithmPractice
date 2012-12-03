package CareerCup.Matrix;

import java.util.ArrayList;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column is set to 0.
 * @author Zheng Lu
 *
 */
public class ResetRow
{
	private static final int Row = 3;		// M*N
	private static final int Column = 3;
	
	private int[][] matrix = new int[Row][Column];
	public ResetRow()
	{
		matrix[0][0] = 1;
		matrix[0][1] = 1;
		matrix[0][2] = 1;
		
		matrix[1][0] = 2;
		matrix[1][1] = 0;
		matrix[1][2] = 34;
		
		matrix[2][0] = 4;
		matrix[2][1] = 5;
		matrix[2][2] = 6;
	}
	
	//brutal force?!
	private void reset()
	{
		ArrayList<zeroPos> zeros = new ArrayList<zeroPos>();
		for (int i = 0;i<Row;i++)
		{
			for (int j = 0;j<Column;j++)
			{
				if (matrix[i][j] == 0)
				{
					zeroPos pos = new zeroPos(i,j);
					zeros.add(pos);
				}
			}
		}
		
		for (zeroPos p:zeros)
		{
			//set row to zeros
			for (int i=0;i<Column;i++)
			{
				matrix[p.row][i] = 0;
			}
			
			//set column to zeros
			for (int i=0;i<Row;i++)
			{
				matrix[i][p.column] = 0;
			}
		}
	}
	
	public static void main(String[] args)
	{
		ResetRow rs = new ResetRow();
		rs.reset();
		
		for (int i = 0;i<Row;i++)
		{
			for (int j = 0;j<Column;j++)
			{
				System.out.print(rs.matrix[i][j]);
			}
			System.out.println();
		}
	}
	
/******************************************/	
	private class zeroPos
	{
		int row;
		int column;
		
		public zeroPos(int row, int column)
		{
			this.row = row;
			this.column = column;
		}
	}
}


