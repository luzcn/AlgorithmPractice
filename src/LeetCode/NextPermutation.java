package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
 * 1,2,3 1,1,5 → 1,5,1
 * 
 * @author Zheng Lu
 * @date Oct 25, 2012
 * 
 */
public class NextPermutation
{

	public void nextPermutation(int[] nums)
	{
		int n = nums.length;
		if (n < 2)
			return;

		for (int i = n - 1; i > 0; i--)
		{
			if (nums[i] > nums[i - 1])
			{
				swapRange(nums, i, n - 1);
				
				for (int j = i; j < n; j++)
				{
					if (nums[j] > nums[i-1])
					{
						swap(nums, i - 1, j);
						break;
					}
				}
			}
		}
		swapRange(nums, 0, n-1);
	}

	private void swapRange(int[] nums, int start, int end)
	{
		for (int i = start, j = end; i < j; i++, j--)
			swap(nums, i, j);
	}

	private void swap(int nums[], int i, int j)
	{
		// nums[i] = nums[i] ^ nums[j];
		// nums[j] = nums[i] ^ nums[j];
		// nums[i] = nums[i] ^ nums[j];

		nums[i] = nums[j] - nums[i];
		nums[j] = nums[j] - nums[i];
		nums[i] = nums[j] + nums[i];
	}

	public static void main(String[] args)
	{
		int[] num = { 1, 2, 3 };
		NextPermutation np = new NextPermutation();
		np.nextPermutation(num);
		System.out.println(num[0]);
	}

}
