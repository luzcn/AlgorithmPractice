package CareerCup.DynamicProgram;

import java.util.ArrayList;

/**
 * @author Zheng Lu
 * @date Oct 2, 2012
 * 
 */
public class CoinsChange
{

	public int coinChnageAllCombination(int[] coins, int n)
	{
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		coinChangeAllRec(coins, n, result, new ArrayList<Integer>(), 0);

		System.out.println(result);

		return result.size();
	}

	private ArrayList<ArrayList<Integer>> coinChangeAllRec(int[] coins, int n,
			ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current,
			int index)
	{
		if (n < 0)
			return result;
		if (n == 0)
		{
			result.add(new ArrayList<Integer>(current));
			return result;
		}
		for (int i = index; i < coins.length; i++)
		{
			current.add(coins[i]);
			coinChangeAllRec(coins, n - coins[i], result, current, i);
			current.remove(current.size() - 1);
		}
		return result;
	}

	/**
	 * compute the coins change ways
	 * 
	 * @param coins
	 * @param n
	 * @return
	 */
	public int coinChnageWays(int[] coins, int n)
	{
		if (n == 0)
			return 0;

		// return coinChangeWaysRec(coins, n, coins.length - 1);
		return coinChangeWaysDP(coins, n);
	}

	private int coinChangeWaysRec(int[] coins, int n, int m)
	{
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (m < 0 && n > 0)
			return 0;

		return coinChangeWaysRec(coins, n, m - 1)
				+ coinChangeWaysRec(coins, n - coins[m], m);
	}

	private int coinChangeWaysDP(int[] coins, int n)
	{
		int m = coins.length;
		int[][] f = new int[n + 1][m];

		for (int j = 0; j < m; j++)
			f[0][j] = 1;

		for (int i = 1; i < n + 1; i++)
		{
			for (int j = 0; j < m; j++)
			{
				// use this coin, the total value will be change to i - coins[j]
				int x = (i - coins[j]) >= 0 ? f[i - coins[j]][j] : 0;

				// do not use this coin
				int y = j - 1 >= 0 ? f[i][j - 1] : 0;

				f[i][j] = x + y;
			}
		}

		return f[n][m - 1];
	}

	public int minCoinChange(int[] coins, int n)
	{

		return minCoinChangeDP(coins, n);
	}

	private int minCoinChangeRec(int[] c, int n, int m)
	{
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (m < 0 && n > 0)
			return 0;

		return 1 + Math.min(minCoinChangeRec(c, n, m - 1),
				1 + minCoinChangeRec(c, n - c[m], m));
	}

	private int minCoinChangeDP(int[] c, int n)
	{
		int m = c.length;
		int[][] f = new int[m + 1][n + 1];
		int inf = n;// Integer.MAX_VALUE - 1;
		int amount = 0;

		for (int j = 1; j < n + 1; j++)
			f[0][j] = inf;

		for (int denomPos = 1; denomPos < m + 1; denomPos++)
		{
			for (int currentValue = 1; currentValue < n + 1; currentValue++)
			{
				if (currentValue - c[denomPos - 1] >= 0)
					amount = f[denomPos][currentValue - c[denomPos - 1]];
				else
					amount = inf;

				f[denomPos][currentValue] = Math.min(
						f[denomPos - 1][currentValue], 1 + amount);
			}
		}

		for (int i = 0; i < m + 1; i++)
		{
			for (int j = 0; j < n + 1; j++)
				System.out.print(f[i][j] + " ");
			System.out.println();
		}
		return f[m][n];
	}

	public static void main(String[] args)
	{
		int[] coins = { 1, 2, 3 };
		CoinsChange mc = new CoinsChange();
//		System.out.println(mc.coinChnageAllCombination(coins, 12));
//		System.out.println(mc.coinChnageWays(coins, 12));
		System.out.println(mc.minCoinChange(coins, 12));
	}

}
