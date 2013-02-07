package LeetCode;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author Zheng Lu
 * @date Oct 30, 2012
 * 
 */
public class RemoveElement
{
	public static int removeElement(int[] a, int elem)
	{
		if (a.length == 0)
			return 0;
		if (a.length == 1)
		{
			if (a[0] == elem)
				return 0;
			else
				return 1;
		}
		int l = 0;
		int r = a.length - 1;

		while (l <= r)
		{
			if (a[l] == elem)
			{
				while (r >= 0 && a[r] == elem)
				{
					r--;
				}
				if (r > l)
				{
					a[l] = a[r];
					l++;
					r--;
				}
			} else
				l++;

		}
		return l;
	}

	public static void main(String[] args)
	{
		int[] a = { 3 };
		System.out.println(removeElement(a, 3));
	}

}
