package CareerCup.DynamicProgram;

/**
 * Given a rod of length n inches and an array of prices that contains prices of
 * all pieces of size smaller than n. Determine the maximum value obtainable by
 * cutting up the rod and selling the pieces. For example, if length of the rod
 * is 8 and the values of different pieces are given as following, then the
 * maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * 
 * length | 1 2 3 4 5 6 7 8 -------------------------------------------- price |
 * 1 5 8 9 10 17 17 20
 * 
 * And if the prices are as following, then the maximum obtainable value is 24
 * (by cutting in eight pieces of length 1)
 * 
 * 
 * length | 1 2 3 4 5 6 7 8 -------------------------------------------- price |
 * 3 5 8 9 10 17 17 20
 * 
 * @author annie
 * 
 * @date Jan 11, 2013
 */
public class CutRod
{

	public int cutRod(int[] price)
	{
		if (price.length == 0)
			return 0;
		if (price.length == 1)
			return price[0];

		 return cutRodRec(price, price.length);
//		return cutRodDP(price);
	}

	private int cutRodRec(int[] p, int n)
	{
		if (n <= 0)
			return 0;

		int max = 0;
		for (int i = 0; i < n; i++)
			max = Math.max(max, p[i] + cutRodRec(p, n - 1 - i));

		return max;
	}

	private int cutRodDP(int[] p)
	{
		int n = p.length;
		int[] newPrice = new int[n];

		newPrice[0] = p[0];
		int max = 0;
		for (int i = 1; i < n; i++)
		{
			max = p[i];
			for (int j = 0; j < i / 2; j++)
			{
				if (max < p[j] + newPrice[i - j - 1])
					max = p[j] + newPrice[i - j - 1];
			}
			newPrice[i] = max;
		}

		return newPrice[n - 1];
	}

	public static void main(String[] args)
	{
		CutRod cr = new CutRod();

		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(cr.cutRod(price));
	}

}
