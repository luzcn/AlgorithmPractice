package LeetCode;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * @author annie
 * 
 * @date Dec 20, 2012
 */
public class BestToByAndSellStock
{

	/***
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 * 
	 * @param p
	 * @return
	 */
	public int maxProfit1(int[] p)
	{
		int size = p.length;
		if (size == 0)
			return 0;

		int min = p[0];
		int maxProfit = 0;
		int bestbuy = 0;
		int bestsell = 0;

		for (int i = 0; i < size; i++)
		{
			if (p[i] < min)
			{
				min = p[i];
				bestbuy = i;
			}
			else
			{
				int profit = p[i] - min;
				if (profit > maxProfit)
				{
					maxProfit = profit;
					bestsell = i;
				}
			}
		}

		System.out.println(bestbuy + " " + bestsell);
		return maxProfit;
	}

	/***
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 * The answer is simple: Find all the increasing subsequence; the distance
	 * between these numbers is profit
	 */
	public int maxProfit2(int[] p)
	{
		int n = p.length;
		if (n == 0)
			return 0;
		int profit = 0;
		for (int i = 1; i < n; i++)
		{
			if (p[i] > p[i - 1])
				profit += p[i] - p[i - 1];
		}
		return profit;
	}

	/**
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 * 
	 * @param p
	 * @return
	 */
	public int maxProfit3(int[] p)
	{
		int n = p.length;
		if (n == 0)
			return 0;

		int current_maxprofit = 0;
		int min = p[0];
		int[] maxprofits_left = new int[n];

		// from left to right compute the current max profit for each i
		for (int i = 1; i < n; i++)
		{
			if (p[i] < min)
			{
				min = p[i];
			}
			else
			{
				int profit = p[i] - min;
				if (profit > current_maxprofit)
					current_maxprofit = profit;
			}
			maxprofits_left[i] = current_maxprofit;
		}

		// from right to left, again, compute the current max profit for each i
		int[] maxprofits_right = new int[n];
		int highest = p[n - 1];
		current_maxprofit = 0;
		for (int i = n - 2; i >= 0; i--)
		{
			if (p[i] > highest)
			{
				highest = p[i];
			}
			else
			{
				int profit = highest - p[i];
				if (profit > current_maxprofit)
					current_maxprofit = profit;
			}
			maxprofits_right[i] = current_maxprofit;
		}

		int totalMaxProfit = 0;
		for (int i = 0; i < n; i++)
		{
			if (maxprofits_right[i] + maxprofits_left[i] > totalMaxProfit)
				totalMaxProfit = maxprofits_right[i] + maxprofits_left[i];
		}

		for (int i = 0; i < n; i++)
			System.out.print(maxprofits_left[i] + "  ");
		System.out.println();
		for (int i = 0; i < n; i++)
			System.out.print(maxprofits_right[i] + "  ");
		System.out.println();

		return totalMaxProfit;
	}

	public static void main(String[] args)
	{
		BestToByAndSellStock bts = new BestToByAndSellStock();
		int[] p = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9 };
		for (int i = 0; i < p.length; i++)
			System.out.print(p[i] + "  ");
		System.out.println();

		bts.maxProfit3(p);
	}

}
