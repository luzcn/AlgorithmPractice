package CareerCup.String;

import java.util.Arrays;

public class FindAnagram
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String s = "stop";
		System.out.println(FindAnagram.sortString(s));
	}

	
	public static String sortString(String s)
	{
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		
		String sortedString = new String(chars);
		
		return sortedString;
	}
}
