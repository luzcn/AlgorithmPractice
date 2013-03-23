package LeetCode;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ... 1 is read off as "one 1" or 11. 11 is read off
 * as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211. Given an
 * integer n, generate the nth sequence. Note: The sequence of integers will be
 * represented as a string.
 * 
 * @author Zheng Lu Sep 26, 2012
 * 
 */
public class CountAndSay
{
	public static String countAndSay(int n)
	{
		String number = "1";
		for (int i = 1; i <= n; i++)
		{
			String newNumber = new String();

			int j = 0;
			while (j < number.length())
			{
				char current = number.charAt(j);
				int count = 0;
				while (j < number.length() && current == number.charAt(j))
				{
					count++;
					j++;
				}
				newNumber += "" + count + current;
			}
			number = newNumber;
		}
		return number;
	}

	public static void main(String[] args)
	{
		System.out.println(countAndSay(5));
	}
}
