package LeetCode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Zheng Lu
 * @date Nov 13, 2012
 * 
 */
public class SearchInRotatedSortedArray
{
	public int searchInRotatedSortedArray(int[] A, int t)
	{
		int l = 0;
		int r = A.length - 1;

		while (l <= r)
		{
			int m = (l + r) / 2;
			if (t == A[m])
				return m;
			else if (A[l] <= A[m])
			{
				if (t > A[m])
					l = m + 1;
				else if (t >= A[l])
					r = m - 1;
				else
					l = m + 1;
			}
			else
			// A[l] > A[m]
			{
				if (t < A[m])
					r = m - 1;
				else if (t <= A[r])
					l = m + 1;
				else
					r = m - 1;
			}
		}
		return -1;
	}

	public int search(int[] A, int target)
	{
		int n = A.length;
		if (n == 0)
			return -1;

		int l = 0;
		int r = n - 1;

		// binary search
		while (l <= r)
		{
			int mid = (l + r) / 2;
			if (target == A[mid])
				return mid;
			else if (target < A[mid])
			{
				if (target == A[l])
					return l;
				if (target == A[r])
					return r;
				else if (target < A[l])
				{
					if (A[mid] > A[l])
						l = mid + 1;
					else
						r = mid - 1;
				}
				else
					r = mid - 1;
			}
			else
			{
				if (target == A[r])
					return r;
				if (target == A[l])
					return l;
				else if (target > A[r])
				{
					if (target > A[l])
					{
						if (A[mid] > A[l])
							l = mid + 1;
						else
							r = mid - 1;
					}
					else
						l = mid + 1;
				}
				else
					l = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] arr = {2,2,3,2,2,2,2};
		SearchInRotatedSortedArray sr = new SearchInRotatedSortedArray();
//		System.out.println(sr.search(arr, 8));
		System.out.println(sr.searchInRotatedSortedArray(arr, 3));
	}

}
