package LeetCode;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author Zheng Lu
 * @date Oct 16, 2012
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters
{

	public static int lengthOfLongestSubstring(String s)
	{
		if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        int start = 0;
        int count = 1;
        int index = 1;
        int maxcount = 1;
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        map.put(s.charAt(start), 1);
        
        while(index<s.length())
        {
            if (map.get(s.charAt(index)) == null)   //no duplicate
            {
                map.put(s.charAt(index), 1);
                count++;
                index++;
            }
            else
            {
                if (count>maxcount)
                    maxcount = count;
                count = 1;
                map.clear();
                start++;
                index=start+1;
                if (start<s.length())
                    map.put(s.charAt(start),1);
            }
        }
        if (count>maxcount)
            maxcount = count;
            
        return maxcount;
	}

	public static void main(String[] args)
	{
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
