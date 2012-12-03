package Epic;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Given a number , say 263 , 
 * is said to be colorful if the product of all its substrings is unique . 
 * 2 , 6 , 3 , 6*3 , 2*6 .But 2*3 is NOT a valid product . 
 * We have to consider substring only. 
 * 
 * Tell whether the number is colorful or not
 * @author Zheng Lu
 * Sep 22, 2012
 *
 */

public class ColorfulNumber
{
	public static boolean isColorful(int num)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		int product = 1;
		
		while(num != 0)
		{
			int lastDigit = num%10;
			numList.add(lastDigit);
			num = num/10;
		}
		int size = numList.size();
		for (int i = 0;i<size;i++)
		{
			product = numList.get(i);
			for (int j = i+1;j<size;j++)
			{
				product *= numList.get(j);
//				System.out.println(product);
				if (set.contains(product))
					return false;
				else
					set.add(product);
			}
		}	
		return true;
	}
	
	public static void getAllSubString(int num)
	{
		/**put each digit of the number into a list**/
		ArrayList<Integer> numList = new ArrayList<Integer>();
		while(num != 0)
		{
			int lastDigit = num%10;
			numList.add(lastDigit);
			num = num/10;
		}
		int size = numList.size();
		for (int i = 0;i<size;i++)
		{
			for (int j = i+1;j<size;j++)
			{
				for (int k = i;k<=j;k++)
				{
					System.out.print(numList.get(k) + " ");
				}
				System.out.println();
			}
		}	
	}

	public static void main(String[] args)
	{
		int num = 263;
		
		System.out.println(ColorfulNumber.isColorful(num));
	}

}
