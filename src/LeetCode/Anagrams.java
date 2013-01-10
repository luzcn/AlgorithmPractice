package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * @author Zheng Lu
 * 
 */

public class Anagrams
{
	public ArrayList<String> anagrams(String[] strs)
	{
		int n = strs.length;
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		if (n == 0)
			return result;

		for (int i = 0; i < n; i++)
		{
			char[] str = strs[i].toCharArray();
			Arrays.sort(str);
			String sortedString = new String(str);

			if (!map.containsKey(sortedString))
			{
				ArrayList<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(sortedString, list);
			}
			else
			{
				ArrayList<String> list = map.get(sortedString);
				list.add(strs[i]);
				map.put(sortedString, list);
			}
		}

		Iterator<Entry<String, ArrayList<String>>> it = map.entrySet()
				.iterator();
		while (it.hasNext())
		{
			Entry<String, ArrayList<String>> pairs = it.next();
			if (pairs.getValue().size() > 1)
				result.addAll(pairs.getValue());
		}
		// Collections.sort(result);
		return result;
	}

	/***
	 * 
	 * @param strArray
	 */
	private static void sortString(String[] strArray)
	{
		int n = strArray.length;
		String[] sortedString = new String[n];
		for (int i = 0; i < n; i++)
		{
			char[] str = strArray[i].toCharArray();
			Arrays.sort(str);
			sortedString[i] = new String(str);
		}

		for (int i = 0; i < n; i++)
		{
			System.out.println(strArray[i] + ":\t" + sortedString[i]);
		}
	}

	public void findAnagrams(String[] s)
	{
		Hashtable<String, String> strTable = new Hashtable<String, String>();
		LinkedList<Anagram> anagramList = new LinkedList<Anagram>();
		for (int i = 0; i < s.length; i++)
		{
			String str = s[i];
			String sortedStr = "";
			LinkedList<Character> charList = new LinkedList<Character>();

			for (int j = 0; j < str.length(); j++)
			{
				charList.add(str.charAt(j));
			}
			Collections.sort(charList);

			Iterator<Character> it = charList.iterator();
			while (it.hasNext())
				sortedStr += it.next();

			boolean findanagram = false;
			for (Anagram a : anagramList)
			{
				if (a.keywords.equals(sortedStr))
				{
					a.strList.add(str);
					findanagram = true;
				}
			}
			if (findanagram == false)
			{
				Anagram a = new Anagram();
				a.keywords = sortedStr;
				a.strList.add(str);
				anagramList.add(a);
			}
		}
		for (Anagram a : anagramList)
		{
			System.out.println(a.keywords + ": ");
			for (String string : a.strList)
			{
				System.out.print(" " + string);
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String[] s = { "aft", "asp", "foe", "gut", "jab", "wok", "dub", "wis",
				"fan", "lie", "sly", "gob", "ibm", "ben", "any", "oct", "rut",
				"ear", "key", "ado", "yet", "fan", "nap", "hop", "box", "pad",
				"eke", "day", "cub", "cud", "arc", "tan", "cap", "bob", "net",
				"tim", "dad", "hie", "mao", "guy", "fen" };
		Anagrams ana = new Anagrams();
		ArrayList<String> list = ana.anagrams(s);
		System.out.println(list);
	}

}

class Anagram
{
	String keywords;
	LinkedList<String> strList = new LinkedList<String>();
}