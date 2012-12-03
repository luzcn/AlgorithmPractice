package Epic;

import java.util.Hashtable;

/**
 * @author Zheng Lu
 * @date   Oct 2, 2012
 *
 */
public class BullAndCows
{
	public static void findBullsAndCows(String s1, String s2)
	{
		Hashtable<Character,Integer> t1 = new Hashtable<Character,Integer>(); 
		int cows = 0;
		int bulls = 0;
		
		for (int i = 0;i<s1.length();i++)
			t1.put(s1.charAt(i), i);
		
		for (int i = 0;i<s2.length();i++)
		{
			char c = s2.charAt(i);
			if (t1.get(c)!=null)
			{
				if (t1.get(c) == i)
					bulls++;
				else
					cows++;
			}
		}
		System.out.println(cows + " Cows "+bulls+" Bulls");
	}
	
	public static void main(String[] args)
	{
		findBullsAndCows("dusts", "studs ");
	}

}
