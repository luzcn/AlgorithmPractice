package LeetCode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
 * @author Zheng Lu
 * Sep 25, 2012
 *
 */
public class ClimStairs
{

	public static int climbStairs(int n)
	{
		if (n==1) return 1;
		if (n==2) return 2;
		else
			return (climbStairs(n-1) + climbStairs(n-2));
	}
	
	public static int climbStairs2(int n)
	{
		if (n==1) return 1;
		if (n==2) return 2;
		int a = 1;
		int b = 2;
		for (int i = 2;i<n;i++)
		{
			int c = a+b;
			a = b;
			b = c;
		}
		return b;
	}
	public static void main(String[] args)
	{
		System.out.println(ClimStairs.climbStairs(10));
		System.out.println(ClimStairs.climbStairs2(10));
	}
}
