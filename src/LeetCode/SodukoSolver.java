package LeetCode;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * @author Zheng Lu
 * @date Nov 27, 2012
 * 
 */
public class SodukoSolver
{
	public void solveSudoku(char[][] board)
	{
		solveRec(board, 0, 0);
	}

	private boolean solveRec(char[][] board, int i, int j)
	{
		if (i == 9)
		{
			i = 0;
			if (++j == 9)
				return true;
		}
		if (board[i][j] != '.')
			return solveRec(board, i + 1, j);

		for (int val = 1; val <= 9; val++)
		{
			if (valid(i, j, val, board))
			{
				board[i][j] = Character.forDigit(val, 10);
				if (solveRec(board, i + 1, j))
					return true;
			}
		}
		board[i][j] = '.';
		return false;
	}

	private boolean valid(int i, int j, int val, char[][] board)
	{
		// check row validation
		for (int k = 0; k < 9; k++)
		{
			if (Character.getNumericValue(board[i][k]) == val)
				return false;
		}
		// check column validation
		for (int k = 0; k < 9; k++)
		{
			if (Character.getNumericValue(board[k][j]) == val)
				return false;
		}
		// check box validation
		int boxRowOffset = (i / 3) * 3;
		int boxColOffset = (j / 3) * 3;
		for (int k = 0; k < 3; k++)
		{
			for (int m = 0; m < 3; m++)
			{
				if (Character.getNumericValue(board[k + boxRowOffset][m
						+ boxColOffset]) == val)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		String[] input = { "1...7..3.", "83.6.....", "..29..6.8", "6....49.7",
				".9.....5.", "3.75....4", "2.3..91..", ".....2.43", ".4..8...9" };
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

		SodukoSolver ss = new SodukoSolver();
		ss.solveSudoku(board);

		System.out.println("----------------");

		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
