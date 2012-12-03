package LeetCode;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author Zheng Lu
 * @date Nov 6, 2012
 * 
 */
public class SearchForRange
{

	public int[] searchRange(int[] a, int target)
	{
		int[] result = new int[2];
		int index1 = a.length;
		int index2 = 0;
		boolean isFind = false;

		result[0] = -1;
		result[1] = -1;

		if (a.length == 0)
			return result;

		int l = 0;
		int r = a.length - 1;

		while (l <= r)
		{
			int mid = (l + r) / 2;
			if (a[mid] == target)
			{
				if (mid > index2)
					index2 = mid;

				if (mid < index1)
					index1 = mid;

				isFind = true;
				l = mid + 1;			//check right side
			} else if (a[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}

		l = 0;
		r = a.length - 1;
		while (l <= r)
		{
			int mid = (l + r) / 2;

			if (a[mid] == target)
			{
				if (mid > index2)
					index2 = mid;

				if (mid < index1)
					index1 = mid;

				isFind = true;	
				r = mid - 1;			//check left side
			} else if (a[mid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}

		if (isFind)
		{
			result[0] = index1;
			result[1] = index2;
		}

		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
