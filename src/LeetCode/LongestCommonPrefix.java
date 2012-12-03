package LeetCode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * 
 * @author Zheng Lu
 * @date Oct 15, 2012
 * 
 */
public class LongestCommonPrefix
{
	public static String longestCommonPrefix(String[] strs)
	{
		String prefix = "";
		if (strs.length == 0)
			return prefix;
		if (strs.length == 1)
			return strs[0];

		int shortLength = strs[0].length();
		for (int i = 1;i<strs.length;i++)
		{
			if(strs[i].length()<shortLength)
				shortLength = strs[i].length();
		}
		
		int index = 0;
		while(index < shortLength)
		{
			for (int i = 0;i<strs.length-1;i++)
			{
				if (strs[i].charAt(index) != strs[i+1].charAt(index))
					return prefix;
			}
			prefix += strs[0].charAt(index);
			index++;
		}
		return prefix;
	}

	public static void main(String[] args)
	{
		String[] strs = {"Flisght","Flisdg","Flisdfdsf"};
		System.out.println(longestCommonPrefix(strs));
	}

}
