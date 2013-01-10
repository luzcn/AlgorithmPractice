package LeetCode;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author annie
 * 
 * @date Jan 7, 2013
 */
public class RomanToInteger
{
	public int romanToInt(String s)
	{
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };

		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		int num = 0;

		if (s.length() == 0 || s == null)
			return num;

		while (s.length() > 0)
		{
			String first = s.substring(0, 1);
			String second = null;
			if (s.length() > 1)
				second = s.substring(1, 2);
			else
				second = "";

			int newNum = 0;

			for (int i = 0; i < roman.length; i++)
			{
				if ((first + second).equals(roman[i]))
				{
					newNum = value[i];
					break;
				}
			}
			if (newNum > 0)
			{
				if (s.length() > 1)
					s = s.substring(2);
				else
					s = s.substring(1);
			}
			else
			{
				for (int i = 0; i < roman.length; i++)
				{
					if (first.equals(roman[i]))
					{
						newNum = value[i];
						break;
					}
				}
				s = s.substring(1);
			}

			num += newNum;
		}
		return num;
	}

	public static void main(String[] args)
	{
		RomanToInteger ri = new RomanToInteger();
		int num = ri.romanToInt("IV");
		System.out.println(num);
	}

}
