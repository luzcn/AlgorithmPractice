package CareerCup.Array;

import java.util.Arrays;

/**
 * @author Zheng Lu
 * Sep 25, 2012
 *
 */
public class FindKthSmallest
{

	public static int find(int[] a, int k)
	{
		return findKSmallest(a, 0, a.length-1, k);
	}
	
	private static int findKSmallest(int[] a, int p, int r, int k)
	{
		if (p==r) 
			return a[r];
		int q = partition(a, p, r);
		int leftlen = q-p+1;
		if (k == leftlen)
			return a[q];
		else if (k < leftlen)
			return findKSmallest(a, p, q-1, k);
		else
			return findKSmallest(a, q+1, r, k-leftlen);
	}
	private static int partition(int[] A, int p, int r)
	{
		int prefix = p - 1;
		int pivot = A[r];
		for (int j = p;j<r;j++)
		{
			if (A[j] <= pivot)
			{
				prefix++;
				/** exchange A[prefix] and A[j]**/
				int temp = A[prefix];
				A[prefix] = A[j];
				A[j] = temp;
			}
		}
		int temp = A[prefix + 1];
		A[prefix + 1] = A[r];
		A[r] = temp;
		
		return prefix + 1;
		
		/*int prefix = p-1;
		int pivot = a[r];	//or any randomized
		for (int i = p;i<r;i++)
		{
			if (a[i]<=pivot)
			{
				prefix++;
				int temp = a[prefix];
				a[prefix]=a[i];
				a[i] = temp;
			}
			int temp = a[prefix+1];
			a[prefix+1]=a[r];
			a[r] = temp;
		}
		
		return prefix+1;*/
	}
	
	public static void main(String[] args)
	{
		int[] a = {23,45,1,34,68,8,22,21,4,89};
		
		System.out.println(FindKthSmallest.find(a, 7));
		
//		Arrays.sort(a);
		for (int i = 0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}

}
