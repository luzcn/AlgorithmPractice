package CareerCup.String;

/**
 * Reverse each word in one string, 
 * for example, input:"I am a student."
 * output: "student. a am I"
 * @author annie
 *
 * @date Jan 9, 2013
 */
public class ReverseWords
{

	public String reverseWords(String str)
	{
		if (str == null || str.length() == 0)
			return str;
		
		
		
		return null;
	}
	
	private void swapRange(char[] strs, int i, int j)
	{
		
		strs[i] ^= strs[j];
		strs[j] ^= strs[i];
		strs[i] ^= strs[j];
	}
	
	public static void main(String[] args)
	{

	}

}
