package LeetCode;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 -> 2 [1,3,5,6], 2 -> 1 [1,3,5,6], 7-> 4
 * [1,3,5,6], 0-> 0
 * 
 * @author Zheng Lu
 * @date Nov 13, 2012
 * 
 */
public class SearchInsertPosition
{

	public int searchInsert(int[] A, int target)
	{
		int position = -1;
		if (A.length == 0)
			return 0;

		// binary search
		int l = 0;
		int r = A.length - 1;

		while (l <= r)
		{
			int mid = (l + r) / 2;
			if (target == A[mid])
			{
				position = mid;
				break;
			}
			else if (target > A[mid])
				l = mid + 1;
			else
				r = mid - 1;
		}
		if (position == -1)
			return r+1;
        else
		    return position;
	}

	public static void main(String[] args)
	{
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] arr = {1,3,5,6};
		
		System.out.println(sip.searchInsert(arr, 1));
		
	}

}
