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

	public void nextPermutation(int[] num)
	{
		
	}

	private int[] reverse(int[] num)
	{
		int[] reverse = new int[num.length];
		for (int i = 0;i<num.length;i++)
			reverse[i] = num[num.length-1-i];
		return reverse;
	}
	public static void main(String[] args)
	{
		int[] num = {1,2,3};
		NextPermutation np = new NextPermutation();
		
		np.nextPermutation(num);
	
	}

}
