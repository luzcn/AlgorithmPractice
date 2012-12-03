package LeetCode;

import java.util.ArrayList;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ... 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence. 
 * Note: The sequence of integers will be represented as a string. 
 * 
 * @author Zheng Lu
 * Sep 26, 2012
 *
 */
public class CountAndSay
{
	public static String countAndSay(int n)
	{
		String countAndSayStr = "";
		String inputStr = Integer.toString(n);
		int[] arr = new int[inputStr.length()];
		int count = 1;
		int element = 0;
		
		for (int i = 0;i<inputStr.length();i++)
		{
			arr[i] = Character.getNumericValue(inputStr.charAt(i));
			//Integer.parseInt(inputStr.substring(i, i+1));
		}
		for (int i = 0;i<arr.length-1;i++)
		{
			element = arr[i];
			if (element == arr[i+1])
				count++;
			else
			{
				countAndSayStr += count+""+element +" ";
				count = 1;
				element = arr[i+1];
			}
		}
		countAndSayStr += count+""+element +".";
		return countAndSayStr;
	}
	public static void main(String[] args)
	{
		System.out.println(countAndSay(12333354));
	}

}
