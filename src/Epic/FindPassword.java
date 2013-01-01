package Epic;

import java.util.ArrayList;

/**
 * Find all the possible passwords, given the length of the password and that it
 * is a well ordered number (159 is well-ordered as 1<5<9)
 * 
 * @author Zheng Lu Sep 24, 2012
 * 
 */
public class FindPassword
{

	public ArrayList<ArrayList<Integer>> findWellOrder(int len)
	{
		// findNonRec(len);
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		if (len == 0)
			return solution;
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		findRec(nums, len, solution, new ArrayList<Integer>(), 0);
		
		System.out.println(solution);
		return solution;

	}

	private ArrayList<ArrayList<Integer>> findRec(int[] arr, int len,
			ArrayList<ArrayList<Integer>> solution,
			ArrayList<Integer> currentSol, int index)
	{
		if (currentSol.size() == len)
		{
			solution.add(new ArrayList<Integer>(currentSol));
			return solution;
		}
		else
		{
			for (int i = index; i < arr.length; i++)
			{
				currentSol.add(arr[i]);
				findRec(arr, len, solution, currentSol, i + 1);
				currentSol.remove(currentSol.size() - 1);
			}
		}
		return solution;
	}

	private void findNonRec(int len)
	{
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int i = 0; i <= nums.length - len; i++)
		{
			for (int j = i + 1; j <= nums.length - (len - 1); j++)
			{
				System.out.print(nums[i]);
				for (int k = 0; k < len - 1; k++)
					System.out.print(nums[j + k]);

				System.out.println();
			}
		}
	}

	public static void main(String[] args)
	{
		FindPassword fp = new FindPassword();
		fp.findWellOrder(5);
	}

}
