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
				end++;
			} else
			{
				end++;
			}
		}
//		for (int i = start + 1; i < end; i++)
//			a[i] = -1;

		return start + 1;
	}

	public static void main(String[] args)
	{
		
	}
}
