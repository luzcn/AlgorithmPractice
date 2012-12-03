package LeetCode;

/**
 * @author Zheng Lu
 * Oct 1, 2012
 *
 */
public class FindMissingPositive
{
	public static int firstMissingPositive(int[] A) 
	{
		int n = A.length;
		return findMissingPositive(A, n);
	}

	/**
	 * Since we know each element is in the range of 1..n,
	 * n is the length of array. 
	 * The key idea is to move each element X to the position of X-1
	 * @param A
	 * @param n
	 * @return
	 */
	private static int findMissingPositive(int[] A, int n)
	{
		for (int i = 0;i<n;i++)
		{
			int t = A[i];
			
			while(t>0 && t<=n)
			{
				if (t == A[t-1])	//the element is in the position
					break;
				int temp = A[t-1];
				A[t-1]=t;
				t=temp;
			}
		}
		int i;
		for (i = 0;i<n;i++)
		{
			if (i!=A[i]-1)
				break;
		}
		return i+1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] A = {-1,1,2,4};
		
		System.out.println(firstMissingPositive(A));
		
		for (int i = 0;i<A.length;i++)
			System.out.print(A[i]+" ");
	}

}
