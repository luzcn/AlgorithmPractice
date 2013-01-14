package CareerCup.DynamicProgram;

/**
 * 0-1 knapsack problem
 * 
 * You have a knapsack that has capacity (weight) C.
 * 
 * You have several items I1,É,In.
 * 
 * Each item Ij has a weight wj and a benefit bj.
 * 
 * You want to place a certain number of copies of each item Ij in the knapsack
 * so that:
 * 
 * The knapsack weight capacity is not exceeded and the total benefit is
 * maximal.
 * 
 * @author annie
 * 
 * @date Jan 11, 2013
 */
public class KnapsackProblem
{

	public int knapsack(int capacity, int[] value, int[] weight)
	{
		if (capacity == 0 || value.length == 0 || weight.length == 0)
			return 0;

		// return knapsackRec(value, weight, capacity, value.length);
		return knapsackDP(value, weight, capacity);
	}

	private int knapsackRec(int[] v, int[] w, int c, int n)
	{
		// if the capacity is 0 or all items have been checked
		// return 0
		if (c <= 0 || n == 0)
			return 0;

		// if current item weight is larger than capacity c
		// then this item cannot be included in the optimal solution,
		// skip this item
		if (w[n - 1] > c)
			return knapsackRec(v, w, c, n - 1);
		else
			// we have two choices here,
			// 1. take this item, add up the value[i] and decrease the capacity
			// with c - w[i] 2. do not take this item, simply move to next item
			return Math.max(v[n - 1] + knapsackRec(v, w, c - w[n - 1], n - 1),
					knapsackRec(v, w, c, n - 1));
	}

	private int knapsackDP(int[] v, int[] w, int c)
	{
		int n = v.length;
		int[][] m = new int[c + 1][n + 1];
		m[0][0] = 0;

		// for (int i = 0; i<= n;i++)
		// m[0][i] = 0;
		// for (int j = 0;j <= c; j++)
		// m[0][j] = 0;

		for (int i = 1; i <= c; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (i >= w[j - 1])
					m[i][j] = Math.max(v[j - 1] + m[i - w[j - 1]][j - 1],
							m[i][j - 1]);
				else
					m[i][j] = m[i][j - 1];
			}
		}

		return m[c][n];

	}

	public static void main(String[] args)
	{
		int[] value = { 60, 100, 120 };
		int[] weight = { 10, 20, 30 };
		int capacity = 50;

		KnapsackProblem kp = new KnapsackProblem();
		System.out.println(kp.knapsack(capacity, value, weight));
	}

}
