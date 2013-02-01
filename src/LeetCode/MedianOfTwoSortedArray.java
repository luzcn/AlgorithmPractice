package LeetCode;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * @author annie
 * 
 * @date Jan 8, 2013
 */
public class MedianOfTwoSortedArray
{

	public int findMedianSortedArrays(int A[], int B[])
	{
		int m = A.length;
		int n = B.length;
		if (m == 0 || n == 0)
			return 0;
		int median = 0;

		
		return median;
	}

	private int getmedian(int[] nums, int n)
	{
		if (n % 2 == 0)
			return (nums[n / 2] + nums[n / 2 - 1]) / 2;
		else
			return nums[n / 2];
	}

	public static void main(String[] args)
	{

	}

}
