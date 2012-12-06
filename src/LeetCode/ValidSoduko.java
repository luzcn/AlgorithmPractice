package LeetCode;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * @author annie
 * 
 */
public class ValidSoduko
{
	public boolean isValidSudoku(char[][] board)
	{
		for (int i = 0; i < 9; i++)
		{
			if (!isValidRow(board, i))
				return false;
		}
		for (int j = 0; j < 9; j++)
		{
			if (!isValidCol(board, j))
				return false;
		}
		if (!isValidBox(board))
			return false;

		return true;
	}

	private boolean isValidRow(char[][] board, int row)
	{
		int[] c = new int[10];
		for (int j = 0; j < 9; j++)
		{
			if (board[row][j] != '.')
			{
				int a = Character.getNumericValue(board[row][j]);
				if (c[a] == 0)
					c[a] = 1;
				else
					return false;
			}
		}
		return true;
	}

	private boolean isValidCol(char[][] board, int col)
	{
		int[] c = new int[10];
		for (int j = 0; j < 9; j++)
		{
			if (board[j][col] != '.')
			{
				int a = Character.getNumericValue(board[j][col]);
				if (c[a] == 0)
					c[a] = 1;
				else
					return false;
			}
		}
		return true;
	}

	private boolean isValidBox(char[][] board)
	{
		int rowoffset = 0;
		int coloffset = 0;
		int[] c = new int[10];

		while (rowoffset < 9)
		{
			while (coloffset < 9)
			{
				c = new int[10];
				for (int i = 0; i < 3; i++)
				{
					for (int j = 0; j < 3; j++)
					{
						if (board[i+rowoffset][j+coloffset] != '.')
						{
							int a = Character.getNumericValue(board[i
									+ rowoffset][j + coloffset]);
							if (c[a] == 0)
								c[a] = 1;
							else
								return false;
						}
					}
				}
				coloffset += 3;
			}
			rowoffset += 3;
			coloffset = 0;
		}
		return true;
	}

	public static void main(String[] args)
	{
		String[] input = { "..5..7.13", "3.2......", "....8..9.", ".........",
				"5..6..4..", "....9...4", "..4..5...", ".5...8...", "........9" };
		char[][] board = new char[9][9];

		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				board[i][j] = input[i].charAt(j);
			}
		}
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		ValidSoduko vs = new ValidSoduko();

		System.out.println(vs.isValidSudoku(board));
	}

}
