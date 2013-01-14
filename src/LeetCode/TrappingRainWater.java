package LeetCode;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * for input: A=[0,1,0,2,1,0,1,3,2,1,2,1] N= sizeof(A)
 * 
 * compute B[] where B[i]= Max(A[0..i]) Calculate Max bar height from node 0-i
 * B=[0,1,1,2,2,2,2,3,3,3,3,3]
 * 
 * compute C[] where C[i]= Max(A[i..N]) Calculate Max bar height from node i-n
 * C=[3,3,3,3,3,3,3,3,2,2,2,1]
 * 
 * compute D[] where D[i]=Min(B[i],C[I]) Calculate Min bar height between bar
 * before Vs after i, coz only this much water could fill
 * D=[0,1,1,2,2,2,2,3,2,2,2,1]
 * 
 * compute E[] where E[i]=D[i]-A[i] Subtract the height of bar i from Max water
 * bars could hold before Vs after E[i]=[0,0,1,0,1,2,1,0,0,1,0,0]
 * 
 * the answer is sum(E[i]) the complexity is O(N)
 * 
 * @author annie
 * 
 * @date Jan 11, 2013
 */
public class TrappingRainWater
{

	public int trap(int[] A)
	{
		int water = 0;
		int n = A.length;
		if (n < 3)
			return 0;

		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		int[] minMax = new int[n];

		int max = A[0];
		leftMax[0] = A[0];
		for (int i = 1; i < n; i++)
		{
			if (A[i] > max)
				max = A[i];
			leftMax[i] = max;
		}

		max = A[n - 1];
		rightMax[n - 1] = A[n - 1];
		for (int i = n - 2; i >= 0; i--)
		{
			if (A[i] > max)
				max = A[i];
			rightMax[i] = max;
		}

		for (int i = 0; i < n; i++)
			minMax[i] = Math.min(leftMax[i], rightMax[i]);

		// int[] traping = new int[n];
		for (int i = 0; i < n; i++)
		{
			// traping[i] = minMax[i] - A[i];
			// water += traping[i];
			water += minMax[i] - A[i];
		}

		return water;
	}

	public static void main(String[] args)
	{

	}

}
