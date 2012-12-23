package LeetCode;

/***
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 * Brutal force solution
 * 
 * @author annie
 * 
 * @date Dec 20, 2012
 */
public class ImplementStrStr
{
	public String strStr(String s1, String s2)
	{
		int m = s1.length();
		int n = s2.length();

		if (m == 0 && n == 0)
			return "";

		if (m == 0 && n > 0 || n > m)
			return null;
		boolean isSubString = true;

		for (int i = 0; i <= m - n; i++)
		{
			isSubString = true;
			for (int j = 0; j < n; j++)
			{
				if (s1.charAt(i + j) != s2.charAt(j))
				{
					isSubString = false;
					break;
				}
				if (isSubString)
					return s1.substring(i);
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
