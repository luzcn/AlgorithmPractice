package LeetCode;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author annie
 * 
 * @date Jan 16, 2013
 */
public class ValidPalindrome
{
	public boolean isPalindrome(String s)
	{
		if (s == null)
			return false;
		if (s.length() == 0)
			return true;

		s = s.trim();
		int l = 0;
		int r = s.length() - 1;
		while (l < r)
		{

			while (l < s.length() && !isAlphabet(s.charAt(l)))
			{
				l++;
			}
			while (r >= 0 && !isAlphabet(s.charAt(r)))
				r--;

			if (l < s.length()
					&& r >= 0
					&& Character.toLowerCase(s.charAt(l)) != Character
							.toLowerCase(s.charAt(r)))
				return false;
			l++;
			r--;
		}

		return true;
	}

	private boolean isAlphabet(char c)
	{
		if (Character.isWhitespace(c))
			return false;

		return Character.isLetterOrDigit(c);
	}

	public static void main(String[] args)
	{
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("race a car"));
	}

}
