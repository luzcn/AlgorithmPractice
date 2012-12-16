package LeetCode;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board = [ ["ABCE"], ["SFCS"], ["ADEE"] ]
 * 
 * 
 * word = "ABCCED", -> returns true, word = "SEE", -> returns true, word =
 * "ABCB", -> returns false.
 * 
 * @author annie
 * 
 * @date Dec 12, 2012
 */
public class WordSearch
{
	public boolean exist(char[][] board, String word)
	{
		int m = board.length;
		int n = board[0].length;

		if (m == 0)
			return false;

		int i = 0;
		int j = 0;
		for (i = 0; i < m; i++)
		{
			for (j = 0; j < n; j++)
			{
				if (board[i][j] == word.charAt(0))
				{
					boolean result = searchRec(board, word, 0, i,j);
					if (result)
						return true;
				}
			}
		}
		return false;
	}
	private boolean searchRec(char[][] board, String word, int index, int i, int j)
	{
		if (index == word.length())
			return true;
		if (i < board.length && j < board[0].length && i >= 0 && j >= 0
				&& word.charAt(index) == board[i][j])
		{
			board[i][j] = '#';
			++index;

			return (searchRec(board, word, index, i + 1, j)
					| searchRec(board, word, index, i - 1, j)
					| searchRec(board, word, index, i, j - 1) | searchRec(board,
						word, index, i, j + 1));
		}

		return false;
	}
	
	private boolean searchDP(char[][] board, String word)
	{
		
		return false;
	}

	public static void main(String[] args)
	{
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(board, word));
		
	}

}
