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

		int i = 0;
		int j = 0;
		int count = 0;
		int k = (m + n) / 2;
		int median = 0;

		return median;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
