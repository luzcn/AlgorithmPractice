package Epic;

import java.util.ArrayList;

/**
 * @author Zheng Lu
 * @date Oct 2, 2012
 * 
 */
public class PrintPhoneNumber
{
	public void printPhoneNumber()
	{
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++)
			nums[i] = i;

		int[] exception = {5,6,7};
		
		ArrayList<ArrayList<Integer>> solution = getPhoneNumberRec(nums, 4, 0,
				new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>());
		
		for (ArrayList<Integer> list:solution)
			System.out.println(list);
	}

	private ArrayList<ArrayList<Integer>> getPhoneNumberRec(int[] arr, int len,
			int index, ArrayList<Integer> current,
			ArrayList<ArrayList<Integer>> solution)
	{
		if (current.size() == len)
		{
			if (!current.contains(4))
			{
				solution.add(new ArrayList<Integer>(current));
				return solution;
			} else if (current.get(0) == 4)
			{
				solution.add(new ArrayList<Integer>(current));
				return solution;
			} else
				return solution;
		} else
		{
			while (index < arr.length)
			{
				current.add(arr[index]);
				getPhoneNumberRec(arr, len, index + 1, current, solution);
				index++;
				current.remove(current.size() - 1);
			}
		}
		return solution;
	}

	public static void main(String[] args)
	{
		PrintPhoneNumber ppn = new PrintPhoneNumber();
		ppn.printPhoneNumber();
	}

}
