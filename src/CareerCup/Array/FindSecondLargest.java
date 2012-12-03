package CareerCup.Array;

/***
 * find the 2nd largest number in an array
 * implement in O(N) time and O(2) space
 * @author Zheng Lu
 *
 */

public class FindSecondLargest
{
	public static int findSecond(int[] num)
	{
		int first = 0;
		int second = 0;
		
		for (int i = 0;i<num.length;i++)
		{
			if (first < num[i])
			{
				second = first;
				first = num[i];
			}
			else if (second < num[i])
				second = num[i];
		}
		
		return second;
	}
	
	
	public static void main(String[] args)
	{
		int[] num = {12,34,23,4545,45,68,89,325,3};
		
		System.out.println(findSecond(num));
	}

}
