package LeetCode;

/**
 * @author Zheng Lu
 * @date Oct 16, 2012
 * 
 */
public class LongestPalindromicSubstring
{

	/**
	 * reverse the string and find the longest common substring with the
	 * original string
	 * 
	 * time: O(n^2), space:O(n^2)
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s)
	{
		if (s == null)
			return null;

		int n = s.length();
		if (n < 2)
			return s;

		return findLongestCommonSubStringDP(s);
	}

	/**
	 * dp[i][j] = (dp[i + 1][ j - 1] && s.charAt(i) = s.charAt(j))
	 * 
	 * base condition: dp[i][i] = true; dp[i][i + 1] = true, if s[i] = s[i+1]
	 * 
	 * @param s
	 * @return
	 */
	private String findLongestCommonSubStringDP(String s)
	{
		if (s == null)
			return null;

		int n = s.length();

		boolean dp[][] = new boolean[n][n];
		for (int i = 0; i < n; i++)
			dp[i][i] = true;

		for (int i = 0; i < n - 1; i++)
		{
			if (s.charAt(i) == s.charAt(i + 1))
			{
				dp[i][i + 1] = true;
			}
		}
		
		

		return "";
	}

	public static void main(String[] args)
	{

	}

}
