package LeetCode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author Zheng Lu
 * @date Oct 5, 2012
 * 
 */
public class LengthOfLastWord
{
	public int lengthOfLastWord(String s)
	{
		s = s.trim();
        
        if (s.length() == 0)
            return 0;
            
        String[] strarr = s.split(" ");
        
        return strarr[strarr.length - 1].length();
        
//		int length = 0;
//		if (s.length() == 0)
//			return 0;

//		String t = s.trim();
//		for (int i = t.length()-1;i>=0;i--)
//		{
//			if (t.charAt(i)!=' ')
//				length++;
//			else
//				break;
//		}
		
//		int lastpos = s.length() - 1;
//		while (lastpos >= 0)
//		{
//			if (s.charAt(lastpos) != ' ')
//				break;
//			lastpos--;
//		}
//		for (int i = lastpos; i >= 0; i--)
//		{
//			char c = s.charAt(i);
//			if (c != ' ')
//				length++;
//			else
//				break;
//		}
//
//		return length;
	}

	public static void main(String[] args)
	{
		String s = "      ";
		System.out.println(s + "a");
		System.out.println(s.trim() + "a");
	}

}
