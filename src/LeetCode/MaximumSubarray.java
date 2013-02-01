package LeetCode;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author annie
 * 
 * @date Dec 22, 2012
 */
public class MaximumSubarray
{

	public int maxSubArray(int[] A)
	{
		int n = A.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return A[0];

		int currentSum = 0;
		int maxSum = A[0];
		for (int i = 0; i < n; i++)
		{
			currentSum += A[i];
			if (currentSum > maxSum)
				maxSum = currentSum;
			
			if (currentSum < 0)
				currentSum = 0;
		}
		return maxSum;
	}

	public static void main(String[] args)
	{
	}

}
