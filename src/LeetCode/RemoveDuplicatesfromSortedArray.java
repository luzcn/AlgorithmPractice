package LeetCode;

/**
 * @author Zheng Lu
 * @date Oct 29, 2012
 * 
 */
public class RemoveDuplicatesfromSortedArray
{
	public int removeDuplicates(int[] a)
	{
		if (a.length == 0)
			return 0;
		if (a.length == 1)
			return 1;

		int start = 0;
		int end = 1;

		while (end < a.length)
		{
			if (a[start] != a[end])
			{
				a[start + 1] = a[end];
				start++;
			}
			end++;
		}

		return start + 1;
	}

	public int removeDuplicates2(int[] A)
	{
		if (A.length < 2)
			return A.length;

		int s = 0;
		int e = s + 1;
		int count = 1;

		while (e < A.length)
		{
			if (A[s] == A[e])
			{
				count++;
				if (count <= 2)
				{
					s++;
					A[s] = A[e];
				}
			}
			else
			{
				count = 1;
				s++;
				A[s] = A[e];
			}
			e++;
		}

		return s + 1;
	}

	public static void main(String[] args)
	{

	}
}
