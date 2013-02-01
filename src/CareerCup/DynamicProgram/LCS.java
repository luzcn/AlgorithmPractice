package CareerCup.DynamicProgram;

/**
 * Find the longest common subsequence of two stings
 * 
 * @author Zheng Lu Sep 22, 2012
 * 
 */
public class LCS
{
	public static String lcs(String a, String b)
	{
		int[][] M = new int[a.length() + 1][b.length() + 1];
		/** Construct the DP table **/
		for (int i = 0; i < a.length(); i++)
		{
			for (int j = 0; j < b.length(); j++)
			{
				if (a.charAt(i) == b.charAt(j))
					M[i + 1][j + 1] = M[i][j] + 1;
				else
					M[i + 1][j + 1] = Math.max(M[i + 1][j], M[i][j + 1]);
			}
		}

		// for (int i =0;i<a.length() + 1;i++)
		// {
		// for (int j = 0;j<b.length() + 1;j++)
		// System.out.print(M[i][j]+" ");
		// System.out.println();
		// }

		/** now back tracking to get the common string **/
		int x = a.length();
		int y = b.length();
		StringBuffer sb = new StringBuffer();

		while (x > 0 && y > 0)
		{
			if (M[x][y] == M[x][y - 1])
				y--;
			else if (M[x][y] == M[x - 1][y])
				x--;
			else
			{
				sb.append(a.charAt(x - 1));
				x--;
				y--;
			}
		}

		return sb.reverse().toString();
	}

	/***
	 * Longest common substring
	 * 
	 * @param s
	 * @param t
	 */
	public static String longestSubString(String s, String t)
	{
		int m = s.length();
		int n = t.length();
		String match = "";
		int[][] M = new int[m][n];
		int length = 0;

		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (s.charAt(i) == t.charAt(j)) // match
				{
					if (i == 0 || j == 0)
						M[i][j] = 1;
					else
						M[i][j] = M[i - 1][j - 1] + 1;

					if (M[i][j] >= length)
					{
						length = M[i][j];
						match = s.substring(i - length + 1, i + 1);
					}
				}
			}
		}
		return match;
	}

	public static void main(String[] args)
	{
		String a = "thisisatest";
		String b = "testing123testing";

		// System.out.println(LCS.lcs(a, b));
		System.out.println(LCS.longestSubString(a, b));

	}

}
