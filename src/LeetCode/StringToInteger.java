package LeetCode;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author annie
 * 
 * @date Jan 10, 2013
 */
public class StringToInteger
{
	public int atoi(String s)
	{
		int num = 0;
		int index = 0;
		boolean isNeg = false;

		if (s == null || s.length() == 0)
			return 0;
		s = s.trim();
		if (s.compareTo("2147483647") >= 0)
			return Integer.MAX_VALUE;
		if (s.compareTo("-2147483648") >= 0)
			return Integer.MIN_VALUE;

		if (s.charAt(0) == '-')
		{
			if (s.length() > 1 && !Character.isDigit(s.charAt(1)))
				return 0;

			index = 1;
			isNeg = true;
		}
		else if (s.charAt(0) == '+')
		{
			if (s.length() > 1 && !Character.isDigit(s.charAt(1)))
				return 0;

			index = 1;
			isNeg = false;
		}

		while (index < s.length())
		{
			char c = s.charAt(index);
			if (Character.isDigit(c))
				num = num * 10 + Character.getNumericValue(c);
			else
				return isNeg ? (0 - num) : num;
			// throw new RuntimeException("invalid character");
			index++;
		}
		return isNeg ? (0 - num) : num;
	}

	public static void main(String[] args)
	{

	}

}
