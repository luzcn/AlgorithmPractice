package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Given an array of strings, return all groups of strings that are anagrams. 
 * Note: All inputs will be in lower-case.
 * 
 * @author Zheng Lu
 *
 */

public class Anagrams
{
	private static void sortString(String[] strArray)
	{
		int n = strArray.length;
		String[] sortedString = new String[n];
		for (int i = 0;i<n;i++)
		{
			char[] str = strArray[i].toCharArray();
			Arrays.sort(str);
			sortedString[i] = new String(str);
		}
		
		for (int i = 0;i<n;i++)
		{
			System.out.println(strArray[i]+":\t"+sortedString[i]);
		}
	}
	

	public void findAnagrams(String[] s)
	{
		Hashtable<String, String> strTable = new Hashtable<String, String>();
		LinkedList<Anagram> anagramList = new LinkedList<Anagram>();
		for (int i = 0;i<s.length;i++)
		{
			String str = s[i];
			String sortedStr = "";
			LinkedList<Character> charList = new LinkedList<Character>();
			
			for (int j = 0;j<str.length();j++)
			{
				charList.add(str.charAt(j));
			}
			Collections.sort(charList);
			
			Iterator<Character> it = charList.iterator();
			while(it.hasNext())
				sortedStr += it.next();
			
			boolean findanagram = false;
			for (Anagram a:anagramList)
			{
				if (a.keywords.equals(sortedStr))
				{
					a.strList.add(str);
					findanagram = true;
				}
			}
			if (findanagram==false)
			{
				Anagram a = new Anagram();
				a.keywords = sortedStr;
				a.strList.add(str);
				anagramList.add(a);
			}
		}
		for (Anagram a:anagramList)
		{
			System.out.println(a.keywords + ": ");
			for (String string: a.strList)
			{
				System.out.print(" "+ string);
			}
			System.out.println();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String[] s = {"stop","tops","sdfsd","sfdsd","otsp","tosp"};
		Anagrams ana = new Anagrams();
		ana.findAnagrams(s);
	}

}

class Anagram
{
	String keywords;
	LinkedList<String> strList = new LinkedList<String>();
}