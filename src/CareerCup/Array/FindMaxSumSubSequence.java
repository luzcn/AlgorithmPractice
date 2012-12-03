package CareerCup.Array;

/**
 * Problem: Given an array on n integers, find a contiguous sub-array with
 * largest sum. Example: For an array of following elements { -1, 2, -4, 1, 3,
 * -2 }, the sub-sequence with largest sum is 1,3 Solution
 * 
 * the key idea is: we set sum = 0 at first; add each each element with this sum
 * from the first element. Once any element makes this sum be a negative, we
 * immediately set sum as 0; since this sum will contribute noting to the next
 * sum.
 * 
 * @author Zheng Lu
 * 
 */
public class FindMaxSumSubSequence
{
	public static void main(String[] args)
	{
		int[] A = { 31, -41, 59, 26, -53, 58, 97, -93, -23, 84 };
		FindMaxSumSubSequence fm = new FindMaxSumSubSequence();
		fm.findmaxseq(A);
		// System.out.println(fm.findSum(A, 0,A.length-1));
	}

	/**
	 * Divide-conquer
	 * 
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public int findSum(int[] a, int left, int right)
	{
		if (left > right)
			return 0;
		if (left == right)
			return (Math.max(0, a[left]));

		int sum = 0;
		int lmax = 0;
		int rmax = 0;

		int middle = (left + right) / 2;
		for (int i = middle; i >= left; i--)
		{
			sum += a[i];
			lmax = Math.max(sum, lmax);
		}
		sum = 0;
		for (int i = middle + 1; i <= right; i++)
		{
			sum += a[i];
			rmax = Math.max(rmax, sum);
		}
		return Math.max(lmax + rmax, Math.max(findSum(a, left, middle),
				findSum(a, middle + 1, right)));

	}

	/**
	 * Scan the array in linear time
	 * 
	 * @param a
	 */
	public void findmaxseq(int[] a)
	{
		int sum = 0;
		int maxsum = 0;
		int start = 0; // the max subsequence start position
		int end = 0; // the max subsequence end position

		for (int i = 0; i < a.length; i++)
		{
			/*
			 * newsum = Math.max((newsum+a[i]),0); sum = Math.max(sum, newsum);
			 */
			sum = sum + a[i];
			if (maxsum < sum)
			{
				maxsum = sum;
				end = i;
			} else if (sum < 0)
			{
				sum = 0;
				start = i + 1;
			}
		}
		System.out.println("max = " + maxsum);

		System.out.println(start + "    " + end);
	}

}
