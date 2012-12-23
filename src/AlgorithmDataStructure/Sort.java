package AlgorithmDataStructure;

public class Sort
{
	public static void main(String[] args)
	{

		int[] A = {123,45,56,4,76,82,44,7,1,23};
		Sort s = new Sort();
		s.quickSort(A);
		for (int i = 0;i<A.length;i++)
			System.out.print(A[i]+" ");
		
//		s.countSort(A,124);
	}
	
	public void quickSort(int[] a)
	{
		if (a.length == 0)
			return;
		quickSortHelper(a,0,a.length-1);
	}
	private void quickSortHelper(int[] num, int l, int r)
	{
		if (l > r)
			return;

		int pivot = num[r];
		int m = l - 1;

		for (int i = l; i < r; i++)
		{
			if (num[i] < pivot)
			{
				m++;
				// swap num[m] and num[i]
				int temp = num[m];
				num[m] = num[i];
				num[i] = temp;
			}
		}
		m++;
		int temp = num[m];
		num[m] = num[r];
		num[r] = temp;

		quickSortHelper(num, l, m - 1);
		quickSortHelper(num, m + 1, r);
	}
	
	public void countSort(int[] a, int k)
	{
		CountSort cs = new CountSort();
		int[] B = cs.countSort(a,k); //new int[a.length+1];
				
		for (int i = 1;i<B.length;i++)
			System.out.println(B[i]);
	}
	public void printArray(int[] a)
	{
		for (int i = 0;i<a.length;i++)
		{
			System.out.print(a[i] + " ");
		}
	}
}

class CountSort
{
	private int i;

	/**
	 * count sort
	 * @param A input array
	 * @param B output array
	 * @param k the range of numbers in A
	 */
	public int[] countSort(int[] A, int k)
	{
		int n = A.length;
		int[] c = new int[k];
		int[] B = new int[n+1];
		/**
		 * for each element in A, 
		 * increase the the count number by 1 
		 * in the corresponding position in c
		 * i.e. A[0] = 3, A[1]=3;then c[3]=2; 
		 */
		for (int i = 0;i<n;i++)	
			c[A[i]] = c[A[i]]+1;
		
		for (int j = 1;j<k;j++)
			c[j] += c[j-1];
		
		for (int j = n-1;j>=0;j--)
		{
			B[c[A[j]]] = A[j];
			c[A[j]] -= 1;
		}
		return B;
	}
}

class MergeSort
{
	public void mergeSort(int[] a, int p, int r)
	{
		int left = p;
		int right = r;
		if (left == right) return;
		//divide
		int middle = (left + right)/2;
		mergeSort(a, left, middle);
		mergeSort(a, middle+1,right);
		
		//merge
		int end_low = middle;
		int start_high = middle+1;
		
		while(left<=end_low && start_high<=right)
		{
			if (a[left]<=a[start_high])
				left++;
			else
			{
				int temp = a[start_high];
				for (int k = start_high-1;k>=left;k--)
				{
					a[k+1] = a[k];
				}
				a[left] = temp;
				left++;
				end_low++;
				start_high++;
			}
		}
	}
}

//class QuickSort
//{
//	/**
//	 * 
//	 * @param A The array to be sorted
//	 * @param p	The start position 
//	 * @param r	The end position
//	 */
//	public void quickSort(int[] A, int p, int r)
//	{
//		if (p<r)
//		{
//			int q = partition(A, p, r);
//			quickSort(A, p, q-1);
//			quickSort(A, q+1, r);
//		}
//	}
//	public int partition(int[] A, int p, int r)
//	{
//		int prefix = p - 1;
//		int pivot = A[r];
//		for (int j = p;j<r;j++)
//		{
//			if (A[j] <= pivot)
//			{
//				prefix++;
//				/** exchange A[prefix] and A[j]**/
//				int temp = A[prefix];
//				A[prefix] = A[j];
//				A[j] = temp;
//			}
//		}
//		int temp = A[prefix + 1];
//		A[prefix + 1] = A[r];
//		A[r] = temp;
//		
//		return prefix + 1;
//	}
//}
