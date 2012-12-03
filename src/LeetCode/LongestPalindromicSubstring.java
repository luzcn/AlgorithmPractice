package LeetCode;

/**
 * @author Zheng Lu
 * @date Oct 16, 2012
 * 
 */
public class LongestPalindromicSubstring
{

	public static String longestPalindrome(String s)
	{
		int n = s.length();
		if (n == 0) return "";
		if (n == 1) return s;
		
		String longest = s.substring(0,1);		
		
		for (int i = 0;i<n-1;i++)
		{
			
		}
		
		return null;
	}

	private static String expandAroundCenter(String s, int c1, int c2)
	{
		int l = c1;
		int r = c2;
		int n = s.length();
		
		while(l>=0 && r<=n-1 && s.charAt(l)==s.charAt(r))
		{
			l--;
			r++;
		}
		return s.substring(l+1,r-l-1);
	}
	public static void main(String[] args)
	{
		String s = "stsabcddcbawer";
		longestPalindrome(s);

	}

}
