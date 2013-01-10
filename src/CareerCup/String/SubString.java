package CareerCup.String;

import java.util.ArrayList;

/**
 * Determine if a String is a substring of another string
 * 
 * @author annie
 * 
 * @date Jan 9, 2013
 */
public class SubString
{
	/**
	 * Determine if t is substring of s.
	 * 
	 * brutal force
	 */
	public boolean isSubString(String s, String t)
	{
		if (s == null || t == null)
			return false;
		if (s.length() < t.length())
			return false;
		if (t == "")
			return true;

		boolean isSub = true;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < s.length(); i++)
		{
			isSub = true;
			for (int j = 0; j < t.length(); j++)
			{
				if (s.charAt(i + j) != t.charAt(j))
				{
					isSub = false;
					break;
				}
			}
			if (isSub)
				list.add(i);
		}
		System.out.println(list);

		return list.size() > 0;
	}

	public static void main(String[] args)
	{
		SubString ss = new SubString();
		System.out.println(ss.isSubString("sfdsf  sdf", "sdf"));
	}

}
