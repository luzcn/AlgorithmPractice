package LeetCode;

import java.util.ArrayList;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * @author Zheng Lu
 * @date Oct 25, 2012
 * 
 */
public class NQueens
{
	int count = 0;

	public ArrayList<String[]> solveNQueens(int n)
	{
		ArrayList<String[]> solution = new ArrayList<String[]>();
		int[] columnForRow = new int[n];
		count = 0;

		solveNQueenRec(solution, n, columnForRow, 0);
		System.out.println(count);
		return solution;
	}

	private void solveNQueenRec(ArrayList<String[]> solution, int n,
			int[] columnForRow, int row)
	{
		if (row == n)
		{
			String[] strArray = new String[n];
			for (int i = 0; i < n; i++)
				strArray[i] = "";

			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
				{
					if (j != columnForRow[i])
						strArray[i] += ".";
					else
						strArray[i] += "Q";
				}
			}
			solution.add(strArray);
			++count;
			return;
		}

		for (int i = 0; i < n; i++)
		{
			columnForRow[row] = i;
			if (check(columnForRow, row))
				solveNQueenRec(solution, n, columnForRow, row + 1);
		}
	}

	private boolean check(int[] columnForRow, int row)
	{
		for (int i = 0; i < row; i++) // i is the row index
		{
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if (diff == 0 || diff == row - i)
				return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		NQueens nq = new NQueens();
		ArrayList<String[]> sol = nq.solveNQueens(8);

		// if (sol != null)
		// for (String[] strarray : sol)
		// {
		// for (int i = 0; i < strarray.length; i++)
		// System.out.println(strarray[i] + " ");
		// System.out.println();
		// }
	}
}
