package CareerCup.String;

/**
 * Reverse each word in one string, for example, input:"I am a student." output:
 * "student. a am I"
 * 
 * @author annie
 * 
 * @date Jan 9, 2013
 */
public class ReverseWords
{

	private String reverseWord(String s)
	{
		if (s == null || s.length() == 0)
			return s;

		StringBuffer sb = new StringBuffer(s);
		String reverseStr = sb.reverse().toString();

		char[] strs = reverseStr.toCharArray();
		int i = 0;
		int p = i;
		while (p < strs.length)
		{
			if (strs[p] == ' ')
			{
				swapRange(strs, i, p - 1);
				i = p;
			}
			p++;
		}
		swapRange(strs, i, p - 1);
		return new String(strs);
	}

	private void swapRange(char[] strs, int i, int j)
	{
		while (i < j)
		{
			char temp = strs[i];
			strs[i] = strs[j];
			strs[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args)
	{

	}

}
