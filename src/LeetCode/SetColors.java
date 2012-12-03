package LeetCode;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author Zheng Lu
 * @date Nov 20, 2012
 * 
 */
public class SetColors
{
	public void sortColors(int[] A)
	{
		int n = A.length;
		if (n == 0)
			return;

		int p0 = 0;
		int p = 0;
		int p2 = n - 1;

		while (p0 < n && A[p0] == 0)
			p0++;
		while (p2 >= 0 && A[p2] == 2)
			p2--;

		p = p0;

		while (p <= p2)
		{
			if (A[p] == 0)
			{
				int temp = A[p0];
				A[p0] = 0;
				A[p] = temp;
				p0++;
				p++;
			} else if (A[p] == 2)
			{
				int temp = A[p2];
				A[p2] = 2;
				A[p] = temp;
				p2--;
			} else
				p++;
		}
	}

	public static void main(String[] args)
	{

	}

}
