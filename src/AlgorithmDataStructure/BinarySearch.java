package AlgorithmDataStructure;

public class BinarySearch
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] A = {-2, -1, 0, 3, 5, 6, 7, 9, 12, 13, 14};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.binarySearchLoop(A, 0, A.length-1,9));
	}
	/**
	 * The recursive solution
	 * @param a	The input array
	 * @param left	the start position
	 * @param right	the end position
	 * @param key	the key value to find
	 * @return the position in the array, -1 as not found
	 */
	public int binarySearch (int[] a,int left, int right, int key)
	{
		if (right<left) return -1;
		else 
		{
			int mid = (left+right)/2;
			if (a[mid]>key)
			{
				return binarySearch(a, left, mid-1,key);	//search the left part
			}
			else if (a[mid]<key)
			{
				return binarySearch(a, mid+1,right,key);
			}
			else return mid;
		}
	}
	public int binarySearchLoop (int[] a,int left, int right, int key)
	{
//		if (right<left) return -1;
		while(right>=left)
		{
			int mid = (left+right)/2;
			if (a[mid]>key)	//search the left part
			{
				right = mid-1;
			}
			else if (a[mid]<key)
			{
				left = mid+1;
			}
			else	//found
				return mid;
		}
		return -1;
	}
}
