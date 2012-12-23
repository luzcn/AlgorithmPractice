package LeetCode;
/***
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author annie
 * 
 */
public class EditDistance
{
	public int editDistance(String s, String t)
	{
		if (s.length() == 0 && t.length() == 0)
			return 0;

		return editDistanceDP(s, t);
	}

	private int editDistanceDP(String s, String t)
	{
		int[][] table = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < table.length; i++)
		{
			for (int j = 0; j < table[i].length; j++)
			{
				if (i == 0)
					table[i][j] = j;
				else if (j == 0)
					table[i][j] = i;
				else
				{
					if (s.charAt(i - 1) == t.charAt(j - 1))
						table[i][j] = table[i - 1][j - 1];
					else
					{
						table[i][j] = Math.min(1 + table[i - 1][j - 1],
								1 + Math.min(table[i][j - 1], table[i - 1][j]));
					}
				}
			}
		}

		return table[s.length()][t.length()];
	}

	private int editDistanceRec(String s, String t)
	{
		if (s.length() == 0) // ed("", s) = ed(s,"") = s.length();
			return t.length();
		else if (t.length() == 0)
			return s.length();
		else
		{
			char sc = s.charAt(0);
			char tc = t.charAt(0);
			if (sc == tc) // ed(s+ch1, t+ch2) = ed(s,t) if ch1==ch2
				return editDistanceRec(s.substring(1), t.substring(1));
			else
			{
				// ed(s+ch1, t+ch2) = min(ed(s+ch1, t) + 1, ed(s, t+ch2)+1,
				return Math.min(
						1 + editDistanceRec(s.substring(1), t.substring(1)),
						1 + Math.min(editDistanceRec(s, t.substring(1)),
								editDistanceRec(s.substring(1), t)));
			}
		}
	}

	public static void main(String[] args)
	{
		EditDistance ed = new EditDistance();
		System.out.println(ed.editDistance("", "a"));
	}
}
