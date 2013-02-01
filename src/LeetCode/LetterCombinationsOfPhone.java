package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
 * "cd","ce", "cf"].
 * 
 * @author Zheng Lu
 * @date Oct 14, 2012
 * 
 */
public class LetterCombinationsOfPhone
{

	public static ArrayList<String> letterCombinations(String digits)
	{
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		map.put('0', " ");

		ArrayList<String> solution = new ArrayList<String>();
		if (digits == null)
			return solution;

		combineRec(digits, 0, map, new String(), solution);

		return solution;
	}

	private static void combineRec(String digits, int index,
			HashMap<Character, String> map, String solStr,
			ArrayList<String> solution)
	{
		if (solStr.length() > digits.length())
			return;
		else if (solStr.length() == digits.length())
		{
			solution.add(solStr);
			return;
		}
		else
		{
			for (int i = index; i < digits.length(); i++)
			{
				String letters = map.get(digits.charAt(i));
				for (int j = 0; j < letters.length(); j++)
				{
					combineRec(digits, i + 1, map, solStr + letters.charAt(j),
							solution);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		String digits = "234";
		ArrayList<String> sol = letterCombinations(digits);
		for (String s : sol)
			System.out.println(s);
	}

}
