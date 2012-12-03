package CareerCup.DynamicProgram;

/**
 * Given an array of numbers or a strings
 * find a longest increasing subsequence. 
 * @author Zheng Lu
 * Sep 24, 2012
 *
 */
public class LIS
{

	/***
	 * O(n^2) solution to find the lenght of the lis.
	 * for i=1..n-1
	 * dp[i]=max(dp[j])+1 for each j = 1..i-1;
	 * @param nums
	 * @return
	 */
	public static int findLisLength(int[] nums)
	{
		int length = 0;
		int n = nums.length;
		
		int[] dp = new int[n];
		for (int i = 0;i<n;i++)
			dp[i]=1;
		
		for (int i = 1;i<n;i++)
		{
			length = dp[i];
			for (int j = 0;j<i;j++)
			{
				if (nums[i]>nums[j] && dp[j]>length)
					length = dp[j];
			}
			dp[i]=length+1;
		}
		
		for (int i = 0;i<n;i++)
			System.out.print(dp[i]+"  ");
		
		return length;
	}
	
	public static int[] findLIS(int[] A)
	{
		int n= A.length;
		int[] M = new int[n];
		int[] P = new int[n];
		int L = 1;
		M[0]=0;
		P[0]=-1;
		/**
		 * i: index in A
		 * j: index in M
		 */
		for (int i = 1;i<n;i++)
		{
			/**find the largest positive j<=L, s.t. A[M[j]]<A[i], 
			  set j=-1, if cannot find such j*/
			int j = bSearch(M, A, i, L);
			
			if (j == -1) //cannot find find such j
				P[i]=-1; //set the position of the predecessor as -1
			else
				P[i]=M[j];	
			
			if (j==L-1 || A[i]<A[M[j+1]])
			{
				M[j+1] = i;
				L = Math.max(L, j+2);
			}
		}
		
		int[] lis = new int[L];
		n = L-1;
		int p=M[n];	//read the last element from M array
		while(n>=0)
		{
			lis[n] = A[p];
			p = P[p];	//read the predecessor elements from P array
			n--;
		}
		
		for (int i = 0;i<L;i++)
			System.out.print(lis[i] + "  ");
		return lis;
	}
	
	/**
	 * 
	 * @param M The array to store the position K (in the given array) of the LIS
	 * @param A	The given array
	 * @param i	Current index in given array
	 * @param L The length of LIS
	 * @return
	 */
	private static int bSearch(int[] M,int[] A, int i, int L)
	{
		int left = 0;
		int right = L-1;
		
		while(left<=right)
		{
			int mid = (left+right)/2;
			
			if (A[M[mid]]<=A[i])
				left = mid+1;
			else
				right = mid-1;
		}
		return right;
	}
	
	public static void main(String[] args)
	{
		int[] a = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
//		int[] a = {5,15,1,9,3,11,14,13,18,5};
//		LIS.findLisLength(a);
		LIS.findLIS(a);
	}

}
