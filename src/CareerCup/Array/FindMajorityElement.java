package CareerCup.Array;

/**
 * In an unsorted array, find one element which appears more than half of the
 * size of the array
 * 
 * @author annie
 * 
 * @date Feb 4, 2013
 */
public class FindMajorityElement
{
	public int findMajority(int[] nums)
	{
		int count = 0;
		int majorityElement = 0;

		for (int i = 0; i < nums.length; i++)
		{
			if (count == 0)
				majorityElement = nums[i];
			if (nums[i] == majorityElement)
				count++;
			else
				count--;
		}

		// return me;
		count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == majorityElement)
				count++;
		}
		if (count > nums.length / 2)
			return majorityElement;
		else
			return -1;
	}

	public static void main(String[] args)
	{

	}

}
