package LeetCode;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space to hold additional elements from
 * B. The number of elements initialized in A and B are m and n respectively.
 * 
 * @author Zheng Lu
 * @date Oct 18, 2012
 * 
 */
public class MergeTwoSortedArray
{
	public void merge(int A[], int m, int B[], int n)
	{
		int totalLen = A.length;
		if (totalLen == 0)
			return;

		int lastPos = totalLen - 1;
		int lastElementInA = m - 1;
		int lastElementInB = n - 1;

		while (lastElementInA >= 0 && lastElementInB >= 0)
		{
			if (A[lastElementInA] >= B[lastElementInB])
			{
				A[lastPos] = A[lastElementInA];
				lastElementInA--;
			} else
			{
				A[lastPos] = B[lastElementInB];
				lastElementInB--;
			}
			lastPos--;
		}

		while (lastElementInA >= 0)
		{
			A[lastPos] = A[lastElementInA];
			lastElementInA--;
			lastPos--;
		}
		while (lastElementInB >= 0)
		{
			A[lastPos] = B[lastElementInB];
			lastElementInB--;
			lastPos--;
		}
	}

	public static void main(String[] args)
	{

	}

}
