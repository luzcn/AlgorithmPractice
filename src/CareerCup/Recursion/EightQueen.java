package CareerCup.Recursion;

/**
 * @author Zheng Lu
 * @date Oct 25, 2012
 * 
 */
public class EightQueen
{
	int[] columnForRow = new int[8]; // the position of each queen
	int count = 0; // the solution numbers

	private boolean check(int row)
	{
		for (int i = 0; i < row; i++) // i is the row index
		{
			// Math.abs(columnForRow[i] - columnForRow[row])==0: in the same
			// column
			// columnForRow[i] + i == columnForRow[row] + row: in the diagonal
			// columnForRow[i] - i == columnForRow[row] - row: int he diagonal

			if (Math.abs(columnForRow[i] - columnForRow[row]) == 0
			// || columnForRow[i] + i == columnForRow[row] + row
					|| Math.abs(columnForRow[i] - i) == Math
							.abs(columnForRow[row] - row))
				return false;

			// int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			// if (diff == 0 || diff == row - i)
			// return false;

		}
		return true;
	}

	private void printBoard()
	{
		int[][] board = new int[8][8];
		for (int i = 0; i < 8; i++)
		{
			board[i][columnForRow[i]] = 1;
		}

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void placeQueen(int row)
	{
		if (row == 8)
		{
			printBoard();
			return;
		}
		for (int i = 0; i < 8; i++)
		{
			this.columnForRow[row] = i;
			if (check(row))
				placeQueen(row + 1);
		}
	}

	public static void main(String[] args)
	{
		EightQueen eq = new EightQueen();
		eq.placeQueen(0);
	}

}
