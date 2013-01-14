package CareerCup.DynamicProgram;

import java.util.ArrayList;

/**
 * @author Zheng Lu
 * @date Oct 2, 2012
 * 
 */
public class CoinsChange
{
	private ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();

	/**
	 * Compute how many coin change ways
	 * 
	 * @param n
	 * @param coins
	 * @return
	 */
	public int coinChangeWays(int n, int[] coins)
	{
		if (n <= 0 || coins.length == 0)
			return 0;

		return coinChangeWaysDP(n, coins);
	}

	private int coinChangeWaysDP(int n, int[] coins)
	{
		int m = coins.length;
		int[][] M = new int[n + 1][m + 1];
		for (int j = 0; j <= m; j++)
			M[0][j] = 1;

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (i >= coins[j - 1])
					M[i][j] = M[i - coins[j - 1]][j] + M[i][j - 1];
				else
					M[i][j] = M[i][j - 1];
			}
		}

		return M[n][m];
	}

	private int coinChangeWaysRec(int n, int[] coins, int m)
	{

		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (m < 0 && n > 0)
			return 0;

		return coinChangeWaysRec(n - coins[m], coins, m)
				+ coinChangeWaysRec(n, coins, m - 1);
	}

	/**
	 * print out all the coin change combinations
	 * 
	 * @param n
	 * @param coins
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> coinChangeCombination(int n,
			int[] coins)
	{
		solution = new ArrayList<ArrayList<Integer>>();
		if (n < 0 || coins.length == 0)
			return solution;
		coinChangeRec(n, coins, new ArrayList<Integer>(), 0);
		return this.solution;
	}

	private void coinChangeRec(int n, int coins[], ArrayList<Integer> current,
			int index)
	{
		if (n < 0)
			return;
		if (n == 0)
		{
			solution.add(new ArrayList<Integer>(current));
			return;
		}

		for (int i = index; i < coins.length; i++)
		{
			current.add(coins[i]);
			coinChangeRec(n - coins[i], coins, current, i);
			current.remove(current.size() - 1);
		}
	}

	/**
	 * the coin change with minimum coins
	 * 
	 * @param n
	 * @param coins
	 * @return
	 */
	public int minCoinChange(int n, int[] coins)
	{
		if (n <= 0 || coins.length == 0)
			return 0;

		return minCoinChangeRec(n, coins, coins.length - 1);
		// return minCoinChangeDP(n, coins);
	}

	private int minCoinChangeRec(int n, int[] coins, int m)
	{
		if (n < 0)
			return Integer.MAX_VALUE - 1;
		if (n == 0)
			return 0;
		if (m < 0 && n > 0)
			return Integer.MAX_VALUE - 1;

		return Math.min(minCoinChangeRec(n - coins[m], coins, m) + 1,
				minCoinChangeRec(n, coins, m - 1));
	}

	private int minCoinChangeDP(int n, int[] coins)
	{
		int m = coins.length;
		int[][] M = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++)
			M[i][0] = n;

		int amount = 0;

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (i >= coins[j - 1])
					amount = 1 + M[i - coins[j - 1]][j];
				else
					amount = n;

				M[i][j] = Math.min(M[i][j - 1], amount);
			}
		}
		return M[n][m];
	}

	public static void main(String[] args)
	{
	}
}
