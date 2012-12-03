package AlgorithmDataStructure;

/***
 * n=4 and k=3 . team name can be formed by four digits 1,2,3,4 so n=4 now make
 * team number using any three digits so that b1<b2<b3. Basically print numbers
 * which are in form b1<b2<b3..e.g. 123,124,234 etc
 * 
 * @author Zheng Lu
 * 
 */
public class PermuatationCombination
{
	public int n = 0;

	/**
	 * 
	 * @param nums
	 * @param k
	 *            start index of the array nums
	 * @param m
	 */
	public void totalPermuation(int[] nums, int k, int m)
	{
		if (k > m)
		{
			for (int i = 0; i <= m; i++)
				System.out.print(nums[i] + " ");
			System.out.println();
			n++;
		} else
		{
			for (int i = k; i <= m; i++)
			{
				int temp = nums[k];
				nums[k] = nums[i];
				nums[i] = temp;

				totalPermuation(nums, k + 1, m);

				temp = nums[k];
				nums[k] = nums[i];
				nums[i] = temp;

			}
		}
	}

	/**
	 * none recursive with a bit vector
	 * 
	 * @param nums
	 * @param k
	 */
	public void combinations(int[] nums, int k)
	{
		int n = nums.length;
		int[] b = new int[n];
		for (int i = 0; i < k; i++)
			b[i] = 1;

		// detect '10'
		int index = n - 1;
		while (index >= 0)
		{
			printArray(nums, b, n);
			for (int i = n - 1; i > 0; i--)
			{
				if (b[i] == 0 && b[i - 1] == 1)
				{
					index = i;
					break;
				} else
					index--;
			}
			if (index >= 0)
			{
				b[index] = 1;
				b[index - 1] = 0;
			}
		}
	}

	private void printArray(int[] nums, int[] b, int n)
	{
		for (int i = 0; i < n; i++)
			if (b[i] == 1)
				System.out.print(nums[i] + " ");

		System.out.println();
	}
	public void totalCombinations(int[] nums)
	{
		int nCnt = nums.length;
		int nBit = 1 << nCnt;

		for (int i = 1; i <= nBit; i++)
		{
			for (int j = 0; j < nCnt; j++)
			{
				if ((1 << j & i) != 0)
				{
					System.out.print(nums[j]);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		int[] nums = { 1, 2, 3, 4};

		PermuatationCombination c = new PermuatationCombination();
//		c.totalCombinations(nums);
		c.combinations(nums, 2);
	}
}
